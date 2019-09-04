package com.revature.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.exception.DBException;
import com.revature.bankapp.model.User;
import com.revature.bankapp.util.ConnectionUtil;

public class UserDAO {

	public User login(String email, String password) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select id,name,email,active,role from users where email = ? and password = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("active"));
				user.setRole(rs.getString("role"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DBException("Unable to login",e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		return user;
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
		}catch(SQLIntegrityConstraintViolationException e) {
			throw new DBException("Email already exists" );
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to insert user" , e);
		}
				
	}
	
	public User findOne(int id) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select id,name,email,active,role from users where id= ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			rs = pst.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("active"));
				user.setRole(rs.getString("role"));
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		return user;
	}
	
	public List<User> list() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select id,name,email,active,role from users where role='U'";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("active"));
				user.setRole(rs.getString("role"));
				
				list.add(user);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		return list;
	}
	
	public void deactivateAccount(int id) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		String sql = "update users set active =0 where id = ?";
		
		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			
			int rows = pst.executeUpdate();
			System.out.println("No of rows updated:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to deactivate account" , e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		
	}
	
	public void delete(int id) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		String sql = "delete from users where id = ?";
		
		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			
			int rows = pst.executeUpdate();
			System.out.println("No of rows updated:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to delete account" , e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		
	}
	
	public void updateProfile(User user) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		String sql = "update users set name = ? where id = ?";
		
		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1,user.getName());
			pst.setInt(2, user.getId());
			
			int rows = pst.executeUpdate();
			System.out.println("No of rows updated:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to update profile" , e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		
	}
	
	public void updateAccount(int id, Boolean status) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		String sql = "update users set active =? where id = ?";
		
		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setBoolean(1, status);
			pst.setInt(2,id);
			
			int rows = pst.executeUpdate();
			System.out.println("No of rows updated:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to update account" , e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		
	}
	
	public void activateAccount(int id) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		String sql = "update users set active =1 where id = ?";
		
		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			
			int rows = pst.executeUpdate();
			System.out.println("No of rows updated:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to activate account" , e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		
	}
}
