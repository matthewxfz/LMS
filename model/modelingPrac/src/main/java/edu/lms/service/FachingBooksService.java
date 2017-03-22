package edu.lms.service;

import java.util.List;

import edu.lms.bean.Books;

public interface FachingBooksService {
	public Books getBooksByISBN(String isbns);
	
	public List<Books> getBooksByTitle(String title);
}
