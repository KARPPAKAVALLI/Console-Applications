package noarchi.bankapplication.customer;

import noarchi.bankapplication.bank.Bank;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class CustomerFileHandler {
    private static final String filename="src/noarchi/bankapplication/customer/bank_db.txt";
    public static CustomerFileHandler customerFileHandler;

    public static CustomerFileHandler getInstance(){
        if(customerFileHandler==null){
            customerFileHandler=new CustomerFileHandler();
        }
        return customerFileHandler;
    }
    public void initialize() throws IOException{
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<Customer> customers=new ArrayList<>();
        while (reader.ready()){
            String [] customerInfo=((String)(reader.readLine())).split(" ");
            Customer c = stringToCustomer(customerInfo,customers);
            customers.add(c);
            Bank.customerMap.put(c.custId,c);
        }
        //Don't create a new obj -> since, not crct to create a bank obj in CustomerFileHandler cls (it doesn't make sense)
        Bank.customers=customers;
        if (Bank.customers.size()>0){
            Bank.refCustomerId=Bank.customers.get(customers.size()-1).custId;
            Bank.refAccountNo=Bank.customers.get(customers.size()-1).accountNo;
            Bank.refCustomerId++;
            Bank.refAccountNo++;
        }

    }
    private Customer stringToCustomer(String[]customerInfo,ArrayList<Customer> customers){
        Customer c=new Customer(Integer.parseInt(customerInfo[0]),Integer.parseInt(customerInfo[1]),customerInfo[2],
                Float.parseFloat(customerInfo[3]),customerInfo[4]);
        return c;
    }
    public void addCustomerToFile(Customer c) throws IOException{
        BufferedWriter writer=new BufferedWriter(new FileWriter(filename,true));
        writer.newLine();
        writer.write(c.toString());
        writer.close();
    }

    public void
    updateFile(){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(filename))){
            for(Map.Entry<Integer, Customer> e : Bank.customerMap.entrySet()){
                writer.write(e.getValue().toString());
                writer.newLine();
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
