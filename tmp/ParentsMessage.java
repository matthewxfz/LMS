package edu.iit.dao;

import java.util.List;

public class ParentsMessage {
	private String title;
	private String status;
	private Parents content;
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
	public Parents getContent() {
		return content;
	}
	public void setContent(Parents content) {
		this.content = content;
	}
}
