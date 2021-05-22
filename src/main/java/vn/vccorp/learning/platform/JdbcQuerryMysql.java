package vn.vccorp.learning.platform;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcQuerryMysql {
    public void viewTable(Connection connection){
        try(Statement statement = connection.createStatement()){
            String querry = "select accountID, accountName, availableBalances from account";
            ResultSet resultSet = statement.executeQuery(querry);
            while (resultSet.next()){
                long accountID = resultSet.getLong("accountID");
                String accountName = resultSet.getString("accountName");
                double availableBalances = resultSet.getDouble("availableBalances");
                System.out.println("STK: " + accountID + ",Tên TK: " + accountName + ", Số dư: $" + availableBalances);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
