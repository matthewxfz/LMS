package edu.iit.test;
import java.util.List;

import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;

public class test_book_findbyAuthor{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BooksDAO dao =  new BooksDAO();
		//select 
		Object author ="1";
		List<Books>  booklist = dao.findByAuthor(author);
		
		System.out.println("hello this is :\n"+booklist.toString());

	}

}
