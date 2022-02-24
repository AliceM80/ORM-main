# Exercise # 2 - Hibernate Basic CRUD Operations

In this exercise you are going to perform basic CRUD operations on database using Hibernate.

Verify that you have PostgreSQL server (version > 9.6.25) and any sql client to connect to the PostgreSQL server pre-installed. If you don't have you can download the installer from [Here](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads). The installer includes the PostgreSQl server, pgAdmin: a graphical tool for managing and developing your databases.  


1. Create a database named my_db and create a table in it using the query :
```
CREATE TABLE EMPLOYEES (

    EMP_ID SERIAL,
    NAME VARCHAR(252),
    DEPARTMENT VARCHAR(128),
    SALARY BIGINT,
    JOINED_ON TIMESTAMP,
    PRIMARY KEY (EMP_ID)
);
INSERT INTO EMPLOYEES (EMP_ID, NAME, DEPARTMENT, SALARY, JOINED_ON) VALUES (1, 'Nataraja G', 'Documentation', 10000, CURRENT_TIMESTAMP);
INSERT INTO EMPLOYEES (EMP_ID, NAME, DEPARTMENT, SALARY, JOINED_ON) VALUES (2, 'Amar M', 'Entertainment', 12000, CURRENT_TIMESTAMP);
INSERT INTO EMPLOYEES (EMP_ID, NAME, DEPARTMENT, SALARY, JOINED_ON) VALUES (3, 'Nagesh Y', 'Admin', 25000, CURRENT_TIMESTAMP);
INSERT INTO EMPLOYEES (EMP_ID, NAME, DEPARTMENT, SALARY, JOINED_ON) VALUES (4, 'Vasu V', 'Security', 2500, CURRENT_TIMESTAMP);
```
  Additionally create a sequence named 'hibernate_sequence'
```
  CREATE SEQUENCE hibernate_sequence START 5;
```

2. Edit the j2n-hibernate.cfg.xml file (in src/main/resources) to hold the appropriate configurations.


3. Edit Employee.java (in com.dci.hibernate.model package) by adding appropriate JPA annotations to map with the database table 'EMPLOYEES'.   
	- The class Employee maps to EMPLOYEES table in database.


4. Edit HibernateUtil.java (inside com.dci.hibernate), loadSessionFactory() method to configure the Configuration object.   
	- This is Hibernate Utility class and manages hibernate session.


5. Edit EmployeesDao.java (inside com.dci.hibernate)
	- This class contains the methods : getEmployeeList, getEmployeeById, insertEmployee ,deleteEmployee and main
	- add codes to implement the CRUD operations inside these methods.


6. Run the main method of the EmployeesDao class and make sure everything is fine.
	- insertEmployee method is doing the insertion correctly.
	- getEmployeeList method is retrieving and returning the list of all employees.
	- getEmployeeById method is retrieving and returning the employee by id.
	- deleteEmployee method is deleting the employee from the database table.
