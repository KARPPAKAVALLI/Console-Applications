package mvvm.email.model;

import mvvm.email.dto.Email;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EmailFile {
    private static EmailFile emailFileInstance;
    private String fileName = "Emails.txt";
    File emailFile;
    private EmailFile(){
        emailFile = new File(fileName);
    }

    public static EmailFile getInstance() {
        if(emailFileInstance == null)
            emailFileInstance = new EmailFile();
        return emailFileInstance;
    }

    public void addNewEmail(Email email){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(emailFile, true))){
            writer.write(email.toString());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void eraseFileContent(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(emailFile))){
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
