package noarchi.bankapplication.customer;

public class Customer {
    public int custId;
    int accountNo;
    String name;
    public double balance;
    String encryptPwd;

    public Customer(int custId, int accountNo, String name, double balance, String encryptPwd) {
        this.custId = custId;
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
        this.encryptPwd = encryptPwd;
    }

    @Override
    public String toString() {
        return this.custId+" "+this.accountNo+" "+this.name+" "+this.balance+" "+this.encryptPwd;
    }
}
