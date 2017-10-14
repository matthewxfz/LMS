package edu.iit.test;

import java.util.List;

import edu.iit.dao.ClassesDAO;

public class test_class_groupby {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassesDAO dao = new ClassesDAO();
		Object c ="100";
		String s="123";
		List<Object> l= dao.groupByProperty(s, c);
		System.out.println(l.toString());
	}

}
