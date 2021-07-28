package com.hibernate_.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
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

            // create a student object
           Student student = new Student("Ranadheer","Bolli","bolliranadheer@gmail.com");


            // start a transaction
            session.beginTransaction();
            // save the student object
            session.save(student);

            // commit transaction
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }

    }
}
