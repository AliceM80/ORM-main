package com.dci.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.dci.hibernate.model.AssetMgnt;
import com.dci.hibernate.model.Employee;
 

 
public class HibernateUtil {
 
    private static SessionFactory sessionFactory = null;
 
    static {
        try{
            loadSessionFactory();
        }catch(Exception e){
            System.err.println("Exception while initializing hibernate util.. ");
            e.printStackTrace();
        }
    }
 
    public static void loadSessionFactory(){
 
    	//todo
    	//Create a configuration object with the configuration file inside src/main/resources
       
        
        //add annotated classes Employee and AssetMgnt to the configuration
       
        
        //build the session Factory.
    }
 
    public static Session getSession() throws HibernateException {
 
        Session retSession=null;
            try {
                retSession = sessionFactory.openSession();
            }catch(Throwable t){
            System.err.println("Exception while getting session.. ");
            t.printStackTrace();
            }
            if(retSession == null) {
                System.err.println("session is discovered null");
            }
 
            return retSession;
    }
}