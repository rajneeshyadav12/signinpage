package com.studentregapp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentregapp.model.DAOService;
import com.studentregapp.model.DAOServiceImpl;
@WebServlet("/updateReg")
public class UpdateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateRegistration() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		String email = request.getParameter("email");
	String mobile = request.getParameter("mobile");
//	System.out.println(email);
//	System.out.println(mobile);
	request.setAttribute("email", email);
	request.setAttribute("mobile", mobile);
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/update_registration.jsp");
	 rd.forward(request, response);}
	 else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			 rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
	DAOService service = new DAOServiceImpl();
	service.connectDB();
	service.updateRegistration(email, mobile);
	
	ResultSet result = service.listReg();
	 request.setAttribute("result", result);
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_all.jsp");
	rd.forward(request, response);
	}

}
