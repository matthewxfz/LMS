package edu.lms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.xml.validation.Schema;

public class CSVUtil {
	private int MAX_LENGTH = 30;
	private String charset = "UTF-8";
	private Scanner sc;
	private File file;
	private HashMap<Integer, String> schema = new HashMap<Integer, String>();
	private int colengh;

	/**
	 * 
	 * @param file
	 *            -csv file
	 * @throws FileNotFoundException
	 */
	public CSVUtil(File file) throws FileNotFoundException {
		this.file = file;
		colengh = 0;

	}// constructor
	
//	public writeCSVFile(List<HashMap<Integer, String>> table){
//		
//	}


	public List<HashMap<String, String>> getTable() {
		List<HashMap<String, String>> table = new LinkedList<HashMap<String, String>>();
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);

			sc = new Scanner(fis, charset);

			if (schema.isEmpty()) {
				getSchemaHelper();
			} else {
				sc.next();
			}

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line != "") {
					String[] tuple = line.split(",");
					HashMap<String, String> tuplehash = new HashMap<String, String>();
					for (int i = 0; i < colengh; i++) {
						tuplehash.put(schema.get(i), tuple[i]);
					}

					table.add(tuplehash);
				} else
					break;
			}
			try {
				fis.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return table;
		} catch (FileNotFoundException e) {
			System.out.println("!!Your csvFile is not valide!\n\n");
			e.printStackTrace();
			return null;
		}
	}
	
	public String[] getSchema(){
		if(schema.isEmpty()){
			return null;
		}
		
		String[] schema = new String[colengh];
		
		for(int i=0;i<colengh;i++){
			schema[i] = this.schema.get(i);
		}
		
		return schema;
	}
	
	private HashMap<Integer, String> getSchemaHelper() {
		if (schema.isEmpty()) {

			if (sc.hasNextLine()) {
				String[] tuple = sc.nextLine().split(",");
				colengh = 0;
				for (String s : tuple) {
					if (s != "") {
						schema.put(colengh, s);
						colengh++;
					} else
						break;
				}
			} else {
				return null;
			}
			return schema;
		} else {
			return schema;
		}
	}
	
}
