package edu.iit.dao;

import java.util.List;

public class test_count_student_classes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegisterToDAO dao1 = new RegisterToDAO();
		StudentsDAO dao2 = new StudentsDAO();
		Object StuID =1;
		System.out.println(dao1.count_book(StuID));
		
		//findByProperty(String propertyName, Object value)
		
		
	}

}
