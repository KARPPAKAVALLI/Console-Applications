package mvvm.email.deleteEmail;

import mvvm.email.repository.EmailRepository;

class DeleteEmailViewModel {
    DeleteEmail deleteEmail;
    EmailRepository emailRepository;
    public DeleteEmailViewModel(DeleteEmail deleteEmail){
        this.deleteEmail = deleteEmail;
        emailRepository = EmailRepository.getInstance();
    }

    public void deleteEmail(int id){
        emailRepository.handleEmailDeletion(id);
    }
}
