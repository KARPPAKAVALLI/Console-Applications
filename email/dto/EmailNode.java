package mvvm.email.dto;

public class EmailNode {
    public Email email;
    public EmailNode next;

    public EmailNode(Email email, EmailNode next) {
        this.email = email;
        this.next = next;
    }
}
