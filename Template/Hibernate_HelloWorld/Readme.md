# Exercise # 1 - Hibernate HelloWorld

Verify that you have PostgreSQL server (version > 9.6.25) and any sql client to connect to the PostgreSQL server pre-installed. If you don't have you can download the installer from [Here](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads). The installer includes the PostgreSQl server, pgAdmin: a graphical tool for managing and developing your databases.  

1. Create new maven project.
	- skip archetype selection
	- group id: com.dci
	- artifact id : hibernate  
	- Finish


2. Inside src/main/java --> create a new package : com.dci.hibernate.domain
  - Place file Message.java (POJO) provided, inside this package.


3. Inside src/main/resources --->
	- Place file Message.hbm.xml (make sure the package in hibernate-mapping tag is correct)


4. Inside pom.xml add the hibernate-core dependency inside the <dependencies> tag :
```
                      <dependency>
  				 <groupId>org.hibernate</groupId>
  				 <artifactId>hibernate-core</artifactId>
  				 <version>4.3.2.Final</version>
  			</dependency>  
```
Also add dependency for PostgreSQL driver.
```
										<dependency>
						<groupId>org.postgresql</groupId>
						<artifactId>postgresql</artifactId>
						<version>42.2.4</version>
					</dependency>
```             

5. Copy the file hibernate.cfg.xml provided inside the directory src/main/resources
	- This is the hibernate configuration file.
	- Change the username and password propeties to match with the credentials of your local PostgreSQL server.
	- Create a database named 'hello-world'. Using the hello-world.sql file provided, create the table 'message' inside the database 'hello-world'.

	Additionally create a sequence named 'hibernate_sequence'
	```
	CREATE SEQUENCE hibernate_sequence START 1;
	```


6. Create a new package com.dci.hibernate.util and place HibernateUtil.java(provided) inside it.
  - In HibernateUtil class we build a SessionFactory object using the configuration file we added (hibernate.cfg.xml).
  - This Session Factory is utilized to create sessions when needed.


7. Create a new package com.dci.hibernate.client and place the HelloWorldClient.java (provided) file inside this package.
	- This Class contains the main method which utilizes the HibernateUtil's getSessionFactory method to create a session.
	- We then construct a new object of Message with a text and save it to the database using the session.
	- We finally commit the transaction and close the session.


8. Run the HelloWorldClient.java. Check if the data gets inserted in the message table. Run the client multiple times and see what happens.
	- Add debug points to the lines inside main method of the HelloWorldClient class, run the app in debug mode and see at which point the row actually gets inserted into the table.



###### Now we will use JPA annotations instead of using the mapping file(hibernate.cfg.xml)

9. Create new package com.dci.hibernate.entity and place the MessageEntity.java file inside it.(Rename it to Message.java again.)
	- In the HelloWorldClient.java file, change the import for Messsage from com.dci.hibernate.domain to com.dci.hibernate.entity


10. In hibernate.cfg.xml file  

	Comment this line :
```
<mapping resource="Message.hbm.xml"/>
```
  Uncomment this line :
```
<mapping class="com.dci.hibernate.entity.Message"/>
```

11. Run and verify that everything is fine.
	- Additonally remove the Message.java file from the com.dci.hibernate.domain package and the Message.hbm.xml file and run the application to verify that annotations based mapping is actually in action.
