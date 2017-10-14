package edu.iit.bean;

import java.util.List;

import edu.iit.dao.Students;

public class StudentsMessage {
	
	String title;
	String status;
	String page;
	String totalPage;
	String totalNumber;
	List<Students> content;
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
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}
	public String getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(String totalNumber) {
		this.totalNumber = totalNumber;
	}
	public List<Students> getContent() {
		return content;
	}
	public void setContent(List<Students> content) {
		this.content = content;
	}
}
