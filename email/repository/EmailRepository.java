package mvvm.email.repository;

import mvvm.email.dto.Email;
import mvvm.email.dto.EmailNode;
import mvvm.email.model.EmailFile;
import mvvm.email.model.EmailLinkedList;

import java.util.ArrayList;
import java.util.List;

public class EmailRepository {
    private static EmailRepository emailRepository;
    private EmailFile emailFile;
    private EmailLinkedList emailLinkedList;
    private EmailRepository(){
        emailFile = EmailFile.getInstance();
        emailLinkedList = EmailLinkedList.getInstance();
    }
    public static EmailRepository getInstance(){
        if(emailRepository == null)
            emailRepository = new EmailRepository();
        return emailRepository;
    }

    public void handleEmailAddition(Email email){
        emailFile.addNewEmail(email);
        emailLinkedList.addNewEmail(email);
    }

    public void handleEmailDeletion(int id){
        emailLinkedList.deleteEmail(id);
        emailFile.eraseFileContent();
        EmailNode temp = emailLinkedList.head;
        while (temp != null){
            emailFile.addNewEmail(temp.email);
            temp = temp.next;
        }
    }


    //OPTION 1: getFirstEmail() & getNextEmail(int id)
    public Email getFirstEmail(){
        return emailLinkedList.head.email;
    }

    public Email getNextEmail(int id){
        EmailNode temp = emailLinkedList.head;
        while (temp.next != null){
            if(temp.email.getId() == id){
                return temp.next.email;
            }
            temp = temp.next;
        }
        return null;
    }

    //OPTION 2: getAllEmail()
    public List<Email> getAllEmail(){
        List<Email> emails = new ArrayList<>();
        EmailNode temp = emailLinkedList.head;
        while (temp != null){
            emails.add(temp.email);
            temp = temp.next;
        }
        return emails;
    }

    public Email getEmail(int id){
        EmailNode temp  = emailLinkedList.head;
        while (temp != null){
            if(temp.email.getId() == id)
                return temp.email;
            temp = temp.next;
        }
        return null;
    }

    public void editContent(int id, String find, String replace){
        Email email = getEmail(id);
        String[] words = email.getContent().split(" ");
        StringBuilder newContent = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(find))
                words[i] = replace;
            newContent.append(words[i]);
            newContent.append(" ");
        }
        email.setContent(newContent.toString().trim());
        emailFile.eraseFileContent();
        EmailNode temp = emailLinkedList.head;
        while (temp != null){
            emailFile.addNewEmail(temp.email);
            temp = temp.next;
        }
    }

    private boolean isMatch(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case: empty pattern matches empty text
        dp[0][0] = true;

        // Initialize first row for patterns starting with '*', as '*' can match an empty text
        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];  // '*' can match zero characters
            }
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char textChar = text.charAt(i - 1);
                char patternChar = pattern.charAt(j - 1);

                if (patternChar == textChar) {
                    // Exact match
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (patternChar == '*') {
                    // '*' can match zero or more characters
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else if (patternChar == '+') {
                    // '+' must match at least one character, so we check the previous character match
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        // The result is whether the entire text matches the entire pattern
        return dp[n][m];
    }

    public List<Email> searchEmail(String keywords){
        List<Email> searchResults = new ArrayList<>();
        EmailNode temp = emailLinkedList.head;
        while (temp != null){
            if(isMatch(temp.email.getContent().toLowerCase(), keywords) ||
                    isMatch(temp.email.getSubject().toLowerCase(), keywords)){
                searchResults.add(temp.email);
            }
            temp = temp.next;
        }
        return searchResults;
    }

    public void markImpTag(int id){
        EmailNode temp = emailLinkedList.head;
        while (temp != null){
            if(temp.email.getId() == id){
                temp.email.setTag("Important");
                break;
            }
            temp = temp.next;
        }
        emailFile.eraseFileContent();
        temp = emailLinkedList.head;
        while (temp != null){
            emailFile.addNewEmail(temp.email);
            temp = temp.next;
        }
    }
}
