    package com.hibernateDemo;
import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import java.util.List;

    public class QueryDemo {


        public static void main(String[] args) {
            //Create a Session Factory

            //Create a session
            try (SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class).buildSessionFactory(); sessionFactory) {
                Session session = sessionFactory.getCurrentSession();
                //ALways get a session and Start Tran
                session.beginTransaction();

                List<Student> studentList = session.createQuery("from Student s where s.firstName = 'Kurenai'" )
                        .getResultList();

                System.out.println(studentList);
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}
