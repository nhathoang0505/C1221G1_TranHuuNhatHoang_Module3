package repository.impl;

import model.CustomerType;
import model.Position;
import repository.BaseRepository;
import repository.IPositionRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements IPositionRepository {
    private static final String SELECT_ALL_EMPLOYEES = "select ma_vi_tri,ten_vi_tri from vi_tri";
    BaseRepository baseRepository = new BaseRepository();

    public List<Position> getList() {
        PreparedStatement preparedStatement = null;
        List<Position> positionList = new ArrayList<>();
        try {
            preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_ALL_EMPLOYEES);
            ResultSet resultSet = preparedStatement.executeQuery();
            Position position = null;
            while (resultSet.next()) {
                position = new Position();
//                select ma_khach_hang,ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi from khach_hang
                position.setPositionId(resultSet.getInt("ma_vi_tri"));
                position.setPositionName(resultSet.getString("ten_vi_tri"));
                positionList.add(position);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }
}