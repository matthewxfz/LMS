package edu.lms.bean;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Books entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Books", catalog = "lms")

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
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<Recommend> recommends = new HashSet<Recommend>(0);

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
			Date publicationDate, String studio, String manufactor, String status, String generatedId,
			Set<Orders> orderses, Set<Recommend> recommends) {
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
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "BookID", unique = true, nullable = false)

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Column(name = "ISBN", nullable = false, length = 20)

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column(name = "Title", nullable = false, length = 50)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "Author", nullable = false, length = 50)

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "Publisher", nullable = false, length = 50)

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Column(name = "NumberOfPages", nullable = false)

	public Integer getNumberOfPages() {
		return this.numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	@Column(name = "Cover", nullable = false, length = 50)

	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PublicationDate", nullable = false, length = 10)

	public Date getPublicationDate() {
		return this.publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Column(name = "Studio", nullable = false, length = 50)

	public String getStudio() {
		return this.studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	@Column(name = "Manufactor", nullable = false, length = 50)

	public String getManufactor() {
		return this.manufactor;
	}

	public void setManufactor(String manufactor) {
		this.manufactor = manufactor;
	}

	@Column(name = "Status", nullable = false, length = 13)

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "GeneratedID", nullable = false, length = 30)

	public String getGeneratedId() {
		return this.generatedId;
	}

	public void setGeneratedId(String generatedId) {
		this.generatedId = generatedId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "books")

	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "books")

	public Set<Recommend> getRecommends() {
		return this.recommends;
	}

	public void setRecommends(Set<Recommend> recommends) {
		this.recommends = recommends;
	}

}