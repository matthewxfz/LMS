--MS SQL Server 2016 SP1 test
--Auto incresing implemented by IDENTITY(<start Number>,<step length>)
--Enum implemented by Check command

CREATE DATABASE LMS;
Go
Use LMS;
Go

CREATE TABLE Admin
(
  AdminID INT IDENTITY(1,1) NOT NULL,
  UserID VARCHAR(255) NOT NULL,
  LastName VARCHAR(255) NOT NULL,
  Moblie VARCHAR(255) ,
  Address VARCHAR(255) ,
  Email VARCHAR(255) NOT NULL,
  Power VARCHAR(10) NOT NULL CHECK (Power IN('0', '3')),
  FirstName VARCHAR(255) NOT NULL,
  MiddleName VARCHAR(255) ,
  PAS VARCHAR(255) DEFAULT 'It&looks(like)N0thing2me!',
  PRIMARY KEY (AdminID),
  UNIQUE (UserID)
);

CREATE TABLE Student
(
  StudentID INT IDENTITY(1,1) NOT NULL,
  Moblie VARCHAR(255) ,
  Address VARCHAR(255) ,
  Power VARCHAR(10) NOT NULL CHECK (Power IN('0', '1','2')),
  LastName VARCHAR(255) NOT NULL,
  MiddleName VARCHAR(255) ,
  FirstName VARCHAR(255) NOT NULL,
  Birthday datetime,
  Gender VARCHAR(10) CHECK (Gender IN('male','female','other')),
  Age INT,
  Email VARCHAR(255) NOT NULL,
  UserID VARCHAR(255) NOT NULL,
  PAS VARCHAR(255) DEFAULT 'It&looks(like)N0thing2me!',
  PRIMARY KEY (StudentID)
);

CREATE TABLE Parents
(
  StudentID INT NOT NUll,
  LastName VARCHAR(255) NOT NULL,
  FirstName VARCHAR(255) NOT NULL,
  Address VARCHAR(255) ,
  Moblie VARCHAR(255) ,
  Email VARCHAR(255) NOT NULL,
  MiddleName VARCHAR(255) ,
  Relationship VARCHAR(10) NOT NULL CHECK (Relationship IN('Father','Mother')),
  Power VARCHAR(10) NOT NULL CHECK (Power IN('0')),
  PRIMARY KEY (LastName, FirstName, MiddleName, StudentID),
  FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
);

CREATE TABLE Teacher
(
  TeacherID INT IDENTITY(1,1) NOT NULL,
  LastName VARCHAR(255) NOT NULL,
  Moblie VARCHAR(255) ,
  Email VARCHAR(255) NOT NULL,
  Address VARCHAR(255),
  UserID VARCHAR(255) NOT NULL,
  FirstName VARCHAR(255) NOT NULL,
  MiddleName VARCHAR(255) ,
  Power VARCHAR(10) NOT NULL CHECK (Power IN('0','2','3')),
  PAS VARCHAR(255) DEFAULT 'It&looks(like)N0thing2me!',
  StudentID INT NOT NULL,
  PRIMARY KEY (TeacherID),
  FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
  UNIQUE (UserID)
);

CREATE TABLE Class
(
  ClassID INT IDENTITY(1,1) NOT NULl,
  Section INT NOT NULL,
  Title VARCHAR(255) NOT NULL,
  PRIMARY KEY (ClassID)
);

CREATE TABLE TeachBy
(
  ClassID INT NOT NULL,
  TeacherID INT NOT NULL,
  FOREIGN KEY (ClassID) REFERENCES Class(ClassID),
  FOREIGN KEY (TeacherID) REFERENCES Teacher(TeacherID)
);

CREATE TABLE Book
(
  BookID INT IDENTITY(1,1) NOT NULL,
  ISBN VARCHAR(255) NOT NULL,
  Title VARCHAR(255) NOT NULL,
  Author VARCHAR(255) NOT NULL,
  Publisher VARCHAR(255) NOT NULL,
  NumberOfPages INT NOT NULL,
  Cover VARCHAR(255) NOT NULL,
  PublicationDate datetime NOT NULL,
  Studio VARCHAR(255) NOT NULL,
  Manufactor VARCHAR(255) NOT NULL,
  Status VARCHAR(20) NOT NULL CHECK (Status IN('Available','NotAvailable')),
  GeneratedID VARCHAR(255) NOT NULL,
  PRIMARY KEY (BookID),
  UNIQUE (GeneratedID)
);

CREATE TABLE Recommend
(
  BookID INT NOT NULL,
  ClassID INT NOT NULL,
  FOREIGN KEY (BookID) REFERENCES Book(BookID),
  FOREIGN KEY (ClassID) REFERENCES Class(ClassID)
);

CREATE TABLE Orders
(
  OrderID INT IDENTITY(1,1) NOT NULL,
  CheckinDate datetime NOT NULL,
  CheckoutDate datetime ,
  DueDate datetime NOT NULL,
  Type VARCHAR(10) NOT NULL CHECK (Type IN('Rent', 'Purchase')),
  Statues VARCHAR(10) NOT NULL CHECK (Statues IN('open','close')),
  StudentID INT NOT NULL,
  BookID INT NOT NULL,
  AdminID INT NOT NULL,
  PRIMARY KEY (OrderID),
  FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
  FOREIGN KEY (BookID) REFERENCES Book(BookID),
  FOREIGN KEY (AdminID) REFERENCES Admin(AdminID)
);