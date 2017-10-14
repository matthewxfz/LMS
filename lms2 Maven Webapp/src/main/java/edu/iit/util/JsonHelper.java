package edu.iit.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.iit.bean.SearchBookMessage;
import edu.iit.dao.Books;

public class JsonHelper {
	public String SearchBooksMsgToJson(SearchBookMessage msg) {  
	    GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(Books.class, new BooksAdapter()).create();
	    return gson.toJson(msg);
	}   

}
