package edu.iit.dao;

import java.util.Date;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Date checkinDate;
	private Date checkoutDate;
	private Date dueDate;
	private String type;
	private String statues;
	private Integer studentId;
	private Integer bookId;
	private Integer adminId;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(Date checkinDate, Date dueDate, String type, String statues, Integer studentId, Integer bookId,
			Integer adminId) {
		this.checkinDate = checkinDate;
		this.dueDate = dueDate;
		this.type = type;
		this.statues = statues;
		this.studentId = studentId;
		this.bookId = bookId;
		this.adminId = adminId;
	}

	/** full constructor */
	public Orders(Date checkinDate, Date checkoutDate, Date dueDate, String type, String statues, Integer studentId,
			Integer bookId, Integer adminId) {
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.type = type;
		this.statues = statues;
		this.studentId = studentId;
		this.bookId = bookId;
		this.adminId = adminId;
	}

	// Property accessors

	public Integer book() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getOrderId() {
		return orderId;
	}

}