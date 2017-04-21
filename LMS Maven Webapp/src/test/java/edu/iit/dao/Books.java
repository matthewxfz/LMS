package edu.iit.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Books entity. @author MyEclipse Persistence Tools
 */

public class Books implements java.io.Serializable {

	// Fields

	private Integer bookId;
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private Integer numberOfPages;
	private String cover;
	private Date publicationDate;
	private String studio;
	private String manufactor;
	private String status;
	private String generatedId;
	private Set orderses = new HashSet(0);
	private Set recommends = new HashSet(0);

	// Constructors

	/** default constructor */
	public Books() {
	}

	/** minimal constructor */
	public Books(String isbn, String title, String author, String publisher, Integer numberOfPages, String cover,
			Date publicationDate, String studio, String manufactor, String status, String generatedId) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.numberOfPages = numberOfPages;
		this.cover = cover;
		this.publicationDate = publicationDate;
		this.studio = studio;
		this.manufactor = manufactor;
		this.status = status;
		this.generatedId = generatedId;
	}

	/** full constructor */
	public Books(String isbn, String title, String author, String publisher, Integer numberOfPages, String cover,
			Date publicationDate, String studio, String manufactor, String status, String generatedId, Set orderses,
			Set recommends) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.numberOfPages = numberOfPages;
		this.cover = cover;
		this.publicationDate = publicationDate;
		this.studio = studio;
		this.manufactor = manufactor;
		this.status = status;
		this.generatedId = generatedId;
		this.orderses = orderses;
		this.recommends = recommends;
	}

	// Property accessors

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getNumberOfPages() {
		return this.numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Date getPublicationDate() {
		return this.publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getStudio() {
		return this.studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getManufactor() {
		return this.manufactor;
	}

	public void setManufactor(String manufactor) {
		this.manufactor = manufactor;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGeneratedId() {
		return this.generatedId;
	}

	public void setGeneratedId(String generatedId) {
		this.generatedId = generatedId;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	public Set getRecommends() {
		return this.recommends;
	}

	public void setRecommends(Set recommends) {
		this.recommends = recommends;
	}

}