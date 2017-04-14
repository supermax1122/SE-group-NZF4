/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogInUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.Socket;
import java.util.UUID;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author MengMeng
 */
public class UserLogIn extends JFrame{
       //Create the User Name.
	private JLabel nameTextLabel = new JLabel("User Name：");
	private JTextField nameField = new JTextField(20);

	//Create buttons.
	private JButton YesButton = new JButton("Yes");
	private JButton NoButton = new JButton("No");
	
	private User user;
        
        @SuppressWarnings("unchecked")
	public UserLogIn(){
	
		Box nameBox = Box.createHorizontalBox();
		nameBox.add(Box.createHorizontalStrut(30));
		nameBox.add(this.nameTextLabel);
		nameBox.add(Box.createHorizontalStrut(20));
		nameBox.add(this.nameField);
		nameBox.add(Box.createHorizontalStrut(30));
		

		

		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(this.YesButton);
		buttonBox.add(Box.createHorizontalStrut(30));
		buttonBox.add(this.NoButton);
		
		Box mainBox = Box.createVerticalBox();
		mainBox.add(Box.createVerticalStrut(20));
		mainBox.add(nameBox);
		mainBox.add(Box.createVerticalStrut(20));
		mainBox.add(buttonBox);
		mainBox.add(Box.createVerticalStrut(20));
		this.add(mainBox);
		this.setTitle("Log In Game");
        this.setLocation(800, 300);
		this.pack();
		initializeListeners();
		this.setVisible(true);;
		this.user = new User();

	}
        	//initialize listenners
	private void initializeListeners() {
			this.YesButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
                         login();
                                                
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			this.NoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				
				}
			});
	}
        
        private void login() throws Exception {
			if (this.nameField.getText().equals("")) {
				JOptionPane.showConfirmDialog(null, "Plese Enter Your Name", "warning", 
						JOptionPane.OK_CANCEL_OPTION);
				return;
			}
			//Set User's detail
			setUser();
			this.setVisible(false);
	   }
        
        private void setUser() {
		//Create User
		String name = this.nameField.getText();
		this.user.setUserName(name);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new     UserLogIn();
	}
    
}
