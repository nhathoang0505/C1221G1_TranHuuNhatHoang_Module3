package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository extends ICRUDRepository<Customer> {

    void add(Customer customer);

    List<Customer> searchCustomerByName(String keyword);

    Customer selectCustomer(int id);

    boolean updateCustomer(Customer updateCustomer);
}
