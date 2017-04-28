package edu.iit.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Students entity. @author MyEclipse Persistence Tools
 */

public class Students implements java.io.Serializable {

	// Fields

	private Integer studentId;
	private String moblie;
	private String address;
	private String power;
	private String lastName;
	private String middleName;
	private String firstName;
	private Date birthday;
	private String gender;
	private Integer age;
	private String email;
	private String userId;
	private String pas;
	private Set parentses = new HashSet(0);
	private Set teacherses = new HashSet(0);
	private Set orderses = new HashSet(0);
	private Set registerTos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Students() {
	}

	/** minimal constructor */
	public Students(String power, String lastName, String firstName, Date birthday, String gender, Integer age,
			String email, String userId) {
		this.power = power;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthday = birthday;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.userId = userId;
	}

	/** full constructor */
	public Students(String moblie, String address, String power, String lastName, String middleName, String firstName,
			Date birthday, String gender, Integer age, String email, String userId, String pas, Set parentses,
			Set teacherses, Set orderses, Set registerTos) {
		this.moblie = moblie;
		this.address = address;
		this.power = power;
		this.lastName = lastName;
		this.middleName = middleName;
		this.firstName = firstName;
		this.birthday = birthday;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.userId = userId;
		this.pas = pas;
		this.parentses = parentses;
		this.teacherses = teacherses;
		this.orderses = orderses;
		this.registerTos = registerTos;
	}

	// Property accessors
	
	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getMoblie() {
		return this.moblie;
	}

	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPas() {
		return this.pas;
	}

	public void setPas(String pas) {
		this.pas = pas;
	}

	public Set getParentses() {
		return this.parentses;
	}

	public void setParentses(Set parentses) {
		this.parentses = parentses;
	}

	public Set getTeacherses() {
		return this.teacherses;
	}

	public void setTeacherses(Set teacherses) {
		this.teacherses = teacherses;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	public Set getRegisterTos() {
		return this.registerTos;
	}

	public void setRegisterTos(Set registerTos) {
		this.registerTos = registerTos;
	}

}