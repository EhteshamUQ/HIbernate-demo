package com.hibernateDemo;

import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {
        //Create a Session Factory

        //Create a session
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory(); sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            int id = 5;
            session.beginTransaction();
            //Commit
            Student s = session.get(Student.class , id);
            session.delete(s);
            session.getTransaction().commit();
            session = sessionFactory.getCurrentSession();
            //Start
            session.beginTransaction();
            session.createQuery("delete Student where firstName='bell'").executeUpdate();
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
