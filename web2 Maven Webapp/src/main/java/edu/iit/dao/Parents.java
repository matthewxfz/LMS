package edu.iit.dao;

/**
 * Parents entity. @author MyEclipse Persistence Tools
 */

public class Parents implements java.io.Serializable {

	// Fields

	private ParentsId id;
	private Students students;
	private String address;
	private String moblie;
	private String email;
	private String middleName;
	private String relationship;
	private String power;

	// Constructors

	/** default constructor */
	public Parents() {
	}

	/** minimal constructor */
	public Parents(ParentsId id, Students students, String moblie, String email, String relationship, String power) {
		this.id = id;
		this.students = students;
		this.moblie = moblie;
		this.email = email;
		this.relationship = relationship;
		this.power = power;
	}

	/** full constructor */
	public Parents(ParentsId id, Students students, String address, String moblie, String email, String middleName,
			String relationship, String power) {
		this.id = id;
		this.students = students;
		this.address = address;
		this.moblie = moblie;
		this.email = email;
		this.middleName = middleName;
		this.relationship = relationship;
		this.power = power;
	}

	// Property accessors

	public ParentsId getId() {
		return this.id;
	}

	public void setId(ParentsId id) {
		this.id = id;
	}

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMoblie() {
		return this.moblie;
	}

	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}

}