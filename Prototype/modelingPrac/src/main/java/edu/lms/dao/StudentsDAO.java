package edu.lms.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.lms.bean.Students;

/**
 * A data access object (DAO) providing persistence and search support for
 * Students entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.lms.bean.Students
 * @author MyEclipse Persistence Tools
 */
public class StudentsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(StudentsDAO.class);
	// property constants
	public static final String MOBLIE = "moblie";
	public static final String ADDRESS = "address";
	public static final String POWER = "power";
	public static final String LAST_NAME = "lastName";
	public static final String MIDDLE_NAME = "middleName";
	public static final String FIRST_NAME = "firstName";
	public static final String GENDER = "gender";
	public static final String AGE = "age";
	public static final String EMAIL = "email";
	public static final String USER_ID = "userId";
	public static final String PAS = "pas";

	public void save(Students transientInstance) {
		log.debug("saving Students instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Students persistentInstance) {
		log.debug("deleting Students instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Students findById(java.lang.Integer id) {
		log.debug("getting Students instance with id: " + id);
		try {
			Students instance = (Students) getSession().get("edu.lms.bean.Students", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Students> findByExample(Students instance) {
		log.debug("finding Students instance by example");
		try {
			List<Students> results = (List<Students>) getSession().createCriteria("edu.lms.bean.Students")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Students instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Students as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Students> findByMoblie(Object moblie) {
		return findByProperty(MOBLIE, moblie);
	}

	public List<Students> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Students> findByPower(Object power) {
		return findByProperty(POWER, power);
	}

	public List<Students> findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	public List<Students> findByMiddleName(Object middleName) {
		return findByProperty(MIDDLE_NAME, middleName);
	}

	public List<Students> findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	public List<Students> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List<Students> findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List<Students> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<Students> findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<Students> findByPas(Object pas) {
		return findByProperty(PAS, pas);
	}

	public List findAll() {
		log.debug("finding all Students instances");
		try {
			String queryString = "from Students";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Students merge(Students detachedInstance) {
		log.debug("merging Students instance");
		try {
			Students result = (Students) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Students instance) {
		log.debug("attaching dirty Students instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Students instance) {
		log.debug("attaching clean Students instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}