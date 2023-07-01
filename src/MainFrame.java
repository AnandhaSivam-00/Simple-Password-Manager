import javax.swing.*;
import java.awt.event.*;
import Transactions.UserDataStore;
import Properties.User_Properties;
import Properties.Author_Properties;

import java.awt.*;


class MainFrame extends JFrame{
    JFrame mainFrame;
    JPanel mainPanel; 
    JMenuBar menu;
    JMenu menuHome, menuAdd, menuAbout, menuProfile;
    JMenuItem item_1, item_2, item_3, item_4, item_5;
    private Font font = new Font("Times New Roman", Font.BOLD, 15);

    MainFrame(UserDataStore data){
        mainFrame = new JFrame("User Home Page");

        menu = new JMenuBar();
        menu.setBackground(new Color(112, 217, 255));
        menuProfile = new JMenu("Profile");
        menuProfile.setFont(font);
        menuHome = new JMenu("Home");
        menuHome.setFont(font);
        menuAdd = new JMenu("Add items");
        menuAdd.setFont(font);
        menuAbout = new JMenu("About");
        menuAbout.setFont(font);

        menu.add(menuProfile);
        menu.add(menuHome);
        menu.add(menuAdd);
        menu.add(menuAbout);

        item_1 = new JMenuItem("User Profile");
        item_1.setFont(font);
        item_2 = new JMenuItem("Log Out!");
        item_2.setFont(font);
        item_3 = new JMenuItem("About Product");
        item_3.setFont(font);
        item_4 = new JMenuItem("Supports");
        item_4.setFont(font);
        item_5 = new JMenuItem("Add Items");
        item_5.setFont(font);

        menuProfile.add(item_1);
        menuProfile.add(item_2);
        menuAbout.add(item_3);
        menuAbout.add(item_4);
        menuAdd.add(item_5);

        item_1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                User_Properties.userProfile(data);
            }
        });

        item_2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(User_Properties.logoutFunc()){
                    new Login_Page();
                    dispose();
                }
            }
        });

        item_3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Author_Properties.aboutProduct();
            }
        });

        item_4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Author_Properties.aboutAuthor();
            }
        });

        item_5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                NewUser add = new NewUser();
                add.gotoNewuserFrame(data, data.currentUser);
                dispose();
            }
        });

        mainPanel = new JPanel();

        Image icon = Toolkit.getDefaultToolkit().getImage("Images/My project.png");
        setIconImage(icon);
        
        setTitle("Aaron Keys - Home Page - Welcome " + data.currentUser);
        setJMenuBar(menu);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 680);
        //setResizable(false);
        setVisible(true);
        mainFrameBody(data);
    }

    public void mainFrameBody(UserDataStore data){
        JList list = new JList();
    }
}
