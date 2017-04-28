package edu.iit.test;

import java.sql.Timestamp;

import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;

public class test_savebook {
	public static void main(String[] args) {
	    Timestamp st =new Timestamp (2017030000);
		BooksDAO  dao = new BooksDAO ();
		Books bk= new Books("978-1491962299", "Hands-On Machine Learning with Scikit-Learn", " Aurélien Géron", "O'Reilly Media, Inc", 2000, "", st, "1","1", "available", "123");
		dao.save(bk);
	}
}
