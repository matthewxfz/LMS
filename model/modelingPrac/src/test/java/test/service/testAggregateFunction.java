package test.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import edu.lms.util.CSVUtil;


public class testAggregateFunction {
	@Test
	public void testReadingFiles(){
		try {
			CSVUtil csvUtil = new CSVUtil(new File("/Users/matthewxfz/Workspaces/tmp/autompg.csv"));
			
			List<HashMap<String, String>> table = csvUtil.getTable();
			
			String[] schema = csvUtil.getSchema();
			
			Iterator<HashMap<String, String>> iterator = table.iterator();
			
			while(iterator.hasNext()){
				HashMap<String, String> tuple = iterator.next();
				for(String s: schema){
					System.out.print(tuple.get(s)+",");
				}
				System.out.println("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testBuildArray(){
		int[] a;
		a = (int[])((new Object())[100]);
	}

}
