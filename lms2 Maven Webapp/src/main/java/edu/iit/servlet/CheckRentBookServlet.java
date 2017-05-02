package edu.iit.servlet;

import java.io.BufferedReader;
import java.io.IOException;
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

import edu.iit.bean.SearchBookMessage;
import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;
import edu.iit.dao.OrdersDAO_backup;
import edu.iit.util.BooksAdapter;


@WebServlet(urlPatterns = { "/checkRent" })
public class CheckRentBookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// read the input
		System.out.println("We get the messgae[check rent book]");
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
		String userId = decompositeJSON(jobject, "userId");
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		// Search in hibernate
		SearchBookMessage msg;
		msg = new SearchBookMessage();
		try {
			OrdersDAO_backup dao = new OrdersDAO_backup();
			List<Books> li = dao.findALLBooks_book_ByStudentId(1, 20, Integer.valueOf(userId));
			
			msg.setPage(Integer.valueOf(1));
			msg.setTotalPage(100 / Integer.valueOf(12));
			msg.setContent(li);
			msg.setStatus("true");
		} catch (Exception e) {
			msg.setStatus("false");
		}

		// send the data
		Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(Books.class, new BooksAdapter()).create();
		System.out.println("[Rent book]Data we send: " + gson.toJson(msg));

		// send the data
		resp.getWriter().write(gson.toJson(msg));
	}

	public String decompositeJSON(JsonObject jsonObject, String attr) {
		return ((jsonObject.get(attr).toString()).split("\""))[1];
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
