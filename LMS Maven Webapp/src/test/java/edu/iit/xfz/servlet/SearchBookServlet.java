package edu.iit.xfz.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.iit.bean.LoginMessage;
import edu.iit.bean.SearchBookMessage;
import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;

public class SearchBookServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//read the input 
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
		System.out.println("The string is "+jb.toString());
//		//decomposite the input json
		JsonElement jelement = new JsonParser().parse(jb.toString());
		JsonObject jobject = jelement.getAsJsonObject();
		String keyWord  = decompositeJSON(jobject, "keyword");
		String pageSize = decompositeJSON(jobject, "pagesize");
		String pageNumber = decompositeJSON(jobject, "pagenumber");
//		
		System.out.println(keyWord+"," +pageSize+", "+pageNumber);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		//Search in hibernate
		SearchBookMessage msg;
		msg = new SearchBookMessage();
		try {
			BooksDAO dao = new BooksDAO();
			List<Books> li = (List<Books>)dao.findByIsbn(keyWord);
			msg.setPage(Integer.valueOf(pageNumber));
			msg.setTotalPage(100 / Integer.valueOf(pageSize));
			msg.setContent(li);
			msg.setStatus("true");
		} catch (Exception e) {
			msg.setStatus("false");
		}
		
		// send the data
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		System.out.println("Data we send: " + gson.toJson(msg));

		// send the data
		resp.getWriter().write(gson.toJson(msg));
	}
	
	public String decompositeJSON(JsonObject jsonObject, String attr){
		return ((jsonObject.get(attr).toString()).split("\""))[1];
	}

}
