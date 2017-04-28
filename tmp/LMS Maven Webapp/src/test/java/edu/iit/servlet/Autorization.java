package edu.iit.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.iit.bean.LoginMessage;
import edu.iit.bean.Message;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

@WebServlet(urlPatterns = { "/login" })
public class Autorization extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LoginMessage msg = new LoginMessage();
		System.out.println("We ge the messgae");
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		 }

		System.out.println(jb.toString());
		// http://stackoverflow.com/questions/5490789/json-parsing-using-gson-for-java
		JsonElement jelement = new JsonParser().parse(jb.toString());
		JsonObject jobject = jelement.getAsJsonObject();
		String account = jobject.get("account").toString();
		account = (account.split("\""))[1];
		String password = jobject.get("password").toString();
		password = (password.split("\""))[1];
		System.out.println(account + ", " + password);
	
		//Search in hibernate
		StudentsDAO dao = new StudentsDAO();
		List<Students> ll = dao.findByEmail(account);
		if(ll.size() == 1){
			Students stu = ll.get(0);
			if(stu.getPas().equals(password)){
				msg.setTitle("");
				msg.setStatus("true");
				msg.setFirstName(stu.getFirstName());
				msg.setUserId(stu.getUserId());
				
			}else{
				msg.setTitle("");
				msg.setStatus("false");
				//msg.firstName = null;
			}
		}else{
			msg.setTitle("");
			msg.setStatus("false");
			//msg.content = null;
		}
	

		// send the data
		GsonBuilder builder = new GsonBuilder();
		//builder.registerTypeAdapter(Message.class, new InterfaceAdapter<Students>());
		Gson gson = builder.create();

		System.out.println("Data we send: " + gson.toJson(msg));

		// send the data
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(gson.toJson(msg));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
