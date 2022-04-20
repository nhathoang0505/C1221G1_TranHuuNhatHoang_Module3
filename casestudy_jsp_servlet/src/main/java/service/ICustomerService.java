package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> getList();

    void add(Customer customer);

    List<Customer> searchByName(String keyword);

    Customer selectCustomer(int id);

    void updateCustomer(Customer updateCustomer);
}
