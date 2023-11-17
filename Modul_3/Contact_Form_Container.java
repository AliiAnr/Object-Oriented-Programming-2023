
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Contact_Form_Container extends JFrame {
    private static List<Users> peopleList;
    private String imagePath;
    Contact_Form_Container(List<Users> newpeopleList){
        peopleList = newpeopleList;
        Border border = BorderFactory.createMatteBorder(0, 6, 0, 6, Color.decode("#593b3b"));

        JPanel panelName = new JPanel();
        panelName.setBackground(Color.decode("#2a1c1c"));
        panelName.setLayout(new BorderLayout());
        panelName.setPreferredSize(new Dimension(350, 30));
        JLabel labelName = new JLabel("Name");
        labelName.setFont(new Font("Poppins", Font.BOLD, 12));
        labelName.setForeground(Color.WHITE);
        labelName.setVerticalTextPosition(JLabel.BOTTOM);
        JTextField textFieldName = new JTextField(20);
        textFieldName.setPreferredSize(new Dimension(280, 25));
        textFieldName.setBackground(Color.decode("#593b3b"));
        textFieldName.setForeground(Color.decode("#85959f"));
        textFieldName.setBorder(border);
        textFieldName.setCaretColor(Color.WHITE);
        textFieldName.setFont(new Font("Poppins", Font.BOLD, 12));
        panelName.add(labelName, BorderLayout.WEST);
        panelName.add(textFieldName, BorderLayout.EAST);

        JPanel panelNumber = new JPanel();
        panelNumber.setBackground(Color.decode("#2a1c1c"));
        panelNumber.setLayout(new BorderLayout());
        panelNumber.setPreferredSize(new Dimension(350, 30));
        JLabel labelNumber = new JLabel("Number");
        labelNumber.setFont(new Font("Poppins", Font.BOLD, 12));
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setVerticalTextPosition(JLabel.BOTTOM);

        JTextField textFieldNumber = new JTextField(20);
        textFieldNumber.setPreferredSize(new Dimension(280, 25));
        textFieldNumber.setBackground(Color.decode("#593b3b"));
        textFieldNumber.setForeground(Color.decode("#85959f"));
        textFieldNumber.setBorder(border);
        textFieldNumber.setCaretColor(Color.WHITE);
        textFieldNumber.setFont(new Font("Poppins", Font.BOLD, 12));
        panelNumber.add(labelNumber, BorderLayout.WEST);
        panelNumber.add(textFieldNumber, BorderLayout.EAST);


        JPanel actionPanel = new JPanel();
        actionPanel.setBackground(Color.decode("#2a1c1c"));
        JButton addImageButton = new JButton("Image");
        addImageButton.setPreferredSize(new Dimension(35,35));
        addImageButton.setBackground(Color.decode("#ffafaf"));
        addImageButton.setBorder(null);
        JButton addContactButton = new JButton("Add Contact");
        addContactButton.setBackground(Color.decode("#ffafaf"));
        addContactButton.setFont(new Font("Poppins", Font.BOLD, 12));;
        addContactButton.setPreferredSize(new Dimension(310,35));
        addContactButton.setBorder(null);

        addImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    java.io.File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    imagePath = selectedFile.getAbsolutePath();
                } else {
                    System.out.println("File selection canceled.");
                }
            }
        });

        JPanel panel = new JPanel();

        actionPanel.add(addContactButton);
        actionPanel.add(addImageButton);

        JList<String> list = new JList<>(List_Container.getPeopleName().toArray(new String[0]));
        list.setBackground(Color.decode("#593b3b"));
        list.setFont(new Font("Poppins", Font.PLAIN, 12));
        list.setBorder(new LineBorder(Color.decode("#593b3b"), 12));
        list.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(350, 300));
        scrollPane.getVerticalScrollBar().setBackground(Color.decode("#593b3b"));
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(8,0));
        scrollPane.setBorder(null);

        JLabel labelContact = new JLabel("Your Contact");
        labelContact.setFont(new Font("Poppins", Font.BOLD, 12));
        labelContact.setForeground(Color.WHITE);

        addContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textFieldName.getText().isEmpty()&&!textFieldNumber.getText().isEmpty()&&imagePath!=null){

                    peopleList.add(new Users(textFieldName.getText(), imagePath, textFieldNumber.getText()));
                    textFieldName.setText("");
                    textFieldNumber.setText("");
                    imagePath = null;
                    List_Container.setPeopleList(getPeopleList());
                    Contact_Container.update();
                    list.setListData(List_Container.getPeopleName().toArray(new String[0]));
                    list.revalidate();
                }
            }
        });
        panel.setBackground(Color.decode("#2a1c1c"));
        panel.add(panelName);
        panel.add(panelNumber);
        panel.add(actionPanel);
        panel.add(labelContact);
        panel.add(scrollPane);

        add(panel);
        setTitle("Contact Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void setPeopleList(List<Users> newpeopleList){
        peopleList = newpeopleList;
    }
    public static List<Users> getPeopleList(){
        return peopleList;
    }
}
