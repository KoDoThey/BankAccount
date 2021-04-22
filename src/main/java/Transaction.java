public class Transaction {
    double transactionRate = 0.035;

    long accountID;
    String accountName;
    double availableBalances;
    double addMoney;
    double subMoney;
    double subMoneyFee;
    double interestRate;

    void Account(long l, String s){
        accountID = l;
        accountName = s;
        double availableBalances = 50;
    }

    public double ComeIn(double availableBalances, double addMoney){
        availableBalances = availableBalances + addMoney;
        return availableBalances;
    }

    public double ComeOut(double availableBalances, double subMoney){
        availableBalances = availableBalances - (subMoney + subMoneyFee);
        return availableBalances;
    }

    public double Mature(double availableBalances, double interestRate){
        availableBalances = availableBalances + availableBalances * interestRate;
        return availableBalances;
    }

    public void Transfer(){

    }
}
