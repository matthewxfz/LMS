package edu.lms.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.lms.bean.Books;

/**
 * A data access object (DAO) providing persistence and search support for Books
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see edu.lms.bean.Books
 * @author MyEclipse Persistence Tools
 */
public class BooksDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(BooksDAO.class);
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

	public void save(Books transientInstance) {
		log.debug("saving Books instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Books persistentInstance) {
		log.debug("deleting Books instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Books findById(java.lang.Integer id) {
		log.debug("getting Books instance with id: " + id);
		try {
			Books instance = (Books) getSession().get("edu.lms.bean.Books", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Books> findByExample(Books instance) {
		log.debug("finding Books instance by example");
		try {
			List<Books> results = (List<Books>) getSession().createCriteria("edu.lms.bean.Books").add(create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Books instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Books as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Books> findByIsbn(Object isbn) {
		return findByProperty(ISBN, isbn);
	}

	public List<Books> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List<Books> findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List<Books> findByPublisher(Object publisher) {
		return findByProperty(PUBLISHER, publisher);
	}

	public List<Books> findByNumberOfPages(Object numberOfPages) {
		return findByProperty(NUMBER_OF_PAGES, numberOfPages);
	}

	public List<Books> findByCover(Object cover) {
		return findByProperty(COVER, cover);
	}

	public List<Books> findByStudio(Object studio) {
		return findByProperty(STUDIO, studio);
	}

	public List<Books> findByManufactor(Object manufactor) {
		return findByProperty(MANUFACTOR, manufactor);
	}

	public List<Books> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<Books> findByGeneratedId(Object generatedId) {
		return findByProperty(GENERATED_ID, generatedId);
	}

	public List findAll() {
		log.debug("finding all Books instances");
		try {
			String queryString = "from Books";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Books merge(Books detachedInstance) {
		log.debug("merging Books instance");
		try {
			Books result = (Books) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Books instance) {
		log.debug("attaching dirty Books instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Books instance) {
		log.debug("attaching clean Books instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}