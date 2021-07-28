package com.OneToMany.demo;

import com.OneToMany.Entity.Course;
import com.OneToMany.Entity.Instructor;
import com.OneToMany.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.openSession();

int id=10;
        try{
            // start transaction
            session.beginTransaction();
            Course course = session.get(Course.class,id);
            // delete instructorDetail
            session.delete(course);
            // commit transaction

            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
        }

}
