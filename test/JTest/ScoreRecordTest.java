/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTest;

import nz.ac.aut.ense701.gameModel.Difficulty;
import nz.ac.aut.ense701.gameModel.ScoreRecord;
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
public class ScoreRecordTest {

    private ScoreRecord scoreRecord;
    private ScoreRecord compareScoreRecord;

    public ScoreRecordTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        scoreRecord = new ScoreRecord();
        compareScoreRecord=new ScoreRecord();
        scoreRecord.setDiffculty(Difficulty.Challenge+"");
        compareScoreRecord.setDiffculty(Difficulty.Challenge+"");
    }

    @After
    public void tearDown() {
        scoreRecord = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testGetName() {
        assertEquals("Unknown", scoreRecord.getName());
    }

    @Test
    public void tesGettMapNo() {
        assertEquals("Unknown", scoreRecord.getMapNo());
    }

    @Test
    public void testGetDiffculty() {
        assertEquals("Challenge", scoreRecord.getDiffculty());
    }

    @Test
    public void testGetScore() {
        assertEquals("Unknown", scoreRecord.getScore());
    }
    
    public void testCompareTo(){
        assertEquals(0, scoreRecord.compareTo(compareScoreRecord));
    }

}
