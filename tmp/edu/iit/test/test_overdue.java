package edu.iit.test;

import java.util.List;

import edu.iit.dao.Books;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.Students;

public class test_overdue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrdersDAO dao = new OrdersDAO();
		//Orders o =(Orders)dao.check_overdue(1).get(0);
		List<Orders> ll = dao.findAllDueBooks(1,2);
		List<Students> ls = dao.find_overdue_student(1,2);
		List<Books> lb = dao.check_overdue_book(1,2);
		// System.out.print(o.getBooks().getIsbn());
		System.out.print(ll.size());
		//System.out.print(lb.toString());
		//System.out.print(ls.toString());
	}

}
