package nz.ac.aut.ense701.gui;

import java.io.*;
import javax.sound.sampled.*;

public class MusicPlayer {

    private boolean isStop = true;
    private String songPath;
    AudioInputStream audioIn;
    Clip clip;

    public MusicPlayer (){
    }
    
    public MusicPlayer(String songPath) {
        this.songPath = songPath;
    }

    public boolean isStop() {
        return isStop;
    }

    public void setPath(String songPath) {
        this.songPath = songPath;
    }

    public String getPath (){
        return this.songPath;
    }    
    
    public boolean openFile() {
        try {
            File file = new File(songPath);
            audioIn = AudioSystem.getAudioInputStream(file);
            return true;
        } catch (IOException e) {

            return false;
        } catch (UnsupportedAudioFileException e) {

            return false;
        }
    }

    public boolean Start_Loop() {
        if (isStop() && openFile()) {
            try {
                clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                this.isStop = false;
                return true;
            } catch (LineUnavailableException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean stop() {
        clip.stop();
        isStop = true;
        return true;
    }

    public boolean isEnd() {
        return !clip.isRunning();
    }
}
