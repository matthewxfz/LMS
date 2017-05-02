package edu.iit.test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;

public class testDate {
	
	public static void main(String[] args){
		ZoneId zonedId = ZoneId.of("America/Chicago");
		LocalDate ltoday = LocalDate.now(zonedId);
		Date today = java.sql.Date.valueOf(ltoday);
		
		OrdersDAO odao = new OrdersDAO();
		List<Orders> ls  = (List<Orders>) odao.findDueOrdersByStudentId(1);
		System.out.println(today.toString());
		Iterator<Orders> ite =ls.iterator();
		while(ite.hasNext()){
			System.out.println("Due order:"+ite.next().getDueDate());
		}
		
		BooksDAO bdao = new BooksDAO();
		List<Books> lis = bdao.findAllDueBooks(1, 10);
		
		System.out.println("Book ID:"+lis.get(0).getBookId()+lis.get(0).getTitle());
		System.out.println("Book ID:"+lis.get(1).getBookId()+lis.get(1).getTitle());
	}
	

}
