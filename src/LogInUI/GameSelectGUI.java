/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogInUI;


import FileIO.FileIn;
import FileIO.ScoreRecord;
import GUITools.MyBackGround;
import GUITools.MyButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import nz.ac.aut.ense701.gui.ScoreBoard;


public class GameSelectGUI extends JFrame{



	
	private MyButton NormalMode;
	private MyButton ScoreBoard;
	private MyButton ChallengeMode;
	private MyButton exit;
	private MyBackGround ground;
	//This class for show main menu.
	public GameSelectGUI(){	
		
		super("Kiwi Island Select Menu");
	
	
    
        NormalMode = new MyButton("image/na1.jpg", "image/na2.jpg", "image/na3.jpg");
		NormalMode.setBounds(20, 100, NormalMode.getButtonWidth(), NormalMode.getButtonHeight());
		
		ScoreBoard = new MyButton("image/sa1.jpg", "image/sa2.jpg", "image/sa3.jpg");
		ScoreBoard.setBounds(20, 200, ScoreBoard.getButtonWidth(), ScoreBoard.getButtonHeight());
		
		ChallengeMode = new MyButton("image/ca1.jpg", "image/ca2.jpg", "image/ca3.jpg");
		ChallengeMode.setBounds(20, 300,ChallengeMode.getButtonWidth(), ChallengeMode.getButtonHeight());
		
		exit = new MyButton("image/Exit1.jpg", "image/Exit2.jpg", "image/Exit3.jpg");
		exit.setBounds(20, 400, exit.getButtonWidth(), exit.getButtonHeight());

		ground = new MyBackGround("image/startMenu.jpg");
		this.setLayout(null);
		ground.setBounds(0,0,700,560);
	
	
		
		
		this.add(NormalMode);
		this.add(ScoreBoard);
		this.add(ChallengeMode);
		this.add(exit);
		this.add(ground);
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

		NormalMode.addActionListener(new ActionListener() {     		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
                        new GameLevelSelect();
                        Dispose();
    		}
    	});
		
		ScoreBoard.addActionListener(new ActionListener() {     		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
                         JFrame jf = new JFrame();
                         FileIn ScoreListFileIn = new FileIn("scoreFile.txt");
                         ArrayList<ScoreRecord> scoreRecordList = null;
                        try {
                            scoreRecordList = ScoreListFileIn.ScoreRecordList();
                        } catch (IOException ex) {
                            Logger.getLogger(GameSelectGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  
                        ScoreBoard aScoreBoard = new ScoreBoard(scoreRecordList);
                        jf.add(aScoreBoard);
                        jf.setVisible(true);
                        jf.setSize(515, 600);
                        
    		}
    	});
		ChallengeMode.addActionListener(new ActionListener() {     		
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
		GameSelectGUI ui =new GameSelectGUI();
		
	}
	
	 
}



