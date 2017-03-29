@author Fangzhou Xiong
@ID A20376382
@time 30/11/2016

This is the Lab14 for the CS401
This is the layout of the file intern:

Homework-30-Nov-FangzhouXiong
.
|____.DS_Store
|____Lab14
| |____bin
| | |____edu
| | | |____iit
| | | | |____xfz
| | | | | |____EX1
| | | | | | |____Graph$Edge.class
| | | | | | |____Graph$Vertex.class
| | | | | | |____Graph.class
| | | | | | |____Prim.class
| | | | | |____EX2
| | | | | | |____Dijkstra.class
| | | | | | |____Graph$Edge.class
| | | | | | |____Graph$Vertex.class
| | | | | | |____Graph.class
| |____src
| | |____edu
| | | |____iit
| | | | |____xfz
| | | | | |____EX1
| | | | | | |____Graph.java
| | | | | | |____Prim.java
| | | | | |____EX2
| | | | | | |____Dijkstra.java
| | | | | | |____Graph.java
|____Prim.jar
|____Dijkstra.jar
|____readme.txt

########################
[WHERE IS THE HOMEWORK]
#######################
———————————————
For EX1

You can find the packet for EX1 in ./Homework—30-Nov-FangzhouXiong/Lab14/src/edu/iit/xfz/EX1

You can find a compiled jar file in the ./Homework—30-Nov-FangzhouXiong/Prim.jar

Run the Prim.java with argument of absolute address to prime.txt

For example:
java -jar Prim.jar /Users/matthewxfz/Workspaces/prim.txt


———————————————
For EX2

You can find the packet for EX1 in ./Homework—30-Nov-FangzhouXiong/Lab14/src/edu/iit/xfz/EX2.

You can find a compiled jar file in ./Homework—30-Nov-FangzhouXiong/Dijkstra.jar

Run the Dijkstra.java with argument of absolute address to graph.txt and the start vertex name

For example:
java -jar Dijkstra.jar /Users/matthewxfz/Workspaces/prim.txt A


———————————————

###########################
[HOW TO RUN THE PROJECTS]
###########################

* To run this project, you should best use JDK 1.7 or above and Junit Library.
* Before running the application in cmd, make sure you have CLASSPATH setted right.

You can run the project with IDE or with out IDE:

[Run the project with IDE]
_______________________________
To run the project with IDE, simply import the project as JAVA_PROJECT.
Before you run the project, please read the homework instruction above, and if you are running project concerning calculating the runtime, please add these argument into the VM argument variants in IDE:

-Djava.compiler=NONE

[Run the project without IDE]
_______________________________

If you do not have IDE. After unzip the compressed file, you can compiler the java file your self (find the <filename>.java according to the layout above) by running the common:
java <javafilename>.java

For files in a package, you should:
1. first get the class filed.
2. Then you should create a MANIFEST.MF File with format like:

Manifest-Version: 1.0  
Created-By: anytime  
Class-Path: .  
Main-Class: edu.iit.EX1.Lab11Simulator

3. Put the MANIFEST.MF with the class file and create the jar packet with command:
jar cvfm [packetName].jar MANIFEST.MF -C [path to projects] .  

And when you have the class file, run the command:
java -jar -Djava.compiler=NONE <javafilenameonly>.jar

check the console for result.




