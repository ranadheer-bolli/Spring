package com.OnetoManyUni.demo;

import com.OnetoManyUni.Entity.Course;
import com.OnetoManyUni.Entity.Instructor;
import com.OnetoManyUni.Entity.InstructorDetail;
import com.OnetoManyUni.Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {
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

            Course course = new Course("Let us C");

            // add some reviews
            course.add(new Review("Excellent Course"));
            course.add(new Review("Worst Course"));
            course.add(new Review("Cool Course, well done!!"));

            // save the course and leverage cascade all
            System.out.println("saving the course");
            System.out.println(course);
            System.out.println(course.getReviewList());

            session.save(course);

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
