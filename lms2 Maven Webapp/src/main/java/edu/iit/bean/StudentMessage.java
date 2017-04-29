package edu.iit.bean;

import java.util.List;

import edu.iit.dao.Orders;
import edu.iit.dao.Students;

public class StudentMessage {
	private String title;
	private String status;
	private String totapage;
	private String totalNumber;
	private List<Students> content;
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
	public String getTotapage() {
		return totapage;
	}
	public void setTotapage(String totapage) {
		this.totapage = totapage;
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
