package service;

import model.Employee;
import repository.IEmployeeRepository;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getList();
}
