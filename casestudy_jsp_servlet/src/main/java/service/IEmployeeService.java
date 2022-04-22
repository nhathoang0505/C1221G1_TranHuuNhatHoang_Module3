package service;

import model.Employee;
import repository.IEmployeeRepository;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {

    List<Employee> getList();

    void add(Employee employee);

    List<Employee> searchByNamePositionEmail(String keywordName,String keywordPosition,String keywordEmail);

    Employee selectEmployee(int id);

    void deleteEmployee(int id) throws SQLException;
}
