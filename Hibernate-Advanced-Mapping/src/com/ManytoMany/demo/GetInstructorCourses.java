package com.ManytoMany.demo;

import com.ManytoMany.Entity.Course;
import com.ManytoMany.Entity.Instructor;
import com.ManytoMany.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCourses {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.openSession();

int id=1;
        try{
            // start transaction
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class,id);
            System.out.println("Instructor Details "+instructor);
            System.out.println("associated instructor: "+instructor.getCourseList());

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
