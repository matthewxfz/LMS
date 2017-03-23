package lms.hw;

import java.util.ArrayList;
import java.util.List;

public class Query {
	public static String comma = ",";
	//select count(*),address from student group by address having count(*)>1
	public List<String> GroupByHaving(List<String> datalist){
		
		List<String> result = new ArrayList<String>();
		Node head = null,
			 cur = null,
			 tail = null;
		for(String data:datalist){
			String[] array = data.split(comma);
			if(array[0].equals("ID")){
				String line = "COUNT"+comma+array[2];
				result.add(line);
			}else{
				Node ne = new Node();
				ne.data = array[2];
				if(head == null){
					head = tail = ne;
				}
				cur = head;
				while(true){
					if(cur.data.equals(ne.data)){
						cur.count++;
						break;
					}else{
						if(cur.next == null){
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
		while(cur != null){
			String line = String.valueOf(cur.count)+comma+cur.data;
			result.add(line);
			cur = cur.next;
		}
		return result;
	}
	//select ID,NAME from student where NAME 
	//IN(select NAME from student where ADDRESS = PS and MAJOR = CS)
	public List<String> IN(List<String> datalist){
		List<String> result = new ArrayList<String>(),
				     temp = new ArrayList<String>();
		for(String data:datalist){
			String[] array = data.split(comma);
			if(array[0].equals("ID"))
				continue;
			else if(array[2].equals("PS") && array[3].equals("CS"))
					temp.add(array[1]);	
		}
		for(String data:datalist){
			String[] array = data.split(comma);
			if(result.isEmpty())
				result.add(array[1]);
			else if(temp.contains(array[1]))
				result.add(array[1]);		
		}
		return result;
	}
	//select ID,NAME,ADDRESS,MAJOR,DEPT from student,major where student.MAJOR = major.MAJOR
	public List<String> Join(List<String> table1,List<String> table2){
		List<String> result = new ArrayList<String>(),
					 temp = new ArrayList<String>();
		for(String data1:table1){
			String[] array1 = data1.split(comma);
			for(String data2:table2){
				String[] array2 = data2.split(comma);
				if(result.isEmpty()){
					String line = data1+comma+array2[2];
					result.add(line);
					break;
				}else if(array1[3].equals(array2[1])){
					String line = data1+comma+array2[2];
					result.add(line);
					break;
				}			
			}
		}
		return result;
	}
	
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
