package com.hibernate_.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session

        Session session = factory.getCurrentSession();

        int id=1;
        try{

            // start a transaction
            session.beginTransaction();

            Student student = session.get(Student.class,id);

            session.delete(student);
            // commit transaction
            session.getTransaction().commit();

            // All rows update
            Session session1 = factory.getCurrentSession();
            session1.beginTransaction();
            session1.createQuery("delete from Student where first_name='Javeed'").executeUpdate();
            session1.getTransaction().commit();
        }
        finally {
            factory.close();
        }

        }
}
