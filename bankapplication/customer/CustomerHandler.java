package noarchi.bankapplication.customer;

import noarchi.bankapplication.bank.Bank;
import noarchi.bankapplication.transaction.Transaction;
import noarchi.bankapplication.transaction.TransactionHandler;
import noarchi.bankapplication.transaction.TransactionType;

import java.util.Scanner;

public class CustomerHandler {
    public void addCustomer(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter your Name:");
        String name=sc.next();

        System.out.println("Enter Your Password:");
        String password=sc.next();

        System.out.println("Re-Type Your Password:");
        String reTyped=sc.next();

        if(!password.equals(reTyped)){
            System.out.println("Error!!! password doesnt match");
            return;
        }
        String encryptedPassword=getEncryptedPassword(password);
        Customer c=new Customer(Bank.refCustomerId,Bank.refAccountNo,name,Bank.INITIAL_BALANCE,encryptedPassword);
        Bank.refCustomerId++;
        Bank.refAccountNo++;
        Bank.customers.add(c);
        Bank.customerMap.put(c.custId,c);
        try {
            CustomerFileHandler.getInstance().addCustomerToFile(c);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        logTransactionToFile(c.custId);
    }
    private String getEncryptedPassword(String password){
        StringBuilder encrypted=new StringBuilder();
        for (int i=0;i<password.length();i++){
            if (password.charAt(i)=='z')
                encrypted.append('a');
            else
                encrypted.append((char)(password.charAt(i)+1));
        }
        return encrypted.toString();
    }

    public boolean authenticateCustomer(int enteredId){
        Scanner sc= new Scanner(System.in);
        if(!Bank.customerMap.containsKey(enteredId)){
            System.out.println("Id not found!!!");
            return false;
        }
        System.out.println("Enter Password:");
        String enteredPassword = getEncryptedPassword(sc.next());
        if(Bank.customerMap.get(enteredId).encryptPwd.equals(enteredPassword)){
            System.out.println("Customer validated successfully");
            return true;
        }
        else {
            System.out.println("Password Invalid");
            return false;
        }
    }

    private void logTransactionToFile(int customerId){
        Transaction t = new Transaction(1, TransactionType.valueOf("OPENING"),10000,10000);
        TransactionHandler.getTransactionHandlerInstance().addTransactionDetails(customerId,t);
    }
}
