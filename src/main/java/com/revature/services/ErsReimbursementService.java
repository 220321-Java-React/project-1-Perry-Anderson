package com.revature.services;

import java.util.ArrayList;

import com.revature.daos.ErsReimbursementDAO;
import com.revature.models.ErsReimbursement;

public class ErsReimbursementService {
	ErsReimbursementDAO eDAO = new ErsReimbursementDAO();
	
	public ArrayList<ErsReimbursement> getReimb(){
		
		ArrayList<ErsReimbursement> ersReimbursements = eDAO.getAllReinbursements();
		return ersReimbursements;
		
	};
	
	public void addReimb(ErsReimbursement erb) {
		eDAO.addReimbursement(erb);
	};

}
