/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;
import nz.ac.aut.ense701.gui.GameSelectGUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import nz.ac.aut.ense701.gameModel.Difficulty;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.GameModel;
import nz.ac.aut.ense701.gameModel.ScoreRecord;
import nz.ac.aut.ense701.gui.KiwiCountUI;


public class GameLevelSelect extends JFrame{


	private JLabel text;
	
	private JButton easy;
	private JButton normal;
	private JButton hard;
	private JButton back;
        
        private ScoreRecord aUser;

	//This class for show main menu.
	public GameLevelSelect(){	
		super("Kiwi Island Start Menu");
		
		text = new JLabel("");
		easy= new JButton("Easy Game");
		easy.setBounds(20, 50, 150, 30);
		
		normal= new JButton("Normal Game");
		normal.setBounds(20, 100, 150, 30);
		
		hard= new JButton("Hard Game");
		hard.setBounds(20, 150, 150, 30);
		
		back= new JButton("Back");
		back.setBounds(20, 200, 150, 30);
		

	
		text.setText("");
		text.setFont(new Font( "Dialog", Font.TRUETYPE_FONT, 40));
		text.setForeground(Color.BLACK);
		
		this.add(text);
		this.add(easy);
		this.add(normal);
		this.add(hard);
		this.add(back);
		this.add(text);
		this.setSize(200, 300);
		this.setLocation(400, 200);
		 this.setResizable(false);//size of window cannot be change 
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		back.addActionListener(new ActionListener() {     		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			new GameSelectGUI();
    			Dispose();
    			
    		}
    	});
		easy.addActionListener(new ActionListener() {     		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
                         final Game game = new Game();
                         game.setModel(GameModel.Normal);
                         game.setDiffiucly(Difficulty.ESAY);
                         aUser.setDiffculty(Difficulty.ESAY.toString());
                         game.setaUser(aUser);
                         final KiwiCountUI  gui  = new KiwiCountUI(game);
                         gui.setVisible(true);
                         Dispose();
    		}
    	});
		
		normal.addActionListener(new ActionListener() {     		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
                         final Game game = new Game();
                         game.setDiffiucly(Difficulty.NORMAL);
                         game.setModel(GameModel.Normal);
                         aUser.setDiffculty(Difficulty.NORMAL.toString());
                         game.setaUser(aUser);
                         final KiwiCountUI  gui  = new KiwiCountUI(game);
                         gui.setVisible(true);
                          Dispose();
    		}
    	});
		hard.addActionListener(new ActionListener() {     		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
                         final Game game = new Game();
                         game.setModel(GameModel.Normal);
                         game.setDiffiucly(Difficulty.HARD);
                         aUser.setDiffculty(Difficulty.NORMAL.toString());
                         game.setaUser(aUser);
                         final KiwiCountUI  gui  = new KiwiCountUI(game);
                         gui.setVisible(true); 
                          Dispose();
                         
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
		new GameLevelSelect();
	}

}
