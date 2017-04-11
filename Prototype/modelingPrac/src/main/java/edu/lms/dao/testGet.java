package edu.lms.dao;


import org.junit.Test;

import edu.lms.bean.Students;

public class testGet {
	@Test
	public void tesGetStudentsByuserAndPs(){
		//SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		//Session session = sessionfactory.openSession();
		StudentsDAO stuDao = new StudentsDAO();
		Students stu = stuDao.findById(1);//("yan", "123456");
		
		System.out.println(stu.toString());
	}

}
