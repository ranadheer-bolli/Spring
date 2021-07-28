package com.OneToMany.Entity;

import javax.persistence.*;

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

    public Course(){

    }
    public Course(String title){
        this.title=title;
    }
    public void setId(int id){this.id=id;}
    public void setTitle(String title){this.title=title;}
    public void setInstructorId(Instructor instructorId){this.instructorId = instructorId;}

    public int getId(){return this.id;}
    public String getTitle(){return this.title;}
    public Instructor getInstructorId(){return this.instructorId;}




}
