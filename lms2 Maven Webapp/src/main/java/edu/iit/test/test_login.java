package edu.iit.test;

import java.util.List;

import edu.iit.dao.Books;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class test_login {
	
	public static void main(String[] args){
		StudentsDAO dao = new StudentsDAO();
		Object email ="fxiong4@hawk.iit.edu";
		String password ="123456";
		List<Students>  ll = dao.findByEmail(email);
		if(ll.isEmpty()){
			System.out.println("not in the list");
		}else{
			String temppass=ll.get(0).getPas();
			if (temppass.equals(password)){
				System.out.println("welcome");
				//enter the page
			}else{
				System.out.println("enter again");
				//input password again
			}
		}
	}
}