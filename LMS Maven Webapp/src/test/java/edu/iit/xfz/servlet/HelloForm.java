package edu.iit.xfz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloForm extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		Cookie firstname = new Cookie("first_name", req.getParameter("first_name"));
		Cookie lastname = new Cookie("last_name", req.getParameter("last_name"));
		
		firstname.setMaxAge(60*60*24);
		lastname.setMaxAge(60*60*24);
		
		resp.addCookie(firstname);
		resp.addCookie(lastname);
		
		
		 PrintWriter out = resp.getWriter();
	      String title = "Using GET Method to Read Form Data";
			
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
				
	      out.println(docType + "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor=\"#f0f0f0\">\n" +
	         "<h1 align=\"center\">" + title + "</h1>\n" +
	         "<ul>\n" +
	         "  <li><b>First Name</b>: "
	         + req.getParameter("first_name") + "\n" +
	         "  <li><b>Last Name</b>: "
	         + req.getParameter("last_name") + "\n" +
	         "</ul>\n" +
	         "</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
