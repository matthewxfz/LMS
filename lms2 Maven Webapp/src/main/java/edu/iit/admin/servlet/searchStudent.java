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
		String operation = "Overdue";
		String pageNumber = "1";
		String pageSize = "3";
		StudentMessage smsg = process(operation ,pageNumber, pageSize);
		for(int i =0;i<smsg.getContent().size();i++){
			System.out.println(smsg.getContent().get(i));
		}
		System.out.println(smsg.getTotalNumber());
	}
	public static StudentMessage process(String operation, String pageNumber,String pageSize){
		StudentsDAO sdao= new StudentsDAO();
		StudentMessage smsg= new StudentMessage();
		int num_page =Integer.valueOf(pageNumber);
		int num_pagesize =Integer.valueOf(pageSize);
		try {
			if(operation.equals("Overdue") ){
				List sl = sdao.findAll_Overdue(num_page,num_pagesize);//find all order open
				int total_pagenumber = sdao.findAll_OverdueNum();//find total num
				smsg.setStatus("true");
				smsg.setTitle("All student Overdue");
				smsg.setTotapage(String.valueOf(Math.round(total_pagenumber/num_pagesize)));
				smsg.setTotalNumber(String.valueOf(total_pagenumber));
				smsg.setContent(sl);
				return smsg;
			}else{
				List sl = sdao.findAll_Indue(num_page,num_pagesize);//find all order open
				int total_pagenumber = sdao.findAll_IndueNum();//find total num
				smsg.setStatus("true");
				smsg.setTitle("All student Indue");
				smsg.setTotapage(String.valueOf(Math.round(total_pagenumber/num_pagesize)));
				smsg.setTotalNumber(String.valueOf(total_pagenumber));
				smsg.setContent(sl);
				return smsg;
			}
			
		} catch (Exception e) {
			smsg.setStatus("false");
			smsg.setTitle("error!");
			smsg.setContent(null);
			System.out.println(smsg.getContent().toString());
			return smsg;
		}
	}
}
