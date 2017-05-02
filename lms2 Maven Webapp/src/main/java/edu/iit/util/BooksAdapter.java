package edu.iit.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializer;

import edu.iit.dao.Books;

public class BooksAdapter implements JsonSerializer<Books>{
	public JsonElement serialize(Books books, java.lang.reflect.Type type, com.google.gson.JsonSerializationContext jsc) {
		JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("bookId", books.getBookId());
        jsonObject.addProperty("title", books.getTitle());
        jsonObject.addProperty("author", books.getAuthor());
        jsonObject.addProperty("isbn10", books.getIsbn());
        jsonObject.addProperty("publisher", books.getPublisher());
        jsonObject.addProperty("status", books.getStatus());
        jsonObject.addProperty("generatedId", books.getGeneratedId());
        jsonObject.addProperty("cover", books.getCover());
        return jsonObject;      
	};
}
