package edu.lms.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.xml.validation.Schema;

import com.mysql.fabric.xmlrpc.base.Data;

public class CSVUtil {
//	private String[] schema;

	public CSVUtil() throws FileNotFoundException {

	}// constructor
	
	public static List<String> importCsv(File file){
        List<String> dataList=new ArrayList<String>();
        
        BufferedReader br=null;
        try { 
            br = new BufferedReader(new FileReader(file));
            String line = ""; 
            while ((line = br.readLine()) != null) { 
                dataList.add(line);
            }
        }catch (Exception e) {
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
 
        return dataList;
    }
	
	

//	
	
	public List<HashMap<String, String>> getTableToLinkList(File file) {
		List<HashMap<String, String>> table = new LinkedList<HashMap<String, String>>();
		List<String> datalist = importCsv(file);
		
		Iterator<String> ite = datalist.iterator();
		String[] schema = ite.next().split(",");
		
		while(ite.hasNext()){
			String[] tuple = ite.next().split(",");
			HashMap<String, String> hash =  new HashMap<String, String>(schema.length);
			for(int i = 0; i< schema.length;i++){
				hash.put(schema[i], tuple[i]);
			}
			
			table.add(hash);
		}
		return table;
	}
//
//
//	private HashMap<Integer, String> getSchemaHelperT() {
//		if (schema.isEmpty()) {
//
//			if (sc.hasNextLine()) {
//				String[] tuple = sc.nextLine().split(",");
//				colengh = 0;
//				for (String s : tuple) {
//					if (s != "") {
//						schema.put(colengh, s);
//						colengh++;
//					} else
//						break;
//				}
//			} else {
//				return null;
//			}
//			return schema;
//		} else {
//			return schema;
//		}
//	}
	
	/**
//	 * Get the 2-d array for tabel, schema is in the firt row
//	 * 
//	 * @return
//	 */
//	public String[][] getTableToArray() {
//		List<HashMap<String, String>> linkListTable = getTableToLinkList();
//		String[][] table = new String[linkListTable.size()][linkListTable.get(0).size()];
//
//		// write schema
//		for (int i = 0; i < schema[i]; i++) {
//			table[0][i] = schema[i];
//		}
//
//		// write content
//		Iterator<HashMap<String, String>> ite = linkListTable.iterator();
//
//		for (int i = 1; i < linkListTable.size(); i++) {
//			HashMap<String, String> tuple = ite.next();
//			for (int j = 0; j < linkListTable.get(0).size(); j++) {// copy the
//																	// elements
//				table[i][j] = tuple.get(schema[i]);
//			}
//		}
//
//		return table;
//	}

}
