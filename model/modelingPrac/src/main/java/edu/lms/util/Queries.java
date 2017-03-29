package edu.lms.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.criteria.From;

import org.hibernate.hql.internal.classic.GroupByParser;
import org.hibernate.sql.Select;

public class Queries {

	/**
	 * SELECT <Attri>, COUNT(*) FROM <Table> GROUPBY <Attri> Having COUNT(*) > 1;
	 * SELECT City, COUNT(*) FROM Customers GROUP BY City HAVING COUNT(*) >1;
	 * Using bucket get projection and convert result, O(n)
	 * 
	 * @param file
	 */
	public List<String> groupByHaving(List<HashMap<String, String>> table, String attri, int count) {
		HashMap<String, Integer> buket = new HashMap<String, Integer>();

		Iterator<HashMap<String, String>> ite = table.iterator();

		//record the count int the bucket
		while (ite.hasNext()) {
			String condi = ite.next().get(attri);
			

			// add 1 to the count of the major
			if (buket.containsKey(condi)) {
				buket.put(condi, buket.get(condi) + 1);
			} else {
				buket.put(condi, 1);
			}
		}
		
		//remove all count less then count from the bucket
		Iterator<String> kIte = buket.keySet().iterator();
		
		while (kIte.hasNext()) {
			String key = kIte.next();
			if(buket.get(key) <= count)
				buket.put(key, 0);
			if(key == null || key.equals("null"))
				buket.remove(key);
		}
		
		//convert the result
		List<String> output = new LinkedList<String>();
		output.add(attri+","+"COUNT");
		int num = 0;
		
		Set<String> keys = buket.keySet();
		Iterator<String> CIte = keys.iterator();
		while (CIte.hasNext()) {
			String key = CIte.next();
			if(buket.get(key) != 0)
				output.add(key + "," + buket.get(key));
			num += buket.get(key);
		}
		
		System.out.println(num+"!!!!!!!");
		return output;
	}
	
	/**
	 * SELECT <attri_2>, <attri_1> FROM Customers WHERE <attri_2> (SELECT <attri_2> FROM Orders WHERE <attri_3 >) FROM <Table1);
	 * SELECT CustomerID, CustomerName FROM Customers WHERE CustomerID IN (SELECT CustomerID FROM Orders WHERE EmployeeID = 9) ;
	 * O(n)
	 * @param table
	 * @return the projection result
	 */
	public List<String> nestedQuery(List<HashMap<String, String>> table1,  List<HashMap<String, String>> table2){
		String[] attris = {"CustomerName", "CustomerID", "EmployeeID"};
		int count = 9;
		Iterator<HashMap<String, String>> ite2 = table2.iterator();
		TreeSet<String> tempTable = new TreeSet<String>();
		
		//Nested Selection
		while(ite2.hasNext()){
			HashMap<String, String> tuple = ite2.next();
			if(Integer.valueOf(tuple.get(attris[2])) == count){
				tempTable.add(tuple.get(attris[1]));
			}
		}
		
		Iterator<HashMap<String, String>> ite1 = table1.iterator();
		List<String> result = new LinkedList<String>();
		result.add(attris[0]+","+attris[1]);
		//Selection
		while(ite1.hasNext()){
			HashMap<String, String> tuple = ite1.next();
			if(tempTable.contains(tuple.get(attris[1]))){
				//Projection
				result.add(tuple.get(attris[0])+","+tuple.get(attris[1]));
			}
		}
		
		return result;
	}
	
	/**
	 * SELECT * FROM <table1>, <tabl2>
	 * @param table1
	 * @param table2
	 * @return
	 */
	public List<String> linearNatureJoin(List<HashMap<String, String>> table1, List<HashMap<String, String>> table2){
		//get the key of common columne value
		List<String> comSchema = new LinkedList<String>();
		List<String> table1Schema = new LinkedList<String>();
		List<String> table2Schema = new LinkedList<String>();
		
		List<String> result = new LinkedList<String>();
		
		Iterator<HashMap<String, String>> ite1 = table1.iterator();
		Iterator<HashMap<String, String>> ite2 = table2.iterator();
		
		Set<String> ks1 = ite1.next().keySet();
		Set<String> ks2 = ite2.next().keySet();
		Iterator<String> kite1 = ks1.iterator();
		//find the commmon schema
		while(kite1.hasNext()){
			String key = kite1.next();
			if(ks2.contains(key)){
				comSchema.add(key);
			}else{
				table1Schema.add(key);
			}
		}
		Iterator<String> kite2 = ks1.iterator();
		while(kite2.hasNext()){
			String key = kite2.next();
			if(!comSchema.contains(key))
				table2Schema.add(key);
		}
		
		
		//Generate Two hashTable hashing from value from common key and rest value
		HashMap<String, String[]> hashTable1 = getColumneHashingTable(table1, comSchema, table1Schema);
		HashMap<String, String[]> hashTable2 = getColumneHashingTable(table1, comSchema, table1Schema);
		
		Set<String> keySet = hashTable1.keySet();
		Iterator<String> iks = keySet.iterator();
		
		while(iks.hasNext()){
			String comKey = iks.next();
			String finalTuple = "";
			if(hashTable2.containsKey(comKey)){
				String[] tuple1 = hashTable1.get(comKey);
				String[] tuple2 = hashTable2.get(comKey);
				
				finalTuple = comKey ; 
				for(int i=0; i< tuple1.length;i++){
					finalTuple += ","+tuple1[i];
				}
				for(int i=0; i< tuple2.length;i++){
					finalTuple += ","+tuple1[i];
				}
				result.add(finalTuple);
			}
		}
		
		return result;
		
	}
	
	/**
	 * Generate the HashMap whose key is the common key combination and value is the other values
	 * @param table1
	 * @param comSchema
	 * @param tableSchema
	 * @return hash table
	 */
	private HashMap<String, String[]> getColumneHashingTable(List<HashMap<String, String>> table, List<String> comSchema, List<String> tableSchema){
		HashMap<String, String[]> hashTable = new HashMap<String, String[]>();
		
		Iterator<HashMap<String, String>> tableIte = table.iterator();
		
		while(tableIte.hasNext()){
			HashMap<String, String> tuple = tableIte.next();
			Iterator<String> comSchemaIte = comSchema.iterator();
			String comKey = 
		}
		
		return hashTable;
	}
	/**
	 * SELECT * FROM <table1>, <table2>
	 * @return
	 */
	public List<String> natureJoin(List<HashMap<String, String>> table1, List<HashMap<String, String>> table2){
		
		List<String> comSchema = new LinkedList<String>();
		List<String> result = new LinkedList<String>();
		
		Iterator<HashMap<String, String>> ite1 = table1.iterator();
		Iterator<HashMap<String, String>> ite2 = table2.iterator();
		
		Set<String> ks1 = ite1.next().keySet();
		Set<String> ks2 = ite2.next().keySet();
		Iterator<String> kite1 = ks1.iterator();
		//find the commmon schema
		while(kite1.hasNext()){
			String key = kite1.next();
			if(ks2.contains(key)){
				comSchema.add(key);
			}
		}
		
		result.add(getSchema(table1.iterator().next(), table2.iterator().next(), comSchema));
//		HashMap<String, String> emptyTuple1 = getEmptyTuple(table1.iterator().next());
//		HashMap<String, String> emptyTuple2 = getEmptyTuple(table2.iterator().next());
		//joint
		Iterator<HashMap<String, String>> ite1x = table1.iterator();
		Iterator<HashMap<String, String>> ite2x = table2.iterator();
		
		
		while(ite1x.hasNext()){
			HashMap<String, String> tuple1 = ite1x.next();
			ite2x = table2.iterator();
			while(ite2x.hasNext()){
				HashMap<String, String> tuple2 = ite2x.next();
				if(equalTuples(tuple1, tuple2, comSchema)){
					result.add(joinTuples(tuple1, tuple2, comSchema));
					ite2x.remove();
				}
			}
		}
		return result;
	}
	
	private HashMap<String, String> getEmptyTuple(HashMap<String, String> next) {
		Set<String> keyset =  next.keySet();
		Iterator<String> ite = keyset.iterator();
		HashMap<String, String> nhash = new HashMap<String, String>();
		while(ite.hasNext()){
			nhash.put(ite.next(), "null");
		}
		return nhash;
	}

	private boolean equalTuples(HashMap<String, String> tuple1,HashMap<String, String> tuple2, List<String> schema) {
		Iterator<String> ite = schema.iterator();
		while(ite.hasNext()){
			String key = ite.next();
			if(!tuple1.get(key).equals(tuple2.get(key))){
				return false;
			}
		}
		return true;
	}
	
	private String joinTuples(HashMap<String, String> tuple1,HashMap<String, String> tuple2, List<String> schema){
		Iterator<String> ite = schema.iterator();
		String result = "";
		//add commom part
		while(ite.hasNext()){
			String key = ite.next();
			result += tuple1.get(key)+",";
			tuple1.remove(key);
			tuple2.remove(key);
		}
		//add table1
		Set<String> keySet = tuple1.keySet();
		Iterator<String> ite1 = keySet.iterator();
		while(ite1.hasNext()){
			result += tuple1.get(ite1.next())+",";
		}
		
		//add table2
		Set<String> keySet2 = tuple2.keySet();
		Iterator<String> ite2 = keySet2.iterator();
		while(ite2.hasNext()){
			result += tuple2.get(ite2.next())+",";
		}
		
		return result;
	}
	
	private String getSchema(HashMap<String, String> tuple1, HashMap<String, String > tuple2, List<String> schema){
		Iterator<String> ite = schema.iterator();
		String result = "";
		//add commom part
		while(ite.hasNext()){
			String key = ite.next();
			result += key + ",";
		}
		//add table1
		Set<String> keySet = tuple1.keySet();
		Iterator<String> ite1 = keySet.iterator();
		while(ite1.hasNext()){
			String key = ite1.next();
			if(!schema.contains(key))
				result += key+",";
		}
		
		//add table2
		Set<String> keySet2 = tuple2.keySet();
		Iterator<String> ite2 = keySet2.iterator();
		while(ite2.hasNext()){
			String key = ite2.next();
			if(!schema.contains(key))
				result += key+",";
		}
		
		return result;
	}
		
	
	/**
	 * Get the avg of the attri of table
	 * @param table
	 * @return
	 */
	private long avg(List<HashMap<String, String>> table, String attri){
		Iterator<HashMap<String, String>> ite = table.iterator();
		long avge=0;
		while(ite.hasNext()){
			avge += Long.valueOf(ite.next().get(attri))/table.size();
		}
		
		return avge;
	}

	/**
	 * Converting hash to list O(n)
	 * 
	 * @param buket
	 * @return
	 */
	private List<String> convertHashMap2ListString(HashMap<String, Integer> buket) {
		List<String> output = new LinkedList<String>();
		Set<String> keys = buket.keySet();
		Iterator<String> kIte = keys.iterator();
		while (kIte.hasNext()) {
			String key = kIte.next();
			if(buket.get(key) != 0)
				output.add(key + "," + buket.get(key));
		}
		return output;
	}
	
}
