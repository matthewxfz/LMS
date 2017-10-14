package edu.iit.test;
import java.util.List;

import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;

public class test_book_findall{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BooksDAO dao =  new BooksDAO();
		Object title ="1";
		//select 
		List<Books>  booklist = dao.findByTitle(title);
		
		System.out.println("hello this is :\n"+booklist.toString());

	}

}
