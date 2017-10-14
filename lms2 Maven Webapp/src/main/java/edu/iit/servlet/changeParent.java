package edu.iit.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.iit.bean.ParentsMessage;
import edu.iit.dao.Parents;
import edu.iit.dao.ParentsDAO;
import edu.iit.dao.ParentsId;

@WebServlet(urlPatterns="/changeParent")
public class changeParent extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//read the input 
				System.out.println("We get the messgae");
				StringBuffer jb = new StringBuffer();
				String line = null;
				try {
					BufferedReader reader = req.getReader();
					while ((line = reader.readLine()) != null)
						jb.append(line);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("The string is "+jb.toString());
//				//decomposite the input json
				JsonElement jelement = new JsonParser().parse(jb.toString());
				JsonObject jobject = jelement.getAsJsonObject();
				String studentId  = decompositeJSON(jobject, "studentId");
				String parentLastName = decompositeJSON(jobject, "parentLastName");
				String parentFirstName = decompositeJSON(jobject, "parentFirstName");
				String opt = decompositeJSON(jobject, "opt");
	}
	
	private ParentsMessage Process(String studentID,String Lastpname,String Firstpname, String opt){
		ParentsMessage pmsg = new ParentsMessage();
		try {
			ParentsDAO pdao = new ParentsDAO();
			
			if(opt.equals("add")){// add a parent
				//pdao.save((new Parents(new ParentsId(Lastpname, Firstpname, Integer.valueOf(studentID), students, address, moblie, email, middleName, relationship, power)));
			}else{//delete a parent
				
			}
			ParentsId pid = new ParentsId(Lastpname, Firstpname, Integer.valueOf(studentID));
			Parents pnt = new Parents();
			
			pnt = pdao.findById(pid);
			
			
			
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
		} catch (Exception e) {
			pmsg.setStatus("false");
			pmsg.setTitle("Error!");
			pmsg.setContent("Inner Server Error!");
			return pmsg;
		}
	}
	
	public String decompositeJSON(JsonObject jsonObject, String attr){
		return ((jsonObject.get(attr).toString()).split("\""))[1];
	}
}
