package com.ManytoMany.Entity;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade =
            {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructorId;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> studentList;

    public Course(){

    }
    public Course(String title){
        this.title=title;
    }
    public void setId(int id){this.id=id;}
    public void setTitle(String title){this.title=title;}
    public void setInstructorId(Instructor instructorId){this.instructorId = instructorId;}
    public void setStudentList(List<Student> studentList){this.studentList=studentList;}

    public int getId(){return this.id;}
    public String getTitle(){return this.title;}
    public Instructor getInstructorId(){return this.instructorId;}
    public List<Student> getStudentList(){return this.studentList;}

    public void add(Student student){
        if(studentList==null){
            studentList = new ArrayList<>();
        }
        studentList.add(student);
    }


}
