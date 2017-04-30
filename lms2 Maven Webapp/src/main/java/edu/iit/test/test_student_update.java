package edu.iit.test;

import java.util.List;

import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class test_student_update {
	
	public static void main(String[] args) {
		StudentsDAO dao = new StudentsDAO();
		//int id = 3;
		//Students stu_find=dao.findById(id);
 		//stu_find.setAddress("0");
		//Students result = dao.merge(stu_find);
		//System.out.println("output is "+result.toString());
		System.out.println(dao.test(1, 3));
	
	}
}
