package edu.iit.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Books books;
	private Admins admins;
	private Students students;
	private Timestamp checkinDate;
	private Timestamp checkoutDate;
	private Timestamp dueDate;
	private String type;
	private String statues;

	// Constructors

	/** default constructor */
	public Orders() {
	}



	/** full constructor */
	public Orders(Books books, Admins admins, Students students, Timestamp checkinDate, Timestamp checkoutDate,
		 String type, String statues) {
		Calendar cal = Calendar.getInstance();
		this.books = books;
		this.admins = admins;
		this.students = students;
		this.checkinDate = checkinDate;
		cal.setTime(checkinDate);
		cal.add(Calendar.MONTH,1);
		this.checkoutDate = checkoutDate;
		this.dueDate = (Timestamp) cal.getTime();
		this.type = type;
		this.statues = statues;
		
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Books getBooks() {
		return this.books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public Admins getAdmins() {
		return this.admins;
	}

	public void setAdmins(Admins admins) {
		this.admins = admins;
	}

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public Timestamp getCheckinDate() {
		return this.checkinDate;
	}

	public void setCheckinDate(Timestamp checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return this.checkoutDate;
	}

	public void setCheckoutDate(Timestamp checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Timestamp getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatues() {
		return this.statues;
	}

	public void setStatues(String statues) {
		this.statues = statues;
	}

}