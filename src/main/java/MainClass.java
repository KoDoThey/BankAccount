import java.io.InputStream;

public class MainClass {
    long accountID;
    String accountName;
    double availableBalances;
    double addMoney;
    double subMoney;
    double subMoneyFee;
    double interestRate;

    MainClass input = new MainClass(System.in);

    public MainClass(InputStream in) {
        accountID = input.nextLong();
        accountName = input.nextLine();//Cannot resolve nextLine in MainClass
        availableBalances = input.availableBalances;//IDE suggest
    }
}
