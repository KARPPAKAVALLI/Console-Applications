package mvvm.email.tags;

import mvvm.email.repository.EmailRepository;

class AddTagViewModel {
    AddTag addTag;
    EmailRepository emailRepository;
    public AddTagViewModel(AddTag addTag) {
        this.addTag = addTag;
        emailRepository = EmailRepository.getInstance();
    }

    public void addImpTag(int id){
        emailRepository.markImpTag(id);
    }
}
