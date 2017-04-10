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
 * Classes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Classes", catalog = "lms")

public class Classes implements java.io.Serializable {

	// Fields

	private Integer classId;
	private Integer section;
	private String title;
	private Set<TeachBy> teachBies = new HashSet<TeachBy>(0);
	private Set<Recommend> recommends = new HashSet<Recommend>(0);

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
	public Classes(Integer section, String title, Set<TeachBy> teachBies, Set<Recommend> recommends) {
		this.section = section;
		this.title = title;
		this.teachBies = teachBies;
		this.recommends = recommends;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ClassID", unique = true, nullable = false)

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@Column(name = "Section", nullable = false)

	public Integer getSection() {
		return this.section;
	}

	public void setSection(Integer section) {
		this.section = section;
	}

	@Column(name = "Title", nullable = false, length = 30)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classes")

	public Set<TeachBy> getTeachBies() {
		return this.teachBies;
	}

	public void setTeachBies(Set<TeachBy> teachBies) {
		this.teachBies = teachBies;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classes")

	public Set<Recommend> getRecommends() {
		return this.recommends;
	}

	public void setRecommends(Set<Recommend> recommends) {
		this.recommends = recommends;
	}

}