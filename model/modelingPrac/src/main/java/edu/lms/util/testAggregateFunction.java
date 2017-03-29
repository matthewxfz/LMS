package edu.lms.util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class testAggregateFunction {
	@Test
	public void testReadingFilesToHash() {
		try {
			CSVUtil csvUtil = new CSVUtil(new File("/Users/matthewxfz/Workspaces/tmp/autompg.csv"));

			List<HashMap<String, String>> table = csvUtil.getTableToLinkList();

			String[] schema = csvUtil.getSchema();

			Iterator<HashMap<String, String>> iterator = table.iterator();

			while (iterator.hasNext()) {
				HashMap<String, String> tuple = iterator.next();
				for (String s : schema) {
					System.out.print(tuple.get(s) + ",");
				}
				System.out.println("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testReadingFilesToArray() {
		try {
			CSVUtil csvUtil = new CSVUtil(new File("/Users/matthewxfz/Workspaces/tmp/autompg.csv"));

			String[][] table = csvUtil.getTableToArray();

			printTableInArray(table);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testProjection() {
		MySession session = new MySession();

		try {
			session.addTable(new File("/Users/matthewxfz/Workspaces/tmp/autompg.csv"));
			Table table = session.tables.get(0);
			List<String> attris = new LinkedList<String>();

			attris.add("mpg");
			attris.add("weight");

			table = table.project(attris);

			printTableInArray(table.content);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelection() {
		MySession session = new MySession();

		try {
			session.addTable(new File("/Users/matthewxfz/Workspaces/tmp/autompg.csv"));
			Table table = session.tables.get(0);
			List<String> attris = new LinkedList<String>();

			attris.add("mpg");
			attris.add("weight");

			table = table.select(new Condition(""));

			printTableInArray(table.content);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testProduction() {
		MySession session = new MySession();

		try {
			session.addTable(new File("/Users/matthewxfz/Workspaces/tmp/autompg_1.csv"));
			session.addTable(new File("/Users/matthewxfz/Workspaces/tmp/autompg_2.csv"));
//			List<Table> tableList = session.tables;
			Table table = session.production(session.tables.get(0),session.tables.get(1));
			
			printTableInArray(table.content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBuildArray() {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println(a.length + ", " + a[0].length + ", " + a[0][2]);
	}

	private void printTableInArray(String[][] table) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < table[0].length; j++) {
				System.out.print(", " + table[i][j]);
			}
			System.out.println("\n");
		}
	}
	
	private void printHashTable(List<HashMap<String, String>> table){
		Iterator<HashMap<String, String>> ite = table.iterator();
		
		while(ite.hasNext()){
			System.out.println(ite.next().toString());
		}
	}
	private void printList(List<String> table){
		Iterator<String> ite =  table.iterator();
		
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
	}
	
	@Test
	public void testHashMap(){
		HashMap<String, String> tuple = new HashMap<String, String>();
		
		tuple.put("hello", "world");
		tuple.put("hello", "new");
		
		Set<String> keys = tuple.keySet();
		keys.iterator();
		
		assertEquals("new", tuple.get("hello"));
	}
	
	@Test
	public void testQueriesGroupByHavingCount(){
		try {
			CSVUtil csvUtil = new CSVUtil();
			Queries q = new Queries();
			printList(q.groupByHaving(csvUtil.getTableToLinkList(new File("/Users/matthewxfz/Workspaces/tmp/Customers.csv")), "Country",1));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNexstQuery(){
		try {
			File customers = new File("/Users/matthewxfz/Workspaces/tmp/Customers.csv");
			File orders = new File("/Users/matthewxfz/Workspaces/tmp/Orders.csv");
			CSVUtil customer = new CSVUtil());
			CSVUtil Orders = new CSVUtil();
			Queries q = new Queries();
			printList(q.nestedQuery(customer.getTableToLinkList(customers), Orders.getTableToLinkList(orders)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testJoinQuery(){
		try {
			File customers = new File("/Users/matthewxfz/Workspaces/tmp/Customers.csv");
			File orders = new File("/Users/matthewxfz/Workspaces/tmp/Orders.csv");
			CSVUtil csvUtil = new CSVUtil();

			Queries q = new Queries();
			printList(q.linearNatureJoin(csvUtil.getTableToLinkList(customers), csvUtil.getTableToLinkList(orders)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
