
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogInUI;

import GUITools.MyBackGround;
import GUITools.MyButton;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import nz.ac.aut.ense701.gui.ScoreBoard;



public class StartMenuGUI extends JFrame{


	private static JPanel textPanel;
	private JLabel text;
	
	private MyButton StartGame;
	private MyButton ScoreBoard;
	private MyButton GameLevel;
	private MyButton exit;
	private MyBackGround ground;
	//This class for show main menu.
	public StartMenuGUI(){	
		super("Kiwi Island Start Menu");
		
		text = new JLabel("");
		StartGame = new MyButton("image/StartGame1.jpg", "image/StartGame2.jpg", "image/StartGame3.jpg");
		StartGame.setBounds(20, 100, StartGame.getButtonWidth(), StartGame.getButtonHeight());
		
		ScoreBoard = new MyButton("image/ScoreBoard1.jpg", "image/ScoreBoard2.jpg", "image/ScoreBoard3.jpg");
		ScoreBoard.setBounds(20, 200, ScoreBoard.getButtonWidth(), ScoreBoard.getButtonHeight());
		
		GameLevel = new MyButton("image/GameLevel1.jpg", "image/GameLevel2.jpg", "image/GameLevel3.jpg");
		GameLevel.setBounds(20, 300, GameLevel.getButtonWidth(), GameLevel.getButtonHeight());
		
		exit = new MyButton("image/Exit1.jpg", "image/Exit2.jpg", "image/Exit3.jpg");
		exit.setBounds(20, 400, exit.getButtonWidth(), exit.getButtonHeight());
		

		ground = new MyBackGround("image/startMenu.jpg");
		this.setLayout(null);
		ground.setBounds(0,0,700,560);
	
		text.setText("Kiwi Island");
		text.setFont(new Font( "Dialog", Font.ITALIC, 70));
		text.setForeground(Color.WHITE);
		
		
		this.add(StartGame);
		this.add(ScoreBoard);
		this.add(GameLevel);
		this.add(exit);
		this.add(ground);
		ground.add(text);
		this.setSize(700, 600);
		this.setLocation(400, 300);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		exit.addActionListener(new ActionListener() {     		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			System.out.println("Thank you for using!");
    			System.exit(0);
    			
    		}
    	});
		StartGame.addActionListener(new ActionListener() {     		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
                        new UserLogIn();
                        Dispose();
    		}
    	});
		
		ScoreBoard.addActionListener(new ActionListener() {     		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    		
    		}
    	});
		GameLevel.addActionListener(new ActionListener() {     		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    		
    		}	
    	});
		
		
	}
	private void Dispose(){
		this.dispose();
	}
	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		new StartMenuGUI();	
	}

}
