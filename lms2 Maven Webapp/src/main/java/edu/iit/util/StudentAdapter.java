package edu.iit.util;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.Order;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mysql.jdbc.log.Log;

import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.Parents;
import edu.iit.dao.ParentsId;
import edu.iit.dao.Students;

public class StudentAdapter implements JsonSerializer<Students> {
	public JsonElement serialize(Students student, java.lang.reflect.Type type,
		com.google.gson.JsonSerializationContext jsc) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("studentId", student.getStudentId());
		jsonObject.addProperty("generatedId", student.getUserId());
		
		jsonObject.addProperty("firstName", student.getFirstName());
		jsonObject.addProperty("lastName", student.getLastName());
		jsonObject.addProperty("middleName", student.getMiddleName());
		jsonObject.addProperty("email", student.getEmail());
		jsonObject.addProperty("power", student.getPower());
		jsonObject.addProperty("address", student.getAddress());
		Set pset = student.getParentses();
		
		Parents parent;
		Iterator<Parents> ite = pset.iterator();
		if (ite.hasNext()) {
			parent = ite.next();
		}else{
			parent = new Parents(new ParentsId("Not Defined","Not Defined",-1), null, "Not Defined", "Not Defined", "Not Defined", "0");
		}
		jsonObject.addProperty("pFirstName", parent.getId().getFirstName());
		jsonObject.addProperty("pLastName", parent.getId().getLastName());
		jsonObject.addProperty("pMiddleName", parent.getMiddleName());
		jsonObject.addProperty("pEmail", student.getEmail());
		jsonObject.addProperty("pMobile", student.getMoblie());
		
		//Class information
		jsonObject.addProperty("classN", student.getRegisterTos().size());
		//Book informaiton
		BooksDAO bdao = new BooksDAO();
		OrdersDAO odao = new OrdersDAO();
		List<Orders> orders = odao.findDueOrdersByStudentId(student.getStudentId());
		int cost = 0;
		int dueBooks = 0;
		ZoneId zonedId = ZoneId.of("America/Chicago");
		LocalDate ltoday = LocalDate.now(zonedId);
		Date today = java.sql.Date.valueOf(ltoday);
		Iterator<Orders> ite2 = orders.iterator();
		while(ite2.hasNext()){
			Orders order = ite2.next();
			long diff = Math.abs(today.getTime() - order.getDueDate().getTime());
			long diffDays = diff / (24 * 60 * 60 * 1000);
			cost += diffDays;
			dueBooks++;
		}
		jsonObject.addProperty("dueNum", String.valueOf(dueBooks));
		jsonObject.addProperty("dueHour",String.valueOf(cost));
		
		
		return jsonObject;
	}
}
