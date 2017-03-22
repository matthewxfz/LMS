package test.service;

import org.junit.Test;

import edu.lms.service.impl.FachingBooksServiceImple;

public class TestFachingBooksServiceImple {
	
	@Test
	public void testGetBooksByISBN(){
		FachingBooksServiceImple service = new FachingBooksServiceImple();
		
		service.getBooksByISBN("number");
	}

}
