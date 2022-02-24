package com.dci.hibernate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dci.hibernate.model.AssetMgnt;
import com.dci.hibernate.model.Employee;
 
 
public class EmployeesDao {
 
    public List<Employee> getEmployeeList(){
 
    	//todo
    	//to return list of all the employees in the employee table.
    	
    	return null;
    }
 
    public Employee getEmployeeById(Long empId){
 
    	//todo
    	//to return an employee with the given id
    	
    	return null;
    }
 
    public void insertEmployee(Employee emp) {
 
    	//todo
        //to insert an employee to the Employee table with cascading effect.	
    }
 
    public void deleteEmployee(Employee emp) {
 
    	//todo
        //to delete employee from the Employee table with cascading effect.
    }
 
    public static void main(String a[]) {
 
    	//Insert data into EMPLOYEE and ASSET_MNGT ID WITH MAPPING
    	//using the insertEmployee(Employee emp) method
    
		//List all the data from the database table.
    	//using the getEmployeeList() method
        
        
        //get employee by id
        //using the getEmployeeById(Long empId) method
		 

		//delete employee
        //using the deleteEmployee(Employee emp) method
		 
    }
}
