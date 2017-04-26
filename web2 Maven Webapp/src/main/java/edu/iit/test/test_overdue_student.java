package edu.iit.test;

import java.util.List;

import edu.iit.dao.Books;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class test_overdue_student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrdersDAO dao = new OrdersDAO();
		StudentsDAO sdao = new StudentsDAO();
		Students XF= sdao.findById(1);
		//Orders o =(Orders)dao.check_overdue(1).get(0);
		List<Orders> ll = dao.findDueBooksByStudentId(1,2,XF);
		List<Books> lb = dao.findDueBooks_book_ByStudentId(1,2,XF);

		// System.out.print(o.getBooks().getIsbn());
		//System.out.print(ll.toString());
		//System.out.print(lb.toString());
		//System.out.print(ls.toString());
	}

}
