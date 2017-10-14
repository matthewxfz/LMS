package edu.iit.dao;

import java.util.HashSet;
import java.util.Set;

/**
 * Teachers entity. @author MyEclipse Persistence Tools
 */

public class Teachers implements java.io.Serializable {

	// Fields

	private Integer teacherId;
	private Students students;
	private String lastName;
	private String moblie;
	private String email;
	private String address;
	private String userId;
	private String firstName;
	private String middleName;
	private String power;
	private String pas;
	private Set teachBies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teachers() {
	}

	/** minimal constructor */
	public Teachers(Students students, String lastName, String email, String userId, String firstName, String power) {
		this.students = students;
		this.lastName = lastName;
		this.email = email;
		this.userId = userId;
		this.firstName = firstName;
		this.power = power;
	}

	/** full constructor */
	public Teachers(Students students, String lastName, String moblie, String email, String address, String userId,
			String firstName, String middleName, String power, String pas, Set teachBies) {
		this.students = students;
		this.lastName = lastName;
		this.moblie = moblie;
		this.email = email;
		this.address = address;
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.power = power;
		this.pas = pas;
		this.teachBies = teachBies;
	}

	// Property accessors

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getPas() {
		return this.pas;
	}

	public void setPas(String pas) {
		this.pas = pas;
	}

	public Set getTeachBies() {
		return this.teachBies;
	}

	public void setTeachBies(Set teachBies) {
		this.teachBies = teachBies;
	}

}