package edu.iit.servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import edu.iit.bean.SearchBookMessage;
import edu.iit.bean.StudentMessage;
import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;
import edu.iit.util.BooksAdapter;
import edu.iit.util.StudentAdapter;

@WebServlet(urlPatterns = "/getProfile")
public class getProfileServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// read the input
		String studentId = req.getParameter("studentId");
		System.out.println("Student Id" + studentId);
		// Search in hibernate
		StudentMessage msg = new StudentMessage();
		StudentsDAO sdao = new StudentsDAO();
		try {
			msg.content = (Students)sdao.findById(Integer.valueOf(studentId));
			msg.title = "Success";
			msg.status = "true";
		} catch (Exception e) {
			msg.title = "Error, InnerServer Error!";
			msg.status = "true";
		}
		// send the data
		Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(Students.class, new StudentAdapter())
				.create();
		System.out.println("[Student Profile]Data we send: " + gson.toJson(msg));

		// send the data
		resp.getWriter().write(gson.toJson(msg));
	}

	public String decompositeJSON(JsonObject jsonObject, String attr) {
		return ((jsonObject.get(attr).toString()).split("\""))[1];
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
