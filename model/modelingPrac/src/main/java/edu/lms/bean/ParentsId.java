package edu.lms.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ParentsId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class ParentsId implements java.io.Serializable {

	// Fields

	private String lastName;
	private String firstName;
	private Integer studentId;

	// Constructors

	/** default constructor */
	public ParentsId() {
	}

	/** full constructor */
	public ParentsId(String lastName, String firstName, Integer studentId) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.studentId = studentId;
	}

	// Property accessors

	@Column(name = "LastName", nullable = false, length = 20)

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "FirstName", nullable = false, length = 20)

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "StudentID", nullable = false)

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ParentsId))
			return false;
		ParentsId castOther = (ParentsId) other;

		return ((this.getLastName() == castOther.getLastName()) || (this.getLastName() != null
				&& castOther.getLastName() != null && this.getLastName().equals(castOther.getLastName())))
				&& ((this.getFirstName() == castOther.getFirstName()) || (this.getFirstName() != null
						&& castOther.getFirstName() != null && this.getFirstName().equals(castOther.getFirstName())))
				&& ((this.getStudentId() == castOther.getStudentId()) || (this.getStudentId() != null
						&& castOther.getStudentId() != null && this.getStudentId().equals(castOther.getStudentId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getLastName() == null ? 0 : this.getLastName().hashCode());
		result = 37 * result + (getFirstName() == null ? 0 : this.getFirstName().hashCode());
		result = 37 * result + (getStudentId() == null ? 0 : this.getStudentId().hashCode());
		return result;
	}

}