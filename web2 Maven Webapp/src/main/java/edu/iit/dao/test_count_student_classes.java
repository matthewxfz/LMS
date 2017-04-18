package edu.iit.dao;

import java.util.List;

public class test_count_student_classes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegisterToDAO dao = new RegisterToDAO();
		Object StuID =1;
		String password ="123456";
		List<RegisterTo> ll= dao.findByProperty("studentId",StuID);
		//findByProperty(String propertyName, Object value)
		
		System.out.println(ll.toString());
	}

}
