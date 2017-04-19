package edu.iit.test;
import edu.iit.dao.Parents;
import edu.iit.dao.ParentsId;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class test_parent_save {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentsDAO dao = new StudentsDAO();
		int id = 3;
		Students stu_find=dao.findById(id);
		Parents p = new Parents(123, stu_find, "1234", "2323", "eewew", "wew");
	}

}
