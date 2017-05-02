package edu.iit.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import edu.iit.dao.Books;
import edu.iit.dao.BooksDAO;
import edu.iit.dao.BooksMessage;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.dao.Parents;
import edu.iit.dao.ParentsDAO;
import edu.iit.dao.ParentsId;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class FindBooks {

	public static void main(String[] args) {
		
		String keyword = "";
		String pagenumber = "1";
		String pagesize = "15";
		String opt = "rent";
		BooksMessage msg = Process(keyword,pagenumber,pagesize,opt);
		
		System.out.println(msg.getStatus()+", size:"+msg.getContent().size());

	}
	
	public static BooksMessage Process(String keyword,String pagenumber,String pagesize,String opt){
		
		OrdersDAO ddao = new OrdersDAO();
		BooksDAO bdao = new BooksDAO();
		
		BooksMessage bmsg = new BooksMessage();
		try {
			if(opt.equals("due")){//findallduebook
				List<Books> blist = bdao.findAllDueBooks(1, 5);
				bmsg.setStatus("true");
				bmsg.setTitle("Find due Successful!");
				bmsg.setPage(Integer.valueOf(pagenumber));
				int totalpage = 0;
				totalpage = (bdao.getCount(keyword, opt)%Integer.valueOf(pagesize) == 0)?
				(bdao.getCount(keyword, opt)/Integer.valueOf(pagesize)):
				(bdao.getCount(keyword, opt)/Integer.valueOf(pagesize)+1);
				bmsg.setTotalpage(totalpage);
				bmsg.setContent(blist);
				return bmsg;
				
			}else if(opt.equals("rent")){//rentbooks
				List<Books> list = bdao.findAllRentBook(keyword, Integer.valueOf(pagenumber),Integer.valueOf(pagesize));
				bmsg.setStatus("true");
				bmsg.setTitle("Find rent Successful!");
				bmsg.setPage(Integer.valueOf(pagenumber));
				int totalpage = 0;
				totalpage = (bdao.getCount(keyword, opt)%Integer.valueOf(pagesize) == 0)?
				(bdao.getCount(keyword, opt)/Integer.valueOf(pagesize)):
				(bdao.getCount(keyword, opt)/Integer.valueOf(pagesize)+1);
				bmsg.setTotalpage(totalpage);
				bmsg.setContent(list);
				System.out.println("Content: \n"+bmsg.getContent().toString()+"\n"+"PageNumber: \n"+
						bmsg.getPage()+"\n"+"TotalPageNumber: \n"+bmsg.getTotalpage());
				return bmsg;
			}else if(opt.equals("all")){
				List<Books> list = bdao.findBooksBykeyword(keyword, Integer.valueOf(pagenumber),Integer.valueOf(pagesize));
				bmsg.setStatus("true");
				bmsg.setTitle("Find Successful!");
				bmsg.setPage(Integer.valueOf(pagenumber));
				int totalpage = 0;
				totalpage = (bdao.getCount(keyword, opt)%Integer.valueOf(pagesize) == 0)?
				(bdao.getCount(keyword, opt)/Integer.valueOf(pagesize)):
				(bdao.getCount(keyword, opt)/Integer.valueOf(pagesize)+1);
				bmsg.setTotalpage(totalpage);
				bmsg.setContent(list);
				System.out.println("Content: \n"+bmsg.getContent().toString()+"\n"+"PageNumber: \n"+
						bmsg.getPage()+"\n"+"TotalPageNumber: \n"+bmsg.getTotalpage());
				return bmsg;	
			}else{
				bmsg.setStatus("false");
				bmsg.setTitle("Input Error!");
				return bmsg;
			}
		} catch (Exception e) {
			bmsg.setStatus("false");
			bmsg.setTitle("error!");
			bmsg.setEmsg("Inner Server Error!");
			System.out.println(bmsg.getEmsg().toString());
			return bmsg;
		}
	}
	
}





