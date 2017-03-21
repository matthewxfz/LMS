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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Admin", catalog = "lms")

public class Admin implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private String userId;
	private String lastName;
	private String moblie;
	private String address;
	private String email;
	private String power;
	private String firstName;
	private String middleName;
	private String pas;
	private Set<Orders> orderses = new HashSet<Orders>(0);

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(String userId, String lastName, String email, String power, String firstName) {
		this.userId = userId;
		this.lastName = lastName;
		this.email = email;
		this.power = power;
		this.firstName = firstName;
	}

	/** full constructor */
	public Admin(String userId, String lastName, String moblie, String address, String email, String power,
			String firstName, String middleName, String pas, Set<Orders> orderses) {
		this.userId = userId;
		this.lastName = lastName;
		this.moblie = moblie;
		this.address = address;
		this.email = email;
		this.power = power;
		this.firstName = firstName;
		this.middleName = middleName;
		this.pas = pas;
		this.orderses = orderses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "AdminID", unique = true, nullable = false)

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Column(name = "UserID", nullable = false, length = 18)

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "LastName", nullable = false, length = 30)

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

	@Column(name = "Address", length = 30)

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Email", nullable = false, length = 30)

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Power", nullable = false, length = 2)

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	@Column(name = "FirstName", nullable = false, length = 30)

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "MiddleName", length = 30)

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "PAS", length = 40)

	public String getPas() {
		return this.pas;
	}

	public void setPas(String pas) {
		this.pas = pas;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admin")

	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

}