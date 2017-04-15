package edu.iit.test;

import java.util.List;

import edu.iit.bean.Students;
import edu.iit.bean.StudentsDAO;

public class tesGet {
	
	public static void main(String[] args){
		StudentsDAO dao =  new StudentsDAO();
		//select 
		dao.save(new Students("1", "Xiong", "Fangzhou", "male", "asdf@hawk.iit.edu", "xin"));
		List<Students>  stulist = dao.findByUserId("xin");
		
		System.out.println("hello this is :\n"+stulist.toString());
	}

}
