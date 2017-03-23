package edu.lms.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

public class MySession {
		protected List<Table> tables;
		
		public MySession(){tables = new LinkedList<Table>();};
		
		public Boolean addTable(File file) throws FileNotFoundException{
			return tables.add(new Table((new CSVUtil(file)).getTableToArray()));
		}
		/**
		 * Projection
		 * @param attris
		 * @return the new table after the projection
		 */
		public Table project(List<String> attris, Table table){
			return table.project(attris);
		}
		/**
		 * selection
		 * @param conditions
		 * @return
		 */
		public Table select(Condition condition, Table table){
			return table.select(condition);		
		}
		
		/**
		 * production of the tables
		 * @param ta
		 * @param tb
		 * @return
		 */
		public Table production(Table ta, Table tb){
			//creat a new Schema
			String[][] content = new String[ta.rowLength*tb.rowLength][tb.colLength+ta.colLength];
			
			//write schema to merge content
			mergeArray(ta.content[0], tb.content[0], content[0]);
			
			//write content to merge content
			for(int i = 1;i<ta.rowLength;i++){
				for(int j=1;j<tb.rowLength;j++){
					mergeArray(ta.content[i], tb.content[j], content[(i-1)*(tb.rowLength-1)+j]);
				}
			}
				
			return new Table(content);
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
		
		public Table natrueJoin(Table ta, Table tb){
			//Find the command schema
			List<String> schemaA = ta.attris;
			HashMap<String , Integer > schemaB = tb.schema;
			List<String> commonAttri = new LinkedList<String>();
			
			Iterator<String> ite = schemaA.iterator();
			while(ite.hasNext()){
				String attri = ite.next();
				if(schemaB.containsKey(attri));
					commonAttri.add(attri);
			}
			
		}
		
		/**
		 * Merging content in aA and bA into new Array newA
		 * @param aA
		 * @param bA
		 * @param newA
		 */
		private void mergeArray(String[] aA, String[] bA, String[] newA){
			if(newA.length < aA.length+bA.length){
				System.out.println("Merging Array combined lenght larger then new Array!");
			}else{
				int i = 0;
				for(;i<aA.length;i++){
					newA[i] = aA[i];
				}
				for(;i<aA.length+bA.length;i++){
					newA[i] = bA[i-aA.length];
				}
			}
		}

}
