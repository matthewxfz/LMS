package edu.iit.test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Order;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.iit.bean.Message;
import edu.iit.bean.OrdersMessage;
import edu.iit.bean.SearchBookMessage;
import edu.iit.dao.Admins;
import edu.iit.dao.AdminsDAO;
import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;
import edu.iit.dao.BooksWithRefference;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO_backup2;
import edu.iit.dao.OrdersDAO_backup;
import edu.iit.dao.OrdersId;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;
import edu.iit.util.BooksAdapter;

public class testFind {

	public static void main(String[] args) {
		String adminId = "1";
		String studentId = "2";
		String generatedId = "9";
		String operation = "return";
		String commit = "true";
		process(adminId, studentId, generatedId, operation, commit);
	}

	public static Message process(String AdminId, String studentId, String generatedId, String operation,
			String commit) {
		BooksDAO bdao = new BooksDAO();
		OrdersDAO_backup2 odao = new OrdersDAO_backup2();
		StudentsDAO sdao = new StudentsDAO();
		AdminsDAO adao = new AdminsDAO();

		// book, order, student, admin
		Books book = ((List<Books>) bdao.findByGeneratedId(generatedId)).get(0);

		Students student = (Students) sdao.findById(Integer.valueOf(studentId));
		Admins admin = (Admins) adao.findById(Integer.valueOf(AdminId));

		Message msg = new Message();

		ZoneId zonedId = ZoneId.of("America/Chicago");
		LocalDate ltoday = LocalDate.now(zonedId);
		Date today = java.sql.Date.valueOf(ltoday);
		Date dueDay = java.sql.Date.valueOf(ltoday.minusMonths(-1));

		if (operation == "rent") {// Rent
			Orders order = (Orders) odao.findOpenOrdersByBookId(book.getBookId());
			if (order == null) {
				// no one rent the book
				if (commit == "false") {// No really want to rent the book!

					msg.status = "true";
					msg.title = "Renting Information! Press yes button to commit!";
					msg.content = "Rent to:\n" + "Student Name: " + student.getLastName() + ", "
							+ student.getFirstName() + "\n" + "Studnet Id: " + studentId + "\n" + "With Book:\n"
							+ "Book ID: " + book.getGeneratedId() + "\n" + "Book Info: " + book.getTitle() + ", by: "
							+ book.getAuthor() + ", pressed by: " + book.getPublisher() + "\n" + "During:\n" + "Today: "
							+ today.toString() + "\n" + "Due day: " + dueDay.toString() + "\n";

					System.out.println(msg.content);
				} else {// really want to rent the book!
					System.out.println(msg.content);
					if (addorder(odao, student, book, admin)) {// add the order
																// successful!

						msg.setStatus("true");
						msg.title = "Rent Successfull!, Check receipt";
						msg.content = "Rent to:\n" + "Student Name: " + student.getLastName() + ", "
								+ student.getFirstName() + "\n" + "Studnet Id: " + studentId + "\n" + "With Book:\n"
								+ "Book ID: " + book.getGeneratedId() + "\n" + "Book Info: " + book.getTitle()
								+ ", by: " + book.getAuthor() + ", pressed by: " + book.getPublisher() + "\n"
								+ "During:\n" + "Today: " + today + "\n" + "Due day: " + dueDay.toString() + "\n";

					} else {// add the order fail!
						msg.status = "false";
						msg.title = "Oops!";
						msg.content = "inner Server Error!";
					}
				}
			} else if (order.getStudentId() != Integer.valueOf(studentId)) {
				msg.status = "false";
				msg.title = "Oops!";
				msg.content = "Student with id " + order.getStudentId() + " Rent the book!" + "\nThe book is due on:"
						+ order.getDueDate();
			} else {
				msg.status = "false";
				msg.title = "Oops!";
				msg.content = "You rent the book and not returned it yet.";
			}
		} else {// want to return?
			Orders order = (Orders) odao.findOpenOrderById(book.getBookId(), Integer.valueOf(studentId));
			if (order == null) {
				msg.status = "false";
				msg.title = "Oops!";
				msg.content = "The Student Never Rent the Book!";
			} else {
				if (updateorder(order)) {// return scuessfull
					msg.setStatus("true");
					msg.title = "Rent Successfull!, Check receipt";
					msg.content = "Return By:\n" + "Student Name: " + student.getLastName() + ", "
							+ student.getFirstName() + "\n" + "Studnet Id: " + studentId + "\n" + "With Book:\n"
							+ "Book ID: " + book.getGeneratedId() + "\n" + "Book Info: " + book.getTitle() + ", by: "
							+ book.getAuthor() + ", pressed by: " + book.getPublisher() + "\n" + "During:\n" + "Today: "
							+ order.getCheckinDate().toString() + "\n" + "Due day: " + today.toString() + "\n";

					odao.commit();
				} else {
					msg.status = "false";
					msg.title = "Oops!";
					msg.content = "inner Server Error!";
				}
			}
		}

		System.out.println(msg.content);

		return msg;
	}

	private static boolean addorder(OrdersDAO_backup2 odao, Students student, Books book, Admins admin) {
		ZoneId zonedId = ZoneId.of("America/Chicago");
		LocalDate ltoday = LocalDate.now(zonedId);
		Date today = java.sql.Date.valueOf(ltoday);
		Date dueDay = java.sql.Date.valueOf(ltoday.minusMonths(-1));

		try {
			Orders curOrder = new Orders(today, dueDay, "Rent", "Open", student.getStudentId(), book.getBookId(),
					admin.getAdminId());
			odao.save(curOrder);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	private static boolean updateorder(Orders order) {
		ZoneId zonedId = ZoneId.of("America/Chicago");
		LocalDate ltoday = LocalDate.now(zonedId);
		Date today = java.sql.Date.valueOf(ltoday);
		try {
			order.setStatues("Closed");
			order.setCheckoutDate(today);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
