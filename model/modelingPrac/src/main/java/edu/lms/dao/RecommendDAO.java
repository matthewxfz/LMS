package edu.lms.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.lms.bean.Recommend;
import edu.lms.bean.RecommendId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Recommend entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.lms.bean.Recommend
 * @author MyEclipse Persistence Tools
 */
public class RecommendDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(RecommendDAO.class);
	// property constants

	public void save(Recommend transientInstance) {
		log.debug("saving Recommend instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Recommend persistentInstance) {
		log.debug("deleting Recommend instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Recommend findById(edu.lms.bean.RecommendId id) {
		log.debug("getting Recommend instance with id: " + id);
		try {
			Recommend instance = (Recommend) getSession().get("edu.lms.bean.Recommend", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Recommend> findByExample(Recommend instance) {
		log.debug("finding Recommend instance by example");
		try {
			List<Recommend> results = (List<Recommend>) getSession().createCriteria("edu.lms.bean.Recommend")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Recommend instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Recommend as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Recommend instances");
		try {
			String queryString = "from Recommend";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Recommend merge(Recommend detachedInstance) {
		log.debug("merging Recommend instance");
		try {
			Recommend result = (Recommend) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Recommend instance) {
		log.debug("attaching dirty Recommend instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Recommend instance) {
		log.debug("attaching clean Recommend instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}