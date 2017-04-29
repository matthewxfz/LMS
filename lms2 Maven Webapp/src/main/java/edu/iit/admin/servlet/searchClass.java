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

public class searchClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String keyword = "1";
		String isClose = "Closed";
		String pageNumber = "1";
		String pageSize = "3";
		System.out.println("ok");
		ClassMessage cmsg = process(keyword);
		for(int i =0;i<cmsg.getContent().size();i++){
			System.out.println(cmsg.getContent().get(i));
		}
		System.out.println(cmsg);
	}
	public static ClassMessage process(String keyword){
		RegisterToDAO rdao= new RegisterToDAO();
		ClassesDAO cdao= new ClassesDAO();
		String studentid = keyword;
		ClassMessage cmsg= new ClassMessage();
		try {
			List<RegisterTo> cl = rdao.findByStudentID(studentid);//find all order
			List<Classes> classnameList=new ArrayList<Classes>();
			if(cl.size()==0){//no class
				cmsg.setStatus("true");
				cmsg.setTitle("Select Courses first");
				cmsg.setTotalNumber("0");
				cmsg.setContent(null);
			}else{//show classes
				omsg.setStatus("true");
				omsg.setTitle("Orders of book found");
				omsg.setTotapage(String.valueOf(Math.round(total_pagenumber/num_pagesize)));
				omsg.setTotalNumber(String.valueOf(total_pagenumber));
				omsg.setContent(ol);
			}
			return omsg;
		} catch (Exception e) {
			omsg.setStatus("false");
			omsg.setTitle("error!");
			omsg.setContent(null);
			System.out.println(omsg.getContent().toString());
			return omsg;
		}
	}
}
