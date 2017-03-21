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
 * Recommend entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Recommend", catalog = "lms")

public class Recommend implements java.io.Serializable {

	// Fields

	private RecommendId id;
	private Book book;

	private Class class;


    // Constructors

    /** default constructor */
    public Recommend() {
    }

	/** full constructor */
    public Recommend(RecommendId id, Book book, Class class) {
        this.id = id;
        this.book = book;
        this.class = class;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="bookId", column=@Column(name="BookID", nullable=false) ), 
        @AttributeOverride(name="classId", column=@Column(name="ClassID", nullable=false) ) } )

    public RecommendId getId() {
        return this.id;
    }

	public void setId(RecommendId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BookID", nullable = false, insertable = false, updatable = false)

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="ClassID", nullable=false, insertable=false, updatable=false)

    public Class getClass() {
        return this.class;
    }

	public void setClass(Class class) {
        this.class = class;
    }
   








}