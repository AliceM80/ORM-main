# Exercise # 6 - Spring Data JPA


In this exercise you'll create a data access layer for a domain object Customer.

Verify that you have PostgreSQL server (version > 9.6.25) and any sql client to connect to the PostgreSQL server pre-installed. If you don't have you can download the installer from [Here](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads). The installer includes the PostgreSQl server, pgAdmin: a graphical tool for managing and developing your databases. 

1. Create a customer table in your database with 3 fields in it.
	- id (int)
	- name (varchar)
	- email (varchar)
```
create table customer(
id int PRIMARY KEY,
name varchar(20),
email varchar(100)
);
```


2. Create a spring boot project named customerdata using one of the spring boot project creation method
  - (start.spring.io, IDE or CLI)


3. Once you have the spring boot project, create an entity or model class which you'll map to the database table using JPA annotations.
  - Create fields within this entity namely id, name and email which will be automatically mapped to id, name and email in the database table.
  - If the names here are different from database, you should use annotations like @Column. But if field names are same as the database table column names, no additional annotations are required.
  - Mark the id attribute as primary key


4. Create a Customer Repository	that will extend the CrudRepository Interface.


5. Configure the datasource in the application.properties file(spring boot properties file)


6. Write tests to perform CRUD operation on the customer entity.
	- Write 4 different tests to verify the
      - save,
      - update,
      - delete and
      - read/find  
      operations can be done using Customer Repository.
