package edu.iit.test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.iit.bean.Message;
import edu.iit.bean.StudentMessage;
import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.OrdersDAO_backup2;
import edu.iit.dao.OrdersDAO_backup;
import edu.iit.dao.OrdersId;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;
import edu.iit.util.StudentAdapter;

public class tesJson {

	@Test
	public void testSingleObjects() {
		String input = "{\"account\":\"matthewxfz@gmail.com\",\"password\":\"sadfasdfa\"}";

		JsonElement jelement = new JsonParser().parse(input);
		JsonObject jobject = jelement.getAsJsonObject();
		// jobject = jobject.getAsJsonObject("data");
		// JsonArray jarray = jobject.getAsJsonArray("translations");
		// jobject = jarray.get(0).getAsJsonObject();
		// JsonElement account = jobject.getAsJsonObject("account")

		String account = jobject.get("account").toString();
		String password = jobject.get("password").toString();
		System.out.println(account + ", " + password);
	}

	// @Test
	// public void testMultiObjects(){
	// List<Students> ll = new LinkedList<Students>();
	//
	// ll.add(new Students("1", "Xiong", "fangzhou", new Date(2008-12-12),
	// "male", 23, "matthewxfz@gmail.com", "A20376382"));
	//
	// Message<List<Students>> msg = new Message<List<Students>>();
	// msg.title="students";
	// msg.status="true";
	// msg.content = ll;
	// GsonBuilder builder = new GsonBuilder();
	// Gson gson = builder.create();
	//
	// String sendingJson = gson.toJson(msg);
	//
	// System.out.println("This is the sending data:" + sendingJson);
	//
	// //recived
	// JsonElement jelement = new JsonParser().parse(sendingJson);
	// JsonObject jobject = jelement.getAsJsonObject();
	// String title = jobject.get("title").toString();
	// String status = jobject.get("status").toString();
	//
	// //JsonObject content = jobject.getAsJsonObject("content");
	// JsonArray content = jobject.getAsJsonArray("content");
	// jobject = content.get(0).getAsJsonObject();
	// }

	@Test
	public void testSplist() {
		String input = "{\"account\":\"matthewxfz@gmail.com\",\"password\":\"sadfasdfa\"}";
		JsonElement jelement = new JsonParser().parse(input);
		JsonObject jobject = jelement.getAsJsonObject();
		System.out.println(decompositeJSON(jobject, "account"));
	}

	public String decompositeJSON(JsonObject jsonObject, String attr) {
		return ((jsonObject.get(attr).toString()).split("\""))[1];
	}

	// @Test
	// public void testDue(){
	// int studentId = 1;
	// OrdersDAO dao = new OrdersDAO();
	// List<Orders> ll = (List<Orders>)dao.check_overdue(1, 2);
	// System.out.println("result:"+ll.get(0).getStudents().getStudentId());
	//
	// }
	//
	@Test
	public void testCap() {
		StudentsDAO dao = new StudentsDAO();
		String content = String.valueOf(dao.booktoborrow(Integer.valueOf(1)));
		System.out.println(content);
	}

	@Test
	public void testFindOrder() {
		OrdersDAO_backup2 odao = new OrdersDAO_backup2();
		Orders order = (Orders) odao.findById(new OrdersId(1, 2));
		System.out.println(order == null ? "null" : order.getAdminId());
	}

	@Test
	public void testFindAllRent() {
		OrdersDAO_backup dao = new OrdersDAO_backup();
		List<Books> ls = dao.findALLBooks_book_ByStudentId(1, 6, 1);
		System.out.println(ls.get(0).getAuthor());
	}

	@Test
	public void testStudent() {
		StudentMessage msg = new StudentMessage();
		StudentsDAO sdao = new StudentsDAO();
		msg.content = (Students)sdao.findById(1);
		// send the data
		Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(Students.class, new StudentAdapter())
				.create();
		System.out.println("[Student Profile]Data we send: " + gson.toJson(msg));
	}
	
	@Test
	public void testGetDueBooks(){
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
	}
	
	@Test
	public void testDataDifferent(){
		ZoneId zonedId = ZoneId.of("America/Chicago");
		LocalDate ltoday = LocalDate.now(zonedId);
		Date today = java.sql.Date.valueOf(ltoday);
		OrdersDAO odao = new OrdersDAO();
		Orders order = odao.findById(14);
		Date dueday = order.getDueDate();
		
		long diff = Math.abs(dueday.getTime() - today.getTime());
		long diffDays = diff / (24 * 60 * 60 * 1000);
		System.out.println(diffDays);
	}
	
	@Test
	public void testFindDue(){
		BooksDAO bdao = new BooksDAO();
		System.out.println(bdao.findDueBookNumber(1));
		
	}
}
