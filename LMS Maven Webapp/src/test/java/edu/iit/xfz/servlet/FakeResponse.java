package edu.iit.xfz.servlet;

import java.io.IOException;
import java.io.StringReader;
import java.util.Enumeration;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FakeResponse extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		Enumeration<String> headerNames = req.getAttributeNames();
	      
	      while(headerNames.hasMoreElements()) {
	         String paramName = (String)headerNames.nextElement();
	         System.out.print("[" + paramName + ":");
	         String paramValue = (String) req.getAttribute(paramName);
	         System.out.println(" " + paramValue + "]");
	      }
	      
	      System.out.println("nailed it!");
		
//		resp.setStatus(200, "fake response");
//		
//		req.getParameter(name)
//		
//		JsonObject json = Json.createReader(new StringReader(s))
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}