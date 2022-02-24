# Exercise # 4 - Hibernate One to Many Mapping Relationship

In this exercise, you are going to implement bi-directional One-to-Many mapping between persisted objects using @OneToMany annotation.  
A one-to-many relationships occurs when one entity is related to multiple occurrences of another entity.

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
CREATE TABLE ASSET_MNGT (

    AM_ID SERIAL,
    EMP_ID SERIAL,
    ASSET_NAME VARCHAR(128),
    VENDOR VARCHAR(128),
    PRIMARY KEY (AM_ID),
    FOREIGN KEY (EMP_ID) REFERENCES EMPLOYEES(EMP_ID)
);
```

2. Add data to the tables using the queries below :
```
INSERT INTO EMPLOYEES (EMP_ID, NAME, DEPARTMENT, SALARY, JOINED_ON) VALUES (1, 'Samuel K', 'Documentation', 10000, CURRENT_TIMESTAMP);
INSERT INTO EMPLOYEES (EMP_ID, NAME, DEPARTMENT, SALARY, JOINED_ON) VALUES (2, 'Hanis M', 'Entertainment', 12000, CURRENT_TIMESTAMP);
INSERT INTO EMPLOYEES (EMP_ID, NAME, DEPARTMENT, SALARY, JOINED_ON) VALUES (3, 'Peter Y', 'Admin', 25000, CURRENT_TIMESTAMP);
INSERT INTO EMPLOYEES (EMP_ID, NAME, DEPARTMENT, SALARY, JOINED_ON) VALUES (4, 'Martin V', 'Security', 2500, CURRENT_TIMESTAMP);
INSERT INTO ASSET_MNGT (EMP_ID, ASSET_NAME, VENDOR) VALUES (1, 'Laptop', 'Apple');
INSERT INTO ASSET_MNGT (EMP_ID, ASSET_NAME, VENDOR) VALUES (1, 'Mobile', 'Apple');
INSERT INTO ASSET_MNGT (EMP_ID, ASSET_NAME, VENDOR) VALUES (1, 'LCD Monitor', 'HCL');
INSERT INTO ASSET_MNGT (EMP_ID, ASSET_NAME, VENDOR) VALUES (2, 'Laptop', 'Apple');
INSERT INTO ASSET_MNGT (EMP_ID, ASSET_NAME, VENDOR) VALUES (2, 'Mobile', 'Samsung');
INSERT INTO ASSET_MNGT (EMP_ID, ASSET_NAME, VENDOR) VALUES (2, 'LCD Monitor', 'HCL');
INSERT INTO ASSET_MNGT (EMP_ID, ASSET_NAME, VENDOR) VALUES (3, 'Laptop', 'Apple');
INSERT INTO ASSET_MNGT (EMP_ID, ASSET_NAME, VENDOR) VALUES (3, 'Mobile', 'Samsung');
INSERT INTO ASSET_MNGT (EMP_ID, ASSET_NAME, VENDOR) VALUES (4, 'Laptop', 'Apple');
```

Additionally create a sequence named 'hibernate_sequence'
```
  CREATE SEQUENCE hibernate_sequence START 5;
```

Our tables are already One-to-Many mapped. We have created EMPLOYEES AND ASSET_MNGT tables. EMPLOYEES is our primary table and we are using Foreign Key in ASSET_MNGT table for One-to-Many mapping.


2. Create hibernate xml based configuration file in your resources folder (classpath). This file includes hibernate configurations like driver class, DB connectivity URL, DB credentials and so on...


3. Create the entity classes according to our database tables along with One-to-Many mapping (For both tables EMPLOYEES and ASSET_MNGT).
  - Since we are creating bi-directional mapping, place @OneToMany annotation in parent entity class and @ManyToOne in the child.
  - Configure ASSET_MNGT to be eagerly loaded while loading data from the EMPLOYEES table.
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
    - Insert data into the EMPLOYEE and ASSET_MNGT table with mappings
    - List all the data from the EMPLOYEE Table
    - Get employee by id
    - Delete employee record


7. Run and verify :
    - CRUD operations are fine.
    - Mapping is correct.
    - Non select operations are cascaded.
