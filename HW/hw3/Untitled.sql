create table student(
sid int auto_increment NOT NULL,
sname varchar(255),
sex varchar(255),
age int,
year date, 
gpa int,
primary key(sid));

create table dept(
dname varchar(255) not null,
numphds int,
primary key(dname));

create table prof(
pname varchar(255) not null,
dname varchar(255) not null,
foreign key(dname) references dept(dname));

create table course(
cno int not null,
cname varchar(255),
dname varchar(255) not null,
primary key(cno),
foreign key(dname) references dept(dname));

create table section(
dname varchar(255) not null,
cno int not null,
sectno int not null,
pname varchar(255),
primary key(dname, cno, sectno),
foreign key(dname) references dept(dname),
foreign key(cno) references course(cno));

create table enroll(
sid int not null,
grade int,
dname varchar(255) not null,
cno int not null,
sectno int not null,
primary key(sid, dname, sectno, cno),
foreign key(sid) references student(sid),
foreign key(dname) references dept(dname),
#foreign key(sectno) references  section(sectno),
foreign key(cno) references  section(cno));

create table major(
dname varchar(255) not null,
sid int not null,
foreign key(dname) references dep(dname),
foreign key(sid) references enroll(side));

