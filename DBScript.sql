create table TASK
(
	TASKID INTEGER not null primary key,
	DESCRIPTION VARCHAR(255),
	EMPLOYEEID INTEGER
);
create table ROLE
(
	ROLEID INTEGER not null primary key,
	TITLE VARCHAR(100)
);
create table EMPLOYEE
(
	EMPLOYEEID INTEGER not null primary key,
	NAME VARCHAR(100),
	ROLEID INTEGER
);