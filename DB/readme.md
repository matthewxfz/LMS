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

___________________________________________
##The difference of the three RDMS:

1, SQL syntax, 
	1.1 The Enum type, MySQL use Enum, SQL server use check, oracle use check or object to implement that. 
	1.2 Auto increase attribute, mySQL use AUTO_INCREMENT, SQL server use identity, oracle has to define sequence object separately.
	1.3 Data Types, even though three RDMS share some same data types, but some are unique to one of them, for example the Enum for MySQL.
	1.4 Special commmand, in SQL server, there is special command "GO" use to indicate excute the last command immediantly.
2, Objects, Oracle and SQL server Can support defining Objects, but MySQL cannot.
3, UI, oracle and SQL server support UI and cmd, but mySQL only support cmd
4, tools, Oracle and SQL server offer many tools for user like code generating, er diagram generating, but mysql offer the least tools.
5, weight, Oracle required much more cost in time and space than the other two RDMS, and SQL server required more than MySQL.
6.Operating System, oracle and mysql are wildly support many operating systems, SQL server try to support mac and linux in the latest version with lots of problems.




