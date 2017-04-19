package edu.iit.test;

import java.util.List;

import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;

public class test_overdue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrdersDAO dao = new OrdersDAO();
		//Orders o =(Orders)dao.check_overdue(1).get(0);
		List<Orders> ll = dao.check_overdue(2,2);
		// System.out.print(o.getBooks().getIsbn());
		System.out.print(ll.size());
	}

}
