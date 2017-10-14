//
//import edu.iit.dao.Parents;
//import edu.iit.dao.ParentsDAO;
//import edu.iit.dao.ParentsId;
//import edu.iit.dao.ParentsMessage;
//
//public class testFind {
//
//	public static void main(String[] args) {
//		
//		int StudentID = 100;
//		String Lastpname = "matthew";
//		String Firstpname = "Xiong";
//		Process(StudentID,Lastpname,Firstpname);
//
//	}
//	
//	public static ParentsMessage Process(String studentID,String Lastpname,String Firstpname){
//		ParentsMessage pmsg = new ParentsMessage();
//		try {
//			ParentsDAO pdao = new ParentsDAO();
//			ParentsId pid = new ParentsId(Lastpname, Firstpname, Integer.valueOf(studentID));
//			Parents pnt = new Parents();
//			
//			pnt = pdao.findById(pid);
//			
//			
//			
//			if(!pnt.equals(null)){
//				pmsg.setStatus("true");
//				pmsg.setTitle("Delete Successful!");
//				pmsg.setContent("StutentID: \n"+pid.getStudentId().toString() + "\n" 
//								+ "Parent information:\n" + pid.getFirstName() + " " 
//								+ pid.getLastName()
//								+ "\n");
//				pdao.delete(pnt);
//				System.out.println(pmsg.getContent().toString());
//				return pmsg;
//			}else{
//				pmsg.setStatus("false");
//				pmsg.setTitle("Parent information not found!");
//				pmsg.setContent("Not found!");
//				System.out.println(pmsg.getContent().toString());
//				return pmsg;
//			}
//		} catch (Exception e) {
//			pmsg.setStatus("false");
//			pmsg.setTitle("Error!");
//			pmsg.setContent("Inner Server Error!");
//		}
//	}
//	
//}
