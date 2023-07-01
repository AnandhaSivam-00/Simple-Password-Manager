import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

import Transactions.Authentication;
import Transactions.DataOperations;
import Transactions.Password_Check;
import Transactions.UserDataStore;

class NewUser extends JFrame implements Runnable{
	
	JFrame newuserFrame;
	JLabel titleLabel, noteLabel, label_1, label_2, label_3, label_4, label_5;
	JPanel despPanel, contentPanel, buttonPanel;
	JTextField field_1, field_2, field_3, field_4, field_5;
	JButton createBtn, cancelBtn, viewBtn, checkBtn;
	//JTextArea area_1;

	final private Font despFont = new Font("Times New Roman", Font.BOLD, 15);
	final private Font contentFont = new Font("Times New Roman", Font.PLAIN, 15);

	//UserDataStore data = new UserDataStore();

	public void gotoNewuserFrame(UserDataStore data, String username){
		newuserFrame = new JFrame("NEW USER");

		titleLabel = new JLabel("Welcome to Password Manager", SwingConstants.CENTER);
		titleLabel.setFont(new Font("DIN", Font.BOLD, 20));
		//titleLabel.setBounds(0, 10, 600, 20);

		noteLabel = new JLabel("Add your important belongings 'Username' and 'Password' here...", SwingConstants.CENTER);
		noteLabel.setFont(contentFont);
		//noteLabel.setBounds(0, 60, 600, 15);

		label_1 = new JLabel("Website (or) UPI Name");
		label_1.setFont(despFont);
		field_1 = new JTextField();
		field_1.setFont(contentFont);

		label_2 = new JLabel("Username (or) UserID");
		label_2.setFont(despFont);
		field_2 = new JTextField();
		field_2.setFont(contentFont);

		label_3 = new JLabel("Password (or) Passcode");
		label_3.setFont(despFont);
		field_3 = new JTextField();
		field_3.setFont(contentFont);

		label_4 = new JLabel("Link");
		label_4.setFont(despFont);
		field_4 = new JTextField();
		field_4.setFont(contentFont);

		label_5 = new JLabel("Description");
		label_5.setFont(despFont);
		field_5 = new JTextField();
		field_5.setFont(contentFont);
		//JTextArea area_1 = new JTextArea();
		//area_1.setFont(contentFont);
		//area_1.setLineWrap(true);

		despPanel = new JPanel();
		despPanel.setLayout(new GridLayout(0, 1, 10, 10));
		despPanel.setBackground(new Color(112, 217, 255));
		//despPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
		despPanel.add(titleLabel);
		despPanel.add(noteLabel);

		contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(0, 1, 10, 10));
		contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
		contentPanel.add(label_1);
		contentPanel.add(field_1);
		contentPanel.add(label_2);
		contentPanel.add(field_2);
		contentPanel.add(label_3);
		contentPanel.add(field_3);
		contentPanel.add(label_4);
		contentPanel.add(field_4);
		contentPanel.add(label_5);
		contentPanel.add(field_5);
		//contentPanel.add(area_1);

		createBtn = new JButton("Add");
		createBtn.setFont(despFont);
		createBtn.setBackground(new Color(170, 102, 255));
		createBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				DataOperations obj = new DataOperations();
				getData(data);
                if(obj.addData(data, data.currentUser)){
					JOptionPane.showMessageDialog(NewUser.this, "Your Data is successfully added...");
					nullProvider(data);
				}
				else{
					JOptionPane.showMessageDialog(NewUser.this, "Your Data is thrown back", "Try Again", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		cancelBtn = new JButton("Cancel");
		cancelBtn.setFont(despFont);
		cancelBtn.setBackground(new Color(170, 102, 255));
		cancelBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				new Login_Page();
				dispose();
			}
		});

		viewBtn = new JButton("View");
		viewBtn.setFont(despFont);
		viewBtn.setBackground(new Color(170, 102, 255));
		viewBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				MainFrame mainFrame = new MainFrame(data);
				dispose();
			}
		});

		//JList list = new JList();

		checkBtn = new JButton("Check");
		checkBtn.setFont(despFont);
		checkBtn.setBackground(new Color(170, 102, 255));
		checkBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				data.password = field_3.getText();
				Password_Check obj = new Password_Check();
				if(obj.checkPassword(data.password) == 1){
                    JOptionPane.showMessageDialog(NewUser.this, "Your Password is Very Strong");
				}
				if(obj.checkPassword(data.password) == 0){
                    JOptionPane.showMessageDialog(NewUser.this, "Your Password is Strong");
				}
				else if(obj.checkPassword(data.password) == -1){
                    JOptionPane.showMessageDialog(NewUser.this, "Your Password is Very Weak", "Try Again", JOptionPane.ERROR_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(NewUser.this, "Your Password is Weak", "Try Again", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4, 10, 0));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
		buttonPanel.setBackground(new Color(252, 237, 191));

		buttonPanel.add(cancelBtn);
		buttonPanel.add(checkBtn);
		buttonPanel.add(viewBtn);
		buttonPanel.add(createBtn);

		add(despPanel, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		/*add(titleLabel);
		add(noteLabel);
		add(label_1);
		add(label_2);
		add(label_3);*/
		//add(scroll, BorderLayout.CENTER);

		Image icon = Toolkit.getDefaultToolkit().getImage("Images/My project.png");
        setIconImage(icon);

		setTitle("Aaron Keys - Data Entry Page");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 680);
        //setLayout(null);
        setResizable(false);
        setVisible(true);
	}

	private void nullProvider(UserDataStore data){
		data.webName = "";
		field_1.setText("");
		data.userName = "";
		field_2.setText("");
		data.password = "";
		field_3.setText("");
		data.link = "";
		field_4.setText("");
		data.despdata = "";
		field_5.setText("");
	}

	public void run(){
		/*JScrollPane scroll = new JScrollPane(contentPanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scroll, BorderLayout.CENTER);*/
	}

	private void getData(UserDataStore data){
		data.webName = field_1.getText();
		data.userName = field_2.getText();
		data.password = field_3.getText();
		data.link = field_4.getText();
		data.despdata = field_5.getText();
	}

}
