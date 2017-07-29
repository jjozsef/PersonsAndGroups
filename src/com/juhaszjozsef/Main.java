package com.juhaszjozsef;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Group.class)
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Group> theGroups = session.createQuery("from Group").getResultList();

            for (Group tempGroup : theGroups) {
                System.out.println(tempGroup);
            }

            List<Person> thePersons = session.createQuery("from Person").getResultList();

            for (Person tempPerson : thePersons) {
                System.out.println(tempPerson);
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
