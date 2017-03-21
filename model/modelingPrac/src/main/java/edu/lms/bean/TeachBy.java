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
 * TeachBy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TeachBy", catalog = "lms")

public class TeachBy implements java.io.Serializable {

	// Fields

	private TeachById id;
	private Teacher teacher;

	private Class className;


    // Constructors

    /** default constructor */
    public TeachBy() {
    }

	/** full constructor */
    public TeachBy(TeachById id, Teacher teacher, Class className) {
        this.id = id;
        this.teacher = teacher;
        this.className = className;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="classId", column=@Column(name="ClassID", nullable=false) ), 
        @AttributeOverride(name="teacherId", column=@Column(name="TeacherID", nullable=false) ) } )

    public TeachById getId() {
        return this.id;
    }

	public void setId(TeachById id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TeacherID", nullable = false, insertable = false, updatable = false)

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="ClassID", nullable=false, insertable=false, updatable=false)

    public Class getClass() {
        return this.className;
    }

	public void setClass(Class class) {
        this.class = className;
    }
   








}