package edu.iit.test;

import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.iit.bean.SearchBookMessage;
import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;


public class tesGet {
	
	@Test
	public void testFindByISBN(){
		SearchBookMessage msg;
		msg = new SearchBookMessage();
		BooksDAO dao = new BooksDAO();
		List<Books> li = (List<Books>)dao.findByIsbn("978-0130948557");
		System.out.println(li.toArray()[0]);
		msg.setPage(Integer.valueOf(1));
		msg.setTotalPage(100 / Integer.valueOf(6));
		msg.setContent(li);
		msg.setStatus("true");
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		System.out.println(gson.toJson(msg));
	}

}
