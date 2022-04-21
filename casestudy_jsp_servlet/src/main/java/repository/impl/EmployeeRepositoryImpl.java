package repository.impl;

import model.Customer;
import model.Employee;
import repository.BaseRepository;
import repository.IEmployeeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private static final String SELECT_ALL_EMPLOYEES = "select ma_nhan_vien,ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri, ma_trinh_do, ma_bo_phan from nhan_vien";
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
                employee.setEmployeeBirthday(resultSet.getDate("ngay_sinh"));
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
}
