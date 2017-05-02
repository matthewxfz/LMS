package edu.iit.bean;

import edu.iit.dao.Students;

public class StudentMessage {
	
	public String title;
	public String status;
	public Students content;
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
	public Students getContent() {
		return content;
	}
	public void setContent(Students content) {
		this.content = content;
	}
	
}
