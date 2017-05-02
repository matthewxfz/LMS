package edu.iit.bean;

import java.util.List;

import edu.iit.dao.Orders;

public class OrdersMessage {
	private String title;
	private String status;
	private String totapage;
	private String totalNumber;
	private List<Orders> content;
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
	public List<Orders> getContent() {
		return content;
	}
	public void setContent(List<Orders> content) {
		this.content = content;
	}
}
