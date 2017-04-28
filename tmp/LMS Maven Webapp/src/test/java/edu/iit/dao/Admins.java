package edu.iit.dao;

import java.util.HashSet;
import java.util.Set;

/**
 * Admins entity. @author MyEclipse Persistence Tools
 */

public class Admins implements java.io.Serializable {

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
	private Set orderses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Admins() {
	}

	/** minimal constructor */
	public Admins(String userId, String lastName, String email, String power, String firstName) {
		this.userId = userId;
		this.lastName = lastName;
		this.email = email;
		this.power = power;
		this.firstName = firstName;
	}

	/** full constructor */
	public Admins(String userId, String lastName, String moblie, String address, String email, String power,
			String firstName, String middleName, String pas, Set orderses) {
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

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
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

	public String getPas() {
		return this.pas;
	}

	public void setPas(String pas) {
		this.pas = pas;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}