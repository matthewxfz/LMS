package edu.iit.dao;

/**
 * Recommend entity. @author MyEclipse Persistence Tools
 */

public class Recommend implements java.io.Serializable {

	// Fields

	private RecommendId id;
	private Books books;
	private Classes classes;

	// Constructors

	/** default constructor */
	public Recommend() {
	}

	/** full constructor */
	public Recommend(RecommendId id, Books books, Classes classes) {
		this.id = id;
		this.books = books;
		this.classes = classes;
	}

	// Property accessors

	public RecommendId getId() {
		return this.id;
	}

	public void setId(RecommendId id) {
		this.id = id;
	}

	public Books getBooks() {
		return this.books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public Classes getClasses() {
		return this.classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

}