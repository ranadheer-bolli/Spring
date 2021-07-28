package com.Ranadheer.Entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetailId;
    public Instructor(){

    }
    public Instructor(String firstName,String lastName,String email){
            this.email=email;
            this.firstName=firstName;
            this.lastName=lastName;
        }

    public void setId(int Id){this.Id=Id;}
    public void setFirstName(String firstName){this.firstName=firstName;}
    public void setLastName(String lastName){this.lastName=lastName;}
    public void setEmail(String email){this.email=email;}
    public void setInstructorDetailId(InstructorDetail instructorDetailId){this.instructorDetailId=instructorDetailId;}

    public int getId(){return  this.Id;}
    public String getFirstName(){return this.firstName;}
    public String getLastName(){return this.lastName;}
    public String getEmail(){return this.email;}
    public InstructorDetail getInstructorDetailId(){return  this.instructorDetailId;}

    public String toString(){
        return Id+" "+firstName+" "+lastName+" "+email;
    }
}
