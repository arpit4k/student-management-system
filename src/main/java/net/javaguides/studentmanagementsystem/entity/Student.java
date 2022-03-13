package net.javaguides.studentmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
//Even if I dont use @Table annotation then JPA is smart enough to name it as the name of the class 

public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Primary key generation strategy, identity is used  
    //Both the above tags are used to declare a PRIMARY KEY for the table "students"
    private Long id;

    //Even if I dont use @Column annotation then JPA is smart enough to name it as the name of the field i.e firstName
    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email") 
    private String email;

    //Hibernate needs a default constructor in order to create objects dynamically
    //and a default constructor should always be accompanied with a parametrized const

    public Student(){

    }

    public Student(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLastName() {   
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
