
public class Account {
    private long accountID;
    private String accountName;
    private double availableBalances;

    private double addMoney;
    private double subMoney;
    private double matureMoney;
    private double transferMoney;
    private final double subMoneyFee = 0.01;
    private final double interestRate = 0.035;

    public Account(){};

    public Account(long l, String s, double d){
        accountID = l;
        accountName = s;
        availableBalances = d;
    }

    public Account(long l, String s){
        accountID = l;
        accountName = s;
        double availableBalances = 50;
    }

    public long getAccountID(){ return accountID; }

    public void setAccountID(long accountID){ this.accountID = accountID; }

    public String getAccountName(){
        return accountName;
    }

    public void setAccountName(String accountName){
        this.accountName = accountName;
    }

    public double getAvailableBalances(){
        return availableBalances;
    }

    public void setAvailableBalances(double availableBalances){
        this.availableBalances = availableBalances;
    }

    public String toString(){
        return "STK: " + this.accountID + ",Tên TK: " + this.accountName + ", Số dư: $" + availableBalances;
    }

    public void ComeIn(double addMoney){
        if (subMoney < 0) {
            System.out.println("Số tiền nhập không hợp lệ");
        } else {
            availableBalances += addMoney;
        }
    }

    public void ComeOut(double subMoney){
        if (subMoney < 0) {
            System.out.println("Số tiền nhập không hợp lệ");
        } else if(subMoney >= availableBalances){
            System.out.println("Số dư không đủ!");
        } else{
            availableBalances = availableBalances - (subMoney + subMoneyFee);
        }
    }

    public void Mature(){
        availableBalances += availableBalances * interestRate;
    }

    public void TransferMoney(double transferMoney){
        if (transferMoney < 0) {
            System.out.println("Số tiền nhập không hợp lệ");
        }else if(transferMoney > availableBalances){
            System.out.println("Số dư không đủ!");
        } else{
            availableBalances -= transferMoney;
        }
    }

    public void ReceiveMoney(double transferMoney){
        availableBalances += transferMoney;
    }
}
