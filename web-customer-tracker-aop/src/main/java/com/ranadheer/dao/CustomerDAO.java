package com.ranadheer.dao;

import com.ranadheer.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    void saveorUpdateCustomer(Customer customer);

    public Customer getCustomer(int id);

    void deleteCustomer(int id);
}
