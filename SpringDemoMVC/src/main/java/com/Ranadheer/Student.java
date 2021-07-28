package com.Ranadheer;

import java.util.HashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favourite_language;
    private String operating_system[];
    private HashMap<String,String>  country_list;
    public Student(){
      country_list= new HashMap<>();
      country_list.put("IN","INDIA");
      country_list.put("FR","FRANCE");
      country_list.put("DE","GERMANY");
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName= lastName;
    }


    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }

    public HashMap<String,String> getCountry_list(){
        return country_list;
    }

    public void setFavouriteLanguage(String favourite_language){
        this.favourite_language=favourite_language;
    }

    public String getFavouriteLanguage(){
        return this.favourite_language;
    }
    public void setCountry(String country){
        this.country=country;
    }

    public String getCountry(){
        return this.country;
    }
    public void setOperatingSystem(String[] operating_system){
        this.operating_system=operating_system;
    }
    public String[] getOperatingSystem(){
        return this.operating_system;
    }
}
