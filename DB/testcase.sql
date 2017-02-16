-- 1.check auto_increment function and status
delimiter $$
drop procedure if exists increment_test;
create procedure increment_test()
begin
declare i int;
set i=1;
while i <=6 do
insert into Student(
Moblie,
Address,
Power,
LastName,
MiddleName,
FirstName,
Birthday,
Gender,
Age,
Email,
UserID,
PAS) values(
'3128237707',
'MCV',
'1',
'Li',
'',
'Charles',
'1988-3-13',
'male',
'29',
'zli175@dk.com',
'zlq100',
'321654');
set i=i+1;
end while;
end $$

delimiter ;
call increment_test();

-- 2.delete one row then check auto_increment status
delete from Student where StudentID=1;

-- 3.delete one student whose parent is not in database yet
delimiter $$
drop procedure if exists addparents;
create procedure addparents()
begin
declare i int;
set i=2;
repeat
insert into Parents values(
'a',
'b',
'c',
'12',
'@d',
'',
'Father',
'0',
i);
set i=i+1;
until i>=5
end repeat;
end $$

delimiter ;
call addparents();
delete from Student where StudentID=5;
-- 4.delete one student whose parent has been added in database
delete from Student where StudentID=2;

