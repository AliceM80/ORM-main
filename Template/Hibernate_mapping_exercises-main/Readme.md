# Exercise # 7  - Hibernate Mappings (One To Many / Many To Many)

Verify that you have PostgreSQL server (version > 9.6.25) and any sql client to connect to the PostgreSQL server pre-installed. If you don't have you can download the installer from [Here](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads). The installer includes the PostgreSQl server, pgAdmin: a graphical tool for managing and developing your databases.


## One to many association

Hibernate one to many mapping is made between two entities where first entity can have relation with multiple second entity instances but second can be associated with only one instance of first entity. Its 1 to N relationship.

For example, in any company an employee can register multiple bank accounts but one bank account will be associated with one and only one employee. In this hibernate one to many mapping exercise, you will make such mapping in database using hibernate with two approaches :

##### Approach 1 : Foreign Key Column

Use Foreign Key Association to create one to many mapping between account and employee entity.

a. Inside package com.dci.hibernate.oneToMany.foreignKeyAsso :  
		- Edit entities i.e. EmployeeEntity and AccountEntity such that multiple accounts can be associated with a single employee, but one single account can not be shared between two or more employees.  
		- EmployeeEntity should declare that relationship is one to many, and AccountEntity should declare that relationship from its end is many to one  
		- In EmployeeEntity :<ol>
				- Give the entity name as "ForeignKeyAssoEmployeeEntity", table name as "EMPLOYEE" and add id and email as unique constraints to the table.  
				- Add primary key field(integer) named employeeId which maps to column name "ID" in the "EMPLOYEE" table. Set the Generation strategy to IDENTITY.  
				- Add email field(string), which maps to column "EMAIL". Mark this as unique and non nullable.  
				- Add first name field which maps to column "FIRST_NAME" in the "EMPLOYEE" table. Mark this as non nullable.  
				- Add last name field which maps to column "LAST_NAME" in the "EMPLOYEE" table. Mark this as non nullable.  
				- Add set of accounts field(Set<AccountEntity>), such that one employee can have multiple accounts. Cascade all non-select operations to Account Entity.  
				- generate getters and setters for all the fields
    </ol>    
		- In accountEntity :<ol>
				- Give the entity name as "ForeignKeyAssoAccountEntity", table name as "ACCOUNT" and add id as unique constraints to the table.  
				- Add primary key field(integer) named accountId which maps to column name "ID" in the "ACCOUNT" table. Set the Generation strategy to IDENTITY.  
				- Add account number field(string), which maps to column "ACC_NUMBER". Mark this as unique and non nullable.  
				- Add employee(EmployeeEntity) field, such that multiple accounts are associated with one employee.  
				- generate getters and setters for all the fields.
        </ol>


b. In the src/main/resources directory :<ol>
				- Edit the "hibernate.cfg-one-to-many.xml" file to hold the appropriate hibernate configurations as mentioned.  
				- Make sure the database name specified on the configuration file is present. Create if not present.  
        </ol>


c. Inside package com.dci.hibernate.oneToMany :<ol>
		- Edit HibernateUtil class buildSessionFactory method to build and return session factory using the 'hibernate.cfg-one-to-many.xml' configuration file.  
		- In HibernateUtil class, make sure the imports for EmployeeEntity and AccountEntity are from correct package i.e com.dci.hibernate.oneToMany.foreignKeyAsso  
		- Edit the TestForeignKeyAssociation class as mentioned in the todos.
    </ol>

d. Finally, run the TestForeignKeyAssociations class main method and verify that tables with appropriate columns are created inside the database automatically and rows are inserted to the tables. Also verify that there's a foreign key column 'employee_id' in the 'account' table which holds the id of the employee who owns the account.


##### Approach 2 : Join Table

Use 'join table' to store the associations between account and employee entities.

a. Inside package com.dci.hibernate.oneToMany.joinTable :  
		- Edit entities i.e. EmployeeEntity and AccountEntity such that multiple accounts can be associated with a single employee, but one single account can not be shared between two or more employees.  
		- EmployeeEntity should declare that relationship is one to many  
		- In EmployeeEntity :<ol>
				- Give the entity name as "joinTableEmployeeEntity", table name as "EMPLOYEE" and add id and email as unique constraints to the table.  
				- Add primary key field(integer) named employeeId which maps to column name "ID" in the "EMPLOYEE" table. Set the Generation strategy to IDENTITY.  
				- Add email field(string), which maps to column "EMAIL". Mark this as unique and non nullable.  
				- Add first name field which maps to column "FIRST_NAME" in the "EMPLOYEE" table. Mark this as non nullable.  
				- Add last name field which maps to column "LAST_NAME" in the "EMPLOYEE" table. Mark this as non nullable.  
				- Add set of accounts field(Set<AccountEntity>), such that one employee can have multiple accounts. Use @JoinTable annotation to make a new table named "EMPLOYEE_ACCOUNT" with columns "EMPLOYEE_ID" (to hold id of an employee) and "ACCOUNT_ID"(to hold id of the account). Cascade all non-select operations to Account Entity.  
				- generate getters and setters for all the fields.
    </ol>    
		- In accountEntity :<ol>
				- Give the entity name as "joinTableAccountEntity", table name as "ACCOUNT" and add id as unique constraints to the table.  
				- Add primary key field(integer) named accountId which maps to column name "ID" in the "ACCOUNT" table. Set the Generation strategy to IDENTITY.  
				- Add account number field(string), which maps to column "ACC_NUMBER". Mark this as unique and non nullable.  
				- generate getters and setters for all the fields.  
        </ol>

b. In the src/main/resources directory :  
				- Edit the "hibernate.cfg-one-to-many.xml" file to hold the appropriate hibernate configurations as mentioned.  
				- Make sure the entities from correct package i.e com.dci.hibernate.oneToMany.joinTable are included in the mapping. and other entities are excluded.  
				- Make sure the database name specified on the configuration file is present. Create if not present.

c. Inside package com.dci.hibernate.oneToMany :  
		- Edit HibernateUtil class buildSessionFactory method to build and return session factory using the 'hibernate.cfg-one-to-many.xml' configuration file.  
		- In HibernateUtil class, make sure the imports for EmployeeEntity and AccountEntity are from correct package i.e com.dci.hibernate.oneToMany.joinTable  
		- Edit the TestJoinTable class as mentioned in the todos.

d. Finally, run the TestJoinTable class main method and verify that tables with appropriate columns are created inside the database automatically and rows are inserted to the tables. Also verify that there's a seperate table named "employee_account" created, which holds mapping information between the employee and the account table

## Many to many association

Hibernate many to many mapping is made between two entities where one can have relation with multiple other entity instances.

For example, for a subscription service SubscriptionEntity and ReaderEntity can be two type of entities. Any subscription can have multiple readers, where a reader can subscribe to multiple subscriptions.

In this exercise, you will create many to many mapping in database using hibernate.


a. Inside package com.dci.hibernate.manyToMany.joinTable :  
		- Edit entities i.e. ReaderEntity and SubscriptionEntity such that multiple readers can be associated with multiple subscriptions vice versa.  
		- ReaderEntity should declare that relationship is many to many, and SubscriptionEntity should declare that relationship from its end is many to many as well  
		- Owner entity is the entity which is responsible make making the association and maintaining it. Make ReaderEntity the owner entity. Use Join table strategy for the association  
		- In ReaderEntity :<ol>
				- Give the entity name as "ReaderEntity", table name as "READER" and add id and email as unique constraints to the table.  
				- Add primary key field(integer) named readerId which maps to column name "ID" in the "READER" table. Set the Generation strategy to IDENTITY.  
				- Add email field(string), which maps to column "EMAIL". Mark this as unique and non nullable.  
				- Add first name field which maps to column "FIRST_NAME" in the "READER" table. Mark this as non nullable.  
				- Add last name field which maps to column "LAST_NAME" in the "READER" table. Mark this as non nullable.  
				- Add set of subscriptions field(Set<SubscriptionEntity>), such that multiple readers can have multiple subscriptions. Use @JoinTable annotation to make a new table named "READER_SUBSCRIPTIONS" with columns "READERS_ID" (to hold id of reader) and "SUBSCRIPTIONS_ID"(to hold id of the subscription). Cascade all non-select operations to Subscription entity.  
				- generate getters and setters for all the fields.
        </ol>
		- In SubscriptionEntity :<ol>
				- Give the entity name as "SubscriptionEntity", table name as "SUBSCRIPTION" and add id as unique constraints to the table.  
				- Add primary key field(integer) named subscriptionId which maps to column "ID" in the "SUBSCRIPTION" table. Set the Generation strategy to IDENTITY.  
				- Add subscription name field(string), which maps to column "SUBS_NAME" in the "SUBSCRIPTION" table. Mark this as unique and non nullable.  
				- Add set of readers(Set<ReaderEntity>) field, such that multiple subscriptions are associated with multiple readers. Add Many to many association.  
				- generate getters and setters for all the fields.  
        </ol>

b. In the src/main/resources directory :  
				- Edit the "hibernate.cfg-many-to-many.xml" file to hold the appropriate hibernate configurations as mentioned.  
				- Make sure the database name specified on the configuration file is present. Create if not present.


c. Inside package com.dci.hibernate.manyToMany :  
		- Edit HibernateUtil class buildSessionFactory method to build and return session factory using the 'hibernate.cfg-many-to-many.xml' configuration file.  
		- Edit the TestJoinTable class as mentioned in the todos.

d. Finally, run the TestJoinTable class main method and verify that tables with appropriate columns are created inside the database automatically and rows are inserted to the tables. Also verify that there's a seperate table named "reader_subscriptions" created, which holds mapping information between the reader and the subscription table		
