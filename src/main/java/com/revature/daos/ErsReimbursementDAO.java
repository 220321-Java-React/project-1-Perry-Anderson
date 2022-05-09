package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.ErsReimbursement;
import com.revature.utils.ConnectionUtil;

public class ErsReimbursementDAO {

	public ArrayList<ErsReimbursement> getAllReinbursements(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_reimbursements;";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			ArrayList<ErsReimbursement> reimbSet = new ArrayList<>();
			
		while(rs.next()) {
			ErsReimbursement e = new ErsReimbursement(
					rs.getInt("reimb_id"),
					rs.getInt("reimb_amount"),
					rs.getString("reimb_Submitted"),
					rs.getInt("reimb_author_id_fk"),
					rs.getInt("reimb_status_id_fk"),
					rs.getInt("reimb_type_id_fk")
					);
					
			reimbSet.add(e);
		}
			return reimbSet;

		}catch(SQLException e){
			System.out.println("Database issue");
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<ErsReimbursement> getAllReinbursementsByEmployee(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
		}catch(SQLException e){
			System.out.println("Database issue");
		}
		return null;
		
	}

	public void addReimbursement(ErsReimbursement erb) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO ers_reimbursements; "
					+ "VALUES (?, ?, ?, ?, ?),";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, erb.getAmount());
			ps.setString(2, erb.getSubmitted());
			ps.setInt(3, erb.getAuthorId());
			ps.setInt(4, erb.getStatusId());
			ps.setInt(5, erb.getTypeId());
			ps.executeUpdate();
			
		}catch(SQLException e){
			System.out.println("Database issue");
			e.printStackTrace();
		}
	
		
	}
	
	
}


