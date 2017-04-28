package edu.iit.xfz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class LoginServlet extends HttpServlet {
	private String succ = "Welcome!";
	private String fail = "This user not exist!";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		Cookie firstname = new Cookie("uname", req.getParameter("uname"));
		Cookie lastname = new Cookie("psw", req.getParameter("psw"));
		
		firstname.setMaxAge(60*60*24);
		lastname.setMaxAge(60*60*24);
		
		resp.addCookie(firstname);
		resp.addCookie(lastname);
		
		String userId = req.getParameter("uname");
		String pas = req.getParameter("psw");
		System.out.println("here we go:!!\n"+userId);
		
		List<Students> stu = (new StudentsDAO()).findByUserId(userId);
		if(!stu.isEmpty()){
			userId = stu.get(0).getUserId();
			pas = stu.get(0).getPas();
		}
		
		
		 PrintWriter out = resp.getWriter();
	      String title = "Welcome!";
			
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
				
	      out.println(docType + "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor=\"#f0f0f0\">\n" +
	         "<h1 align=\"center\">" + title + "</h1>\n" +
	         "<ul>\n" +
	         "  <li><b>userID</b>: "
	         +userId + "\n" +
	         "  <li><b>Pas</b>: "
	         + pas + "\n" +
	         "</ul>\n" +
	         "</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
