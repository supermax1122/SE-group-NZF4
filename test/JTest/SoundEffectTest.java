/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTest;

import nz.ac.aut.ense701.gameModel.SoundEffect;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Near
 */
public class SoundEffectTest {
    SoundEffect test;
    public SoundEffectTest() {
    }
    
    @Before
    public void setUp() {
        test = new SoundEffect();
    }
    
    @After
    public void tearDown() {
        test = null;
    }

    /**
     * Test of openFile method, of class SoundEffect.
     */
    @Test
    public void testOpenClickFile() {
        System.out.println("openFile");
        String soundName = "res/SoundEffect/click_sound_effect.wav";
        SoundEffect instance = new SoundEffect();
        boolean expResult = true;
        boolean result = instance.openFile(soundName);
        System.out.print(result);
        assertEquals(expResult, result);
    }

    @Test
    public void testOpenStepFile() {
        System.out.println("openFile");
        String soundName = "res/SoundEffect/step.wav";
        SoundEffect instance = new SoundEffect();
        boolean expResult = true;
        boolean result = instance.openFile(soundName);
        System.out.print(result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOpenWarningFile() {
        System.out.println("openFile");
        String soundName = "res/SoundEffect/warning.wav";
        SoundEffect instance = new SoundEffect();
        boolean expResult = true;
        boolean result = instance.openFile(soundName);
        System.out.print(result);
        assertEquals(expResult, result);
    }
    
}
