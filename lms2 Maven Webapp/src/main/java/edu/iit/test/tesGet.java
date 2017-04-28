package edu.iit.test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import edu.iit.dao.Students;
import edu.iit.dao.StudentsDAO;

public class tesGet {
	
	public static void main(String[] args){
		ZoneId zonedId = ZoneId.of( "America/Chicago" );
		LocalDate ltoday = LocalDate.now( zonedId );
		java.util.Date today = java.sql.Date.valueOf(ltoday);
		java.util.Date due_today = java.sql.Date.valueOf(ltoday.minusMonths(-12));
		System.out.println(today);
		System.out.println(due_today);
	}

}
