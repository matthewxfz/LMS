package edu.lms.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Students entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Students", catalog = "lms")

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
	private Set<Parents> parentses = new HashSet<Parents>(0);
	private Set<Teachers> teacherses = new HashSet<Teachers>(0);
	private Set<Orders> orderses = new HashSet<Orders>(0);

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
			Date birthday, String gender, Integer age, String email, String userId, String pas, Set<Parents> parentses,
			Set<Teachers> teacherses, Set<Orders> orderses) {
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
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "StudentID", unique = true, nullable = false)

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@Column(name = "Moblie", length = 10)

	public String getMoblie() {
		return this.moblie;
	}

	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}

	@Column(name = "Address", length = 30)

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Power", nullable = false, length = 2)

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	@Column(name = "LastName", nullable = false, length = 20)

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "MiddleName", length = 20)

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "FirstName", nullable = false, length = 20)

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Birthday", nullable = false, length = 10)

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "Gender", nullable = false, length = 6)

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "Age", nullable = false)

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "Email", nullable = false, length = 20)

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "UserID", nullable = false, length = 20)

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "PAS", length = 40)

	public String getPas() {
		return this.pas;
	}

	public void setPas(String pas) {
		this.pas = pas;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "students")

	public Set<Parents> getParentses() {
		return this.parentses;
	}

	public void setParentses(Set<Parents> parentses) {
		this.parentses = parentses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "students")

	public Set<Teachers> getTeacherses() {
		return this.teacherses;
	}

	public void setTeacherses(Set<Teachers> teacherses) {
		this.teacherses = teacherses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "students")

	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

}