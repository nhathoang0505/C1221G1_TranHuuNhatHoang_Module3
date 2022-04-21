package service;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {

    List<Customer> getList();

    void add(Customer customer);

    List<Customer> searchByName(String keyword);

    Customer selectCustomer(int id);

    void updateCustomer(Customer updateCustomer) throws SQLException;

    void deleteCustomer(int id) throws SQLException;
}
