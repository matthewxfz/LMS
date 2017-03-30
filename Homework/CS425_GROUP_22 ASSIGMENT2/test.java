package lms.hw;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		QueryList query = new QueryList();
		CSVIO csv = new CSVIO();
		List<String> datalist1 = CSVIO.importCsv(new File("D:/Customers.csv"));	
		List<String> datalist2 = CSVIO.importCsv(new File("D:/Orders.csv"));	
		List<String> result;
		boolean isSuccess;
		//GroupByHaving test
		result = query.GroupByHaving(datalist1);
		isSuccess = csv.exportCsv(new File("D:/GROUPBYHAVING.csv"), result);
		if(isSuccess)
			System.out.println("Export Success");
		else
			System.out.println("Export Failed");
        //IN test
        result = query.IN(datalist1,datalist2);
		isSuccess = csv.exportCsv(new File("D:/IN.csv"), result);
        if(isSuccess)
			System.out.println("Export Success");
		else
			System.out.println("Export Failed");
		//Natural Join test
		result = query.NaturalJoin(datalist1, datalist2);
		isSuccess = csv.exportCsv(new File("D:/NATURALJOIN.csv"), result);
        if(isSuccess)
			System.out.println("Export Success");
		else
			System.out.println("Export Failed");
        //Anti Join test
        result = query.AntiJoin(datalist1, datalist2);
        isSuccess = csv.exportCsv(new File("D:/ANTIJOIN.csv"), result);
        if(isSuccess)
        	System.out.println("Export Success");
        else
        	System.out.println("Export Failed");
      //left outer Join test
        result = query.LeftOuterJoin(datalist1, datalist2);
        isSuccess = csv.exportCsv(new File("D:/LEFTOUTERJOIN.csv"), result);
        if(isSuccess)
        	System.out.println("Export Success");
        else
        	System.out.println("Export Failed");
	}

}
