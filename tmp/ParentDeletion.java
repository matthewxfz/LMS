package eu.iit.test;

import edu.iit.dao.Parents;
import edu.iit.dao.ParentsDAO;
import edu.iit.dao.ParentsId;
import edu.iit.dao.ParentsMessage;
import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class ParentDeletion {

	public static void main(String[] args) {
		
		String StudentID = "2";
		String Lastpname = "matthew";
		String Firstpname = "Xiong";
		String opt = "add";
		Process(StudentID,Lastpname,Firstpname,opt);

	}
	
	public static ParentsMessage Process(String StudentID,String Lastpname,String Firstpname,String opt){
		
		ParentsDAO pdao = new ParentsDAO();
		ParentsId pid = new ParentsId(Lastpname, Firstpname, Integer.valueOf(StudentID));
		Parents pnt;
		ParentsMessage pmsg = new ParentsMessage();
		StudentsDAO sdao = new StudentsDAO();
		Students stu = sdao.findById(Integer.valueOf(StudentID));
		try {
			if(opt.equals("add")){//add parent
				pnt = new Parents(pid,stu,"21","lzq102@djd.com","Mother","0");
				pdao.save(pnt); //save parent
				pmsg.setStatus("true");
				pmsg.setTitle("Add Successful!");
				pmsg.setScontent(stu);
				pmsg.setContent("Student Information: \n" + "StutentID: \n"+stu.getStudentId()
								+ "\n" +  "Student Name: \n" + stu.getFirstName() + " " + stu.getLastName() + "\n"
								+ "Mobile: \n" + stu.getMoblie() + "\n" + "Address: \n" + stu.getAddress() + "\n" 
								+ "Gender: \n" + stu.getGender() + "\n" + "Age: \n" + stu.getAge() + "\n"
								+" \n" + "Parent information:\n" + "ParentName: \n" + pid.getFirstName() + " " 
								+ pid.getLastName() + "\n" + "Mobile: \n" + pnt.getMoblie() + "\n" 
								+ "Email: \n" + pnt.getEmail() + "\n" + "Relationship: \n"
								+ pnt.getRelationship());
				System.out.println(pmsg.getContent().toString());
				return pmsg;
				
			}else if(opt.equals("delete")){//delete parent
				pnt = pdao.findById(pid);
				pmsg.setStatus("true");
				pmsg.setTitle("Delete Successful!");
				pmsg.setScontent(stu);
				pmsg.setContent("Student Information: \n" + "StutentID: \n"+stu.getStudentId()
								+ "\n" +  "Student Name: \n" + stu.getFirstName() + " " + stu.getLastName() + "\n"
								+ "Mobile: \n" + stu.getMoblie() + "\n" + "Address: \n" + stu.getAddress() + "\n" 
								+ "Gender: \n" + stu.getGender() + "\n" + "Age: \n" + stu.getAge() + "\n"
								+ " \n" + "Parent information:\n" + "ParentName: \n" + pid.getFirstName() + " " 
								+ pid.getLastName() + "\n" + "Mobile: \n" + pnt.getMoblie() + "\n" 
								+ "Email: \n" + pnt.getEmail() + "\n" + "Relationship: \n"
								+ pnt.getRelationship());
				pdao.delete(pnt);// delete parent
				System.out.println(pmsg.getContent().toString());
			}
			return pmsg;
		} catch (Exception e) {
			pmsg.setStatus("false");
			pmsg.setTitle("error!");
			pmsg.setContent("Inner Server Error!");
			System.out.println(pmsg.getContent().toString());
			return pmsg;
		}
	}
	
}
