package com.Ranadheer;


import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.validation.constraints.*;

public class Customer {


    private String firstName;

    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    private String lastName;

    @Min(value = 18, message = "Must be 18 or above")
    @Max(value = 60,message = "Should be less than or equal 60")
    private int age;

    @Pattern(regexp = "[A-Xa-z0-9]{5}",message = "only 5 characters or digits")
    private String postalCode;

    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    @CourseCode(value = "TOPS",message = "Must start with TOPS")
    private String courseCode;


    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName= lastName;
    }
    public void setAge(int age){ this.age=age;}
    public void setPostalCode(String postalCode){ this.postalCode=postalCode;}
    public void setCourseCode(String courseCode){this.courseCode=courseCode;}


    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public int getAge(){ return this.age;}
    public String getPostalCode(){return this.postalCode;}
    public String getCourseCode(){return this.courseCode;}



}
