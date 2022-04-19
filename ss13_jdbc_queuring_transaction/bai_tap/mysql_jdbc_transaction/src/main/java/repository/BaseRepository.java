package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/demo";
    private String username = "root";
    private String password = "nhathoang";
    private Connection connection;

    //Cách 1: tạo ra kết nối database xuyên suốt đến khi đóng. Nhược điểm: tiêu tốn tài nguyên
    public BaseRepository() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
    }

    //Cách 2: tạo ra 1 phương thức kết nối DB mỗi lần gọi.
    // Tuy nhiên cần phải đóng sau mỗi lần sử dụng(vì nhiều quá có thể gây sập)
    public Connection getConnectionJavaToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

        //Cách 1
//        return connection;
    }
}