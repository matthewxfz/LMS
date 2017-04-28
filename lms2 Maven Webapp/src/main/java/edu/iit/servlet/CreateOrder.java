package edu.iit.servlet;

import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.iit.bean.OrdersMessage;
import edu.iit.bean.SearchBookMessage;
import edu.iit.dao.Admins;
import edu.iit.dao.AdminsDAO;
import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class CreateOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		System.out.println("The string is "+jb.toString());
//		//decomposite the input json
		JsonElement jelement = new JsonParser().parse(jb.toString());
		JsonObject jobject = jelement.getAsJsonObject();
		String studentid = decompositeJSON(jobject, "studentId");
		String bookgenerateid = decompositeJSON(jobject, "GeneratedID");

		System.out.println(studentid+bookgenerateid);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		//Search in hibernate
		OrdersMessage msg;
		msg = new OrdersMessage();
		try {
			BooksDAO bdao = new BooksDAO();
			StudentsDAO sdao= new StudentsDAO();
			OrdersDAO odao =new OrdersDAO();
			AdminsDAO adao = new AdminsDAO();
			List<Books> cur_book = bdao.findByGeneratedId(Integer.getInteger(bookgenerateid));
			int cur_bid = cur_book.get(0).getBookId();
			List<Orders> cur_orderOrders=odao.findByBookID(cur_bid);
			Admins cur_admin = adao.findById(1);
			if(cur_orderOrders == null){
				addorder(sdao,studentid,cur_book,cur_admin);
				msg.setTitle("successfully create");
				msg.setStatus("true");
			}else{
				int cur_statue = 0;
				Orders cur_order= new Orders();
				Object s1="Open";
				Object s2="Closed";
				cur_order.setStatues("Closed");
				for(int i =0;i<cur_orderOrders.size();i++){
					if(cur_orderOrders.get(i).getStatues().equals(s1)){
						cur_order=cur_orderOrders.get(i);
						cur_statue=1;
						updateorder(cur_order);
						msg.status="true";
						msg.title="successfully update";
					}
				}
				if(cur_statue==0){
					addorder(sdao,studentid,cur_book,cur_admin);
					msg.setTitle("successfully create");
					msg.setStatus("true");
				}
			}
		
		} catch (Exception e) {
			msg.setTitle("error");
			msg.setStatus("false");
		}
		// send the data
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		System.out.println("Data we send: " + gson.toJson(msg));

		// send the data
		resp.getWriter().write(gson.toJson(msg));
	}
	private static void addorder(StudentsDAO sdao,String studentid,List<Books> cur_book,Admins cur_admin){
	    Students cur_student = new Students();
			sdao.findById(Integer.getInteger(studentid));
			ZoneId zonedId = ZoneId.of( "America/Chicago" );
			LocalDate ltoday = LocalDate.now( zonedId );
			java.util.Date today = java.sql.Date.valueOf(ltoday);
			java.util.Date due_today = java.sql.Date.valueOf(ltoday.minusMonths(-1));
			Orders current_order= new Orders(cur_book.get(0),cur_admin, cur_student,today, due_today, "Rent","Open");
	}
	private static void updateorder(Orders cur_order){
		//Search in hibernate
		ZoneId zonedId = ZoneId.of( "America/Chicago" );
		LocalDate ltoday = LocalDate.now( zonedId );
		java.util.Date today = java.sql.Date.valueOf(ltoday);
		cur_order.setStatues("Closed");
		cur_order.setCheckoutDate(today);
	}
	public static String decompositeJSON(JsonObject jsonObject, String attr){
		return ((jsonObject.get(attr).toString()).split("\""))[1];
	}
}
