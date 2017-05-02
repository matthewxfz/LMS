package edu.iit.dao;

/**
 * OrdersId entity. @author MyEclipse Persistence Tools
 */

public class OrdersId implements java.io.Serializable {

	// Fields

	private Integer studentId;
	private Integer bookId;

	// Constructors

	/** default constructor */
	public OrdersId() {
	}

	/** full constructor */
	public OrdersId(Integer studentId, Integer bookId) {
		this.studentId = studentId;
		this.bookId = bookId;
	}

	// Property accessors

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrdersId))
			return false;
		OrdersId castOther = (OrdersId) other;

		return ((this.getStudentId() == castOther.getStudentId()) || (this.getStudentId() != null
				&& castOther.getStudentId() != null && this.getStudentId().equals(castOther.getStudentId())))
				&& ((this.getBookId() == castOther.getBookId()) || (this.getBookId() != null
						&& castOther.getBookId() != null && this.getBookId().equals(castOther.getBookId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getStudentId() == null ? 0 : this.getStudentId().hashCode());
		result = 37 * result + (getBookId() == null ? 0 : this.getBookId().hashCode());
		return result;
	}

}