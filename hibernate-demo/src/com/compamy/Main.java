package com.compamy;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
	String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
	String username = "hbstudent";
	String password = "hbstudennt";
	try {
        System.out.println("Connecting to database " + jdbcurl);
        Connection myConn = DriverManager.getConnection(jdbcurl,username,password);
        System.out.println("Connection successful");
    }
	catch (Exception e){
	    e.printStackTrace();
    }
    }
}
