package com.Bidirectional.demo;

import com.Bidirectional.Entity.Instructor;
import com.Bidirectional.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetails {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

int id=3;
        try{
            // start transaction
            session.beginTransaction();

            InstructorDetail instructorDetail = session.get(InstructorDetail.class,id);
            System.out.println("Instructor Details "+instructorDetail);
            System.out.println("associated instructor: "+instructorDetail.getInstructor());


            //Remove the associated object reference and break bi directional link

            instructorDetail.getInstructor().setInstructorDetailId(null);

            // delete instructorDetail

            session.delete(instructorDetail);

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
