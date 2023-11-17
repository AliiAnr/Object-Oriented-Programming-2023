import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class List_Container extends JPanel {

    private static List<Users> peopleList = new ArrayList<>();


    List_Container(){
        peopleList.add(new Users("Ali An Nuur"));

        Chat_Container.setPeople(peopleList.get(0));



        showContactList();


        setBackground(Color.decode("#593b3b"));
        setBorder(null);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


    }
    public void showContactList(){
        for (int i = 0; i< peopleList.size(); i++){
            Users person = peopleList.get(i);
            person.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    Chat_Container.setPeople(person);
                }
            });
            
            add(peopleList.get(i));
        }

    }
    public static List<Users> getPeopleList(){
        return peopleList;
    }
    public void update(){
        removeAll();
        revalidate();
        repaint();
    }

    public static List<String> getPeopleName(){
        List<String> peopleName = new ArrayList<>();
        for (int i = 0; i< peopleList.size(); i++){
            peopleName.add(peopleList.get(i).getName());
        }
        return peopleName;
    }
    
    public static void setPeopleList(List<Users> newpeopleList){
        peopleList = newpeopleList;
    }
}
