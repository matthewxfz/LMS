package edu.iit.admin.servlet;

import java.util.List;

import org.junit.Test;

import edu.iit.bean.OrderMessage;
import edu.iit.bean.StudentMessage;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class searchStudent {
	
	public static void main(String[] args) {
		String keyword = "";
		String operation = "Open";
		String pageNumber = "1";
		String pageSize = "3";
		System.out.println("ok");
		StudentMessage smsg = process(keyword,operation ,pageNumber, pageSize);
		for(int i =0;i<smsg.getContent().size();i++){
			System.out.println(smsg.getContent().get(i));
		}
		System.out.println(smsg.getTotalNumber());
	}
	public static StudentMessage process(String keyword,String operation, String pageNumber,String pageSize){
		StudentsDAO sdao= new StudentsDAO();
		StudentMessage smsg= new StudentMessage();
		int num_page =Integer.valueOf(pageNumber);
		int num_pagesize =Integer.valueOf(pageSize);
		try {
			if(keyword.equals("")&& operation.equals("Overdue") ){
				List<Students> sl = sdao.findAll_Overdue(num_page,num_pagesize);//find all order open
				int total_pagenumber = sdao.findAll_Indue();//find total num
				smsg.setStatus("true");
				smsg.setTitle("All student");
				smsg.setTotapage(String.valueOf(Math.round(total_pagenumber/num_pagesize)));
				smsg.setTotalNumber(String.valueOf(total_pagenumber));
				smsg.setContent(sl);
				return smsg;
			}
			int bookid = Integer.valueOf(keyword);
			if(operation.equals("Closed")){
				List<Orders> ol = odao.findByBookID_Closed(Integer.valueOf(bookid),num_page,num_pagesize);//find all order open
				int total_pagenumber = odao.findTotalNum(bookid);//find total num
				if(ol.size()==0){//no order of that book
					omsg.setStatus("true");
					omsg.setTitle("No order of that book");
					omsg.setTotapage("0");
					omsg.setTotalNumber("0");
					omsg.setContent(null);
				}else{
					omsg.setStatus("true");
					omsg.setTitle("Orders of book found");
					omsg.setTotapage(String.valueOf(Math.round(total_pagenumber/num_pagesize)));
					omsg.setTotalNumber(String.valueOf(total_pagenumber));
					omsg.setContent(ol);
				}
			}else{
				List<Orders> ol = odao.findByBookID_Open(Integer.valueOf(bookid),num_page,num_pagesize);//find all order open
				int total_pagenumber = odao.findTotalNum(bookid);//find total num
				if(ol.size()==0){//no order of that book
					omsg.setStatus("true");
					omsg.setTitle("No order of that book");
					omsg.setTotapage("0");
					omsg.setTotalNumber("0");
					omsg.setContent(null);
				}else{
					omsg.setStatus("true");
					omsg.setTitle("Orders of book found");
					omsg.setTotapage(String.valueOf(Math.round(total_pagenumber/num_pagesize)));
					omsg.setTotalNumber(String.valueOf(total_pagenumber));
					omsg.setContent(ol);
				}
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
