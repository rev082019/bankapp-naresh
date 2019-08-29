package com.revature.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bankapp.exception.DBException;
import com.revature.bankapp.model.User;
import com.revature.bankapp.util.ConnectionUtil;

public class UserDAO {

	public boolean login(String email, String password) {
		boolean isValidLogin = false;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select id,name,email from users where email = ? and password = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				isValidLogin = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		return isValidLogin;
	}

	public void register(User user) throws DBException {
		
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "insert into users(name,email,password) values ( ?,?,?)";
		
		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			
			int rows = pst.executeUpdate();
			System.out.println("No of rows inserted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to insert user" , e);
		}
				
	}
}
