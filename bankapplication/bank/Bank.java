package noarchi.bankapplication.bank;

import noarchi.bankapplication.customer.Customer;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    public static ArrayList<Customer> customers;
    public static HashMap<Integer,Customer> customerMap = new HashMap<>();
    public static int refCustomerId;
    public static int refAccountNo;
    public static final double INITIAL_BALANCE=10000;

}
