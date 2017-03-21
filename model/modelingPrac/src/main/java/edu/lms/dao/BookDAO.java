package edu.lms.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.lms.bean.Book;

/**
 * A data access object (DAO) providing persistence and search support for Book
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see edu.lms.bean.Book
 * @author MyEclipse Persistence Tools
 */
public class BookDAO extends TempletDAO {
	private static final Logger log = LoggerFactory.getLogger(BookDAO.class);
	// property constants
	public static final String ISBN = "isbn";
	public static final String TITLE = "title";
	public static final String AUTHOR = "author";
	public static final String PUBLISHER = "publisher";
	public static final String NUMBER_OF_PAGES = "numberOfPages";
	public static final String COVER = "cover";
	public static final String STUDIO = "studio";
	public static final String MANUFACTOR = "manufactor";
	public static final String STATUS = "status";
	public static final String GENERATED_ID = "generatedId";

	public void save(Book transientInstance) {
		log.debug("saving Book instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Book persistentInstance) {
		log.debug("deleting Book instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Book findById(java.lang.Integer id) {
		log.debug("getting Book instance with id: " + id);
		try {
			Book instance = (Book) getSession().get("edu.lms.bean.Book", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Book> findByExample(Book instance) {
		log.debug("finding Book instance by example");
		try {
			List<Book> results = (List<Book>) getSession().createCriteria("edu.lms.bean.Book").add(create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Book instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Book as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Book> findByIsbn(Object isbn) {
		return findByProperty(ISBN, isbn);
	}

	public List<Book> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List<Book> findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List<Book> findByPublisher(Object publisher) {
		return findByProperty(PUBLISHER, publisher);
	}

	public List<Book> findByNumberOfPages(Object numberOfPages) {
		return findByProperty(NUMBER_OF_PAGES, numberOfPages);
	}

	public List<Book> findByCover(Object cover) {
		return findByProperty(COVER, cover);
	}

	public List<Book> findByStudio(Object studio) {
		return findByProperty(STUDIO, studio);
	}

	public List<Book> findByManufactor(Object manufactor) {
		return findByProperty(MANUFACTOR, manufactor);
	}

	public List<Book> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<Book> findByGeneratedId(Object generatedId) {
		return findByProperty(GENERATED_ID, generatedId);
	}

	public List findAll() {
		log.debug("finding all Book instances");
		try {
			String queryString = "from Book";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Book merge(Book detachedInstance) {
		log.debug("merging Book instance");
		try {
			Book result = (Book) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Book instance) {
		log.debug("attaching dirty Book instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Book instance) {
		log.debug("attaching clean Book instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}