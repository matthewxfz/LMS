package edu.iit.dao;

/**
 * RegisterToId entity. @author MyEclipse Persistence Tools
 */

public class RegisterToId implements java.io.Serializable {

	// Fields

	private Integer classId;
	private Integer studentId;

	// Constructors

	/** default constructor */
	public RegisterToId() {
	}

	/** full constructor */
	public RegisterToId(Integer classId, Integer studentId) {
		this.classId = classId;
		this.studentId = studentId;
	}

	// Property accessors

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

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
		if (!(other instanceof RegisterToId))
			return false;
		RegisterToId castOther = (RegisterToId) other;

		return ((this.getClassId() == castOther.getClassId()) || (this.getClassId() != null
				&& castOther.getClassId() != null && this.getClassId().equals(castOther.getClassId())))
				&& ((this.getStudentId() == castOther.getStudentId()) || (this.getStudentId() != null
						&& castOther.getStudentId() != null && this.getStudentId().equals(castOther.getStudentId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getClassId() == null ? 0 : this.getClassId().hashCode());
		result = 37 * result + (getStudentId() == null ? 0 : this.getStudentId().hashCode());
		return result;
	}

}