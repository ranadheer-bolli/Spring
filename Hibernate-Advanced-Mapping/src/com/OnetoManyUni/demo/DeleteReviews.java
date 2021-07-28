package com.OnetoManyUni.demo;

import com.OnetoManyUni.Entity.Course;
import com.OnetoManyUni.Entity.Instructor;
import com.OnetoManyUni.Entity.InstructorDetail;
import com.OnetoManyUni.Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteReviews {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        int id = 1;
        try{

            // start transaction
            session.beginTransaction();

            Review review = session.get(Review.class,id);

            session.delete(review);
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
