/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javafx.scene.input.KeyCode;
import javax.swing.JFrame;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.MoveDirection;
import nz.ac.aut.ense701.gameModel.SoundEffect;

/**
 *
 * @author Rongsen Chen
 */
public class KeybordListener implements KeyListener, MouseListener{
    private Game game;
    private JFrame frame;
    private SoundEffect soundEffect;
    
    public KeybordListener (Game game, JFrame frame){
        this.game = game;
        soundEffect = new SoundEffect();
    }

    KeybordListener(Game game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        //IGNORE
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){
            if(game.isPlayerMovePossible(MoveDirection.NORTH)){
                game.playerMove(MoveDirection.NORTH);
                soundEffect.playStepSound();
            }
            else
            {
                soundEffect.playWarningSound();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S){
            if(game.isPlayerMovePossible(MoveDirection.SOUTH)){
                game.playerMove(MoveDirection.SOUTH);
                soundEffect.playStepSound();
            }
            else
            {
                soundEffect.playWarningSound();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A){
            if (game.isPlayerMovePossible(MoveDirection.WEST)){
                game.playerMove(MoveDirection.WEST);
                soundEffect.playStepSound();
            }
            else
            {
                soundEffect.playWarningSound();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            if(game.isPlayerMovePossible(MoveDirection.EAST)){
                game.playerMove(MoveDirection.EAST);
                soundEffect.playStepSound();
            }
            else
            {
                soundEffect.playWarningSound();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //IGNORE
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        frame.setFocusable(true);
        frame.requestFocusInWindow();        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        frame.setFocusable(true);
        frame.requestFocusInWindow();        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        frame.setFocusable(true);
        frame.requestFocusInWindow();        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        frame.setFocusable(true);
        frame.requestFocusInWindow();        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        frame.setFocusable(true);
        frame.requestFocusInWindow();        
    }
    
}
