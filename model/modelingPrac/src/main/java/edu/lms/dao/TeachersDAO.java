package edu.lms.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.lms.bean.Teachers;

/**
 * A data access object (DAO) providing persistence and search support for
 * Teachers entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.lms.bean.Teachers
 * @author MyEclipse Persistence Tools
 */
public class TeachersDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TeachersDAO.class);
	// property constants
	public static final String LAST_NAME = "lastName";
	public static final String MOBLIE = "moblie";
	public static final String EMAIL = "email";
	public static final String ADDRESS = "address";
	public static final String USER_ID = "userId";
	public static final String FIRST_NAME = "firstName";
	public static final String MIDDLE_NAME = "middleName";
	public static final String POWER = "power";
	public static final String PAS = "pas";

	public void save(Teachers transientInstance) {
		log.debug("saving Teachers instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Teachers persistentInstance) {
		log.debug("deleting Teachers instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Teachers findById(java.lang.Integer id) {
		log.debug("getting Teachers instance with id: " + id);
		try {
			Teachers instance = (Teachers) getSession().get("edu.lms.bean.Teachers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Teachers> findByExample(Teachers instance) {
		log.debug("finding Teachers instance by example");
		try {
			List<Teachers> results = (List<Teachers>) getSession().createCriteria("edu.lms.bean.Teachers")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Teachers instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Teachers as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Teachers> findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	public List<Teachers> findByMoblie(Object moblie) {
		return findByProperty(MOBLIE, moblie);
	}

	public List<Teachers> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<Teachers> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Teachers> findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<Teachers> findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	public List<Teachers> findByMiddleName(Object middleName) {
		return findByProperty(MIDDLE_NAME, middleName);
	}

	public List<Teachers> findByPower(Object power) {
		return findByProperty(POWER, power);
	}

	public List<Teachers> findByPas(Object pas) {
		return findByProperty(PAS, pas);
	}

	public List findAll() {
		log.debug("finding all Teachers instances");
		try {
			String queryString = "from Teachers";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Teachers merge(Teachers detachedInstance) {
		log.debug("merging Teachers instance");
		try {
			Teachers result = (Teachers) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Teachers instance) {
		log.debug("attaching dirty Teachers instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Teachers instance) {
		log.debug("attaching clean Teachers instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}