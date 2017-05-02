package edu.iit.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orders entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.iit.dao.Orders
 * @author MyEclipse Persistence Tools
 */
public class OrdersDAO_backup2 extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(OrdersDAO_backup2.class);
	// property constants
	public static final String TYPE = "type";
	public static final String STATUES = "statues";
	public static final String ADMIN_ID = "adminId";

	public void save(Orders transientInstance) {
		log.debug("saving Orders instance");
		try {
			getSession().save(transientInstance);
			commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void commit(){
		log.debug("commit the save");
		try {
			Transaction tx = getSession().beginTransaction();
			tx.commit();
			getSession().close();
			log.debug("commit successful");
		} catch (Exception e) {
			log.error("commite failed", e);
			throw e;
		}
	}

	public void delete(Orders persistentInstance) {
		log.debug("deleting Orders instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Orders findById(edu.iit.dao.OrdersId id) {
		log.debug("getting Orders instance with id: " + id);
		try {
			Orders instance = (Orders) getSession().get("edu.iit.dao.Orders", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public Orders findOpenOrderById(int bookId, int studentId){
		try {
			String queryString = "from Orders where BookID =? and StudentID = ? and Statues = ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, bookId);
			queryObject.setParameter(1, studentId);
			queryObject.setParameter(2, "open");
			List<Orders> list = queryObject.list();
			if(list.size() <= 0){
				return null;
			}else{
				return list.get(0);
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public Orders findClosedOrderById(int bookId, int studentId){
		try {
			String queryString = "from Orders where BookID =? and StudentID = ? and Statues = ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, bookId);
			queryObject.setParameter(1, studentId);
			queryObject.setParameter(2, "Closed");
			List<Orders> list = queryObject.list();
			if(list.size() <= 0){
				return null;
			}else{
				return list.get(0);
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByExample(Orders instance) {
		log.debug("finding Orders instance by example");
		try {
			List results = getSession().createCriteria("edu.iit.dao.Orders").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Orders instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Orders as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public Orders findOpenOrdersByBookId(int bookId){
		try {
			String queryString = "from Orders where BookID =? and Statues = ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, bookId);
			queryObject.setParameter(1, "open");
			List<Orders> list = queryObject.list();
			if(list.size() <= 0){
				return null;
			}else{
				return list.get(0);
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByStatues(Object statues) {
		return findByProperty(STATUES, statues);
	}

	public List findByAdminId(Object adminId) {
		return findByProperty(ADMIN_ID, adminId);
	}

	public List findAll() {
		log.debug("finding all Orders instances");
		try {
			String queryString = "from Orders";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orders merge(Orders detachedInstance) {
		log.debug("merging Orders instance");
		try {
			Orders result = (Orders) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orders instance) {
		log.debug("attaching dirty Orders instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Orders instance) {
		log.debug("attaching clean Orders instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public Orders findByBookId(int BookId){
		log.debug("finding all Orders instances");
		try {
			String queryString = "from Orders where BookID = ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, BookId);
			List<Orders> ls = (List<Orders>) queryObject.list();
			if(ls.size() <=0){
				return null;
			}else{
				return ls.get(0);
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}