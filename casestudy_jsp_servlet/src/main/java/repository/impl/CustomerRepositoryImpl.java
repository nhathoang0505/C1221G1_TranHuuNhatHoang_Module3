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
    private static final String SELECT_CUSTOMER_BY_ID = "select ma_khach_hang,ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi from khach_hang where ma_khach_hang =?";
    private static final String UPDATE_CUSTOMERS_SQL = "update khach_hang set ma_loai_khach = ?,ho_ten= ?, ngay_sinh =?, gioi_tinh =?, so_cmnd =?, so_dien_thoai =?, email =?, dia_chi =? where ma_khach_hang = ?;";
    private static final String DELETE_USERS_SQL = "delete from khach_hang where ma_khach_hang = ?;";
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

    @Override
    public List<Customer> searchCustomerByName(String keyword) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Customer> customers = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = baseRepository.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.
                     prepareStatement("select * from khach_hang  where ho_ten like ?");) {
            preparedStatement.setString(1, "%" + keyword + "%");
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int customerId = rs.getInt("ma_khach_hang");
                int customerTypeId = rs.getInt("ma_loai_khach");
                String customerName = rs.getString("ho_ten");
                String customerBirthday = rs.getString("ngay_sinh");
                Byte customerGender = rs.getByte("gioi_tinh");
                String customerIdCard = rs.getString("so_cmnd");
                String customerPhone = rs.getString("so_dien_thoai");
                String customerEmail = rs.getString("email");
                String customerAddress = rs.getString("dia_chi");
                customers.add(new Customer(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        // Step 1: Establishing a Connection
        try (Connection connection = baseRepository.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int customerId = rs.getInt("ma_khach_hang");
                int customerTypeId = rs.getInt("ma_loai_khach");
                String customerName = rs.getString("ho_ten");
                String customerBirthday = rs.getString("ngay_sinh");
                Byte customerGender = rs.getByte("gioi_tinh");
                String customerIdCard = rs.getString("so_cmnd");
                String customerPhone = rs.getString("so_dien_thoai");
                String customerEmail = rs.getString("email");
                String customerAddress = rs.getString("dia_chi");
                customer = new Customer(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    @Override
    public boolean updateCustomer(Customer updateCustomer) throws SQLException {
        boolean rowUpdated;
        System.out.println(updateCustomer);
        try (Connection connection = baseRepository.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMERS_SQL);) {
            statement.setInt(1, updateCustomer.getCustomerTypeId());
            statement.setString(2, updateCustomer.getCustomerName());
            statement.setString(3, updateCustomer.getCustomerBirthday());
            statement.setByte(4, updateCustomer.getCustomerGender());
            statement.setString(5, updateCustomer.getCustomerIdCard());
            statement.setString(6, updateCustomer.getCustomerPhone());
            statement.setString(7, updateCustomer.getCustomerEmail());
            statement.setString(8, updateCustomer.getCustomerAddress());
            statement.setInt(9, updateCustomer.getCustomerId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = baseRepository.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
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
