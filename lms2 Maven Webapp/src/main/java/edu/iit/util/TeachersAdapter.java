package edu.iit.util;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import edu.iit.dao.Orders;
import edu.iit.dao.Teachers;

public class TeachersAdapter implements JsonSerializer<Teachers>{

	@Override
	public JsonElement serialize(Teachers src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();
        //jsonObject.addProperty("teacherId", String.valueOf(src.getUserId()));
        jsonObject.addProperty("teacherGeneratedId", String.valueOf(src.getUserId()));
        jsonObject.addProperty("lastName", String.valueOf(src.getLastName()));
        jsonObject.addProperty("firstName", String.valueOf(src.getFirstName()));
        jsonObject.addProperty("email", String.valueOf(src.getEmail()));
        jsonObject.addProperty("mobile", String.valueOf(src.getMoblie()));
        jsonObject.addProperty("address", String.valueOf(src.getAddress()));
        jsonObject.addProperty("power", String.valueOf(src.getPower()));
        
        return jsonObject;
	}

}
