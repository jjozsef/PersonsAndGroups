package com.juhaszjozsef;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Feature {

    static SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Group.class)
            .addAnnotatedClass(Person.class)
            .buildSessionFactory();

    static Session session = factory.getCurrentSession();

    public static void create() {

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Name, Date of birth (XXX-XX-XX), Group number:");

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            String dateOfBirth = scanner.nextLine();
            int groupNumber = scanner.nextInt();

            Person newPerson = new Person(name, dateOfBirth, groupNumber);
            session.save(newPerson);

            session.getTransaction().commit();

            System.out.println("The new person: " + newPerson);

        } catch (Exception e) {
            System.out.println(e);
            session.close();
        }
    }

    public static void update() {

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Select the ID number!");

            Scanner scanner = new Scanner(System.in);
            int personId = scanner.nextInt();

            Person selectedPerson = session.get(Person.class, personId);

            System.out.println("The selected person: " + selectedPerson);

            System.out.println("Name, Date of birth (XXX-XX-XX), Group number:");

            Scanner scanner2 = new Scanner(System.in);
            String name = scanner2.nextLine();
            String dateOfBirth = scanner2.nextLine();
            int groupNumber = scanner2.nextInt();

            selectedPerson.setPersonName(name);
            selectedPerson.setDateOfBirth(dateOfBirth);
            selectedPerson.setGroupNumber(groupNumber);

            System.out.println("The modified person: " + selectedPerson);

            session.getTransaction().commit();

        } catch (Exception e){
            System.out.println(e);
            session.close();
        }
    }

    public static void delete() {

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Select the ID number!");

            Scanner scanner = new Scanner(System.in);
            int personId = scanner.nextInt();

            Person selectedPerson = session.get(Person.class, personId);
            session.delete(selectedPerson);

            System.out.println("The deleted person: " + selectedPerson);

            session.getTransaction().commit();

        } catch (Exception e){
            System.out.println(e);
            session.close();
        }
    }

    public static void read() {

        try {
            session = factory.getCurrentSession();
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

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
