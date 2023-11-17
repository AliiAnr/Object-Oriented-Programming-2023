import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Chat {
    String content;
    String sender;
    String time;

    public Chat(String content, String sender) {
        this.content = content;
        this.sender = sender;
        this.time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    }
    public String getContent() {
        return content;
    }
    public String getSender() {
        return sender;
    }
    public String getTime() {
        return time;
    }
}
