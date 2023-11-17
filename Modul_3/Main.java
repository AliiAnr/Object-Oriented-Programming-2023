import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Contact_Container contactBox = new Contact_Container();
        Chat_Container chatBox = new Chat_Container();


        JFrame frame = new JFrame("Jurnal Modul 3");
        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.decode("#593b3b"));
        panel.add(contactBox);
        panel.add(chatBox);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}