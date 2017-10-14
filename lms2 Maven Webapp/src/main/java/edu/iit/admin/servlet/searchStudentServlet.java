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

import edu.iit.bean.ClassMessage;
import edu.iit.bean.StudentsMessage;
import edu.iit.dao.Classes;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;
import edu.iit.util.ClassAdapter;
import edu.iit.util.StudentAdapter;

@WebServlet(urlPatterns = "/admin/search/students")
public class searchStudentServlet extends HttpServlet {

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
		StudentsMessage msg = process(keyWord, pageNumber, pageSize);

		// send the data
		Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(Students.class, new StudentAdapter()).create();
		System.out.println("Data we send: " + gson.toJson(msg));

		// send the data
		resp.getWriter().write(gson.toJson(msg));
	}

	public void main(String[] args) {
		String keyWord = "";
		String pageNumber = "1";
		String pageSize = "10";
		StudentsMessage msg = process(keyWord, pageNumber, pageSize);

		System.out.println(msg.getStatus() + ", " + msg.getContent().get(0).getFirstName() + msg.getContent().size());
	}

	public StudentsMessage process(String keyWrod, String pageNumber, String pageSize) {

		StudentsMessage msg = new StudentsMessage();
		try {
			StudentsDAO sdao = new StudentsDAO();
			if (keyWrod.equals("")) {// find all students
				List<Students> students = sdao.findAll(Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
				int totalNumber = sdao.findAll().size();
				msg.setStatus("true");
				msg.setTitle("All students information");
				msg.setTotalNumber(String.valueOf(totalNumber));
				msg.setTotalPage(String.valueOf(totalNumber / Integer.valueOf(pageSize)));
				msg.setContent(students);

			} else {// find specific student
				List<Students> students = (List<Students>) sdao.findByUserId(keyWrod);
				if (students.size() == 0) {
					msg.setStatus("false");
					msg.setTitle("The Student is not exsit");
				} else {
					int totalNumber = sdao.findAll().size();
					msg.setStatus("true");
					msg.setTitle("All students information");
					msg.setTotalNumber(String.valueOf(1));
					msg.setTotalPage(String.valueOf(1/ Integer.valueOf(pageSize)));
					List<Students> content = (new LinkedList<Students>());
					content.add(students.get(0));
					msg.setContent(content);
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
