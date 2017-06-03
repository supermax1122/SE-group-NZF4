/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;


import nz.ac.aut.ense701.gameModel.ScoreRecord;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import nz.ac.aut.ense701.gameModel.Difficulty;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.GameModel;
import nz.ac.aut.ense701.gameModel.ScoreList;
import nz.ac.aut.ense701.gui.ScoreBoard;


public class GameSelectGUI extends JFrame{

	private CustomizeButton NormalMode;
	private CustomizeButton ScoreBoard;
	private CustomizeButton ChallengeMode;
	private CustomizeButton exit;
	private CustomizeBackground ground;
        private ScoreRecord aUser;
	//This class for show main menu.
	public GameSelectGUI(){	
		
		super("Kiwi Island Select Menu");
	
	
    
                NormalMode = new CustomizeButton("image/NormalMode1.png", "image/NormalMode2.png", "image/NormalMode3.png");
		NormalMode.setBounds(20, 100, NormalMode.getButtonWidth(), NormalMode.getButtonHeight());
		
		ScoreBoard = new CustomizeButton("image/ScoreBoard1.png", "image/ScoreBoard2.png", "image/ScoreBoard3.png");
		ScoreBoard.setBounds(20, 200, ScoreBoard.getButtonWidth(), ScoreBoard.getButtonHeight());
		
		ChallengeMode = new CustomizeButton("image/Challenge1.png", "image/Challenge2.png", "image/Challenge3.png");
		ChallengeMode.setBounds(20, 300,ChallengeMode.getButtonWidth(), ChallengeMode.getButtonHeight());
		
		exit = new CustomizeButton("image/exit1.png", "image/exit2.png", "image/exit3.png");
		exit.setBounds(20, 400, exit.getButtonWidth(), exit.getButtonHeight());

		ground = new CustomizeBackground("image/startMenu.jpg");
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
                        try {
                            // TODO Auto-generated method stub
                            JFrame jf = new JFrame();                            
                            ArrayList<ScoreRecord> scoreRecordList = new ScoreList().ScoreRecordList();                           
                            ScoreBoard aScoreBoard = new ScoreBoard(scoreRecordList);
                            jf.add(aScoreBoard);
                            jf.setVisible(true);
                            jf.setSize(490, 480);
                        } catch (IOException ex) {
                            Logger.getLogger(GameSelectGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
    		}
    	});
		ChallengeMode.addActionListener(new ActionListener() {     		
    		@Override
    		public void actionPerformed(ActionEvent e) {
                    final Game game = new Game(aUser);
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
	
	
	 
}



