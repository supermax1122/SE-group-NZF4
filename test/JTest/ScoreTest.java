/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTest;

import nz.ac.aut.ense701.gameModel.GameModel;
import nz.ac.aut.ense701.gameModel.Score;
import nz.ac.aut.ense701.gameModel.TimeData;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marvin'PC
 */
public class ScoreTest {
    
    private Score score;
    private TimeData timeData;
    private GameModel gameModel;
    
    
    public ScoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        score=new Score();
        gameModel=GameModel.Challenge;
        timeData=new TimeData(gameModel);
        
    }
    
    @After
    public void tearDown() {
        score=null;
        timeData=null;
        gameModel=null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
        @Test
    public void testGetScore(){
            assertEquals(0, score.getscore());
    
    }
    
    @Test
    public void testAddExtra(){
        int preScore=score.getscore();
        score.addExtra(10);
        int curScore=score.getscore();
        assertEquals(preScore+10, curScore);
    }

    @Test
    public void testEndCount(){
        int preScore=score.getscore();
        score.endCount(timeData);
        int curScore=score.getscore();
        assertEquals(preScore+50, curScore);
        
    
    }
    @Test
    public void testPlusScore(){
         int prescore=score.getscore();
        score.plusScore(timeData);
        int curscore=score.getscore();
       
        assertTrue("TRUE", curscore<30);
    
    }

}
