package edu.iit.dao;

/**
 * RegisterTo entity. @author MyEclipse Persistence Tools
 */

public class RegisterTo implements java.io.Serializable {

	// Fields

	private RegisterToId id;
	private Classes classes;
	private Students students;

	// Constructors

	/** default constructor */
	public RegisterTo() {
	}

	/** minimal constructor */
	public RegisterTo(RegisterToId id) {
		this.id = id;
	}

	/** full constructor */
	public RegisterTo(RegisterToId id, Classes classes, Students students) {
		this.id = id;
		this.classes = classes;
		this.students = students;
	}

	// Property accessors

	public RegisterToId getId() {
		return this.id;
	}

	public void setId(RegisterToId id) {
		this.id = id;
	}

	public Classes getClasses() {
		return this.classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

}