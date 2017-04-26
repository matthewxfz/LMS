package edu.iit.test;

import java.sql.Timestamp;

public class test_time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timestamp checkinDate= new Timestamp(System.currentTimeMillis());
		System.out.println(checkinDate.toString());
	}

}
