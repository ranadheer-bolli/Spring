package com.OnetoManyUni.Entity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    public Review(){}
    public Review(String comment){
        this.comment=comment;
    }

    public void setId(int id){this.id=id;}
    public void setComment(String comment){this.comment=comment;}

    public int getId(){return this.id;}
    public String getComment(){return this.comment;}

}
