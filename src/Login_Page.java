import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseEvent;
import java.io.IOException;

import Transactions.Authentication;
import Transactions.DataOperations;
import Transactions.UserDataStore;

public class Login_Page extends JFrame implements Runnable{
    final private Font loginFont = new Font("Times New Roman", Font.BOLD, 18);
    final private Font titleFont = new Font("DIN", Font.BOLD, 20);
    final private Font textFont = new Font("Times New Roman", Font.PLAIN, 18);
    JLabel label_1, label_2, label_3, label_4;
    JTextField userName;
    JButton loginBtn, cancelBtn, createBtn;
    Login_Page(){
        UserDataStore data = new UserDataStore();
        label_1 = new JLabel("USER LOGIN", SwingConstants.CENTER);
        label_1.setFont(titleFont);
        label_1.setBounds(330, 30, 190, 30);

        label_2 = new JLabel("Username");
        label_2.setFont(loginFont);
        label_2.setBounds(290, 90, 200, 20);
        userName = new JTextField();
        userName.setFont(textFont);
        userName.setBounds(290, 120, 270, 30);

        label_3 = new JLabel("Password");
        label_3.setFont(loginFont);
        label_3.setBounds(290, 170, 200, 20);
        JPasswordField passWord = new JPasswordField();
        passWord.setFont(loginFont);
        passWord.setBounds(290, 200, 270, 30);

        
        add(label_1);
        add(label_2);
        add(label_3);
        add(userName);
        add(passWord);

        createBtn = new JButton("New User");
        createBtn.setFont(loginFont);
        createBtn.setBackground(new Color(146, 161, 207));  //112, 217, 255
        createBtn.setBounds(85, 390, 130, 35);
        //createBtn.setRolloverEnabled(true);
        createBtn.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e1){
                createBtn.setBackground(new Color(134, 245, 83));
            }
            public void mouseExited(MouseEvent e2){
                if(e2.getSource() == createBtn){
                    createBtn.setBackground(new Color(112, 217, 255));
                }
            }
        });
        createBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String userid = userName.getText();
                String password = String.valueOf(passWord.getPassword());
                Authentication user = new Authentication();
                if(user.isExistsUser(userid) || user.isExistsPass(password)){
                    JOptionPane.showMessageDialog(Login_Page.this, "Entered Username or Password is already Exists", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                else if(userid.length() == 0 || password.length() == 0){
                    JOptionPane.showMessageDialog(Login_Page.this, "Enter Username or Password first...", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    //UserDataStore data = new UserDataStore();
                    data.currentUser = userid;
                    DataOperations obj = new DataOperations();
                    if(obj.createNewUser(data, data.currentUser, password)){
                        NewUser newUser = new NewUser();
                        newUser.gotoNewuserFrame(data, userid);
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(Login_Page.this, "DataBase Fails...", "Alert", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        

        loginBtn = new JButton("Login");
        loginBtn.setFont(loginFont);
        loginBtn.setBackground(new Color(245, 169, 108));
        loginBtn.setBounds(310, 390, 100, 35);
        loginBtn.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e1){
                loginBtn.setBackground(new Color(134, 245, 83));
            }
            public void mouseExited(MouseEvent e2){
                loginBtn.setBackground(new Color(245, 169, 108));
            }
        });
        loginBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String userid = userName.getText();
                String password = String.valueOf(passWord.getPassword());
                
                Authentication user = new Authentication();
                if(user.getAuthenticatedUser(userid, password)){
                    data.currentUser = userid;
                    MainFrame mainframe = new MainFrame(data);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(Login_Page.this,"Entered entities are Invaild", "Try agin", JOptionPane.ERROR_MESSAGE);
                    userName.setText("");
                    passWord.setText("");
                }
            }
        });

        cancelBtn = new JButton("Cancel");
        cancelBtn.setFont(loginFont);
        cancelBtn.setBackground(new Color(245, 169, 108));
        cancelBtn.setBounds(440, 390, 100, 35);
        cancelBtn.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e1){
                cancelBtn.setBackground(new Color(134, 245, 83));
            }
            public void mouseExited(MouseEvent e2){
                cancelBtn.setBackground(new Color(245, 169, 108));
            }
        });
        cancelBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });

        add(createBtn);
        add(loginBtn);
        add(cancelBtn);
        
        label_4 = new JLabel();
        label_4.setIcon(new ImageIcon("Images/login page image.jpeg"));
        label_4.setBounds(0, 0, 270, 500);
        add(label_4);

        Image icon = Toolkit.getDefaultToolkit().getImage("Images/My project.png");
        setIconImage(icon);
        
        setTitle("Aaron Keys Login Page");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(190, 144, 120));  //136, 116, 100
        setSize(600, 500);
        setLayout(null);
        setResizable(false);
        //setMinimumSize(new Dimension(350, 450));
        //setLocationRelativeTo(null);
        setVisible(true);
    }
    public void run(){}

    public static void main(String args[]) throws IOException{
        new Login_Page();
    }
}