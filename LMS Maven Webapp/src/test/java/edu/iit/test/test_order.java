package edu.iit.test;

import java.util.ArrayList;
import java.util.List;

import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class test_order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentsDAO dao=new StudentsDAO();
		OrdersDAO odao=new OrdersDAO();
		Students sd=dao.findById(1);
		List<Orders> list=new ArrayList<Orders>();
		//list=odao.findDueBooksByStudentId(1,2,sd);
		int xf_class = dao.booktoborrow(sd);
		//System.out.println(list.get(0).getStudents().getFirstName());
		System.out.println(xf_class);
	}

}
