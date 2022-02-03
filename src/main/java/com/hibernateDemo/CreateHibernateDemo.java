package com.hibernateDemo;

import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class CreateHibernateDemo {

    public static void main(String[] args) {
        //Create a Session Factory
        SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class).buildSessionFactory();

        //Create a session
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            Student student = new Student("Aiger", "Aakabane", "AigaBane@gmail.com");

            //Start tran
            session.beginTransaction();
            //save
            session.save(student);
            //Commit
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
