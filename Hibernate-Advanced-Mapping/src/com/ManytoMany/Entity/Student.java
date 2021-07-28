package com.ManytoMany.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
    CascadeType.MERGE,
    CascadeType.PERSIST,
    CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courseList;

    public Student(){}
    public Student(String firstName,String lastName,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }

    public void setId(int Id){this.Id=Id;}
    public void setFirstName(String firstName){this.firstName=firstName;}
    public void setLastName(String lastName){this.lastName=lastName;}
    public void setEmail(String email){this.email=email;}
    public void setCourseList(List<Course> courseList){this.courseList=courseList;}


    public int getId(){return  this.Id;}
    public String getFirstName(){return this.firstName;}
    public String getLastName(){return this.lastName;}
    public String getEmail(){return this.email;}
    public List<Course> getCourseList(){return this.courseList;}

    public void add(Course course){
        if(courseList==null){
            courseList = new ArrayList<>();
        }
        courseList.add(course);
    }
}
