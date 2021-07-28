package com.Bidirectional.demo;


import com.Bidirectional.Entity.Instructor;
import com.Bidirectional.Entity.InstructorDetail;
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
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try{
            // create objects

            Instructor instructor = new Instructor("Nikhil","Chowdary","nikhilchowdary@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("http://lovebabbar/youtube","live2Code");
            // Associate with objects
            instructor.setInstructorDetailId(instructorDetail);

            // start transaction
            session.beginTransaction();
            //save the objects
            session.save(instructor);
            // commit transaction

            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
        }

}
