package edu.lms.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Orders", catalog = "lms")

public class Orders implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Book book;
	private Admin admin;
	private Student student;
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
	public Orders(Book book, Admin admin, Student student, Date checkinDate, Date dueDate, String type,
			String statues) {
		this.book = book;
		this.admin = admin;
		this.student = student;
		this.checkinDate = checkinDate;
		this.dueDate = dueDate;
		this.type = type;
		this.statues = statues;
	}

	/** full constructor */
	public Orders(Book book, Admin admin, Student student, Date checkinDate, Date checkoutDate, Date dueDate,
			String type, String statues) {
		this.book = book;
		this.admin = admin;
		this.student = student;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.type = type;
		this.statues = statues;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "OrderID", unique = true, nullable = false)

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BookID", nullable = false)

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AdminID", nullable = false)

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "StudentID", nullable = false)

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CheckinDate", nullable = false, length = 10)

	public Date getCheckinDate() {
		return this.checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CheckoutDate", length = 10)

	public Date getCheckoutDate() {
		return this.checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DueDate", nullable = false, length = 10)

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name = "Type", nullable = false, length = 8)

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "Statues", nullable = false, length = 6)

	public String getStatues() {
		return this.statues;
	}

	public void setStatues(String statues) {
		this.statues = statues;
	}

}