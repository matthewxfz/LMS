package edu.iit.admin.servlet;

import java.util.ArrayList;
import java.util.List;

import edu.iit.bean.ClassMessage;
import edu.iit.bean.OrderMessage;
import edu.iit.dao.Classes;
import edu.iit.dao.ClassesDAO;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.RegisterTo;
import edu.iit.dao.RegisterToDAO;
import edu.iit.dao.RegisterToId;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class searchClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String keyword = "A20376382";
		ClassMessage cmsg = process(keyword);
		for(int i =0;i<cmsg.getContent().size();i++){
			System.out.println(cmsg.getContent().get(i).getTitle());
		}
		System.out.println(cmsg);
	}
	public static ClassMessage process(String keyword){
		RegisterToDAO rdao= new RegisterToDAO();
		ClassesDAO cdao= new ClassesDAO();
		StudentsDAO sdao=new StudentsDAO();
		List<Students> generateIDlist=sdao.findByUserId(keyword);
		ClassMessage cmsg= new ClassMessage();
		if(generateIDlist.size()==0){
			cmsg.setStatus("true");
			cmsg.setTitle("Select Courses first");
			cmsg.setTotalclass("0");
			cmsg.setContent(null);
		}
		String studentid = String.valueOf(generateIDlist.get(0).getStudentId());
		try {
			List<RegisterTo> cl = rdao.findByStudentID(studentid);//find all order
			List<Classes> classList=new ArrayList<Classes>();
			for(int i =0; i< cl.size();i++){
				classList.add(cl.get(i).getClasses());
			}
				cmsg.setStatus("true");
				cmsg.setTitle("Orders of book found");
				cmsg.setTotalclass(String.valueOf(classList.size()));
				cmsg.setContent(classList);
			return cmsg;
		} catch (Exception e) {
			cmsg.setStatus("false");
			cmsg.setTitle("error!");
			cmsg.setContent(null);
			System.out.println(cmsg.getContent().toString());
			return cmsg;
		}
	}
}
