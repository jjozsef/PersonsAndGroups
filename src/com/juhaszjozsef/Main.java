package com.juhaszjozsef;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Groups.class)
                .addAnnotatedClass(Persons.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Groups> theGroups = session.createQuery("from Groups").getResultList();

            for (Groups tempGroup : theGroups) {
                System.out.println(tempGroup);
            }

            List<Persons> thePersons = session.createQuery("from Persons").getResultList();

            for (Persons tempPerson : thePersons) {
                System.out.println(tempPerson);
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
