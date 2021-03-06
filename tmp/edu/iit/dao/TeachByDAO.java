package edu.iit.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TeachBy entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.iit.dao.TeachBy
 * @author MyEclipse Persistence Tools
 */
public class TeachByDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TeachByDAO.class);
	// property constants

	public void save(TeachBy transientInstance) {
		log.debug("saving TeachBy instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TeachBy persistentInstance) {
		log.debug("deleting TeachBy instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TeachBy findById(edu.iit.dao.TeachById id) {
		log.debug("getting TeachBy instance with id: " + id);
		try {
			TeachBy instance = (TeachBy) getSession().get("edu.iit.dao.TeachBy", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TeachBy instance) {
		log.debug("finding TeachBy instance by example");
		try {
			List results = getSession().createCriteria("edu.iit.dao.TeachBy").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TeachBy instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from TeachBy as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TeachBy instances");
		try {
			String queryString = "from TeachBy";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TeachBy merge(TeachBy detachedInstance) {
		log.debug("merging TeachBy instance");
		try {
			TeachBy result = (TeachBy) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TeachBy instance) {
		log.debug("attaching dirty TeachBy instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TeachBy instance) {
		log.debug("attaching clean TeachBy instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}