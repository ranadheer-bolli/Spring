package com.Ranadheer.Entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name="hobby")
    private String hobby;

    public InstructorDetail(){}
    public InstructorDetail(String youtube,String hobby){
         this.hobby=hobby;
         this.youtubeChannel=youtube;
    }

    public void setId(int id){this.id=id;}
    public void setYoutube(String youtube){this.youtubeChannel=youtube;}
    public void setHobby(String hobby){this.hobby=hobby;}

    public int getId(){return this.id;}
    public String getYoutube(){return this.youtubeChannel;}
    public String getHobby(){return this.hobby;}
    
}
