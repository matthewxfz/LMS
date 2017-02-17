--Oracle 11g Express Edition 
--Difference between Oracle and Mysql
--No such thing as "auto_increment" or "identity" columns in Oracle which it must be  modeled  with a sequence and a trigger:
--This is also no Enum ,  use constraint and check to mimic Enum function.
--use dbca to create the database






CREATE TABLE Admin
(
  AdminID int NOT NULL PRIMARY KEY,
  LastName VARCHAR(30) NOT NULL,
  Moblie VARCHAR(10),
  Address VARCHAR(30),
  Email VARCHAR(30) NOT NULL,
  Power Number NOT NULL check (Power=0 or Power=3),
  FirstName VARCHAR(30) NOT NULL,
  MiddleName VARCHAR(30),
  PAS VARCHAR(40) DEFAULT '123456'
);

<<<<<<< Updated upstream
CREATE SEQUENCE seq_AdminID
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10
;
=======
>>>>>>> Stashed changes

CREATE TABLE Student
(
  StudentID INT NOT NULL PRIMARY KEY,
  Moblie VARCHAR(10),
  Address VARCHAR(30),
  Power Number NOT NULL check (Power=0 or Power=1 or Power=2),
  LastName VARCHAR(20) NOT NULL,
  FirstName VARCHAR(20) NOT NULL,
  Birthday DATE NOT NULL,
  Gender  VARCHAR(10) NOT NULL check (Gender='male' or Gender='female' or Gender='transgender'),
  Age INT NOT NULL,
  Email VARCHAR(20) NOT NULL,
  UserID VARCHAR(20) NOT NULL,
  PAS VARCHAR(40) DEFAULT '123456'
);

<<<<<<< Updated upstream
CREATE SEQUENCE seq_StudentID
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10
;
=======
>>>>>>> Stashed changes

CREATE TABLE Parents
(
  LastName VARCHAR(20) NOT NULL,
  FirstName VARCHAR(20) NOT NULL,
  Address VARCHAR(30),
  Moblie VARCHAR(10) NOT NULL,
  Email VARCHAR(30) NOT NULL,
  MiddleName VARCHAR(20),
  Relationship  VARCHAR(10) NOT NULL check(Relationship='father' or Relationship='mother'),
  Power Number NOT NULL check (Power=0),
  CONSTRAINT pk_ParentsID PRIMARY KEY (LastName,FirstName,MiddleName),
  StudentID INT NOT NULL,
  FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
);

CREATE TABLE Teacher
(
  TeacherID INT NOT NULL PRIMARY KEY,
  LastName VARCHAR(20) NOT NULL,
  Moblie VARCHAR(10),
  Email VARCHAR(30) NOT NULL,
  Address VARCHAR(30),
  UserID VARCHAR(30) NOT NULL,
  FirstName VARCHAR(20) NOT NULL,
  MiddleName VARCHAR(20),
  Power Number NOT NULL check (Power=0 or Power=2 or Power=3),
  PAS VARCHAR(40) DEFAULT '123456',
  StudentID INT NOT NULL,
  FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
 );

<<<<<<< Updated upstream
CREATE SEQUENCE seq_TeacherID
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10
;
=======
>>>>>>> Stashed changes

 CREATE TABLE Class
(
  ClassID INT NOT NULL PRIMARY KEY,
  Section INT NOT NULL,
  Title VARCHAR(30) NOT NULL
);

CREATE SEQUENCE seq_ClassID
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10
;

CREATE TABLE TeachBy
(
  ClassID INT NOT NULL,
  TeacherID INT NOT NULL,
  FOREIGN KEY (ClassID) REFERENCES Class(ClassID),
  FOREIGN KEY (TeacherID) REFERENCES Teacher(TeacherID)
 );

CREATE TABLE Book
(
  BookID INT NOT NULL PRIMARY KEY,
  ISBN VARCHAR(20) NOT NULL,
  Title VARCHAR(50) NOT NULL,
  Author VARCHAR(50) NOT NULL,
  Publisher VARCHAR(50) NOT NULL,
  NumberOfPages INT NOT NULL,
  Cover VARCHAR(50) NOT NULL,
  PublicationDate DATE NOT NULL,
  Studio VARCHAR(50) NOT NULL,
  Manufactor VARCHAR(50) NOT NULL,
  Status VARCHAR(50)  NOT NULL check (Status='available' or Status='not available'),
  GeneratedID VARCHAR(30) NOT NULL
  );
<<<<<<< Updated upstream
  
CREATE SEQUENCE seq_BookID
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10
;
=======

>>>>>>> Stashed changes

CREATE TABLE Recommend
(
  BookID INT NOT NULL,
  ClassID INT NOT NULL,
  FOREIGN KEY (BookID) REFERENCES Book(BookID),
  FOREIGN KEY (ClassID) REFERENCES Class(ClassID)
);
  
CREATE TABLE Orders
(
  OrderID INT NOT NULL PRIMARY KEY,
  CheckinDate DATE NOT NULL,
  CheckoutDate DATE,
  DueDate DATE NOT NULL,
  Type VARCHAR(10)  NOT NULL check (Type='Rent' or Type='Purchase'),
  Statues VARCHAR(20)  NOT NULL check (Statues='Open' or Statues='Closed'),
  StudentID INT NOT NULL,
  BookID INT NOT NULL,
  AdminID INT NOT NULL,
  FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
  FOREIGN KEY (BookID) REFERENCES Book(BookID),
  FOREIGN KEY (AdminID) REFERENCES Admin(AdminID)
 );
<<<<<<< Updated upstream
 
 CREATE SEQUENCE seq_OrderID
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10
;
=======

>>>>>>> Stashed changes
