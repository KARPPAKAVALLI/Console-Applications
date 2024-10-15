package noarchi.bankapplication.transaction;

import java.io.*;

public class TransactionHandler {

    private static TransactionHandler transactionHandler;
    private TransactionHandler(){

    }

    public static TransactionHandler getTransactionHandlerInstance(){
        if(transactionHandler == null)
            transactionHandler = new TransactionHandler();
        return transactionHandler;
    }
    public void addTransactionDetails(int customerId, Transaction transaction){
        String filePath = "C:\\Users\\VALLI MALAR\\IdeaProjects\\Zoho LLD\\src\\noarchi\\bankapplication\\transaction\\transactionfiles\\"+customerId+"transaction.txt";
        File transactionFile = new File(filePath);
        try{
            if(!transactionFile.exists()){
                if(transactionFile.createNewFile()){
                    FileWriter fw = new FileWriter(transactionFile,true);
                    BufferedWriter writer = new BufferedWriter(fw);
                    writer.write(transaction.toString());
                    writer.newLine();
                    writer.close();
                    fw.close();
                }
                else {
                    System.out.println("file not found");
                }
            }

        }
        catch (IOException e) {

        }
    }
    public int getLastTransactionId(int customerId){
        String filePath = "C:\\Users\\VALLI MALAR\\IdeaProjects\\Zoho LLD\\src\\noarchi\\bankapplication\\transaction\\transactionfiles\\"+customerId+"transaction.txt";
        try{
            FileReader fr = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fr);
            String line = String.valueOf(reader.readLine());
            String line2 = "";
            while (line!=null){
                line2 = line;
                line = reader.readLine();
            }
            reader.close();
            fr.close();
            return Integer.parseInt(line2.split("\t")[0]);
        }
        catch (IOException e) {
            //System.out.println(e.getMessage());
        }
        return 0;
    }
}
