package com.hibernateDemo;

import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {
        //Create a Session Factory

        //Create a session
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory(); sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            Student student = new Student("Aiger", "Aakabane", "AigaBane@gmail.com");
            System.out.println(student);
            //Start tran
            session.beginTransaction();
            //save
            session.save(student);
            //Commit
            session.getTransaction().commit();

            System.out.println("Generated Primary key : " +student.getId());

            // Again Use Transaction
            session = sessionFactory.getCurrentSession();

            //start tran
            session.beginTransaction();
            //Read
            Student aiger = session.get(Student.class , student.getId());

            System.out.println(aiger);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
