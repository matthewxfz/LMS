package edu.lms.bean;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Teacher", catalog = "lms")

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer teacherId;
	private Student student;
	private String lastName;
	private String moblie;
	private String email;
	private String address;
	private String userId;
	private String firstName;
	private String middleName;
	private String power;
	private String pas;
	private Set<TeachBy> teachBies = new HashSet<TeachBy>(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Student student, String lastName, String email, String userId, String firstName, String power) {
		this.student = student;
		this.lastName = lastName;
		this.email = email;
		this.userId = userId;
		this.firstName = firstName;
		this.power = power;
	}

	/** full constructor */
	public Teacher(Student student, String lastName, String moblie, String email, String address, String userId,
			String firstName, String middleName, String power, String pas, Set<TeachBy> teachBies) {
		this.student = student;
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
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "TeacherID", unique = true, nullable = false)

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "StudentID", nullable = false)

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Column(name = "LastName", nullable = false, length = 20)

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "Moblie", length = 10)

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

	@Column(name = "Address", length = 30)

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "UserID", nullable = false, length = 30)

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "FirstName", nullable = false, length = 20)

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "MiddleName", length = 20)

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "Power", nullable = false, length = 2)

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	@Column(name = "PAS", length = 40)

	public String getPas() {
		return this.pas;
	}

	public void setPas(String pas) {
		this.pas = pas;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacher")

	public Set<TeachBy> getTeachBies() {
		return this.teachBies;
	}

	public void setTeachBies(Set<TeachBy> teachBies) {
		this.teachBies = teachBies;
	}

}