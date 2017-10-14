package edu.iit.dao;

import java.util.HashSet;
import java.util.Set;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable {

	// Fields

	private Integer classId;
	private Integer section;
	private String title;
	private Set teachBies = new HashSet(0);
	private Set registerTos = new HashSet(0);
	private Set recommends = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classes() {
	}

	/** minimal constructor */
	public Classes(Integer section, String title) {
		this.section = section;
		this.title = title;
	}

	/** full constructor */
	public Classes(Integer section, String title, Set teachBies, Set registerTos, Set recommends) {
		this.section = section;
		this.title = title;
		this.teachBies = teachBies;
		this.registerTos = registerTos;
		this.recommends = recommends;
	}

	// Property accessors

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getSection() {
		return this.section;
	}

	public void setSection(Integer section) {
		this.section = section;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set getTeachBies() {
		return this.teachBies;
	}

	public void setTeachBies(Set teachBies) {
		this.teachBies = teachBies;
	}

	public Set getRegisterTos() {
		return this.registerTos;
	}

	public void setRegisterTos(Set registerTos) {
		this.registerTos = registerTos;
	}

	public Set getRecommends() {
		return this.recommends;
	}

	public void setRecommends(Set recommends) {
		this.recommends = recommends;
	}

}