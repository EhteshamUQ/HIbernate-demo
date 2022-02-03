package com.hibernateDemo;

import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //Create a Session Factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        //Create a session
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            Student bell = new Student("Bell", "dokkan", "bellDOkan@gmail.com");
            Student volt = new Student("Volt", "Aoi", "voltaoi@gmail.com");
            Student shu = new Student("Shu", "Kurenai", "KurenaiShu@gmail.com");

            //Start tran
            session.beginTransaction();
            //save
            session.save(bell);
            session.save(volt);
            session.save(shu);
            //Commit
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
