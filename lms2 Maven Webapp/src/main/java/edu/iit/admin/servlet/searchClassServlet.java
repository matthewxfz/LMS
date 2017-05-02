package edu.iit.admin.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
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
import edu.iit.bean.OrdersMessage;
import edu.iit.dao.Classes;
import edu.iit.dao.ClassesDAO;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.RegisterTo;
import edu.iit.dao.RegisterToDAO;
import edu.iit.dao.RegisterToId;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;
import edu.iit.util.ClassAdapter;
import edu.iit.util.OrdersAdapter;

@WebServlet(urlPatterns = "/admin/search/Classes")
public class searchClassServlet extends HttpServlet {

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
		ClassMessage cmsg = process(keyWord, pageNumber, pageSize);

		// send the data
		Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(Classes.class, new ClassAdapter()).create();
		System.out.println("Data we send: " + gson.toJson(cmsg));

		// send the data
		resp.getWriter().write(gson.toJson(cmsg));
	}

	public ClassMessage process(String keyword, String pageNumber, String pageSize) {
		RegisterToDAO rdao = new RegisterToDAO();
		ClassesDAO cdao = new ClassesDAO();
		StudentsDAO sdao = new StudentsDAO();
		ClassMessage cmsg = new ClassMessage();
		if (keyword.equals("")) {
			try {
				List<Classes> li = cdao.findAll(Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
				int totalNumber = (cdao.findAll()).size();
				cmsg.setStatus("true");
				cmsg.setPage(pageNumber);
				cmsg.setTotalNumber(String.valueOf(totalNumber));
				cmsg.setTotalPage(String.valueOf(totalNumber / Integer.valueOf(pageNumber)));

				cmsg.setContent(li);
			} catch (NumberFormatException e) {
				cmsg.setStatus("false");
				cmsg.setTitle("Inner Server Error!");
				cmsg.setContent(null);
			}
		} else {
			// return classes of a student
			List<Students> generateIDlist = sdao.findByUserId(keyword);
			if (generateIDlist.size() == 0) {
				int totalNumber = generateIDlist.size();
				cmsg.setStatus("true");
				cmsg.setTitle("Select Courses first");
				cmsg.setTotalNumber("0");
				cmsg.setPage(pageNumber);
				cmsg.setTotalPage("1");
				cmsg.setContent(null);
				return cmsg;
			}

			try {
				String studentid = String.valueOf(generateIDlist.get(0).getStudentId());
				List<RegisterTo> cl = rdao.findByStudentID(studentid, Integer.valueOf(pageNumber),
						Integer.valueOf(pageSize));// find all order
				List<Classes> classList = new ArrayList<Classes>();
				for (int i = 0; i < cl.size(); i++) {
					classList.add(cl.get(i).getClasses());
				}
				int totalNumber = classList.size();
				cmsg.setStatus("true");
				cmsg.setTitle("Courses found");
				cmsg.setTotalNumber(String.valueOf(totalNumber));
				cmsg.setPage(pageNumber);
				cmsg.setTotalPage(String.valueOf(totalNumber / Integer.valueOf(pageNumber)));
				cmsg.setContent(classList);
				return cmsg;

			} catch (Exception e) {
				cmsg.setStatus("false");
				cmsg.setTitle("Inner Server Error!");
				cmsg.setContent(null);
				return cmsg;
			}
		}
		return cmsg;

	}

	public String decompositeJSON(JsonObject jsonObject, String attr) {
		String result = ((jsonObject.get(attr).toString()).split("\""))[1];
		result = result.equals(" ") ? "" : result;
		return result;
	}
}
