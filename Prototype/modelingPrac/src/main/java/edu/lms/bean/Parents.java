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
 * Parents entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Parents", catalog = "lms")

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
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "lastName", column = @Column(name = "LastName", nullable = false, length = 20)),
			@AttributeOverride(name = "firstName", column = @Column(name = "FirstName", nullable = false, length = 20)),
			@AttributeOverride(name = "studentId", column = @Column(name = "StudentID", nullable = false)) })

	public ParentsId getId() {
		return this.id;
	}

	public void setId(ParentsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "StudentID", nullable = false, insertable = false, updatable = false)

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	@Column(name = "Address", length = 30)

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Moblie", nullable = false, length = 10)

	public String getMoblie() {
		return this.moblie;
	}

	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}

	@Column(name = "Email", nullable = false, length = 30)

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "MiddleName", length = 20)

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "Relationship", nullable = false, length = 7)

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	@Column(name = "Power", nullable = false, length = 2)

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}

}