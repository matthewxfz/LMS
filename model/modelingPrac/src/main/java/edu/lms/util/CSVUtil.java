package edu.lms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
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

	public CSVUtil(File file) throws FileNotFoundException {
		this.file = file;
		colengh = 0;

	}// constructor
	
	/**
	 * Get the 2-d array for tabel, schema is in the firt row
	 * @return 
	 */
	public String[][] getTableToArray() {
		List<HashMap<String, String>> linkListTable = getTableToLinkList();
		String[][] table = new String[linkListTable.size()][linkListTable.get(0).size()];

		// write schema
		for (int i = 0; i < schema.size(); i++) {
			table[0][i] = schema.get(i);
		}

		// write content
		Iterator<HashMap<String, String>> ite = linkListTable.iterator();

		for (int i = 1; i < linkListTable.size(); i++) {
			HashMap<String, String> tuple = ite.next();
			for (int j = 0; j < linkListTable.get(0).size(); j++) {// copy the
																	// elements
				table[i][j] = tuple.get(schema.get(j));
			}
		}

		return table;
	}

	public List<HashMap<String, String>> getTableToLinkList() {
		List<HashMap<String, String>> table = new LinkedList<HashMap<String, String>>();
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);

			sc = new Scanner(fis, charset);

			if (schema.isEmpty()) {
				getSchemaHelperT();
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

	public String[] getSchema() {
		if (schema.isEmpty()) {
			return null;
		}

		String[] schema = new String[colengh];

		for (int i = 0; i < colengh; i++) {
			schema[i] = this.schema.get(i);
		}

		return schema;
	}

	private HashMap<Integer, String> getSchemaHelperT() {
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
