package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		//In this try/catch, we're just testing whether our Connection (from the ConnectionUtil Class) is successful
		//remember - the getConnection() method will return a Connection Object if you connect successfully
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("CONNECTION SUCCESSFUL :)");
		} catch (SQLException e) { //if creating this connection fails... catch the exception and print the stack trace
			System.out.println("connection failed... :(");
			e.printStackTrace();
		}
	
		Javalin app = Javalin.create(
				config ->{
					config.enableCorsForAllOrigins();
				}
			).start(3000);
		
		app.get("/employees", ec.getEmployeesHandler);
		
		app.post("/login", ac.loginHandler);
		
	}
	
}
