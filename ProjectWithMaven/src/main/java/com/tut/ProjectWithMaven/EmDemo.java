package com.tut.ProjectWithMaven;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory() ;  
        Student student1 = new Student();
        student1.setId(101);
        student1.setName("Aditya Pandey");
        student1.setCity("Gandhinagar");
        
        
       Certificate certificate = new Certificate();
       certificate.setCourse("Android");
       certificate.setDuration("6 months");
       student1.setCerti(certificate);
		
       
       Student student2 = new Student();
       student2.setId(102);
       student2.setName("Mamta Pandey");
       student2.setCity("Amritsar");
       
       
      Certificate certificate1 = new Certificate();
      certificate1.setCourse("Java");
      certificate1.setDuration("8 months");
      student2.setCerti(certificate1);
      
      Session s = factory.openSession();
      org.hibernate.Transaction tx = s.beginTransaction();
      
      s.save(student1);
      s.save(student2);
		
	
      tx.commit();
      s.close();
	  factory.close();
	}

}
