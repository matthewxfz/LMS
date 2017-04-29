package edu.iit.bean;

import java.util.List;

import edu.iit.dao.Classes;
import edu.iit.dao.Orders;

public class ClassMessage {
	private String title;
	private String status;
	private String totalclass;
	private List<Classes> content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTotalclass() {
		return totalclass;
	}
	public void setTotalclass(String totalclass) {
		this.totalclass = totalclass;
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
