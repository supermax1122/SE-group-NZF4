/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;


import nz.ac.aut.ense701.gameModel.FileIn;
import nz.ac.aut.ense701.gameModel.ScoreRecord;
import nz.ac.aut.ense701.GUITools.MyBackGround;
import nz.ac.aut.ense701.GUITools.MyButton;
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
import nz.ac.aut.ense701.gameModel.Difficulty;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.GameModel;
import nz.ac.aut.ense701.gui.ScoreBoard;


public class GameSelectGUI extends JFrame{



	
	private MyButton NormalMode;
	private MyButton ScoreBoard;
	private MyButton ChallengeMode;
	private MyButton exit;
	private MyBackGround ground;
        private ScoreRecord aUser;
	//This class for show main menu.
	public GameSelectGUI(){	
		
		super("Kiwi Island Select Menu");
	
	
    
                NormalMode = new MyButton("image/NormalMode1.png", "image/NormalMode2.png", "image/NormalMode3.png");
		NormalMode.setBounds(20, 100, NormalMode.getButtonWidth(), NormalMode.getButtonHeight());
		
		ScoreBoard = new MyButton("image/ScoreBoard1.png", "image/ScoreBoard2.png", "image/ScoreBoard3.png");
		ScoreBoard.setBounds(20, 200, ScoreBoard.getButtonWidth(), ScoreBoard.getButtonHeight());
		
		ChallengeMode = new MyButton("image/Challenge1.png", "image/Challenge2.png", "image/Challenge3.png");
		ChallengeMode.setBounds(20, 300,ChallengeMode.getButtonWidth(), ChallengeMode.getButtonHeight());
		
		exit = new MyButton("image/exit1.png", "image/exit2.png", "image/exit3.png");
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
		 this.setResizable(false);//size of window cannot be change 
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
                       GameLevelSelect levelSelect= new GameLevelSelect();
                       levelSelect.setaUser(aUser);
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
                    final Game game = new Game();
                    game.setModel(GameModel.Challenge);
                    game.setDiffiucly(Difficulty.HARD);
                    aUser.setDiffculty(Difficulty.Challenge.toString());
                    game.setaUser(aUser);
                     final KiwiCountUI  gui  = new KiwiCountUI(game);
                         gui.setVisible(true);
                          Dispose();
    			// TODO Auto-generated method stub
    		
    		}	
    	});
		
		
	}
	private void Dispose(){
		this.dispose();
	}

    public ScoreRecord getaUser() {
        return aUser;
    }

    public void setaUser(ScoreRecord aUser) {
        this.aUser = aUser;
    }
	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		GameSelectGUI ui =new GameSelectGUI();
		
	}
	
	 
}



