package repository;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeRepository extends ICRUDRepository<Employee> {

    void add(Employee employee);

    List<Employee> searchByNamePositionEmail(String keywordName,String keywordPosition,String keywordEmail);

    Employee selectEmployee(int id);

    boolean deleteEmployee(int id) throws SQLException;
}
