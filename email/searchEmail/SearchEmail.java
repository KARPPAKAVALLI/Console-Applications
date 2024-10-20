package mvvm.email.searchEmail;

import mvvm.email.dto.Email;

import java.util.List;
import java.util.Scanner;

public class SearchEmail {
    private SearchEmailViewModel searchEmailViewModel;
    Scanner sc;
    public SearchEmail(){
        searchEmailViewModel = new SearchEmailViewModel(this);
        sc= new Scanner(System.in);
    }

    public void getKeywords(){
        System.out.println("Enter keywords to search:");
        searchEmailViewModel.searchResults(sc.nextLine());
    }

    public void printSearchResults(List<Email> emails){
        for (Email email : emails)
            System.out.println(email);
    }
}
