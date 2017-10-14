package edu.iit.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.iit.bean.Message;
import edu.iit.bean.OrdersMessage;
import edu.iit.dao.Admins;
import edu.iit.dao.AdminsDAO;
import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO_backup;
import edu.iit.dao.OrdersDAO_backup2;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

@WebServlet(urlPatterns = "/admin/tradeBook")
public class tradeBook extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// read the input
		System.out.println("We get the messgae");
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The string is " + jb.toString());
		// //decomposite the input json
		JsonElement jelement = new JsonParser().parse(jb.toString());
		JsonObject jobject = jelement.getAsJsonObject();
		String adminId = decompositeJSON(jobject, "adminId");
		String generatedId = decompositeJSON(jobject, "generatedId");
		String operation = decompositeJSON(jobject, "operation");
		String studentId = decompositeJSON(jobject, "studentId");
		String commit = decompositeJSON(jobject, "commit");
		
		//process
		Message msg = process(adminId, studentId, generatedId, operation, commit);
		// send the data
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		System.out.println("Data we send: " + gson.toJson(msg));

		// send the data
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(gson.toJson(msg));
	}

	public  Message process(String AdminId, String stuGeneratedId, String generatedId, String operation,
			String commit) {
		BooksDAO bdao = new BooksDAO();
		OrdersDAO_backup2 odao = new OrdersDAO_backup2();
		StudentsDAO sdao = new StudentsDAO();
		AdminsDAO adao = new AdminsDAO();

		// book, order, student, admin
		Books book = ((List<Books>) bdao.findByGeneratedId(generatedId)).get(0);

		Students student = (Students) (sdao.findByUserId(stuGeneratedId).get(0));
		int studentId = student.getStudentId();
		Admins admin = (Admins) adao.findById(Integer.valueOf(AdminId));

		Message msg = new Message();

		ZoneId zonedId = ZoneId.of("America/Chicago");
		LocalDate ltoday = LocalDate.now(zonedId);
		Date today = java.sql.Date.valueOf(ltoday);
		Date dueDay = java.sql.Date.valueOf(ltoday.minusMonths(-1));

		if (operation.equals("rent")) {// Rent
			Orders order = (Orders) odao.findOpenOrdersByBookId(book.getBookId());
			if (order == null) {
				// no one rent the book
				if (commit.equals("false")) {// No really want to rent the book!

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
					msg.title = "Return Successfull!, Check receipt";
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

	private boolean addorder(OrdersDAO_backup2 odao, Students student, Books book, Admins admin) {
		ZoneId zonedId = ZoneId.of("America/Chicago");
		LocalDate ltoday = LocalDate.now(zonedId);
		Date today = java.sql.Date.valueOf(ltoday);
		Date dueDay = java.sql.Date.valueOf(ltoday.minusMonths(-1));

		try {
			Orders curOrder = new Orders(today, dueDay, "Rent", "Open", student.getStudentId(), book.getBookId(),
					admin.getAdminId());
			
			BooksDAO bdao = new BooksDAO();
			Books curBook = (Books)bdao.findById(curOrder.getBookId());
			curBook.setStatus("not available");
			bdao.merge(curBook);
			odao.save(curOrder);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	private boolean updateorder(Orders order) {
		ZoneId zonedId = ZoneId.of("America/Chicago");
		LocalDate ltoday = LocalDate.now(zonedId);
		Date today = java.sql.Date.valueOf(ltoday);
		try {
			order.setStatues("Closed");
			BooksDAO bdao = new BooksDAO();
			Books curBook = (Books)bdao.findById(order.getBookId());
			curBook.setStatus("available");
			bdao.merge(curBook);
			order.setCheckoutDate(today);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public String decompositeJSON(JsonObject jsonObject, String attr) {
		return ((jsonObject.get(attr).toString()).split("\""))[1];
	}
}
