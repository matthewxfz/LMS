package iit.lms;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
public class QueryList {
	public static String comma = ",";
	
	/**
	 * select count(*),City from Customers group by City having count(*)>1;
	 * @param datalist -table
	 * @return 
	 */
	public List<String> GroupByHaving(List<String> datalist){
		//a list to store the result of the query
		List<String> result = new ArrayList<String>();
		Node head = null,
			 cur = null,
			 tail = null;
		
		//process the relation tuple by tuple
		for(String data:datalist){
			String[] array = data.split(comma);
			if(result.isEmpty()){ //decide if the current tuple is the schema
				String line = "COUNT"+comma+array[4];
				result.add(line);
			}else{ // put the data from address column into a node of a list 
				Node ne = new Node();
				ne.data = array[4];
				if(head == null){ //add data into the list if it's empty
					head = tail = ne;
				}
				cur = head;
				//compare the current address with the addresses in the list
				//and construct a list with addresses and the number of the addresses
				while(true){
					if(cur.data.equals(ne.data)){ //count the number of the address
												  //which is the same
						cur.count++;
						break;
					}else{
						if(cur.next == null){ //add address into the list
											  //if there is no matched address in the list
							tail.next = ne;
							tail = ne;
							tail.count++;
							break;
						}
						cur = cur.next;	
					}	
				}
			}
		}
		cur = head;
		//transfer data from node list into the result if the count>1
		while(cur != null){
			if(cur.count > 1){
				String line = String.valueOf(cur.count)+comma+cur.data;
				result.add(line);
			}
			cur = cur.next;
		}
		return result;
	}
	/**
	 * select CustomerID,CustomerName from Customer where CustomerID IN(select CustomerID from Order where ShipperID = 3);
	 * @param datalist1 -table1
	 * @param datalist2 -table2
	 * @return
	 */
	public List<String> IN(List<String> datalist1,List<String> datalist2){
		//a list to store the result of the query
		List<String> result = new ArrayList<String>(),
					 temp = new ArrayList<String>();
													 
		//process data in a relation tuple by tuple
		//and construct the result list
		for(String data:datalist2){
			String[] array = data.split(comma);
			if(array[1].equals("CustomerID")){//determine if the current tuple is the schema
				continue;
			//add data into the result if the query condition is satisfied 
			}else if(array[4].equals("3")){
				temp.add(array[1]);
			}
		}
		//traverse data in Customers and add it in the result
		//if its CustomerID in the Orders and customer's shipperID is 3
		for(String data:datalist1){
			String[] array = data.split(comma);
			if(result.isEmpty()){
				String line = array[0]+comma+array[1];
				result.add(line);
			}else if(temp.contains(array[0])){
				String line = array[0]+comma+array[1];
				result.add(line);
			}
		}

		return result;
	}
	
	/**
	 * select * from Customers,Orders where Customers.CustomerID = Orders.CustomerID
	 * @param table1
	 * @param table2
	 * @return
	 */
	public List<String> NaturalJoin(List<String> table1,List<String> table2){
		
		List<String> result = new ArrayList<String>();
		//process data in a relation tuple by tuple
		//and construct result list
		for(String data1:table1){
			String[] array1 = data1.split(comma);
			for(String data2:table2){//compare every tuple of the same column in relation 2
				String[] array2 = data2.split(comma);
				if(result.isEmpty()){//add the schema into the result
					String line = data1+comma+array2[0]+comma+array2[2]+comma+array2[3]+comma+array2[4];
					result.add(line);
					break;
				//add data into the result if the query condition is satisfied
				}else if(array1[0].equals(array2[1])){
					String line = data1+comma+array2[0]+comma+array2[2]+comma+array2[3]+comma+array2[4];
					result.add(line);
				}			
			}
		}
		return result;
	}
	/**
	 * SELECT* FROM Customers WHERE CustomerID NOT IN(SELECT CustomerID FROM Orders)
	 * @param table1
	 * @param table2
	 * @return
	 */
	public List<String> AntiJoin(List<String> table1,List<String> table2){
		List<String> result = new ArrayList<String>();
		//process data in a relation tuple by tuple
		//and construct result list
		for(String data1:table1){
			String[] array1 = data1.split(comma);
			int count = 0;//flag to determine if the data is in the other relation
			for(String data2:table2){//compare every tuple of the same column in relation 2
				String[] array2 = data2.split(comma);
				if(result.isEmpty()){//add the schema into the result
					result.add(data1);
					break;
				//if the campared line is the schema or exist in the other relation
				}else if(array2[1].equals("CustomerID") || array1[0].equals(array2[1]))
					continue;
				else
					count++;
			}
			//if the count equals size of data in the other relation
			//add the data into the result
			if(count == table2.size()-1)
				result.add(data1);	
		}
		return result;
	}
	/**
	 * select c.CustomerID, c.CustomerName, o.OrderID from Customers c left outer join Orders o on c.CustomerID = o.CustomerID;
	 * @param datalist1
	 * @param datalist2
	 * @return
	 */
	public List<String> LeftOuterJoin(List<String> datalist1,List<String> datalist2){
		List<String> result = new ArrayList<String>();
		//process data in a relation tuple by tuple
		//and construct result list
		for(String data1:datalist1){
			String[] array1 = data1.split(comma);
			int count = 0;
			for(String data2:datalist2){//compare every tuple of the same column in relation 2
				String[] array2 = data2.split(comma);
				if(result.isEmpty()){//add the schema into the result
					String line = array1[0]+comma+array1[1]+comma+array2[0];
					result.add(line);
					break;
				//add data into the result if the query condition is satisfied
				}else if(array1[0].equals(array2[1])){
					String line = array1[0]+comma+array1[1]+comma+array2[0];
					result.add(line);
				}else if(array2[1].equals("CustomerID")){//if the compared line is the schema,then skip
					continue;
				}else//if the CustomerID doesn't exist in Orders
					count++;
			}
			//determine if its CustomerID exist in Orders
			if(count == datalist2.size()-1){
				String line = array1[0]+comma+array1[1]+comma+"null";
				result.add(line);
			}
		}
		
		return result;
	}
	
	//Node to store data from group by and count the number of same data
	class Node{
		private String data;
		private int count;
		Node next;
		
		protected Node(){
			this.data = null;
			this.next = null;
			this.count = 0;
		}
	}
}
