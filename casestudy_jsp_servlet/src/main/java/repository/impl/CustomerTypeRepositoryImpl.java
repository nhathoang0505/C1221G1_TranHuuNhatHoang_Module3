package repository.impl;

import model.Customer;
import model.CustomerType;
import repository.BaseRepository;
import repository.ICustomerTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements ICustomerTypeRepository {
    private static final String SELECT_ALL_CUSTOMERS = "select ma_loai_khach,ten_loai_khach from loai_khach";
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<CustomerType> getList() {
        PreparedStatement preparedStatement = null;
        List<CustomerType> customerTypeList = new ArrayList<>();
        try {
            preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerType customerType = null;
            while (resultSet.next()) {
                customerType = new CustomerType();
//                select ma_khach_hang,ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi from khach_hang
                customerType.setCustomerTypeId(resultSet.getInt("ma_loai_khach"));
                customerType.setCustomerTypeName(resultSet.getString("ten_loai_khach"));
                customerTypeList.add(customerType);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }
}
