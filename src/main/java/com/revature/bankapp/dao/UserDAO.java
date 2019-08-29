package com.revature.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
