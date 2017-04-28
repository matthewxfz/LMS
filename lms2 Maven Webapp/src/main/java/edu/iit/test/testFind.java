package edu.iit.test;

import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.iit.bean.SearchBookMessage;
import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;
import edu.iit.dao.BooksWithRefference;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;
import edu.iit.util.BooksAdapter;

public class testFind {

	// @Test
	public static void main(String[] args) {
		int studentId = 1;
		BooksDAO dao = new BooksDAO();
		List<Books> ll = (List<Books>) dao.findDueBooks(1, 1, 4);
		System.out.println("result:" + ll.get(2).getAuthor());

		// send the data
		Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(Books.class, new BooksAdapter()).create();
		SearchBookMessage msg = new SearchBookMessage();
		msg.setContent(ll);
		// Gson gson = builder.create();

		System.out.println("Data we send: " + gson.toJson(msg));

	}

}
