package edu.lms.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.channels.SeekableByteChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.lms.util.CSVUtil;

public class AggregateFunctionService {
	HashMap<String, String> schema;
	LinkedList<HashMap<String, String>> table;

	// select count(groupby) from <tableName> groupby <attribute> having
	// <atrribute> >
	public LinkedList<HashMap<String,String>> selectGroupByHavingCountLargerThen(
			List<String> selectedAttri, File table, List<String> groupAttri, List<String> condition) throws FileNotFoundException{
		
		CSVUtil util = new CSVUtil(table);
		List<HashMap<String, String>> tuples = util.getTable();
		
		Iterator<String> groupIte = groupAttri.iterator();
		
		while(groupIte.hasNext()){
			
			
			//HashMap<String, String> tuple = groupIte.next();
			
		}
		
		return null;
		
	}
	public List<String> maxTuple(String attri) {
		return null;
	}

	public List<String> minTuple(String attri) {
		return null;
	}

	public int ava(String attri) {
		return -1;
	}

	public int sum(String attri) {
		return -1;
	}

	public int count(String attri) {
		return 1;
	}
}
