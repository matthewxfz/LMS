package edu.iit.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import edu.iit.bean.BookMessage;
import edu.iit.bean.Message;
import edu.iit.bean.SearchBookMessage;
import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;


@WebServlet(urlPatterns="/addBook")
public class SaveBook extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
		System.out.println("The string is " + jb.toString());
		// //decomposite the input json
		JsonElement jelement = new JsonParser().parse(jb.toString());
		JsonObject jobject = jelement.getAsJsonObject();
		//String BookID = decompositeJSON(jobject, "bookid");
		String ISBN = decompositeJSON(jobject, "isbn");
		String Title = decompositeJSON(jobject, "title");
		String Author = decompositeJSON(jobject, "author");
		String Publisher = decompositeJSON(jobject, "publisher");
		String NumberOfPages = decompositeJSON(jobject, "page");
		String Cover = decompositeJSON(jobject, "cover");
		String PublicationDate = decompositeJSON(jobject, "publicationdate");
		String Studio = decompositeJSON(jobject, "studio");
		String Manufactor = decompositeJSON(jobject, "manufactor");
		String Status = decompositeJSON(jobject, "status");
		String GeneratedID = decompositeJSON(jobject, "generatedID");
		//
		System.out.println(
				ISBN + ", " + Title + "," + Author + "," + Publisher + "," + NumberOfPages + "," + Cover
						+ "," + PublicationDate + "," + Studio + "," + Manufactor + "," + Status + "," + GeneratedID);

		// Search in hibernate
		BookMessage msg = process(ISBN, Title, Author, Publisher, NumberOfPages, Cover, PublicationDate, Studio,
				Manufactor, GeneratedID);

		// send the data
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		System.out.println("Data we send: " + gson.toJson(msg));

		// send the data
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(gson.toJson(msg));
	}
	
	public BookMessage process(String ISBN, String Title, String Author, String Publisher, String NumberOfPages, String Cover, String PublicationDate, String Studio,
			String Manufactor, String GeneratedID){
		BookMessage msg;
		msg = new BookMessage();
		try {
			
			
			BooksDAO dao = new BooksDAO();
			List<Books> books = dao.findByGeneratedId(GeneratedID);
			System.out.println("[ID token]:"+ books.size());
			if(books.size() < 1){
				String[] as = PublicationDate.split("-");
				SimpleDateFormat sdf ;
				if(as.length == 3)
					sdf = new SimpleDateFormat("yyyy-MM-dd");
				else if(as.length == 2)
					sdf = new SimpleDateFormat("yyyy-MM");
				else
					sdf = new SimpleDateFormat("yyyy");
				Date pdate = sdf.parse(PublicationDate);
				Books book = new Books(ISBN, Title, Author, Publisher, Integer.valueOf(NumberOfPages), Cover, pdate, Studio,
						Manufactor, "available", GeneratedID);
				dao.save(book);
				msg.setContent("Saved Book:["+book.getGeneratedId()+"], "+book.getTitle()+", BY "+book.getAuthor()+", "+book.getIsbn());
				msg.setStatus("true");
			}else{
				msg.setStatus("false");
				msg.setContent("GeneratedId had already been token!");
			}
		} catch (Exception e) {
			msg.setStatus("false");
			msg.setContent("Inner Server Error!");
			e.printStackTrace();
		}
		
		return msg;
	}

	public String decompositeJSON(JsonObject jsonObject, String attr){
		try {
			return ((jsonObject.get(attr).toString()).split("\""))[1];
		} catch (Exception e) {
			return "";
		}
		
		
	}
}
