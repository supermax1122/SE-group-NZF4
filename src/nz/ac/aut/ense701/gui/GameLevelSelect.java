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
import nz.ac.aut.ense701.GUITools.MyBackGround;
import nz.ac.aut.ense701.GUITools.MyButton;
import nz.ac.aut.ense701.gameModel.Difficulty;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.GameModel;
import nz.ac.aut.ense701.gameModel.ScoreRecord;
import nz.ac.aut.ense701.gui.KiwiCountUI;


public class GameLevelSelect extends JFrame{


	private JLabel text;
	
	private MyButton easy;
	private MyButton normal;
	private MyButton hard;
	private MyButton back;
        private MyBackGround ground;
        private ScoreRecord aUser;
        private GameSelectGUI GameSelectGUI;
        private String userName;
	//This class for show main menu.
	public GameLevelSelect(){	
		super("Kiwi Island Start Menu");
		
		text = new JLabel("");
            
		easy= new MyButton("image/EasyGame1.png", "image/EasyGame2.png", "image/EasyGame3.png");
		easy.setBounds(20, 50,easy.getButtonWidth(), easy.getButtonHeight());
		
		normal= new MyButton("image/NormalGame1.png", "image/NormalGame2.png", "image/NormalGame3.png");
		normal.setBounds(20, 120, normal.getButtonWidth(), normal.getButtonHeight());
		
		hard= new MyButton("image/HardGame1.png", "image/HardGame2.png", "image/HardGame3.png");
		hard.setBounds(20, 190, hard.getButtonWidth(), hard.getButtonHeight());
		
		back= new MyButton("image/Back1.png", "image/Back2.png", "image/Back3.png");
		back.setBounds(20, 260,back.getButtonWidth(), back.getButtonHeight());
		

	
		text.setText("");
		text.setFont(new Font( "Dialog", Font.TRUETYPE_FONT, 40));
		text.setForeground(Color.BLACK);
		ground = new MyBackGround("image/GameLevelBackGound.jpg");
	
		ground.setBounds(0,0,700,560); 
             
		this.add(text);
		this.add(easy);
		this.add(normal);
		this.add(hard);
		this.add(back);
		this.add(text);
                this.add(ground);
		this.setSize(180, 350);
		this.setLocation(400, 200);
               
		this.setResizable(false);//size of window cannot be change 
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		back.addActionListener(new ActionListener() {     		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			new GameSelectGUI().setaUser(aUser);
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
