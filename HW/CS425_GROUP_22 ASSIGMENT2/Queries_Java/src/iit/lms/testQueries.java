package iit.lms;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class testQueries {
	List<String> datalist1 = CSVIO.importCsv(new File("src/Customers.csv"));	
	List<String> datalist2 = CSVIO.importCsv(new File("src/Orders.csv"));	
	
	QueryList ql = new QueryList();
	
	/**
	 * select count(*),City from Customers group by City having count(*)>1;
	 * @param datalist -table
	 * @return 
	 */
	@Test
	public void testGroupBy(){
		printlist(ql.GroupByHaving(datalist1));
	}
	
	/**
	 * select CustomerID,CustomerName from Customer where CustomerID IN(select CustomerID from Order where ShipperID = 3);
	 * @param datalist1 -table1
	 * @param datalist2 -table2
	 * @return
	 */
	@Test
	public void testNestQueiresWithIN(){
		printlist(ql.IN(datalist1,datalist2));
	}
	
	/**
	 * select * from Customers,Orders where Customers.CustomerID = Orders.CustomerID
	 * @param table1
	 * @param table2
	 * @return
	 */
	@Test
	public void testNatureJoin(){
		printlist(ql.NaturalJoin(datalist1,datalist2));
	}
	
	/**
	 * SELECT* FROM Customers WHERE CustomerID NOT IN(SELECT CustomerID FROM Orders)
	 * @param table1
	 * @param table2
	 * @return
	 */
	@Test
	public void testAntiJoin(){
		printlist(ql.AntiJoin(datalist1,datalist2));
	}
	
	/**
	 * SELECT c.CustomerID, c.CustomerName, o.OrderID FROM Customers c LEFT OUTER JOIN Orders o on c.CustomerID = o.CustomerID;
	 */
	@Test
	public void testLeftOuterJoin(){
		printlist(ql.LeftOuterJoin(datalist1,datalist2));
	}
	
	
	private void printlist(List<String> list){
		Iterator<String> ite = list.iterator();
		System.out.println("================================\n"+
							"This is the result\n"+"================================\n");
		
		while(ite.hasNext()){
			System.out.println(ite.next()+"\n");
		}
	}
}
