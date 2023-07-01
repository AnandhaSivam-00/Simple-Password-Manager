package Properties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Transactions.UserDataStore;

public class User_Properties{
    static JDialog profileDialog, logoutDialog;
    static JPanel profilePanel, logoutPanel, buttonPanel, imagePanel;
    static JLabel label_1, label_2, label_3, logLabel, imageLabel;
    static JButton yesBtn, noBtn;
    static String pass;
    private static boolean flag;

    public static void userProfile(UserDataStore data){
        profileDialog = new JDialog();

        label_1 = new JLabel("Welcome,");
        label_1.setFont(new Font("Times New Roman", Font.BOLD, 18));

        label_2 = new JLabel(data.currentUser);
        label_2.setFont(new Font("Times New Roman", Font.ITALIC, 45));
        label_2.setForeground(new Color(0, 251, 255));

        label_3 = new JLabel("Password : " + pass);
        label_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        profilePanel = new JPanel();
        profilePanel.setLayout(new GridLayout(0, 1, 10, 10));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        profilePanel.setBackground(new Color(215, 184, 164));

        profilePanel.add(label_1);
        profilePanel.add(label_2);
        profilePanel.add(label_3);

        profileDialog.add(profilePanel, BorderLayout.CENTER);
        profileDialog.setTitle("Profile");
        profileDialog.setSize(370, 170);
        //profileDialog.setResizable(false);
        //profileDialog.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        profileDialog.setVisible(true);
    }
    

    public static boolean logoutFunc(){
        logoutDialog = new JDialog();
        logLabel = new JLabel("Do you want to Log Out ?");
        logLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));

        yesBtn = new JButton("Yes");
        yesBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
        yesBtn.setBackground(new Color(99, 255, 255));
        yesBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                flag = true;
            }
        });
        noBtn = new JButton("No");
        noBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
        noBtn.setBackground(new Color(99, 255, 255));
        noBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                flag = false;
                logoutDialog.dispose();
            }
        });

        logoutPanel = new JPanel();
        logoutPanel.setLayout(new GridLayout(1, 2, 10, 10));
        logoutPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon("Images/logout icon.png"));
        imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(1, 2, 10, 10));
        imagePanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        imagePanel.add(imageLabel);

        logoutPanel.add(logLabel);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        buttonPanel.add(yesBtn);
        buttonPanel.add(noBtn);

        logoutDialog.add(imagePanel, BorderLayout.WEST);
        logoutDialog.add(logoutPanel, BorderLayout.CENTER);
        logoutDialog.add(buttonPanel, BorderLayout.SOUTH);

        logoutDialog.setTitle("Logout Window...");
        logoutDialog.setSize(370, 170);
        logoutDialog.setVisible(true);

        return flag;
    }
}
