package edu.iit.bean;

import java.util.List;

import edu.iit.dao.Classes;
import edu.iit.dao.Orders;

public class ClassMessage {
	private String title;
	private String status;
	private String page;
	private String totalPage;
	private String totalNumber;
	
	private List<Classes> content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Classes> getContent() {
		return content;
	}
	public void setContent(List<Classes> content) {
		this.content = content;
	}
	
}
