import API.Database;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Main {
   public static void main(String[] args) {
      
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      // JANGAN LUPA BACA FILE README.MD SEBELUM RUN !!!
      
      try {
         new Database();
      } catch (SQLException | ClassNotFoundException e) {
         e.printStackTrace();
      }

      LoginContainer loginContainer = new LoginContainer();
      JPanel panel = new JPanel();
      JFrame frame = new JFrame("ALI GANTENG");

      panel.setLayout(new GridBagLayout());
      panel.add(loginContainer);
      panel.setBackground(Color.WHITE);
      frame.add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(750, 700);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);

   }
}
