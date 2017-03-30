package iit.lms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		String basePath = new File("").getAbsolutePath();
		
		System.out.println("The default path storing all five csv files is \""+basePath+"/\"\n Want another path?[Y/N]");
		Scanner sc = new Scanner(System.in);
		if(sc.next().equalsIgnoreCase("Y")){
			while(true){
				System.out.println("Your new path:\n");
				String path = sc.next();
				if(!(new File(basePath)).exists() || !(new File(basePath)).isDirectory()){
					System.out.println("Invalid address for a directory, try again!\n");
				}else{
					basePath = path;
					break;
				}
			}
		}
		
		// Auto-generated method stub
		QueryList query = new QueryList();
		CSVIO csv = new CSVIO();
		List<String> datalist1 = CSVIO.importCsv(new File("Customers.csv"));	
		List<String> datalist2 = CSVIO.importCsv(new File("Orders.csv"));	
		List<String> result;
		boolean isSuccess;
		
		
		//GroupByHaving test
		result = query.GroupByHaving(datalist1);
		isSuccess = csv.exportCsv(new File(basePath+"/GROUPBYHAVING.csv"), result);
		if(isSuccess)
			System.out.println("Export Success");
		else
			System.out.println("Export Failed");
        //IN test
        result = query.IN(datalist1,datalist2);
		isSuccess = csv.exportCsv(new File(basePath+"/IN.csv"), result);
        if(isSuccess)
			System.out.println("Export Success");
		else
			System.out.println("Export Failed");
		//Natural Join test
		result = query.NaturalJoin(datalist1, datalist2);
		isSuccess = csv.exportCsv(new File(basePath+"/NATURALJOIN.csv"), result);
        if(isSuccess)
			System.out.println("Export Success");
		else
			System.out.println("Export Failed");
        //Anti Join test
        result = query.AntiJoin(datalist1, datalist2);
        isSuccess = csv.exportCsv(new File(basePath+"/ANTIJOIN.csv"), result);
        if(isSuccess)
        	System.out.println("Export Success");
        else
        	System.out.println("Export Failed");
      //left outer Join test
        result = query.LeftOuterJoin(datalist1, datalist2);
        isSuccess = csv.exportCsv(new File(basePath+"/LEFTOUTERJOIN.csv"), result);
        if(isSuccess)
        	System.out.println("Export Success");
        else
        	System.out.println("Export Failed");
	}

}
