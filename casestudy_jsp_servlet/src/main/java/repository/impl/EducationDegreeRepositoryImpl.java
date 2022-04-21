package repository.impl;

import model.EducationDegree;
import model.Position;
import repository.BaseRepository;
import repository.IEducationDegreeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepositoryImpl implements IEducationDegreeRepository {
    private static final String SELECT_ALL_EMPLOYEES = "select ma_trinh_do, ten_trinh_do from trinh_do";
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<EducationDegree> getList() {
        PreparedStatement preparedStatement = null;
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        try {
            preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_ALL_EMPLOYEES);
            ResultSet resultSet = preparedStatement.executeQuery();
            EducationDegree educationDegree = null;
            while (resultSet.next()) {
                educationDegree = new EducationDegree();
//                select ma_khach_hang,ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi from khach_hang
                educationDegree.setEducationDegreeId(resultSet.getInt("ma_trinh_do"));
                educationDegree.setEducationDegreeName(resultSet.getString("ten_trinh_do"));
                educationDegreeList.add(educationDegree);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegreeList;
    }
}
