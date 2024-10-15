package noarchi.bankapplication;

import noarchi.bankapplication.bank.AccountActionHandler;
import noarchi.bankapplication.bank.Bank;
import noarchi.bankapplication.customer.CustomerFileHandler;
import noarchi.bankapplication.customer.CustomerHandler;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        CustomerFileHandler.getInstance().initialize();
        Scanner sc = new Scanner(System.in);
        outer:
        while (true){
            System.out.println("1. Add customer\n2. Cash Deposit\n3. Withdrawal\n4. Money Transfer");
            System.out.println("Enter choice: ");
            int choice = sc.nextInt();
            CustomerHandler handler = new CustomerHandler();
            AccountActionHandler accountActionHandler = new AccountActionHandler();
            int customerId;
            switch (choice){
                case 1:
                    handler.addCustomer();
                    break;
                case 2:
                    System.out.println("Enter customer ID");
                    customerId= sc.nextInt();
                    if(handler.authenticateCustomer(customerId)){
                        System.out.println("Enter Deposit amount");
                        double amount = sc.nextDouble();
                        accountActionHandler.deposit(customerId,amount);
                    }
                    break;
                case 3:
                    System.out.println("Enter customer ID");
                    customerId = sc.nextInt();
                    if(handler.authenticateCustomer(customerId)){
                        System.out.println("Enter withdraw amount");
                        double amount = sc.nextDouble();
                        accountActionHandler.withdraw(customerId,amount);
                    }
                    break;
                case 4:
                    System.out.println("Enter source customer ID");
                    int customerIdSrc = sc.nextInt();

                    if(handler.authenticateCustomer(customerIdSrc)){
                        System.out.println("Enter destination customer ID");
                        int customerIdDest = sc.nextInt();
                        if (handler.authenticateCustomer(customerIdDest)){
                            System.out.println("Enter withdraw amount");
                            double amount = sc.nextDouble();
                            accountActionHandler.transfer(customerIdSrc,customerIdDest,amount);
                        }
                    }
                    break;
                default:
                    break outer;
            }
        }
        System.out.println(Bank.customers);
    }
}
