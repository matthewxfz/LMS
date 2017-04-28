package edu.iit.util;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import edu.iit.dao.Books;
import edu.iit.dao.Parents;
import edu.iit.dao.Students;

public class StudentAdapter implements JsonSerializer<Students> {
	public JsonElement serialize(Students student, java.lang.reflect.Type type,
		com.google.gson.JsonSerializationContext jsc) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("studentId", student.getStudentId());
		jsonObject.addProperty("firstName", student.getFirstName());
		jsonObject.addProperty("lastName", student.getLastName());
		jsonObject.addProperty("middleName", student.getMiddleName());
		jsonObject.addProperty("email", student.getEmail());
		jsonObject.addProperty("power", student.getPower());
		jsonObject.addProperty("address", student.getAddress());
		Set pset = student.getParentses();
		
		Parents parent;
		Iterator<Parents> ite = pset.iterator();
		if (ite.hasNext()) {
			parent = ite.next();
		}else{
			parent = new Parents(null, null, "null", "null", "null", "1");
		}
		jsonObject.addProperty("pFirstName", parent.getId().getFirstName());
		jsonObject.addProperty("pLastName", parent.getId().getLastName());
		jsonObject.addProperty("pMiddleName", parent.getMiddleName());
		jsonObject.addProperty("pEmail", student.getEmail());
		jsonObject.addProperty("pMobile", student.getMoblie());
		return jsonObject;
	}
}
