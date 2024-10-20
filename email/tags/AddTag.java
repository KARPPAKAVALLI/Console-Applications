package mvvm.email.tags;

import java.util.Scanner;

public class AddTag {
    Scanner sc;
    AddTagViewModel addTagViewModel;

    public AddTag(){
        addTagViewModel = new AddTagViewModel(this);
        sc= new Scanner(System.in);
    }

    public void getInput(){
        System.out.println("Enter id");
        addTagViewModel.addImpTag(sc.nextInt());
    }
}
