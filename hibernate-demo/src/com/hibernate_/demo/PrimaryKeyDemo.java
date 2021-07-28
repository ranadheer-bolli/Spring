package com.hibernate_.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session

        Session session = factory.getCurrentSession();

        try{
            // use the session object to save java object

            // create 3 student objects
            System.out.println("Creating 3 student objects");
            Student student1 = new Student("Ranadheer","Bolli","bolliranadheer@gmail.com");
            Student student2 = new Student("Javeed","Ather","javeedather007@gmail.com");
            Student student3 = new Student("Nikhil","Chowdary","nikhilchowdary@gmail.com");
            // start a transaction
            session.beginTransaction();
            // save the student object
            session.save(student1);
            session.save(student2);
            session.save(student3);
            // commit transaction
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }

    }
}
