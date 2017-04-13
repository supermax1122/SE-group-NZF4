/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTest;

import nz.ac.aut.ense701.gameModel.MusicPlayer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rongsen Chen
 * @version 2017 0.1
 */
public class MusicPlayerTest extends junit.framework.TestCase{
    String songPath;
    MusicPlayer mplayer;
    
    public MusicPlayerTest() {
    }
     
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        mplayer = new MusicPlayer ();
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @After
    public void tearDown() {
        mplayer = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}


    /**
     * Test if the class can open audio file with correctly;
     */
    @Test
    public void testOpenFile (){
        mplayer.setPath("res/music/Scenery_of_the_Town_Morning.wav");
        assertTrue("should open the file and return true.", mplayer.openFile());
        mplayer.setPath("");
        assertTrue("Wrong path. Should return false and notify that file cannot be open", !mplayer.openFile());
    }
    
    /**
     * Test if the class can start the music correctly, and than stop it correctly
     */
    @Test
    public void testStartandStop (){
        mplayer.setPath("res/music/Scenery_of_the_Town_Morning.wav");
        assertTrue("should start the music and return true.", mplayer.Start());        
        assertTrue("should stop the music and return true.", mplayer.stop());
    }
}
