package com.tut.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class fetchDemo {

	public static void main (String[] args) {
		
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory() ;
		 
		 Session session = factory.openSession();
		 
		Student student = (Student) session.load(Student.class,1);
		System.out.println(student);
		 
		Address ad = session.get(Address.class,2);
		System.out.println(ad.getStreet() + ":" + ad.getCity());
		 
		session.close();
		factory.close();
		
		
		}
	}
