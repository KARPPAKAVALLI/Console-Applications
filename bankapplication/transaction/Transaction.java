package noarchi.bankapplication.transaction;

public class Transaction {
    int transactionId;
    TransactionType type;
    double amount;
    double balance;

    public Transaction(int transactionId, TransactionType type, double amount, double balance) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return transactionId +
                "\t" + type +
                "\t" + amount +
                "\t"+ balance;
    }
}
