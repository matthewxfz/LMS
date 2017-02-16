drop database if exists lms;

create database lms;

use lms;


CREATE TABLE Admin
(
  AdminID INT AUTO_INCREMENT NOT NULL,
  UserID VARCHAR(18) NOT NULL,
  LastName VARCHAR(30) NOT NULL,
  Moblie VARCHAR(10),
  Address VARCHAR(30),
  Email VARCHAR(30) NOT NULL,
  Power Enum('0','3') NOT NULL,
  FirstName VARCHAR(30) NOT NULL,
  MiddleName VARCHAR(30),
  PAS VARCHAR(40) DEFAULT '123456',
  PRIMARY KEY (AdminID));

CREATE TABLE Student
(
  StudentID INT AUTO_INCREMENT NOT NULL,
  Moblie VARCHAR(10),
  Address VARCHAR(30),
  Power Enum('0','1','2') NOT NULL,
  LastName VARCHAR(20) NOT NULL,
  MiddleName VARCHAR(20),
  FirstName VARCHAR(20) NOT NULL,
  Birthday DATE NOT NULL,
  Gender Enum('male','female','other') NOT NULL,
  Age INT NOT NULL,
  Email VARCHAR(20) NOT NULL,
  UserID VARCHAR(20) NOT NULL,
  PAS VARCHAR(40) DEFAULT '123456',
  PRIMARY KEY (StudentID));

CREATE TABLE Parents
(
  LastName VARCHAR(20) NOT NULL,
  FirstName VARCHAR(20) NOT NULL,
  Address VARCHAR(30),
  Moblie VARCHAR(10) NOT NULL,
  Email VARCHAR(30) NOT NULL,
  MiddleName VARCHAR(20),
  Relationship Enum('Father','Mother') NOT NULL,
  Power Enum('0') NOT NULL,
  StudentID INT NOT NULL,
  PRIMARY KEY (LastName, FirstName,StudentID),
  FOREIGN KEY (StudentID) REFERENCES Student(StudentID));

CREATE TABLE Teacher
(
  TeacherID INT AUTO_INCREMENT NOT NULL,
  LastName VARCHAR(20) NOT NULL,
  Moblie VARCHAR(10),
  Email VARCHAR(30) NOT NULL,
  Address VARCHAR(30),
  UserID VARCHAR(30) NOT NULL,
  FirstName VARCHAR(20) NOT NULL,
  MiddleName VARCHAR(20),
  Power Enum('0','2','3') NOT NULL,
  PAS VARCHAR(40) DEFAULT '123456',
  StudentID INT NOT NULL,
  PRIMARY KEY (TeacherID),
  FOREIGN KEY (StudentID) REFERENCES Student(StudentID));

CREATE TABLE Class
(
  ClassID INT AUTO_INCREMENT NOT NULL,
  Section INT NOT NULL,
  Title VARCHAR(30) NOT NULL,
  PRIMARY KEY (ClassID));

CREATE TABLE TeachBy
(
  ClassID INT NOT NULL,
  TeacherID INT NOT NULL,
  FOREIGN KEY (ClassID) REFERENCES Class(ClassID),
  FOREIGN KEY (TeacherID) REFERENCES Teacher(TeacherID));

CREATE TABLE Book
(
  BookID INT AUTO_INCREMENT NOT NULL,
  ISBN VARCHAR(20) NOT NULL,
  Title VARCHAR(50) NOT NULL,
  Author VARCHAR(50) NOT NULL,
  Publisher VARCHAR(50) NOT NULL,
  NumberOfPages INT NOT NULL,
  Cover VARCHAR(50) NOT NULL,
  PublicationDate DATE NOT NULL,
  Studio VARCHAR(50) NOT NULL,
  Manufactor VARCHAR(50) NOT NULL,
  Status ENUM('available','not available') NOT NULL,
  GeneratedID VARCHAR(30) NOT NULL,
  PRIMARY KEY (BookID));

CREATE TABLE Recommend
(
  BookID INT NOT NULL,
  ClassID INT NOT NULL,
  FOREIGN KEY (BookID) REFERENCES Book(BookID),
  FOREIGN KEY (ClassID) REFERENCES Class(ClassID));

CREATE TABLE Orders
(
  OrderID INT AUTO_INCREMENT NOT NULL,
  CheckinDate DATE NOT NULL,
  CheckoutDate DATE,
  DueDate DATE NOT NULL,
  Type Enum('Rent', 'Purchase') NOT NULL,
  Statues Enum('Open','Closed') NOT NULL,
  StudentID INT NOT NULL,
  BookID INT NOT NULL,
  AdminID INT NOT NULL,
  PRIMARY KEY (OrderID),
  FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
  FOREIGN KEY (BookID) REFERENCES Book(BookID),
  FOREIGN KEY (AdminID) REFERENCES Admin(AdminID));