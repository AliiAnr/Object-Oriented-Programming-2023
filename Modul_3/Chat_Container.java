

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Chat_Container extends JPanel {
    static private Users people ;
    static private JLabel peopleName = new JLabel();
    static private Chat_List messages = new Chat_List();

    Chat_Container(){
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setBackground(Color.decode("#2a1c1c"));
        setPreferredSize(new Dimension(620, 600));

        peopleName.setForeground(Color.WHITE);
        peopleName.setBackground(Color.decode("#593b3b"));
        peopleName.setOpaque(true);
        peopleName.setText(people.getName());
        peopleName.setPreferredSize(new Dimension(620, 50));
        peopleName.setHorizontalAlignment(JLabel.CENTER);
        peopleName.setFont(new Font("Poppins", Font.BOLD, 18));
        add(peopleName);
        add(messages);

        JScrollPane scrollPane = new JScrollPane(messages);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(600, 430));
        // scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10,0));
        scrollPane.getVerticalScrollBar().setBackground(Color.decode("#0f0c0c"));
//        scrollPane.getVerticalScrollBar().setBackground(Color.decode("#0f0c0c"));
        scrollPane.getVerticalScrollBar().setBorder(null);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
                scrollPane.getVerticalScrollBar().removeAdjustmentListener(this);
            }
        });
        scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
        add(scrollPane);

        JPanel sendPanel = new JPanel();
        sendPanel.setBackground(Color.decode("#593b3b"));
        sendPanel.setOpaque(false);

        sendPanel.setLayout(new FlowLayout());
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(550, 32));
        textField.setFont(new Font("Poppins", Font.PLAIN, 12));
        Border border = BorderFactory.createMatteBorder(0, 6, 0, 6, Color.decode("#593b3b"));
        textField.setBorder(border);
        textField.setBackground(Color.decode("#593b3b"));
        textField.setForeground(Color.PINK);
        textField.setCaretColor(Color.WHITE);

        JButton sendButton = new JButton("Send");
        sendButton.setBackground(Color.PINK);
        sendButton.setBorder(null);
        sendButton.setPreferredSize(new Dimension(32, 32));
        sendButton.setFont(new Font("Poppins", Font.PLAIN, 10));
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().isEmpty()){
                    people.Messages.add(new Chat(textField.getText(), "You"));
                    update();
                    textField.setText("");
                    scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
                        public void adjustmentValueChanged(AdjustmentEvent e) {
                            e.getAdjustable().setValue(e.getAdjustable().getMaximum());
                            scrollPane.getVerticalScrollBar().removeAdjustmentListener(this);
                        }
                    });

//
                }
            }
        });
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar()==KeyEvent.VK_ENTER){
                    if (!textField.getText().isEmpty()){
                        people.Messages.add(new Chat(textField.getText(), "You"));
                        update();
                        textField.setText("");
                        scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
                            public void adjustmentValueChanged(AdjustmentEvent e) {
                                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
                                scrollPane.getVerticalScrollBar().removeAdjustmentListener(this);}
                        });
                    }
                }
            }
        });

        sendPanel.add(textField);
        sendPanel.add(sendButton);
        add(sendPanel);
    }
    public static void setPeople(Users newPeople){
        people = newPeople;
        update();
    }
    public static void update(){
        peopleName.setText(people.getName());
        messages.removeAll();
        messages.setPeople(people);
        messages.revalidate();
        messages.repaint();
    }



}
