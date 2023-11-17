import CustomSwingComp.ImageAvatar;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Users extends JButton {
    String Name;
    String Path = "Object-Oriented-Programming-2023\\Modul_3\\Image\\Ali (6).jpg";

    String Number;
    List<Chat> Messages = new ArrayList<>();

    Users(String Name, String Path, String Number) {
        this.Name = Name;
        this.Path = Path;
        this.Number = Number;

        showPeople();

    }

    Users(String Name) {
        this.Name = Name;
        Messages.add(new Chat("P", this.Name));
        showPeople();

    }

    public void showPeople() {
        ImageIcon newIcon = new ImageIcon(Path);

        JLabel imgLabel = new JLabel();
        imgLabel.setBackground(Color.WHITE);
        imgLabel.setOpaque(true);
        imgLabel.setPreferredSize(new Dimension(50, 50));

        ImageAvatar imageAvatar = new ImageAvatar();
        imageAvatar.setIcon(newIcon);
        imageAvatar.setPreferredSize(new Dimension(40, 40));

        JLabel newLabel = new JLabel("   " + Name, JLabel.LEFT);
        newLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        newLabel.setForeground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel indent = new JPanel();
        indent.setOpaque(false);
        indent.setPreferredSize(new Dimension(10, 50));
        add(indent);
        add(imageAvatar);
        add(newLabel);
        Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#ffafaf"));

        setBackground(Color.decode("#593b3b"));

        setBorder(border);
        setMaximumSize(new Dimension(350, 60));
    }

    public String getName() {
        return Name;
    }

    public void setButtonBackground(Color color) {
        setBackground(color);
    }

}
