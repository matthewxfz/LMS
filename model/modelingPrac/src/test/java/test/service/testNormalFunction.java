package test.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class testNormalFunction {
	
	@Test	
	public void testTimeStamp(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'HH:mm:ss");
		String timeStamp = sdf.format(cal.getTime());
		System.out.println(timeStamp);
		
	}
	
	@Test
	public void testSignature(){
		
	}
}
