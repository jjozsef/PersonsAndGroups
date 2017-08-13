package com.juhaszjozsef;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "group_number")
    private int groupNumber;

    @ManyToOne
    @JoinColumn(name = "group_number", insertable = false, updatable = false)
    private Group groups;

    public Person() {
    }

    public Person(String personName, String dateOfBirth, int groupNumber) {
        this.personName = personName;
        this.dateOfBirth = dateOfBirth;
        this.groupNumber = groupNumber;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", groupNumber=" + groupNumber +
                '}';
    }
}