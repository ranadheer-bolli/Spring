package com.OneToMany.demo;


import com.OneToMany.Entity.Course;
import com.OneToMany.Entity.Instructor;
import com.OneToMany.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.openSession();
int id = 1;
        try{
            // retrieve instructor object from db
            Instructor instructor = session.get(Instructor.class,id);
            // create dbs
            Course course1 = new Course("Data Structures");
            Course course2 = new Course("Java");

            // add course to instructor

            instructor.add(course1);
            instructor.add(course2);

            // start transaction
            session.beginTransaction();
            //save the objects
            session.save(course1);
            session.save(course2);
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
