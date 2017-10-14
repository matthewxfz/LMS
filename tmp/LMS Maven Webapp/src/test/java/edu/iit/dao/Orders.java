package edu.iit.dao;

import java.util.Date;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Books books;
	private Admins admins;
	private Students students;
	private Date checkinDate;
	private Date checkoutDate;
	private Date dueDate;
	private String type;
	private String statues;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(Books books, Admins admins, Students students, Date checkinDate, Date dueDate, String type,
			String statues) {
		this.books = books;
		this.admins = admins;
		this.students = students;
		this.checkinDate = checkinDate;
		this.dueDate = dueDate;
		this.type = type;
		this.statues = statues;
	}

	/** full constructor */
	public Orders(Books books, Admins admins, Students students, Date checkinDate, Date checkoutDate, Date dueDate,
			String type, String statues) {
		this.books = books;
		this.admins = admins;
		this.students = students;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
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

	public Date getCheckinDate() {
		return this.checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return this.checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
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