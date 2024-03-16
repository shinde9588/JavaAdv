package com.form;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Servlet1 extends HttpServlet {
	
	Connection con = null;
	public void init() throws ServletException
	{
		con = ConnImple.getconnection();
	}
			
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String Name = request.getParameter("name");
		String Course = request.getParameter("Course");
		String[] Language = request.getParameterValues("checkboxes");
		String Gender = request.getParameter("Gender");
		String Address = request.getParameter("add");
		String Email = request.getParameter("email");
		String Password = request.getParameter("pass");
	
		PrintWriter out = response.getWriter();
		out.write("name" + Name + "\n");
	    out.write("Course" + Course + "\n");
	    out.write("languages " + Language + "\n");
		out.write("Gender" + Gender + "\n");
		out.write("Address" + Address + "\n");
		out.write("email" + Email + "\n");
		out.write("Password" + Password + "\n");
		
		System.out.println("object = " + con);
		
		
		
			String sql = "insert into Registration(Name,Course,Languages,Gender,Address,Email,Password) values (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ob = con.prepareStatement(sql);
			ob.setString(1, Name);
			ob.setString(2, Course);
			for(String Languages: Language) 
			{
				ob.setString(3,Languages);
			}         	ob.setString(4, Gender);
			ob.setString(5, Address);
			ob.setString(6, Email);
			ob.setString(7, Password);
			
			int rs = ob.executeUpdate();
//			if(rs>=1) {
//				RequestDispatcher ds = request.getRequestDispatcher("servlet2");
//				ds.forward(request, response); 
//			}else {
//				System.out.println("invalid input!!");
//			}
//			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

