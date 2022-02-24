# Exercise #3  - Hibernate One to One Mapping Relationship

In this page, you are going to implement bidirectional One-to-One mapping between persisted objects using @OneToOne annotation.  
A one-to-one relationships occurs when one entity is related to exactly one occurrence in another entity.

Verify that you have PostgreSQL server (version > 9.6.25) and any sql client to connect to the PostgreSQL server pre-installed. If you don't have you can download the installer from [Here](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads). The installer includes the PostgreSQl server, pgAdmin: a graphical tool for managing and developing your databases. 


1. Create a database named my_db and create tables in it using the queries :
```
CREATE TABLE EMPLOYEES (
    EMP_ID SERIAL,
    NAME VARCHAR(252),
    DEPARTMENT VARCHAR(128),
    SALARY BIGINT,
    JOINED_ON TIMESTAMP,
    PRIMARY KEY (EMP_ID)
);
CREATE TABLE EMP_DETAILS (
    ED_ID SERIAL,
    EMP_ID SERIAL,
    ADDRESS VARCHAR(252),
    GENDER VARCHAR(8),
    YEARS_OF_SERVICE BIGINT,
    BANK_ACCOUNT VARCHAR(128),
    PRIMARY KEY (ED_ID),
    FOREIGN KEY (EMP_ID) REFERENCES EMPLOYEES(EMP_ID)
);
```

2. Add data to the tables using the queries below :
```
INSERT INTO EMPLOYEES (EMP_ID, NAME, DEPARTMENT, SALARY, JOINED_ON) VALUES (1, 'Samuel K', 'Documentation', 10000, CURRENT_TIMESTAMP);
INSERT INTO EMPLOYEES (EMP_ID, NAME, DEPARTMENT, SALARY, JOINED_ON) VALUES (2, 'Hanis M', 'Entertainment', 12000, CURRENT_TIMESTAMP);
INSERT INTO EMPLOYEES (EMP_ID, NAME, DEPARTMENT, SALARY, JOINED_ON) VALUES (3, 'Peter Y', 'Admin', 25000, CURRENT_TIMESTAMP);
INSERT INTO EMPLOYEES (EMP_ID, NAME, DEPARTMENT, SALARY, JOINED_ON) VALUES (4, 'Martin V', 'Security', 2500, CURRENT_TIMESTAMP);
INSERT INTO EMP_DETAILS (EMP_ID, ADDRESS, GENDER, YEARS_OF_SERVICE, BANK_ACCOUNT) VALUES (1, 'Florida', 'Male', 4, '00343466');
INSERT INTO EMP_DETAILS (EMP_ID, ADDRESS, GENDER, YEARS_OF_SERVICE, BANK_ACCOUNT) VALUES (2, 'Texas', 'Male', 2, '988800098');
INSERT INTO EMP_DETAILS (EMP_ID, ADDRESS, GENDER, YEARS_OF_SERVICE, BANK_ACCOUNT) VALUES (3, 'Detroit', 'Male', 6, '11129098');
INSERT INTO EMP_DETAILS (EMP_ID, ADDRESS, GENDER, YEARS_OF_SERVICE, BANK_ACCOUNT) VALUES (4, 'Kansas', 'Male', 10, '887639421');
```
Additionally create a sequence named 'hibernate_sequence'
```
  CREATE SEQUENCE hibernate_sequence START 5;
```

Our tables are already One-to-One mapped. We have created EMPLOYEES AND EMP_DETAILS tables. EMPLOYEES is our primary table and we are using Foreign Key in EMP_DETAILS table for One-to-One mapping.


2. Create hibernate xml based configuration file in your resources folder (classpath). This file includes hibernate configurations like driver class, DB connectivity URL, DB credentials and so on...


3. Create the entity classes according to our database tables along with One-to-One mappings (For both tables EMPLOYEES and EMP_DETAILS).
  - Since we are creating bi-directional mapping, place @OneToOne annotation on both entity classes.
  - Configure EMP_DETAILS to be eagerly loaded while loading data from the EMPLOYEES table.
  - Propagate all the non-select operations on the main object to the child object with cascading :
      - insert
      - update
      - delete


4. Edit the Hibernate Utility Class to manage hibernate session.
    - implement the loadSessionFactory() method.


5. Edit the EmployeesDao class :
    - implement getEmployeeList() method
    - implement getEmployeebyId(Long empId) method
    - implement insertEmployee(Employee emp) method
    - implement deleteEmployee(Employee emp) method


6. Inside the main method of the EmployeeDao class :
    - Insert data into the EMPLOYEE and EMP_DETAILS table with mappings
    - List all the data from the EMPLOYEE Table
    - Get employee by id
    - Delete employee record


7. Run and verify :
    - CRUD operations are fine.
    - Mapping is correct.
    - Non select operations are cascaded.
