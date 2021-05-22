package vn.vccorp.learning.platform;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdateMysql {
    public void updateTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String sqlInsert = "INSERT INTO account(accountID, accountName, availableBalances) VALUE('0004', 'Nguyễn 0004', 201230);";
        int numberRowsAffected = 0;
        try {
            numberRowsAffected = stmt.executeUpdate(sqlInsert);
            //public int executeUpdate (String stmt);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (numberRowsAffected == 0) {
            System.out.println("insertion failed");
        } else {
            System.out.println("inserted successfully");
        }

        stmt.close();
    }
}
