package noarchi.bankapplication.bank;

import noarchi.bankapplication.customer.Customer;
import noarchi.bankapplication.customer.CustomerFileHandler;
import noarchi.bankapplication.transaction.Transaction;
import noarchi.bankapplication.transaction.TransactionHandler;
import noarchi.bankapplication.transaction.TransactionType;

public class AccountActionHandler {
    public void deposit(int customerId , double amount){
        Customer c = Bank.customerMap.get(customerId);
        c.balance+=amount;
        CustomerFileHandler.getInstance().updateFile();
        TransactionHandler transactionHandler = TransactionHandler.getTransactionHandlerInstance();
        Transaction t = new Transaction(transactionHandler.getLastTransactionId(c.custId)+1, TransactionType.valueOf("DEPOSIT"),amount,c.balance);
        transactionHandler.addTransactionDetails(c.custId,t);
    }

    public boolean withdraw(int customerId, double amount){
        Customer c = Bank.customerMap.get(customerId);
        if(c.balance>1000){
            c.balance-=amount;
            CustomerFileHandler.getInstance().updateFile();
            Transaction t = new Transaction(TransactionHandler.getTransactionHandlerInstance().getLastTransactionId(c.custId)+1, TransactionType.valueOf("WITHDRAW"),amount,c.balance);
            TransactionHandler.getTransactionHandlerInstance().addTransactionDetails(c.custId,t);
            return true;
        }
        return false;
    }

    public void transfer(int customerId1, int customerId2, double amount){
        withdraw(customerId1,amount);
        deposit(customerId2,amount);
    }
}
