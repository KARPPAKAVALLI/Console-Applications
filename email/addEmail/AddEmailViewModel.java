package mvvm.email.addEmail;

import mvvm.email.dto.Email;
import mvvm.email.repository.EmailRepository;

class AddEmailViewModel {
    AddEmail addEmailView;
    EmailRepository emailRepository;
    AddEmailViewModel(AddEmail addEmailView){
        this.addEmailView = addEmailView;
        emailRepository = EmailRepository.getInstance();
    }

    public void addEmail(Email email) {
        emailRepository.handleEmailAddition(email);
    }
}
