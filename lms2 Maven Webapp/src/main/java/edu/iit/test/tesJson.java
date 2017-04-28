package edu.iit.test;

import java.util.Date;
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
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class tesJson {
	
	@Test
	public void testSingleObjects() {
		String input = "{\"account\":\"matthewxfz@gmail.com\",\"password\":\"sadfasdfa\"}";
		
		JsonElement jelement = new JsonParser().parse(input);
	    JsonObject  jobject = jelement.getAsJsonObject();
	   // jobject = jobject.getAsJsonObject("data");
//			    JsonArray jarray = jobject.getAsJsonArray("translations");
//			    jobject = jarray.get(0).getAsJsonObject();
	   // JsonElement account = jobject.getAsJsonObject("account")
	
	    String account = jobject.get("account").toString();
	    String password = jobject.get("password").toString();
	    System.out.println(account+", "+password);
	}
	
//	@Test
//	public void testMultiObjects(){
//		List<Students> ll = new LinkedList<Students>();
//		
//		ll.add(new Students("1", "Xiong", "fangzhou", new Date(2008-12-12), "male", 23, "matthewxfz@gmail.com", "A20376382"));
//		
//		Message<List<Students>> msg = new Message<List<Students>>();
//		msg.title="students";
//		msg.status="true";
//		msg.content = ll;
//		GsonBuilder builder = new GsonBuilder();
//	    Gson gson = builder.create();
//	    
//	    String sendingJson = gson.toJson(msg);
//		
//	    System.out.println("This is the sending data:" + sendingJson);
//	    
//	    //recived
//	    JsonElement jelement = new JsonParser().parse(sendingJson);
//	    JsonObject  jobject = jelement.getAsJsonObject();
//	    String title = jobject.get("title").toString();
//	    String status = jobject.get("status").toString();
//
//	    //JsonObject content = jobject.getAsJsonObject("content");
//	    JsonArray content = jobject.getAsJsonArray("content");
//	    jobject = content.get(0).getAsJsonObject();
//	}
	
	@Test
	public void testSplist(){
		String input = "{\"account\":\"matthewxfz@gmail.com\",\"password\":\"sadfasdfa\"}";
		JsonElement jelement = new JsonParser().parse(input);
	    JsonObject  jobject = jelement.getAsJsonObject();
		System.out.println(decompositeJSON(jobject, "account"));
	}
	
	public String decompositeJSON(JsonObject jsonObject, String attr){
		return ((jsonObject.get(attr).toString()).split("\""))[1];
	}
	
//	@Test
//	public void testDue(){
//		int studentId = 1;
//		OrdersDAO dao = new OrdersDAO();
//		List<Orders> ll = (List<Orders>)dao.check_overdue(1, 2);
//		System.out.println("result:"+ll.get(0).getStudents().getStudentId());
//		
//	}
	
	@Test
	public void testCap(){
		StudentsDAO dao = new StudentsDAO();
		String content = String.valueOf(dao.booktoborrow(Integer.valueOf(1)));
		System.out.println(content);
	}
}
