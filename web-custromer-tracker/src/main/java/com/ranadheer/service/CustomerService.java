package com.ranadheer.service;

import com.ranadheer.entity.Customer;

import java.util.List;

public interface CustomerService {
    public Customer getCustomer(int id);

    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    void deleteCustomer(int id);
}
