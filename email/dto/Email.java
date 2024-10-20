package mvvm.email.dto;

public class Email {
    private static int ref_id = 1;
    private String from;
    private String to;
    private String content;
    private String subject;
    private String tag;
    private int id;

    public Email(String from, String to, String subject, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
        this.subject = subject;
        this.tag = null;
        this.id = ref_id++;
    }

    @Override
    public String toString() {
        return id + " " + from + " " + to + " " + subject + " " + content + " " + tag + "\n";
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
