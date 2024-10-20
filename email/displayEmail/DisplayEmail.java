package mvvm.email.displayEmail;

import mvvm.email.dto.Email;

import java.util.List;

public class DisplayEmail {
    private DisplayEmailModelView displayEmailModelView;
    public DisplayEmail(){
        displayEmailModelView = new DisplayEmailModelView(this);
    }

    public void getEmailList(){
        //OPTION 1:
        displayEmailModelView.getAllEmailList();
        //OPTION 2:
        displayEmailModelView.getEmailList();
    }

    public void printEmail(List<Email> emails){
        for(Email email : emails){
            System.out.println(email);
        }
    }
}
