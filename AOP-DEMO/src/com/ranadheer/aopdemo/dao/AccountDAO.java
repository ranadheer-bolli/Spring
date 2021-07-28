package com.ranadheer.aopdemo.dao;

import com.ranadheer.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private int value;

    public void setName(String name){this.name=name;}
    public void setValue(int value){this.value=value;}

    public String getName(){return this.name;}
    public int getValue(){return this.value;}

    public void addAccount(Account account,boolean flag){
        System.out.println(getClass() +" Adding an account to DB");
    }
    public void goToSleep(){
        System.out.println("Please go to sleep");
    }

    public List<Account> findAccounts(boolean flag){
        List<Account> accountList = new ArrayList<>();

        if(flag) {
            throw new RuntimeException("After throwing exception");
        }
        Account account1 = new Account("Ranadheer",10);
        Account account2= new Account("Javeed",11);
        Account account = new Account("Nikhil",20);

        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account);

        return accountList;
    }

}
