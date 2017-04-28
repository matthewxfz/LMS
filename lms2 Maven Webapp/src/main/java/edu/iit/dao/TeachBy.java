package edu.iit.dao;

/**
 * TeachBy entity. @author MyEclipse Persistence Tools
 */

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

	public TeachById getId() {
		return this.id;
	}

	public void setId(TeachById id) {
		this.id = id;
	}

	public Teachers getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}

	public Classes getClasses() {
		return this.classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

}