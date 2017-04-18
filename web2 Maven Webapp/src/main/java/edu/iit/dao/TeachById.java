package edu.iit.dao;

/**
 * TeachById entity. @author MyEclipse Persistence Tools
 */

public class TeachById implements java.io.Serializable {

	// Fields

	private Integer classId;
	private Integer teacherId;

	// Constructors

	/** default constructor */
	public TeachById() {
	}

	/** full constructor */
	public TeachById(Integer classId, Integer teacherId) {
		this.classId = classId;
		this.teacherId = teacherId;
	}

	// Property accessors

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TeachById))
			return false;
		TeachById castOther = (TeachById) other;

		return ((this.getClassId() == castOther.getClassId()) || (this.getClassId() != null
				&& castOther.getClassId() != null && this.getClassId().equals(castOther.getClassId())))
				&& ((this.getTeacherId() == castOther.getTeacherId()) || (this.getTeacherId() != null
						&& castOther.getTeacherId() != null && this.getTeacherId().equals(castOther.getTeacherId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getClassId() == null ? 0 : this.getClassId().hashCode());
		result = 37 * result + (getTeacherId() == null ? 0 : this.getTeacherId().hashCode());
		return result;
	}

}