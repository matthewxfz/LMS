package edu.iit.dao;

/**
 * RecommendId entity. @author MyEclipse Persistence Tools
 */

public class RecommendId implements java.io.Serializable {

	// Fields

	private Integer bookId;
	private Integer classId;

	// Constructors

	/** default constructor */
	public RecommendId() {
	}

	/** full constructor */
	public RecommendId(Integer bookId, Integer classId) {
		this.bookId = bookId;
		this.classId = classId;
	}

	// Property accessors

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RecommendId))
			return false;
		RecommendId castOther = (RecommendId) other;

		return ((this.getBookId() == castOther.getBookId()) || (this.getBookId() != null
				&& castOther.getBookId() != null && this.getBookId().equals(castOther.getBookId())))
				&& ((this.getClassId() == castOther.getClassId()) || (this.getClassId() != null
						&& castOther.getClassId() != null && this.getClassId().equals(castOther.getClassId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBookId() == null ? 0 : this.getBookId().hashCode());
		result = 37 * result + (getClassId() == null ? 0 : this.getClassId().hashCode());
		return result;
	}

}