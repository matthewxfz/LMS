package edu.iit.admin.servlet;

import java.io.BufferedReader;
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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.iit.bean.OrdersMessage;
import edu.iit.bean.TeacherMessage;
import edu.iit.dao.Books;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;
import edu.iit.dao.Teachers;
import edu.iit.dao.TeachersDAO;
import edu.iit.util.BooksAdapter;
import edu.iit.util.OrdersAdapter;
import edu.iit.util.TeachersAdapter;

@WebServlet(urlPatterns = "/admin/search/teachers")
public class searchTeacherServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("We get the messgae");
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The string is " + jb.toString());
		// //decomposite the input json
		JsonElement jelement = new JsonParser().parse(jb.toString());
		JsonObject jobject = jelement.getAsJsonObject();
		String keyWord = decompositeJSON(jobject, "keyword");
		String pageSize = decompositeJSON(jobject, "pagesize");
		String pageNumber = decompositeJSON(jobject, "pagenumber");
		//
		TeacherMessage msg = process(keyWord, pageNumber, pageSize);

		// send the data
		Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(Teachers.class, new TeachersAdapter()).create();
		System.out.println("Data we send: " + gson.toJson(msg));

		// send the data
		resp.getWriter().write(gson.toJson(msg));

	}
	
	public static void main(String[] args) {

		String keyWord = "";
		String pageNumber = "1";
		String pageSize = "3";
		System.out.println("ok");
		TeacherMessage msg = process(keyWord, pageNumber, pageSize);
		
		for (int i = 0; i < msg.getContent().size(); i++) {
			System.out.println(msg.getContent().get(i).getUserId());
		}
		System.out.println(msg.getTotalNumber());
	}

	public static TeacherMessage process(String keyWord,String pageNumber, String pageSize) {
		TeacherMessage msg = new TeacherMessage();
		
		try {
			TeachersDAO tdao = new TeachersDAO();
			if (keyWord.equals("")) {// find all students
				List<Teachers> teachers = tdao.findAll(Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
				int totalNumber = tdao.findAll().size();
				msg.setStatus("true");
				msg.setTitle("All teachers information");
				msg.setTotalNumber(String.valueOf(totalNumber));
				msg.setTotapage(String.valueOf(totalNumber / Integer.valueOf(pageSize)));
				msg.setContent(teachers);

			} else {// find specific student
				List<Teachers> teacher = (List<Teachers>) tdao.findByUserId(keyWord);
				if (teacher.size() == 0) {
					msg.setStatus("false");
					msg.setTitle("The Student is not exsit");
				} else {
					int totalNumber = tdao.findAll().size();
					msg.setStatus("true");
					msg.setTitle("All students information");
					msg.setTotalNumber(String.valueOf(1));
					msg.setTotapage(String.valueOf(1/ Integer.valueOf(pageSize)));
					msg.setContent(teacher);
				}
			}
			return msg;
		} catch (NumberFormatException e) {
			msg.setStatus("false");
			msg.setTitle("Number format is not right!");
			return msg;
		}
	}

	public String decompositeJSON(JsonObject jsonObject, String attr) {
		String result = ((jsonObject.get(attr).toString()).split("\""))[1];
		result = result.equals(" ")?"":result;
		return result;
	}
}
