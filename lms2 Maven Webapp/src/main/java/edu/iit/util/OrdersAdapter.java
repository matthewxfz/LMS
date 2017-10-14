package edu.iit.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializer;

import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;
import edu.iit.dao.Orders;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class OrdersAdapter implements JsonSerializer<Orders>{
	public JsonElement serialize(Orders orders, java.lang.reflect.Type type, com.google.gson.JsonSerializationContext jsc) {
		JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("orderId", String.valueOf(orders.getOrderId()));
        jsonObject.addProperty("dueDate", orders.getDueDate().toString());
        jsonObject.addProperty("checkInDate", orders.getCheckinDate().toString());
        jsonObject.addProperty("status", orders.getStatues());
        StudentsDAO sdao = new StudentsDAO();
        Students stu = sdao.findById(orders.getStudentId());
        jsonObject.addProperty("studentLastName", stu.getLastName());
        jsonObject.addProperty("studentFirstName", stu.getLastName());
        jsonObject.addProperty("studentGeneratedId", stu.getUserId());
        jsonObject.addProperty("studentEmail", stu.getEmail());
        BooksDAO bdao = new BooksDAO();
        Books book = bdao.findById(orders.getBookId());
        jsonObject.addProperty("bookTitle", book.getTitle());
        jsonObject.addProperty("bookAuthor", book.getAuthor());
        jsonObject.addProperty("bookPublisher", book.getPublisher());
        jsonObject.addProperty("booGeneratedId", book.getGeneratedId());
        
        return jsonObject;      
	};
}
