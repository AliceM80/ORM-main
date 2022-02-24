package com.dci.hibernate.client;

import org.hibernate.Session;

import com.dci.hibernate.domain.Message;
import com.dci.hibernate.util.HibernateUtil;


public class HelloWorldClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		session.beginTransaction();
        
        		Message message = new Message( "Hello World with Hibernate and JPA Annotations" );
        
        		session.save(message);    
        
        		session.getTransaction().commit();
        		session.close();
	
	}
}

