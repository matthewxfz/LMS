package edu.iit.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializer;

import edu.iit.dao.Books;
import edu.iit.dao.Classes;

public class ClassAdapter implements JsonSerializer<Classes>{
	public JsonElement serialize(Classes classes, java.lang.reflect.Type type, com.google.gson.JsonSerializationContext jsc) {
		JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("title", classes.getTitle());
        jsonObject.addProperty("section", classes.getSection());
        
        return jsonObject;
	}
}
