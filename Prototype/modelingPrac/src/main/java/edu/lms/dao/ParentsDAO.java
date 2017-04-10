package edu.lms.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.lms.bean.Parents;
import edu.lms.bean.ParentsId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Parents entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.lms.bean.Parents
 * @author MyEclipse Persistence Tools
 */
public class ParentsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ParentsDAO.class);
	// property constants
	public static final String ADDRESS = "address";
	public static final String MOBLIE = "moblie";
	public static final String EMAIL = "email";
	public static final String MIDDLE_NAME = "middleName";
	public static final String RELATIONSHIP = "relationship";
	public static final String POWER = "power";

	public void save(Parents transientInstance) {
		log.debug("saving Parents instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Parents persistentInstance) {
		log.debug("deleting Parents instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Parents findById(edu.lms.bean.ParentsId id) {
		log.debug("getting Parents instance with id: " + id);
		try {
			Parents instance = (Parents) getSession().get("edu.lms.bean.Parents", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Parents> findByExample(Parents instance) {
		log.debug("finding Parents instance by example");
		try {
			List<Parents> results = (List<Parents>) getSession().createCriteria("edu.lms.bean.Parents")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Parents instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Parents as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Parents> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Parents> findByMoblie(Object moblie) {
		return findByProperty(MOBLIE, moblie);
	}

	public List<Parents> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<Parents> findByMiddleName(Object middleName) {
		return findByProperty(MIDDLE_NAME, middleName);
	}

	public List<Parents> findByRelationship(Object relationship) {
		return findByProperty(RELATIONSHIP, relationship);
	}

	public List<Parents> findByPower(Object power) {
		return findByProperty(POWER, power);
	}

	public List findAll() {
		log.debug("finding all Parents instances");
		try {
			String queryString = "from Parents";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Parents merge(Parents detachedInstance) {
		log.debug("merging Parents instance");
		try {
			Parents result = (Parents) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Parents instance) {
		log.debug("attaching dirty Parents instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Parents instance) {
		log.debug("attaching clean Parents instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}