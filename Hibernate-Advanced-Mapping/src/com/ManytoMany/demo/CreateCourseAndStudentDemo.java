package com.ManytoMany.demo;

import com.ManytoMany.Entity.Course;
import com.ManytoMany.Entity.Instructor;
import com.ManytoMany.Entity.InstructorDetail;
import com.ManytoMany.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {
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
        int id = 1;
        try{

            // start transaction
            session.beginTransaction();
            // create course
            Course course = new Course("Algorithms");
/*
            // create students
            Student student1= new Student("Ranadheer","Bolli","bolliranadheer@gmail,com");
            Student student2= new Student("Javeed","Ather","javeedather007@gmail.com");
*/
            Student student = session.get(Student.class,id);
            Course course1 = new Course("C");
            Course course2 = new Course("python");
  /*
            // adding student to course
            course.add(student1);
            // adding course to student
            student2.add(course);
*/
            // adding student to courses

            course1.add(student);
            course2.add(student);

            // save course1
            session.save(course1);
            // save course2
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
