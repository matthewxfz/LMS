package lms.hw;

import java.util.ArrayList;
import java.util.List;
public class QueryList {
	public static String comma = ",";
	//select count(*),address from student group by address having count(*)>1
	public List<String> GroupByHaving(List<String> datalist){
		//a list to store the result of the query
		List<String> result = new ArrayList<String>();
		Node head = null,
			 cur = null,
			 tail = null;
		
		//process the relation tuple by tuple
		for(String data:datalist){
			String[] array = data.split(comma);
			if(array[0].equals("ID")){ //decide if the current tuple is the schema
				String line = "COUNT"+comma+array[2];
				result.add(line);
			}else{ // put the data from address column into a node of a list 
				Node ne = new Node();
				ne.data = array[2];
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
	//select ID,NAME from student where NAME 
	//IN(select NAME from student where ADDRESS = PS and MAJOR = CS)
	public List<String> IN(List<String> datalist){
		//a list to store the result of the query
		List<String> result = new ArrayList<String>();
													 
		//process data in a relation tuple by tuple
		//and construct the result list
		for(String data:datalist){
			String[] array = data.split(comma);
			if(array[0].equals("ID")){//decide if the current tuple is the schema
				String line = array[0]+comma+array[1];
				result.add(line);
			//add data into the result if the query condition is satisfied 
			}else if(array[2].equals("PS") && array[3].equals("CS")){
				String line = array[0]+comma+array[1];	
				result.add(line);	
			}
		}

		return result;
	}
	//select * from student,major where student.MAJOR = major.MAJOR
	public List<String> Join(List<String> table1,List<String> table2){
		
		List<String> result = new ArrayList<String>();
		//process data in a relation tuple by tuple
		//and construct result list
		for(String data1:table1){
			String[] array1 = data1.split(comma);
			for(String data2:table2){//compare every tuple of the same column in relation 2
				String[] array2 = data2.split(comma);
				if(result.isEmpty()){//add the schema into the result
					String line = data1+comma+array2[0]+comma+array2[2];
					result.add(line);
					break;
				//add data into the result if the query condition is satisfied
				}else if(array1[3].equals(array2[1])){
					String line = data1+comma+array2[0]+comma+array2[2];
					result.add(line);
					break;
				}			
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
