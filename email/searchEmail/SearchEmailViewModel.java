package mvvm.email.searchEmail;

import mvvm.email.repository.EmailRepository;

class SearchEmailViewModel {
    SearchEmail searchEmail;
    EmailRepository emailRepository;
    public SearchEmailViewModel(SearchEmail searchEmail) {
        this.searchEmail = searchEmail;
        emailRepository = EmailRepository.getInstance();
    }

    public void searchResults(String keywords){
        keywords = keywords.toLowerCase();
        searchEmail.printSearchResults(emailRepository.searchEmail(keywords));
    }
}
