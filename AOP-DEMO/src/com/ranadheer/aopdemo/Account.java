package com.ranadheer.aopdemo;

public class Account {
    private String name;
    private int value;

    public Account(){}

    public Account(String name,int value){
        this.value=value;
        this.name=name;
    }

    public void setName(String name){this.name=name;}
    public void setValue(int value){this.value=value;}

    public String getName(){return this.name;}
    public int getValue(){return this.value;}

    public String toString(){
        return "name:"+this.name+" value:"+this.value;
    }

}
