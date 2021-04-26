/*

public class Transaction {
    private final double transactionRate = 0.035;

    private long accountID;
    private String accountName;
    private double availableBalances;
    private double addMoney;
    private double subMoney;
    static private double subMoneyFee;
    static private double interestRate;

    public Transaction(){}

    public Transaction(long l, String s){
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


 */