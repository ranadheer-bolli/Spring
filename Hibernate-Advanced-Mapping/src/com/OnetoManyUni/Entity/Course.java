package com.OnetoManyUni.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    public List<Review> reviewList;


    public Course(){

    }
    public Course(String title){
        this.title=title;
    }
    public void setId(int id){this.id=id;}
    public void setTitle(String title){this.title=title;}
    public void setInstructorId(Instructor instructorId){this.instructorId = instructorId;}
    public void setReviewList(List<Review> reviewList){this.reviewList=reviewList;}



    public int getId(){return this.id;}
    public String getTitle(){return this.title;}
    public Instructor getInstructorId(){return this.instructorId;}
    public List<Review> getReviewList(){return this.reviewList;}


    public void add(Review review){
        if(reviewList==null){
            reviewList=new ArrayList<>();
        }
        reviewList.add(review);
    }


}
