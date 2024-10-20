package mvvm.email.displayEmail;

import mvvm.email.dto.Email;
import mvvm.email.repository.EmailRepository;

import java.util.ArrayList;
import java.util.List;

class DisplayEmailModelView {
    DisplayEmail displayEmail;
    EmailRepository emailRepository;
    public DisplayEmailModelView(DisplayEmail displayEmail) {
        this.displayEmail = displayEmail;
        emailRepository = EmailRepository.getInstance();
    }

    //OPTION 1
    public void getAllEmailList(){
        List<Email> emails = emailRepository.getAllEmail();
        displayEmail.printEmail(emails);
    }

    //OPTION 2
    public void getEmailList(){
        List<Email> emails = new ArrayList<>();
        Email temp = emailRepository.getFirstEmail();
        while (temp != null){
            emails.add(temp);
            int nextId = temp.getId();
            temp = emailRepository.getNextEmail(nextId);
        }
        displayEmail.printEmail(emails);
    }
}
