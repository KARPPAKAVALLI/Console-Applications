package mvvm.email.deleteEmail;

import java.util.Scanner;

public class DeleteEmail {
    DeleteEmailViewModel deleteEmailViewModel;
    Scanner sc;
    public DeleteEmail(){
        deleteEmailViewModel = new DeleteEmailViewModel(this);
        sc = new Scanner(System.in);
    }
    public void getId(){
        System.out.println("Enter id to delete:");
        deleteEmailViewModel.deleteEmail(sc.nextInt());
    }
}
