package mvvm.email.model;

import mvvm.email.dto.Email;
import mvvm.email.dto.EmailNode;

public class EmailLinkedList {
    private static EmailLinkedList emailLinkedList;
    public EmailNode head;
    EmailNode curr;
    private EmailLinkedList(){
        head = null;
        curr = head;
    }

    public static EmailLinkedList getInstance(){
        if(emailLinkedList == null)
            emailLinkedList = new EmailLinkedList();
        return emailLinkedList;
    }
    public void addNewEmail(Email email){
        if(head == null){
            head = new EmailNode(email, null);
            curr = head;
            return;
        }
        EmailNode newEmailNode = new EmailNode(email, null);
        curr.next = newEmailNode;
        curr = curr.next;
    }

    public Email getEmail(int id){
        EmailNode temp = head;
        while (temp != null){
            if(temp.email.getId() == id){
                return temp.email;
            }
            temp = temp.next;
        }
        return null;
    }

    public void deleteEmail(int id){
        EmailNode temp = head;
        EmailNode dummy = new EmailNode(null, null);
        dummy.next = head;
        EmailNode prev = dummy;
        while (temp != null){
            if(temp.email.getId() == id){
                prev.next = temp.next;
                temp.next = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        head = dummy.next;
    }
}
