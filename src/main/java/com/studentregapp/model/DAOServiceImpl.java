package com.studentregapp.model;

import java.sql.*;

public class DAOServiceImpl implements DAOService {
	
    private Connection con;
    private Statement stmt;
	@Override
	public void connectDB() {
    try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentregapp","root","test");
    stmt = con.createStatement();
    }catch(Exception e) {
    	e.printStackTrace();
    }
	}

	@Override
	public boolean verifyCredentials(String email, String password) {
		try {
			ResultSet result = stmt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
		return result.next();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveRegistratin(String name, String city, String email, String mobile) {
     try {
    	 stmt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
     }catch(Exception e) {
    	 e.printStackTrace();
     }
	}

	@Override
	public void deleteRegistration(String email) {
		try {
	    	 stmt.executeUpdate("delete from registration where email='"+email+"'");
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }
	}

	@Override
	public void updateRegistration(String email, String mobile) {
		try {
	    	 stmt.executeUpdate("update registration set mobile='"+mobile+"'  where email='"+email+"' ");
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }
	}

	@Override
	public ResultSet listReg() {
		try {
			ResultSet result = stmt.executeQuery("select * from registration");
		return result;
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
