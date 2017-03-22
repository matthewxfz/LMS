package edu.lms.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import edu.lms.bean.Books;

public class FachingBooksServiceImple implements edu.lms.service.FachingBooksService {
	@Override
	public Books getBooksByISBN(String isbns) {

		return null;
	}

	@Override
	public List<Books> getBooksByTitle(String title) {
		String str = "http://webservices.amazon.com/onca/xml? " + "Service=AWSECommerceService"
				+ "&Operation=ItemSearch" 
				+ "&ResponseGroup=Small" 
				+ "&SearchIndex=Books" 
				+ "&Title = Art of war"
				+ "&ItemPage=1"
				+ "&AWSAccessKeyId=matthewxfz-20" 
				+ "&AssociateTag=haha" 
				+ "&Timestamp=2017" 
				+ "&Signature=";

		URL url;
		try {
			url = new URL("https://graph.facebook.com/search?q=java&type=post");
			try {
				InputStream is = url.openStream();
				JsonReader rdr = Json.createReader(is);
				JsonObject obj = rdr.readObject();
				JsonArray results = obj.getJsonArray("data");
				for (JsonObject result : results.getValuesAs(JsonObject.class)) {
					System.out.print(result.getJsonObject("from").getString("name"));
					System.out.print(": ");
					System.out.println(result.getString("message", ""));
					System.out.println("-----------");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
