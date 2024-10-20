package mvvm.email.addEmail;

import mvvm.email.dto.Email;

import java.util.Scanner;

public class AddEmail {
    AddEmailViewModel addEmailViewModel;
    Scanner sc;
    public AddEmail(){
        addEmailViewModel = new AddEmailViewModel(this);
        sc = new Scanner(System.in);
    }

    public void getEmail(){
        String from, to, subject, content, tag;
        System.out.println("Enter from email id:");
        from = sc.next();
        System.out.println("To email id:");
        to = sc.next();
        sc.nextLine();  // Consume the leftover newline
        System.out.println("Enter subject:");
        subject = sc.nextLine();
        System.out.println("Enter content:");
        content = sc.nextLine();

        Email email = new Email(from, to, subject, content);
        addEmailViewModel.addEmail(email);
    }
}
