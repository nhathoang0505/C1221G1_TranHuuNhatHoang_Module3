package service.impl;

import model.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> getList() {
        return employeeRepository.getList();
    }

    @Override
    public void add(Employee employee) {
        employeeRepository.add(employee);
    }

    @Override
    public List<Employee> searchByNamePositionEmail(String keywordName, String keywordPosition, String keywordEmail) {
        return employeeRepository.searchByNamePositionEmail(keywordName,keywordPosition,keywordEmail);
    }


    @Override
    public Employee selectEmployee(int id) {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        employeeRepository.deleteEmployee(id);
    }
}
