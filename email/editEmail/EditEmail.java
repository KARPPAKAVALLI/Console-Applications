package mvvm.email.editEmail;

import java.util.Scanner;

public class EditEmail {
    private final EditEmailViewModel editEmailViewModel;
    Scanner sc;
    public EditEmail(){
        editEmailViewModel = new EditEmailViewModel(this);
        sc = new Scanner(System.in);
    }

    public void getIdToEdit(){
        System.out.println("Enter Id To Edit:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter find word:");
        String find = sc.nextLine();
        System.out.println("Enter replace word:");
        String replace = sc.nextLine();
        editEmailViewModel.editEmail(id, find, replace);
    }
}
