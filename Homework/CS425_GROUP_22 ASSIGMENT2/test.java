package lms.hw;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Query query = new Query();
		CSVIO csv = new CSVIO();
		List<String> datalist1 = CSVIO.importCsv(new File("D:/student.csv"));	
		List<String> datalist2 = CSVIO.importCsv(new File("D:/major.csv"));	
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
        result = query.IN(datalist1);
		isSuccess = csv.exportCsv(new File("D:/IN.csv"), result);
        if(isSuccess)
			System.out.println("Export Success");
		else
			System.out.println("Export Failed");
		//Join test
		result = query.Join(datalist1, datalist2);
		isSuccess = csv.exportCsv(new File("D:/JOIN.csv"), result);
        if(isSuccess)
			System.out.println("Export Success");
		else
			System.out.println("Export Failed");
	}

}
