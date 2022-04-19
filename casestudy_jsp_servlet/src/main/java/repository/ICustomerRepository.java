package repository;

import model.Customer;

public interface ICustomerRepository extends ICRUDRepository<Customer> {

    void add(Customer customer);
}
