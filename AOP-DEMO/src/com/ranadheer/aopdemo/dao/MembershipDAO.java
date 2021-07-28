package com.ranadheer.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

 public boolean addMembershipAccount(){
     System.out.println(getClass()+"adding membership account");
     return true;
 }
}
