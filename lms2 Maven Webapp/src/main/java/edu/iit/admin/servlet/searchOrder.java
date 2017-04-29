package edu.iit.admin.servlet;

import java.util.List;

import org.junit.Test;

import edu.iit.bean.OrderMessage;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;

public class searchOrder {
	
	public static void main(String[] args) {
		String keyword = "";
		String isClose = "Open";
		String pageNumber = "1";
		String pageSize = "3";
		System.out.println("ok");
		OrderMessage omsg = process(keyword, isClose, pageNumber, pageSize);
		for(int i =0;i<omsg.getContent().size();i++){
			System.out.println(omsg.getContent().get(i).getCheckinDate());
		}
		System.out.println(omsg.getTotalNumber());
	}
	public static OrderMessage process(String keyword, String isClose, String pageNumber,String pageSize){
		OrdersDAO odao= new OrdersDAO();
		OrderMessage omsg= new OrderMessage();
		int num_page =Integer.valueOf(pageNumber);
		int num_pagesize =Integer.valueOf(pageSize);
		try {
			if(keyword.equals("")){
				List<Orders> ol = odao.findAll(num_page,num_pagesize);//find all order open
				int total_pagenumber = odao.findAllNum();//find total num
				omsg.setStatus("true");
				omsg.setTitle("All book");
				omsg.setTotapage(String.valueOf(Math.round(total_pagenumber/num_pagesize)));
				omsg.setTotalNumber(String.valueOf(total_pagenumber));
				omsg.setContent(ol);
				return omsg;
			}
			int bookid = Integer.valueOf(keyword);
			if(isClose.equals("Closed")){
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
