package vn.vccorp.learning;

import vn.vccorp.learning.model.Account;
import vn.vccorp.learning.platform.JdbcQuerryMysql;
import vn.vccorp.learning.platform.JdbcUpdateMysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static vn.vccorp.learning.platform.JdbcConnectionMysql.getJdbcConnectionMysql;

public class MainClass {

    public static void main(String[] args) throws SQLException {

        Connection connection = getJdbcConnectionMysql();
        if (connection != null){
            System.out.println("Kết nối thành công");
        } else System.out.println("Kết nối thất bại");

        //Connection viewTable(connection);

        JdbcQuerryMysql jdbcQuerryMysql = new JdbcQuerryMysql();
        jdbcQuerryMysql.viewTable(connection);

        //JdbcUpdateMysql jdbcUpdateMysql = new JdbcUpdateMysql();
        //jdbcUpdateMysql.updateTable(connection);

        System.exit(0);


        long accountID;
        Account acctest1 = new Account(1, "Nguyễn Văn Test", 1000);
        //System.out.println(acctest1.toString());

        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Nhập STK: ");
            accountID = sc.nextLong();
            if (accountID <= 0 || accountID == acctest1.getAccountID()){
                if (accountID <= 0)
                    System.out.println("Số tài khoản phải lớn hơn 0");
                else
                    System.out.println("Số tài khoản đã tồn tại");
                System.out.println("Bạn có muốn nhập lại không? 1.Có 2.Không");
                int choiceAgain = sc.nextInt();
                switch (choiceAgain) {
                    case 1:
                        System.out.println("Nhap 1 a");
                        continue;
                    case 2:
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không hợp lệ");
                }
            }
        } while ((accountID == acctest1.getAccountID() || accountID <= 0));
            System.out.print("Nhập tên tài khoản: ");
            String accountName = sc.next();
            System.out.print("Nhập số dư: ");
            double availableBalances = sc.nextDouble();
            Account acc1 = new Account(accountID, accountName, availableBalances);
            System.out.println(acc1.toString());

            System.out.print("\nBạn muốn: \n1. Nạp tiền \n2. Rút tiền \n3. Đáo hạn \n4. Chuyển khoản\n");
            int choiceTranaction = sc.nextInt();
            switch (choiceTranaction) {
                case 1:
                    System.out.print("Nhập số tiền muốn nạp: ");
                    double addMoney = sc.nextDouble();
                    if (addMoney <= 0) {
                        System.out.print("Số tiền không hợp lệ!");
                        break;
                    } else {
                        acc1.ComeIn(addMoney);
                        System.out.println(acc1.toString());
                        break;
                    }
                case 2:
                    System.out.print("Nhập số tiền muốn rút: ");
                    double subMoney = sc.nextDouble();
                    acc1.ComeOut(subMoney);
                    System.out.println(acc1.toString());
                    break;
                case 3:
                    acc1.Mature();
                    System.out.println(acc1.toString());
                    break;
                case 4:
                    System.out.print("Nhập STK muốn chuyển tiền: ");
                    double transferAccount = sc.nextDouble();
                    if (transferAccount == acctest1.getAccountID()) {
                        System.out.print("Nhập số tiền muốn chuyển: ");
                        double transferMoney = sc.nextDouble();
                        acc1.TransferMoney(transferMoney);
                        System.out.println(acc1.toString());
                        if (0 <= transferMoney && transferMoney <= availableBalances) {
                            acctest1.ReceiveMoney(transferMoney);
                            System.out.println(acctest1.toString());
                        } else {
                            System.out.println("Số tiền nhập không hợp lệ");
                            System.out.println(acctest1.toString());
                        }
                        break;
                    } else {
                        System.out.println("Tài khoản không tồn tại");
                        break;
                    }
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
    }
}