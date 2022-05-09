package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.models.ErsReimbursement;
import com.revature.services.ErsReimbursementService;

import io.javalin.http.Handler;

public class ErsReimbursementController {
	ErsReimbursementService es = new ErsReimbursementService();
	 public Handler getReimbHandler = (ctx) -> {
		 
//		 if(ctx.req.getSession(true) != null) { 
			ArrayList<ErsReimbursement> ersReimbursement = es.getReimb();
		
			Gson gson = new Gson();
			String JSONReimb = gson.toJson(ersReimbursement);
			ctx.result(JSONReimb); 
			ctx.status(200); 
				
//			} else { //if a session DOESN'T exist (user isn't logged in)
	//				ctx.status(400);
	//		}
		
	 };
	 
	 public Handler addReimbHandler = (ctx) -> {
		 String body = ctx.body();
		 Gson gson = new Gson();
		 ErsReimbursement erb = gson.fromJson(body, ErsReimbursement.class);
		 es.addReimb(erb);
		 String JSONReimb = gson.toJson(erb);
			ctx.result(JSONReimb); 
		 ctx.status(200); 
	 };
	
}
