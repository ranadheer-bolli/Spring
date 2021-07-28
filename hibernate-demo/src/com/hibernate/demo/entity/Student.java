package com.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    public Student() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    public Student(String firstName,String lastName,String email){
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public void setId(int Id){this.Id=Id;}
    public void setFirstName(String firstName){this.firstName=firstName;}
    public void setLastName(String lastName){this.lastName=lastName;}
    public void setEmail(String email){this.email=email;}

    public int getId(){return  this.Id;}
    public String getFirstName(){return this.firstName;}
    public String getLastName(){return this.lastName;}
    public String getEmail(){return this.email;}

    public String toString(){
        return Id+" "+firstName+" "+lastName+" "+email;
    }

}
