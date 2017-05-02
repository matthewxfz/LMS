package edu.iit.bean;

import java.util.List;

import edu.iit.dao.Books;

public class BooksMessage {
	private String title;
	private String status;
	private int page;
	private int totalpage;
	private int totalNumber;
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
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