package edu.iit.dao;

import java.util.List;

public class ParentsMessage {
	private String title;
	private String status;
	private String content;
	private Students scontent;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Students getScontent() {
		return scontent;
	}
	public void setScontent(Students scontent) {
		this.scontent = scontent;
	}
	
}