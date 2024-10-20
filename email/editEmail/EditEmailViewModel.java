package mvvm.email.editEmail;

import mvvm.email.repository.EmailRepository;

public class EditEmailViewModel {
    public EditEmail editEmail;
    private EmailRepository emailRepository;
    public EditEmailViewModel(EditEmail editEmail) {
        this.editEmail = editEmail;
        emailRepository = EmailRepository.getInstance();
    }

    public void editEmail(int id, String find, String replace){
        emailRepository.editContent(id, find, replace);
    }
}
