package com.studentregapp.model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDB();  // it will connect to database
	public boolean verifyCredentials(String email,String password); //it will take username & password and return true and false
	public void saveRegistratin(String name,String city,String email,String mobile);
	public void deleteRegistration(String email);
	public void updateRegistration(String email,String mobile);
	public ResultSet listReg();
	
	
}
