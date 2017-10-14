package edu.iit.test;

import edu.iit.bean.BookMessage;
import edu.iit.servlet.SaveBook;

public class testAdd {
	
	public static void main(String args[]){
		SaveBook sb = new SaveBook();
		BookMessage msg = sb.process("0262033844", "Introduction to Algorithms", "Thomas H. Cormen", "Computers", "1292", "http://books.google.com/books/content?id=i-bUBQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api", "2009-07-31", "", "", "12");
		System.out.println(msg.status.toString()+", "+msg.content);
	}

}
