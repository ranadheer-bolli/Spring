package com.ranadheer.dao;

import com.ranadheer.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> query = session.createQuery("from Customer",Customer.class);

        // execute query and get result list

        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public void saveorUpdateCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        try{
                session.saveOrUpdate(customer);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class,id);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class,id);
        session.delete(customer);


    }
}
