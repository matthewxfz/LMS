package edu.iit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//showBook
@WebServlet(urlPatterns = { "/showBook" })
public class showBooksServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookId = req.getParameter("bookId");
		System.out.println("this is the BookId: "+ bookId);
		
	}
}
