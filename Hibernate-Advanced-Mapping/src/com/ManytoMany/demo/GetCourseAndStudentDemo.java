package com.ManytoMany.demo;

import com.ManytoMany.Entity.Course;
import com.ManytoMany.Entity.Instructor;
import com.ManytoMany.Entity.InstructorDetail;
import com.ManytoMany.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndStudentDemo {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        int id = 10;
        try{


            // start transaction
            session.beginTransaction();
/*
            Student student = session.get(Student.class,id);
            System.out.println("student           "+student);
            System.out.println("courses"+student.getCourseList());

  */
            // Deleting course without deleting students

            Course course = session.get(Course.class,id);

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
