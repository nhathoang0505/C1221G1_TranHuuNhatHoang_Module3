package repository.impl;

import model.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private static final String SELECT_ALL_CUSTOMERS = "select ma_khach_hang,ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi from khach_hang";
    private static final String ADD_CUSTOMER_SQL = "INSERT INTO khach_hang (ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Customer> getList() {
        PreparedStatement preparedStatement = null;
        List<Customer> customerList = new ArrayList<>();
        try {
            preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            while (resultSet.next()) {
                customer = new Customer();
//                select ma_khach_hang,ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi from khach_hang
                customer.setCustomerId(resultSet.getInt("ma_khach_hang"));
                customer.setCustomerTypeId(resultSet.getInt("ma_loai_khach"));
                customer.setCustomerName(resultSet.getString("ho_ten"));
                customer.setCustomerBirthday(resultSet.getString("ngay_sinh"));
                customer.setCustomerGender(resultSet.getByte("gioi_tinh"));
                customer.setCustomerIdCard(resultSet.getString("so_cmnd"));
                customer.setCustomerPhone(resultSet.getString("so_dien_thoai"));
                customer.setCustomerEmail(resultSet.getString("email"));
                customer.setCustomerAddress(resultSet.getString("dia_chi"));
                customerList.add(customer);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void add(Customer customer) {
        System.out.println(ADD_CUSTOMER_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(ADD_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setByte(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
