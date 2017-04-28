package edu.iit.bean;

import java.util.List;

import edu.iit.dao.Books;

public class SearchBookMessage {
	private String status;
	private int page;
	private int totalPage;
	private List<Books> content;
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
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Books> getContent() {
		return content;
	}
	public void setContent(List<Books> content) {
		this.content = content;
	}
	
}
