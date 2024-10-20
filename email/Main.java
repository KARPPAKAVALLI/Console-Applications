package mvvm.email;

import mvvm.email.addEmail.AddEmail;
import mvvm.email.deleteEmail.DeleteEmail;
import mvvm.email.displayEmail.DisplayEmail;
import mvvm.email.editEmail.EditEmail;
import mvvm.email.searchEmail.SearchEmail;
import mvvm.email.tags.AddTag;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Add Email\n2. Display Emails\n3. Delete Eamil\n4. Search Email\n5. Edit Email\n6. Add Important tag\n7. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    AddEmail addEmail = new AddEmail();
                    addEmail.getEmail();
                }
                case 2 -> new DisplayEmail().getEmailList();
                case 3 -> {
                    DeleteEmail deleteEmail = new DeleteEmail();
                    deleteEmail.getId();
                    new DisplayEmail().getEmailList();
                }
                case 4 -> {
                    SearchEmail searchEmail = new SearchEmail();
                    searchEmail.getKeywords();
                }
                case 5 -> {
                    EditEmail editEmail = new EditEmail();
                    editEmail.getIdToEdit();
                    new DisplayEmail().getEmailList();
                }
                case 6 -> {
                    AddTag addTag = new AddTag();
                    addTag.getInput();
                    new DisplayEmail().getEmailList();
                }
                case 7 -> System.exit(0);
            }
        }while (choice != 7);
    }
}
