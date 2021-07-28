package com.ranadheer.aopdemo;


import com.ranadheer.aopdemo.dao.AccountDAO;
import com.ranadheer.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainConfig {

    public static void main(String[] args) {

        // read the config class

        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get bean from container

        AccountDAO theaccountDAO = context.getBean("accountDAO",AccountDAO.class);

        // get membership bean from container

        MembershipDAO themembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);


        Account account = new Account();

        theaccountDAO.setName("Ranadheer");
        theaccountDAO.setValue(20);


        // call the business method

        theaccountDAO.addAccount(account,true);
        System.out.println();

        theaccountDAO.goToSleep();
        System.out.println();

        System.out.println(theaccountDAO.getName());

        System.out.println();
        themembershipDAO.addMembershipAccount();

        // After Throwing
        System.out.println();
        List<Account> accountList=null;
        try {
            accountList = theaccountDAO.findAccounts(false);
        }
        catch (Exception e){
            System.out.println("Main method error:"+e);
        }


        System.out.println(accountList);

        // close context
        context.close();
    }
}
