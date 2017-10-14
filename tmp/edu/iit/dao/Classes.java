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
	private Set recommends = new HashSet(0);
	private Set teachBies = new HashSet(0);

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
	public Classes(Integer section, String title, Set recommends, Set teachBies) {
		this.section = section;
		this.title = title;
		this.recommends = recommends;
		this.teachBies = teachBies;
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

	public Set getRecommends() {
		return this.recommends;
	}

	public void setRecommends(Set recommends) {
		this.recommends = recommends;
	}

	public Set getTeachBies() {
		return this.teachBies;
	}

	public void setTeachBies(Set teachBies) {
		this.teachBies = teachBies;
	}

}