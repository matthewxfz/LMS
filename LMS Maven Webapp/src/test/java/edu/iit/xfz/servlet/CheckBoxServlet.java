package edu.iit.xfz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckBoxServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Set response content type
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		String title = "Reading Checkbox Data";

		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>Maths Flag : </b>: " + req.getParameter("maths") + "\n" + "  <li><b>Physics Flag: </b>: "
				+ req.getParameter("physics") + "\n" + "  <li><b>Chemistry Flag: </b>: " + req.getParameter("chemistry")
				+ "\n" + "</ul>\n" + "</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
