package edu.lms.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

public class Table {
	 HashMap<String, Integer> schema;
	 String[][] content;
	 int colLength = 0;
	 int rowLength = 0;
	
	public Table(String[][] content){
		schema = new HashMap<String, Integer>();
		this.content = content;
		if(content.length > 0){
			for(int i = 0;i<content[0].length;i++){
				schema.put(content[0][i], i);
			}
			rowLength = content.length;
			colLength = content[0].length;
		}else{
			System.out.println("Illegal input");
		}
	}
	
	//projection
	/**
	 * Projection
	 * @param attris
	 * @return the new table after the projection
	 */
	public Table project(List<String> attris){
		Iterator<String> ite = attris.iterator();
		while(ite.hasNext()){
			if(!schema.containsKey(ite.next()))
					return null;
		}
		
		String[][] newContent = new String[content.length][attris.size()];
		for(int i = 0; i< content.length;i++){
			for(int j = 0; j< attris.size(); j++){
				newContent[i][j] = content[i][j];
			}
		}
		
		Table newTable = new Table(newContent);
		
		return newTable;
	}
	/**
	 * selection
	 * @param conditions
	 * @return
	 */
	public Table select(Condition condition){
		if(content.length < 0)
				return null;
		
		
		String[][] newContent = new String[content.length][content[0].length];
		//wirte schema
		for(int i = 0;i<content[0].length;i++){
			newContent[0][i] = content[0][i];
		}
		
		//write selected content
		for(int i=1;i<content.length;i++){
			String[] tuple = content[i];
			if(condition.isSatisfied(tuple, schema))
				copyArray(tuple,newContent[i]);
		}
		
		return new Table(newContent);
	}
	
	/**
	 * Copy content of old to new
	 * @param a
	 * @param b
	 */
	private void copyArray(String[] oldA, String[] newA){
		for( int i=0;i<oldA.length;i++){
			newA[i] = oldA[i];
		}
	}
}
