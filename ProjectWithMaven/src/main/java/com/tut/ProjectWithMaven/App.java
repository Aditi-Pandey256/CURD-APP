package com.tut.ProjectWithMaven;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;


//import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws  IOException
    {
        System.out.println( "Project Started!" );
 
        SessionFactory factory = new Configuration().configure().buildSessionFactory() ;  
        
        
     // creating student
        Student st = new Student();
        st.setId(106);
       st.setName("Aditi");
        st.setCity("Vadodara");
        
        System.out.println(st);
        
        Address ad = new Address();
        ad.setStreet("Street1");
        ad.setCity("Vadodara");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.45);
        
        FileInputStream fis = new FileInputStream("src/main/java/pic.png");
        byte[] data = new  byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
    Session session = factory.openSession();
    
    org.hibernate.Transaction tx = session.beginTransaction();
    session.save(st);
    session.save(ad);
    tx.commit();
    session.close();
    System.out.println("Done");

       
        
    }
}
