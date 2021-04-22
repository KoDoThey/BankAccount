
public class Account {
    long accountID;
    String accountName;
    double availableBalances;

    Account(){};

    void ParameterizedConstructor(long l, String s, double d){
        accountID = l;
        accountName = s;
        availableBalances = d;
    }

    public long getAccountID(){
        return accountID;
    }

    public void setAccountID(long accountID){
        this.accountID = accountID;
    }

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
        return "This account ID: " + this.accountID + ", Account name: " + this.accountName + ", Available Balances: " + this.availableBalances;
    }

}
