@author        @ID            @attributes
Xinzhou Yan    A20376898       33.33%
Zhiquan Li     A20381063       33.33%
Fangzhou Xiong A20376382       33.33%
____________________________________________
@time DEC/15/2017
@HW1 for Cs 425
##Layout of the file intern:
.
|____.DS_Store
|____.requirement.swp
|____LMS ER-Diagram.erdplus
|____LMS_ER_Diagram.png
|____LMS_MS_SQL_server.sql
|____LMS_MySQL.sql
|____LMS_oracle1.sql
|____LMS_Schema.erdplus
|____LMS_Schema.png
|____readme.txt
|____Test_Cases.sql


_______________________________________________
The Java
Compiler : Eclipse
OS : windows 7
These codes have implemented these 5 functions: group by with having, in, natural join, anti join and left outer join.
The query for each function is:
Group by having: 
select count(*),City from Customers group by City having count(*)>1;

IN:
select CustomerID,CustomerName from Customer where CustomerID IN(select CustomerID from Order where ShipperID = 3);

Natural Join:
select * from Customers,Orders where Customers.CustomerID = Orders.CustomerID;

Anti Join:
Select* from Customers where CustomerID NOT IN(Select CustomerID from Orders);

Left Outer Join:	
select c.CustomerID, c.CustomerName, o.OrderID from Customers c left outer join Orders o on c.CustomerID = o.CustomerID;

***********************************************
Please run this code by following steps below:
1.Open eclipse  and create a project
2.Create package named lms.hw in the project and drag three java files into the package
3.Put csv data files into D:/ or you can modify the path in test.java where the csv data file is.
4.Run test.java.

***********************************************
The csv files used in the test case are Customers.csv and Orders.csv and you can find these files in CS425_GROUP_22 ASSIGMENT2.

The result:
You will find five csv files in D:/ or in the path you modified in the code after the test.java is executed.
You can find the expected result in CS425_GROUP_22 ASSIGMENT2/expected result

The Python
Compiler : Sublime3 
OS : ISO
These codes have implemented these 5 functions: group by with having, in, natural join, outjoin
The running complexity of the  nature join is o(n+m), out join is O(n+m)

Natural Join:
select * from Customers,Orders where Customers.CustomerID = Order
Using hashtable to realize the simulation

Outer Join:	
select c.CustomerID, c.CustomerName, o.OrderID from Customers c left outer join Orders o on c.CustomerID = o.CustomerID;
Using hashtable to realize the simulation

***********************************************
Please run this code by following steps below:
1.Open Jupiter to run the code with numpy
2.when drag address into system input, please remove space behind .csv

***********************************************
_______________________________________________