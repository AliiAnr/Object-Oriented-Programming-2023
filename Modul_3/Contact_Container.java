
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contact_Container extends JPanel {

    JButton newChat = new JButton("New Chat");
    public static List_Container contactList = new List_Container();

    Contact_Container() {
        showList();
    }

    public void showList() {
        setBackground(Color.decode("#593b3b"));
        setBorder(null);
        setPreferredSize(new Dimension(350, 600));

        JPanel headerPanel = new JPanel();
        headerPanel.setOpaque(false);

        headerPanel.setLayout(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(320, 30));

        newChat.setPreferredSize(new Dimension(100, 30));
        newChat.setBackground(Color.decode("#ffafaf"));
        newChat.setForeground(Color.WHITE);
        newChat.setFont(new Font("Poppins", Font.PLAIN, 10));
        newChat.setBorder(null);
        newChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contact_Form_Container contactForm = new Contact_Form_Container(List_Container.getPeopleList());

            }
        });
        headerPanel.add(newChat, BorderLayout.EAST);
        this.add(headerPanel);
        // this.add(contactList);

        JScrollPane scrollPane = new JScrollPane(contactList);
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        scrollPane.getVerticalScrollBar().setBackground(Color.decode("#111b21"));
        scrollPane.getVerticalScrollBar().setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setPreferredSize(new Dimension(350, 510));
        scrollPane.setBorder(null);
        add(scrollPane);
    }

    public static void update() {
        contactList.removeAll();
        contactList.revalidate();
        contactList.repaint();
        contactList.showContactList();
    }

    public void setContactList(List_Container newContactList) {
        contactList = newContactList;
    }
}
