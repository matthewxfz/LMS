package edu.iit.servlet;

import java.io.BufferedReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.iit.bean.SearchBookMessage;
import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;

public class SaveBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		String BookID  = decompositeJSON(jobject, "bookid");
		String ISBN = decompositeJSON(jobject, "isbn");
		String Title = decompositeJSON(jobject, "title");
		String Author = decompositeJSON(jobject, "author");
		String Publisher = decompositeJSON(jobject, "publisher");
		String NumberOfPages = decompositeJSON(jobject, "numberofpages");
		String Cover = decompositeJSON(jobject, "cover");
		String PublicationDate = decompositeJSON(jobject, "publicationdate");
		String Studio = decompositeJSON(jobject, "studio");
		String Manufactor = decompositeJSON(jobject, "manufactor");
		String Status = decompositeJSON(jobject, "status");
		String GeneratedID = decompositeJSON(jobject, "generatedID");
//		
		System.out.println(BookID+"," +ISBN+", "+Title+","+Author+","+Publisher+","+NumberOfPages+","+Cover+","+PublicationDate+","
				+Studio+","+Manufactor+","+Status+","+GeneratedID);
		
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
	public static String decompositeJSON(JsonObject jsonObject, String attr){
		return ((jsonObject.get(attr).toString()).split("\""))[1];
	}
}
