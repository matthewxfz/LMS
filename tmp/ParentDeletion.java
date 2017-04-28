package eu.iit.test;

import edu.iit.dao.Parents;
import edu.iit.dao.ParentsDAO;
import edu.iit.dao.ParentsId;
import edu.iit.dao.ParentsMessage;

public class testFind {

	public static void main(String[] args) {
		
		int StudentID = 100;
		String Lastpname = "matthew";
		String Firstpname = "Xiong";
		Process(StudentID,Lastpname,Firstpname);

	}
	
	public static ParentsMessage Process(int StudentID,String Lastpname,String Firstpname){
		
		ParentsDAO pdao = new ParentsDAO();
		ParentsId pid = new ParentsId(Lastpname, Firstpname, StudentID);
		Parents pnt = new Parents();
		
		pnt = pdao.findById(pid);
		
		ParentsMessage pmsg = new ParentsMessage();
		
		if(!pnt.equals(null)){
			pmsg.setStatus("true");
			pmsg.setTitle("Delete Successful!");
			pmsg.setContent("StutentID: \n"+pid.getStudentId().toString() + "\n" 
							+ "Parent information:\n" + pid.getFirstName() + " " 
							+ pid.getLastName()
							+ "\n");
			pdao.delete(pnt);
			System.out.println(pmsg.getContent().toString());
			return pmsg;
		}else{
			pmsg.setStatus("false");
			pmsg.setTitle("Parent information not found!");
			pmsg.setContent("Not found!");
			System.out.println(pmsg.getContent().toString());
			return pmsg;
		}
		
	}
	
}
