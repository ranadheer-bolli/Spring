package com.Ranadheer.demo;


import com.Ranadheer.Entity.Instructor;
import com.Ranadheer.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

int id=1;
        try{
            // start transaction
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class,id);
            if(instructor!=null)
            session.delete(instructor);


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
