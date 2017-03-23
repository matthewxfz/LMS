package edu.lms.bean;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TeachBy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TeachBy", catalog = "lms")

public class TeachBy implements java.io.Serializable {

	// Fields

	private TeachById id;
	private Teachers teachers;
	private Classes classes;

	// Constructors

	/** default constructor */
	public TeachBy() {
	}

	/** full constructor */
	public TeachBy(TeachById id, Teachers teachers, Classes classes) {
		this.id = id;
		this.teachers = teachers;
		this.classes = classes;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "classId", column = @Column(name = "ClassID", nullable = false)),
			@AttributeOverride(name = "teacherId", column = @Column(name = "TeacherID", nullable = false)) })

	public TeachById getId() {
		return this.id;
	}

	public void setId(TeachById id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TeacherID", nullable = false, insertable = false, updatable = false)

	public Teachers getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ClassID", nullable = false, insertable = false, updatable = false)

	public Classes getClasses() {
		return this.classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

}