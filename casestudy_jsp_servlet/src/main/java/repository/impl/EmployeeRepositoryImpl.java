package repository.impl;


import model.Employee;
import repository.BaseRepository;
import repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private static final String SELECT_ALL_EMPLOYEES = "select ma_nhan_vien,ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri, ma_trinh_do, ma_bo_phan from nhan_vien";
    private static final String ADD_EMPLOYEE_SQL = "INSERT INTO nhan_vien (ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri, ma_trinh_do, ma_bo_phan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select ma_nhan_vien,ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri, ma_trinh_do, ma_bo_phan from nhan_vien where ma_nhan_vien =?";
    private static final String DELETE_EMPLOYEES_SQL = "delete from nhan_vien where ma_nhan_vien = ?;";



    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Employee> getList() {
        PreparedStatement preparedStatement = null;
        List<Employee> employeeList = new ArrayList<>();
        try {
            preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_ALL_EMPLOYEES);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = null;
            while (resultSet.next()) {
                employee = new Employee();
//                select ma_khach_hang,ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi from khach_hang
                employee.setEmployeeId(resultSet.getInt("ma_nhan_vien"));
                employee.setEmployeeName(resultSet.getString("ho_ten"));
                employee.setEmployeeBirthday(resultSet.getString("ngay_sinh"));
                employee.setEmployeeIdCard(resultSet.getString("so_cmnd"));
                employee.setEmployeeSalary(resultSet.getDouble("luong"));
                employee.setEmployeePhone(resultSet.getString("so_dien_thoai"));
                employee.setEmployeeEmail(resultSet.getString("email"));
                employee.setEmployeeAddress(resultSet.getString("dia_chi"));
                employee.setEmployeePositionId(resultSet.getInt("ma_vi_tri"));
                employee.setEmployeeEducationDegreeId(resultSet.getInt("ma_trinh_do"));
                employee.setEmployeeDivisionId(resultSet.getInt("ma_bo_phan"));
                employeeList.add(employee);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void add(Employee employee) {
        System.out.println(ADD_EMPLOYEE_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(ADD_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getEmployeePositionId());
            preparedStatement.setInt(9, employee.getEmployeeEducationDegreeId());
            preparedStatement.setInt(10, employee.getEmployeeDivisionId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> searchByNamePositionEmail(String keywordName, String keywordPosition, String keywordEmail) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Employee> employees = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = baseRepository.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.
                     prepareStatement("select * from nhan_vien  where ho_ten like ? and cast(ma_vi_tri as char ) like ? and email like ?");) {
            preparedStatement.setString(1, "%" + keywordName + "%");
            preparedStatement.setString(2, keywordPosition);
            preparedStatement.setString(3, "%" + keywordEmail + "%");
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int employeeId = rs.getInt("ma_nhan_vien");
                String employeeName = rs.getString("ho_ten");
                String employeeBirthday = rs.getString("ngay_sinh");
                String employeeIdCard = rs.getString("so_cmnd");
                Double employeeSalary = rs.getDouble("luong");
                String employeePhone = rs.getString("so_dien_thoai");
                String employeeEmail = rs.getString("email");
                String employeeAddress = rs.getString("dia_chi");
                Integer employeePositionId = rs.getInt("ma_vi_tri");
                Integer employeeEducationDegreeId = rs.getInt("ma_trinh_do");
                Integer employeeDivisionId = rs.getInt("ma_bo_phan");
                employees.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, employeePositionId, employeeEducationDegreeId, employeeDivisionId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        // Step 1: Establishing a Connection
        try (Connection connection = baseRepository.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int employeeId = rs.getInt("ma_nhan_vien");
                String employeeName = rs.getString("ho_ten");
                String employeeBirthday = rs.getString("ngay_sinh");
                String employeeIdCard = rs.getString("so_cmnd");
                Double employeeSalary = rs.getDouble("luong");
                String employeePhone = rs.getString("so_dien_thoai");
                String employeeEmail = rs.getString("email");
                String employeeAddress = rs.getString("dia_chi");
                Integer employeePositionId = rs.getInt("ma_vi_tri");
                Integer employeeEducationDegreeId = rs.getInt("ma_trinh_do");
                Integer employeeDivisionId = rs.getInt("ma_bo_phan");
                employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, employeePositionId, employeeEducationDegreeId, employeeDivisionId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = baseRepository.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEES_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
