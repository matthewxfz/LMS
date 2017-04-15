package edu.iit.xfz.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/other/forwardDemo")
public class ForwardDemoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		       String forward = req.getParameter("forward");
		 
		       if ("true".equals(forward)) {
		           System.out.println("Forward to ShowMeServlet");
		 
		           // Send data to next page (page forward to)
		           req.setAttribute(Constants.ATTRIBUTE_USER_NAME_KEY,
		                   "Hi, I'm Tom come from Walt Disney !");
		 
		           RequestDispatcher dispatcher = req.getServletContext()
		                   .getRequestDispatcher("/showMe");
		           dispatcher.forward(req, resp);
		 
		           return;
		       }
		       ServletOutputStream out = resp.getOutputStream();
		       out.println("<h3>Text of ForwardDemoServlet</h3>");
		       out.println("- servletPath=" + req.getServletPath());
		   }
		 
		   @Override
		   protected void doPost(HttpServletRequest request,
		           HttpServletResponse response) throws ServletException, IOException {
		       this.doGet(request, response);
		   }
}
