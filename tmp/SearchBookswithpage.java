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
import edu.iit.dao.ParentsMessage;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class FindBooks {

	public static void main(String[] args) {
		
		String keyword = "lang";
		String pagenumber = "1";
		String pagesize = "2";
		String opt = "";
		Process(keyword,pagenumber,pagesize,opt);

	}
	
	public static BooksMessage Process(String keyword,String pagenumber,String pagesize,String opt){
		
		OrdersDAO ddao = new OrdersDAO();
		BooksDAO bdao = new BooksDAO();
		
		BooksMessage bmsg = new BooksMessage();
		try {
			if(opt.equals("due")){//findallduebook
				List<Books> blist = bdao.findDueBooks(1, 5);
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
			}else{
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









public int getCount(String keyword,String opt){
		if(opt.equals("rent")){
			Criteria criteria = getSession().createCriteria(Books.class);
			List<Books> list = criteria.add(Restrictions.and(Restrictions.eq(STATUS, "not available"),Restrictions.or(
			Restrictions.like(AUTHOR, (String) keyword,MatchMode.ANYWHERE),
			Restrictions.like(TITLE,(String) keyword,MatchMode.ANYWHERE ),
			Restrictions.like(ISBN, (String) keyword,MatchMode.ANYWHERE))))
			.list();
			return list.size();
		}else if(opt.equals("due")){
			ZoneId zonedId = ZoneId.of("America/Chicago");
			LocalDate ltoday = LocalDate.now(zonedId);
			Date today = java.sql.Date.valueOf(ltoday);
			
			String queryString = "from Books where BookID in (:bookids)";
			String orderQuey = "select o.books from Orders as o where o.statues = ? and o.dueDate < ?";
		
			Query orderQueryO = getSession().createQuery(orderQuey);
			orderQueryO.setParameter(0, "Open");
			orderQueryO.setParameter(1, today);
			List<String> bookids = (List<String>)orderQueryO.list();
			return orderQueryO.list().size();
		}else{
			Criteria criteria = getSession().createCriteria(Books.class);
			List<Books> list = criteria.add(Restrictions.or(
			Restrictions.like(AUTHOR, (String) keyword,MatchMode.ANYWHERE),
			Restrictions.like(TITLE,(String) keyword,MatchMode.ANYWHERE ),
			Restrictions.like(ISBN, (String) keyword,MatchMode.ANYWHERE)))
			.list();
			return list.size();
		}
	}



public List<Books> findAllRentBook(Object keyword,int pagenumber,int pagesize){
		log.debug("finding Books instance with Keyword: " + keyword);
		try {
			Criteria criteria = getSession().createCriteria(Books.class);
			List<Books> list = criteria.add(Restrictions.and(Restrictions.eq(STATUS, "not available"),Restrictions.or(
			Restrictions.like(AUTHOR, (String) keyword,MatchMode.ANYWHERE),
			Restrictions.like(TITLE,(String) keyword,MatchMode.ANYWHERE ),
			Restrictions.like(ISBN, (String) keyword,MatchMode.ANYWHERE))))
			.setFirstResult((pagenumber-1)*pagesize)
			.setMaxResults(pagesize).list();
			return list;
		} catch (RuntimeException re) {
			log.error("find by Keyword failed", re);
			throw re;
		}
	}




	package edu.iit.dao;

import java.util.List;

public class BooksMessage {
	private String title;
	private String status;
	private int page;
	private int totalpage;
	private List<Books> content;
	private String emsg;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public List<Books> getContent() {
		return content;
	}
	public void setContent(List<Books> content) {
		this.content = content;
	}
	public String getEmsg() {
		return emsg;
	}
	public void setEmsg(String emsg) {
		this.emsg = emsg;
	}
	
}
