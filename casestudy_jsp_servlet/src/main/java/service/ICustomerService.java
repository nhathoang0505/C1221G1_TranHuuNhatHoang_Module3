package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> getList();

    void add(Customer customer);
}
