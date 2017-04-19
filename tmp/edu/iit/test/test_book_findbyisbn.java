package edu.iit.test;
import java.util.List;

import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;

public class test_book_findbyisbn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BooksDAO dao =  new BooksDAO();
		Object isbn ="123";
		//select 
		List<Books>  booklist = dao.findByIsbn(isbn);
		
		System.out.println("hello this is :\n"+booklist.toString());

	}

}
