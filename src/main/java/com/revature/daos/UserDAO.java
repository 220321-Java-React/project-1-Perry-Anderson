package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.utils.ConnectionUtil;

public class UserDAO {

	public User getUser(String username, String password) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_users where "
					+ "ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			ArrayList<User> userList = new ArrayList<>();
			 
			while(rs.next()){
				User p = new User(
						rs.getInt("ers_user_id"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("user_email"),
						rs.getInt("user_role_id_fk")
						);
						
				userList.add(p);
			}
			if(userList.isEmpty() == false) {
				User currentUser = userList.get(0);
				return currentUser;
			}else {
				return null;
			}
			
		}catch(SQLException e){
			System.out.println("SQL ISSUE");
			e.printStackTrace();
			return null;
		}
	}

	public String getUserRole(UserRole role) {
		// TODO Auto-generated method stub
		return null;
	}

}
