package edu.iit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.iit.dao.Admins;
import edu.iit.dao.AdminsDAO;
import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class test_order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentsDAO dao=new StudentsDAO();
		OrdersDAO odao=new OrdersDAO();
		Students sd=dao.findById(2);
		BooksDAO bdao =new BooksDAO();
		//AdminsDAO adao= new AdminsDAO();
		//Books b= bdao.findById(1);
		//Admins m = adao.findById(1);
		//List<Orders> list=new ArrayList<Orders>();
		//list=odao.findDueBooksByStudentId(1,2,sd);
		//int xf_class = dao.booktoborrow(1);
		//Date checkindate;
		//try {
		//	checkindate = new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-01");
		//	Date duedate =new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-01");
		//	Orders oo = new Orders(b, m, sd, checkindate,null, duedate,"Rent", "Open");
			//odao.save(oo);
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
			
		//System.out.println(list.get(0).getStudents().getFirstName());
		//System.out.println(xf_class);
		
		//@test update_order
		//odao.update_order(1,1);
		odao.testfind(1);
	}

}
