/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Near
 */
public class SoundEffect {
    private String click, step, warning;
    private AudioInputStream audioInputStream;
    
    public SoundEffect(){
        click = "res/SoundEffect/click_sound_effect.wav";
        step = "res/SoundEffect/step.wav";
        warning = "res/SoundEffect/warning.wav";
    }
    
    public boolean openFile(String soundName){
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
        } catch (UnsupportedAudioFileException ex) {
            System.err.println("File type note support");
            return false;
        } catch (IOException ex) {
            System.err.println("Cannot read this path");
            return false;
        }
        
        return true;
    }
    
    public void playClickSound(){
        try {
            if(openFile(click)){
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
        } catch (LineUnavailableException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    public void playStepSound(){
        try {
            if(openFile(step)){
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
        } catch (LineUnavailableException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    public void playWarningSound(){
        try {
            if(openFile(warning)){
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
        } catch (LineUnavailableException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
