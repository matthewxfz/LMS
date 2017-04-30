package edu.iit.admin.servlet;

import java.util.List;

import edu.iit.bean.OrderMessage;
import edu.iit.bean.TeacherMessage;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.Teachers;
import edu.iit.dao.TeachersDAO;

public class searchTeacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		String pageNumber = "1";
		String pageSize = "3";
		System.out.println("ok");
		TeacherMessage tmsg = process(pageNumber, pageSize);
		for(int i =0;i<tmsg.getContent().size();i++){
			System.out.println(tmsg.getContent().get(i).getEmail());
		}
		System.out.println(tmsg.getTotalNumber());
	}
	public static TeacherMessage process(String pageNumber,String pageSize){
		TeachersDAO tdao= new TeachersDAO();
		TeacherMessage tmsg= new TeacherMessage();
		int num_page =Integer.valueOf(pageNumber);
		int num_pagesize =Integer.valueOf(pageSize);
		List<Teachers> ol = tdao.findAll(num_page,num_pagesize);//find all order open
		int total_pagenumber = tdao.findAllNum();//find total num
		tmsg.setStatus("true");
		tmsg.setTitle("All Teachers");
		tmsg.setTotapage(String.valueOf(Math.round(total_pagenumber/num_pagesize)));
		tmsg.setTotalNumber(String.valueOf(total_pagenumber));
		tmsg.setContent(ol);
		return tmsg;
	}
}
