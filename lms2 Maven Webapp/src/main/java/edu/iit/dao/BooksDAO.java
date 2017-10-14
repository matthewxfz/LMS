package edu.iit.dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Books
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see edu.iit.dao.Books
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
			Books instance = (Books) getSession().get("edu.iit.dao.Books", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Books instance) {
		log.debug("finding Books instance by example");
		try {
			List results = getSession().createCriteria("edu.iit.dao.Books").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByAnName(String propertyName, Object value) {
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

	/**
	 * find by the keywords, page number, page size
	 * 
	 * @param keyword
	 * @param pageNumber
	 *            from 1 to infiy
	 * @param pageSize
	 * @return the request result
	 */
	public List findByKeywords(String keyword, int pageNumber, int pageSize) {
		log.debug("find the books by kewords:" + keyword.toString() + ",page number:" + pageNumber + ",pageSize:"
				+ pageSize);
		try {
			String queryString = "select B2.BookID, B2.ISBN, B2.Title, B2.Author, B2.Publisher, B2.NumberOfPages, B2.Cover, B2.PublicationDate, B2.Studio, B2.Manufactor, B2.Status, B2.GeneratedID  from"
					+ "(select *, match(B1.Title, B1.Author, B1.Publisher, B1.ISBN, B1.GeneratedID) " + "against (\""
					+ keyword + "\" WITH QUERY EXPANSION) as refference from Books as B1 order by refference desc"
					+ " limit " + (pageNumber - 1) * pageSize + ", " + (pageNumber) * pageSize + ") as B2";
			System.out.println(queryString);
			Query queryObject = getSession().createQuery(queryString);
			// queryObject.setParameter(0, keyword);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by keywords fail", re);
			throw re;
		}
	}

	/**
	 * Find the size of table
	 * 
	 * @return
	 */
	public int findTableSize() {
		log.debug("find the size of table");
		try {
			String queryString = "select count(*) as size from Books";
			Query queryObject = getSession().createQuery(queryString);

			return Integer.valueOf(queryObject.list().get(0).toString());

		} catch (RuntimeException re) {
			log.error("find table size fail", re);
			throw re;
		}
	}

	public List findByIsbn(Object isbn) {
		return findByProperty(ISBN, isbn);
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List findByPublisher(Object publisher) {
		return findByProperty(PUBLISHER, publisher);
	}

	public List findByNumberOfPages(Object numberOfPages) {
		return findByProperty(NUMBER_OF_PAGES, numberOfPages);
	}

	public List findByCover(Object cover) {
		return findByProperty(COVER, cover);
	}

	public List findByStudio(Object studio) {
		return findByProperty(STUDIO, studio);
	}

	public List findByManufactor(Object manufactor) {
		return findByProperty(MANUFACTOR, manufactor);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByGeneratedId(Object generatedId) {
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

	public List findDueBooks(int studentId, int pageNumber, int pageSize) {
		try {
			ZoneId zonedId = ZoneId.of("America/Chicago");
			LocalDate ltoday = LocalDate.now(zonedId);
			Date today = java.sql.Date.valueOf(ltoday);

			String queryString = "from Books where BookID in (:bookids)";
			String orderQuey = "select o.bookId from Orders as o where o.studentId = ? and o.statues = ? and o.dueDate < ?";

			Query orderQueryO = getSession().createQuery(orderQuey);
			orderQueryO.setParameter(0, studentId);
			orderQueryO.setParameter(1, "Open");
			orderQueryO.setParameter(2, today);
			List<String> bookids = (List<String>) orderQueryO.list();

			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameterList("bookids", bookids);
			queryObject.setFirstResult((pageNumber - 1) * pageSize);// current
																	// page
			queryObject.setMaxResults(pageSize);// the size of page
			List<Books> list = queryObject.list();
			return list;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAllDueBooks(int pageNumber, int pageSize) {
		try {
			ZoneId zonedId = ZoneId.of("America/Chicago");
			LocalDate ltoday = LocalDate.now(zonedId);
			Date today = java.sql.Date.valueOf(ltoday);

			String queryString = "from Books where BookID in (:bookids)";
			String orderQuey = "select o.bookId from Orders as o where o.statues = ? and o.dueDate < ?";

			Query orderQueryO = getSession().createQuery(orderQuey);
			orderQueryO.setParameter(0, "Open");
			orderQueryO.setParameter(1, today);
			List<String> bookids = (List<String>) orderQueryO.list();
				
			if(bookids.size() == 0){
				return new LinkedList<Books>();
			}
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameterList("bookids", bookids);
			queryObject.setFirstResult((pageNumber - 1) * pageSize);// current
																	// page
			queryObject.setMaxResults(pageSize);// the size of page
			List<Books> list = queryObject.list();
			return list;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public Long findDueBookNumber(int studentId) {
		try {
			ZoneId zonedId = ZoneId.of("America/Chicago");
			LocalDate ltoday = LocalDate.now(zonedId);
			Date today = java.sql.Date.valueOf(ltoday);

			String queryString = "select count(*) from Books where BookID in (:bookids)";
			String orderQuey = "select o.bookId from Orders as o where o.studentId = ? and o.statues = ? and o.dueDate < ?";

			Query orderQueryO = getSession().createQuery(orderQuey);
			orderQueryO.setParameter(0, studentId);
			orderQueryO.setParameter(1, "Open");
			orderQueryO.setParameter(2, today);
			List<String> bookids = (List<String>) orderQueryO.list();

			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameterList("bookids", bookids);
			Long length = (Long) queryObject.uniqueResult();
			return length;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findDueBookByStudentId(int studentId) {
		try {
			ZoneId zonedId = ZoneId.of("America/Chicago");
			LocalDate ltoday = LocalDate.now(zonedId);
			Date today = java.sql.Date.valueOf(ltoday);

			String queryString = "from Books where BookID in (:bookids)";
			String orderQuey = "select o.bookId from Orders as o where o.studentId = ? and o.statues = ? and o.dueDate < ?";

			Query orderQueryO = getSession().createQuery(orderQuey);
			orderQueryO.setParameter(0, studentId);
			orderQueryO.setParameter(1, "Open");
			orderQueryO.setParameter(2, today);
			List<String> bookids = (List<String>) orderQueryO.list();

			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameterList("bookids", bookids);
			List<Books> list = queryObject.list();
			return list;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Books> findBooksBykeyword(Object keyword, int pagenumber, int pagesize) {
		log.debug("finding Books instance with Keyword: " + keyword);
		try {
			Criteria criteria = getSession().createCriteria(Books.class);
			List<Books> list = criteria
					.add(Restrictions.or(Restrictions.like(AUTHOR, (String) keyword, MatchMode.ANYWHERE),
							Restrictions.like(TITLE, (String) keyword, MatchMode.ANYWHERE),
							Restrictions.like(ISBN, (String) keyword, MatchMode.ANYWHERE)))
					.setFirstResult((pagenumber - 1) * pagesize).setMaxResults(pagesize).list();
			return list;
		} catch (RuntimeException re) {
			log.error("find by Keyword failed", re);
			throw re;
		}
	}

	public int getCount(String keyword, String opt) {
		if (opt.equals("rent")) {
			Criteria criteria = getSession().createCriteria(Books.class);
			List<Books> list = criteria.add(Restrictions.and(Restrictions.eq(STATUS, "not available"),
					Restrictions.or(Restrictions.like(AUTHOR, (String) keyword, MatchMode.ANYWHERE),
							Restrictions.like(TITLE, (String) keyword, MatchMode.ANYWHERE),
							Restrictions.like(ISBN, (String) keyword, MatchMode.ANYWHERE))))
					.list();
			return list.size();
		} else if (opt.equals("due")) {
			ZoneId zonedId = ZoneId.of("America/Chicago");
			LocalDate ltoday = LocalDate.now(zonedId);
			Date today = java.sql.Date.valueOf(ltoday);

			String queryString = "from Books where BookID in (:bookids)";
			String orderQuey = "select o.bookId from Orders as o where o.statues = ? and o.dueDate < ?";

			Query orderQueryO = getSession().createQuery(orderQuey);
			orderQueryO.setParameter(0, "Open");
			orderQueryO.setParameter(1, today);
			List<String> bookids = (List<String>) orderQueryO.list();
			return orderQueryO.list().size();
		} else {
			Criteria criteria = getSession().createCriteria(Books.class);
			List<Books> list = criteria
					.add(Restrictions.or(Restrictions.like(AUTHOR, (String) keyword, MatchMode.ANYWHERE),
							Restrictions.like(TITLE, (String) keyword, MatchMode.ANYWHERE),
							Restrictions.like(ISBN, (String) keyword, MatchMode.ANYWHERE)))
					.list();
			return list.size();
		}
	}

	public List<Books> findAllRentBook(Object keyword, int pagenumber, int pagesize) {
		log.debug("finding Books instance with Keyword: " + keyword);
		try {
			Criteria criteria = getSession().createCriteria(Books.class);
			List<Books> list = criteria
					.add(Restrictions.and(Restrictions.eq(STATUS, "not available"),
							Restrictions.or(Restrictions.like(AUTHOR, (String) keyword, MatchMode.ANYWHERE),
									Restrictions.like(TITLE, (String) keyword, MatchMode.ANYWHERE),
									Restrictions.like(ISBN, (String) keyword, MatchMode.ANYWHERE))))
					.setFirstResult((pagenumber - 1) * pagesize).setMaxResults(pagesize).list();
			return list;
		} catch (RuntimeException re) {
			log.error("find by Keyword failed", re);
			throw re;
		}
	}
}