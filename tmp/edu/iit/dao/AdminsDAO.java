package edu.iit.dao;
import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Admins entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.iit.dao.Admins
 * @author MyEclipse Persistence Tools
 */
public class AdminsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AdminsDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String LAST_NAME = "lastName";
	public static final String MOBLIE = "moblie";
	public static final String ADDRESS = "address";
	public static final String EMAIL = "email";
	public static final String POWER = "power";
	public static final String FIRST_NAME = "firstName";
	public static final String MIDDLE_NAME = "middleName";
	public static final String PAS = "pas";

	public void save(Admins transientInstance) {
		log.debug("saving Admins instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Admins persistentInstance) {
		log.debug("deleting Admins instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Admins findById(java.lang.Integer id) {
		log.debug("getting Admins instance with id: " + id);
		try {
			Admins instance = (Admins) getSession().get("edu.iit.dao.Admins", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Admins instance) {
		log.debug("finding Admins instance by example");
		try {
			List results = getSession().createCriteria("edu.iit.dao.Admins").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Admins instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Admins as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	public List findByMoblie(Object moblie) {
		return findByProperty(MOBLIE, moblie);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByPower(Object power) {
		return findByProperty(POWER, power);
	}

	public List findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	public List findByMiddleName(Object middleName) {
		return findByProperty(MIDDLE_NAME, middleName);
	}

	public List findByPas(Object pas) {
		return findByProperty(PAS, pas);
	}

	public List findAll() {
		log.debug("finding all Admins instances");
		try {
			String queryString = "from Admins";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Admins merge(Admins detachedInstance) {
		log.debug("merging Admins instance");
		try {
			Admins result = (Admins) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Admins instance) {
		log.debug("attaching dirty Admins instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Admins instance) {
		log.debug("attaching clean Admins instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}