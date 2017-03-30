@author        @ID            @attributes
Xinzhou Yan    A20376898       33.33%
Zhiquan Li     A20381063       33.33%
Fangzhou Xiong A20376382       33.33%
____________________________________________
@time MAR/29/2017
@HW1 for Cs 425
##Layout of the file intern:
.
|____Customers.csv
|____expectedResult
| |____ANTIJOIN.csv
| |____GROUPBYHAVING.csv
| |____IN.csv
| |____LEFTOUTERJOIN.csv
| |____NATURALJOIN.csv
|____Orders.csv
|____Optimization
| |____Customers.csv
| |____database_manipulation.py
| |____Orders.csv
|____Queries_Java
| |____bin
| | |____iit
| | | |____lms
| | | | |____CSVIO.class
| | | | |____Main.class
| | | | |____QueryList$Node.class
| | | | |____QueryList.class
| | | | |____testQuries.class
| |____Customers.csv
| |____Orders.csv
| |____queries.jar
| |____src
| | |____iit
| | | |____lms
| | | | |____CSVIO.java
| | | | |____Main.java
| | | | |____QueryList.java
| | | | |____testQuries.java
|____readme.txt


_______________________________________________
IMPLEMENTED BY JAVA

JAVA: 1.7 or above
These codes have implemented these 5 functions: group by with having, in, natural join, anti join and left outer join.
The csv files used in the test case are Customers.csv and Orders.csv and you can find these files in .／ path.

EXPECTED RESULT:
You will find five csv files in ./expectedResult or in the path you modified in the code after the test.java is executed.
You can find the expected result in CS425_GROUP_22 ASSIGMENT2/expected result


The query for each function is:

#Group by having: 
SELE count(*),City from Customers group by City having count(*)>1;

#IN:
SELECT CustomerID,CustomerName FROM Customer WHRER CustomerID IN(SELECT CustomerID FROM Order WHRER ShipperID = 3);

#Natural Join:
SELECT * FROM Customers,Orders WHRER Customers.CustomerID = Orders.CustomerID;

#Anti Join:
SELECT* FROM Customers WHRER CustomerID NOT IN(SELECT CustomerID FROM Orders);

#Left Outer Join:	
SELECT c.CustomerID, c.CustomerName, o.OrderID FROM Customers c LEFT OUTER JOIN Orders o on c.CustomerID = o.CustomerID;

***********************************************
HOW TO RUN THE PROJECT??
***********************************************
IF YOU HAVE IDE
1.Open eclipse  and create a project
2.Import project from ./Queries_Java
3.You can directly test the function with out test cases in ./src/iit/lms/testQuieres.java
4.Or you can export the result to csv file by excuting ./src/iit/lms/Main.java

IF YOU DONT HAVE IDE
1. Complie the project ./Queries or use our prepared .jar file
2. excute java -jar <filename>.jar

* You can verify the result quickly by excute the code in https://www.w3schools.com/sql/sql_join_full.asp
we have same Customers.csv and Orders.csv data from there.
_______________________________________________
OPTIMIZATION BY PYTHON

Python: 2.7

These codes have implemented these 2 functions: natural join, outjoin.
###
The running complexity of the  nature join is O(n+m), out join is O(n+m), the improvement is implemented by using hastable hashing from comom key values of each tuples to a list which contains distinct key values of all possible tuples.

#Natural Join:
select * from Customers,Orders where Customers.CustomerID = Order
Using hashtable to realize the simulation

#Outer Join:	
select c.CustomerID, c.CustomerName, o.OrderID from Customers c left outer join Orders o on c.CustomerID = o.CustomerID;
Using hashtable to realize the simulation

***********************************************
HOW TO RUN THE PROJECT??
***********************************************
IF YOU HAVE IDE
1.Open IDE to run the code in ./Optimization/database_manipulation.py

IF YOU DO NOT HAVE IDE
1. direct to the location of the file
2. run python database_manipulation.py

* when write address into system input, do not input any space.

_______________________________________________