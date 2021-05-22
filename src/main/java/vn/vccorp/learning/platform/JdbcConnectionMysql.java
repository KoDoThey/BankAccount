package vn.vccorp.learning.platform;

import java.sql.*;

public class JdbcConnectionMysql {
    public static Connection getJdbcConnectionMysql(){
        final String url = "jdbc:mysql://localhost:3306/bankAccount";
        final String user = "root";
        final String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load Driver
            return DriverManager.getConnection(url, user, password); //open connection
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
