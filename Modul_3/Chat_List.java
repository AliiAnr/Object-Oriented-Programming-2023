import javax.swing.*;
import java.awt.*;

public class Chat_List extends JPanel {
    private Users people;

    Chat_List() {
        System.out.println("Message");
    }

    Chat_List(Users people) {
        this.people = people;

        messageList(people);
    }

    public void messageList(Users people) {
        setBackground(Color.decode("#2a1c1c"));
        JPanel messageList = new JPanel();
        messageList.setBackground(Color.decode("#2a1c1c"));
        messageList.setLayout(new BoxLayout(messageList, BoxLayout.Y_AXIS));
        if (!this.people.Messages.isEmpty()) {
            for (int i = 0; i < this.people.Messages.size(); i++) {
                JLabel Sender = new JLabel(this.people.Messages.get(i).getSender());
                Sender.setFont(new Font("Poppins", Font.BOLD, 10));
                Sender.setForeground(Color.PINK);
                JLabel Content = new JLabel(this.people.Messages.get(i).getContent());
                Content.setPreferredSize(new Dimension(530, 40));
                Content.setVerticalAlignment(JLabel.CENTER);
                Content.setFont(new Font("Poppins", Font.PLAIN, 10));
                Content.setForeground(Color.WHITE);
                JLabel Time = new JLabel(this.people.Messages.get(i).getTime());
                Time.setFont(new Font("Poppins", Font.PLAIN, 8));
                Time.setForeground(Color.WHITE);

                JPanel Message = new JPanel();
                Message.setOpaque(false);
                Message.setLayout(new BoxLayout(Message, BoxLayout.Y_AXIS));
                Message.add(Sender);
                Message.add(Content);

                JPanel TimePanel = new JPanel();
                TimePanel.setOpaque(false);
                TimePanel.add(Time);
                TimePanel.setPreferredSize(new Dimension(50, 20));

                JPanel MessagePanel = new JPanel();
                MessagePanel.setBackground(Color.decode("#2a1c1c"));
                MessagePanel.setLayout(new BorderLayout());
                MessagePanel.add(Message, BorderLayout.WEST);
                MessagePanel.add(TimePanel, BorderLayout.EAST);

                messageList.add(MessagePanel);
                add(messageList);
            }
        } else {
            JLabel NoMessage = new JLabel("No Message");
            NoMessage.setPreferredSize(new Dimension(580, 400));
            NoMessage.setHorizontalAlignment(JLabel.CENTER);
            NoMessage.setFont(new Font("Poppins", Font.PLAIN, 18));
            add(NoMessage);
        }
    }

    public void setPeople(Users newPeople) {
        this.people = newPeople;
        messageList(people);
    }
}
