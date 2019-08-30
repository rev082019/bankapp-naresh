package com.revature.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.exception.DBException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.User;
import com.revature.bankapp.util.ConnectionUtil;

public class AccountDAO {

	public void insert(Account account) throws DBException {		

		
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "insert into accounts(user_id,account_type,balance) values (?,?,?)";
		
		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, account.getUser().getId());
			pst.setString(2, account.getType());
			pst.setInt(3, account.getBalance());
			
			
			int rows = pst.executeUpdate();
			System.out.println("No of rows inserted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to insert account" , e);
		}
		
	}

	public List<Account> list(Integer userId) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Account> list = new ArrayList<Account>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select a.id,a.account_type, a.balance, a.created_date, u.id as user_id from accounts a, users u where a.user_id = u.id and a.user_id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1,userId);
			rs = pst.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				Account account = new Account();
				account.setId(rs.getInt("id"));
				account.setUser(user);				
				account.setType(rs.getString("account_type"));
				account.setBalance(rs.getInt("balance"));
				account.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
				list.add(account);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DBException("Unable to fetch accounts");
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		return list;
	
	}
	
	public List<Account> list() throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Account> list = new ArrayList<Account>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select a.id,a.account_type, a.balance, a.created_date, u.id as user_id,u.name from accounts a, users u where a.user_id = u.id";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				Account account = new Account();
				account.setId(rs.getInt("id"));
				account.setUser(user);				
				account.setType(rs.getString("account_type"));
				account.setBalance(rs.getInt("balance"));
				account.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
				list.add(account);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DBException("Unable to fetch accounts");
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		return list;
	
	}
	
}
