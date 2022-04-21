package repository.impl;

import model.Division;
import model.Position;
import repository.BaseRepository;
import repository.IDivisionRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImpl implements IDivisionRepository {
    private static final String SELECT_ALL_EMPLOYEES = "select ma_bo_phan,ten_bo_phan from bo_phan";
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Division> getList() {
        PreparedStatement preparedStatement = null;
        List<Division> divisionList = new ArrayList<>();
        try {
            preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_ALL_EMPLOYEES);
            ResultSet resultSet = preparedStatement.executeQuery();
            Division division = null;
            while (resultSet.next()) {
                division = new Division();
//                select ma_khach_hang,ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi from khach_hang
                division.setDivisionId(resultSet.getInt("ma_bo_phan"));
                division.setDivisionName(resultSet.getString("ten_bo_phan"));
                divisionList.add(division);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisionList;
    }
}
