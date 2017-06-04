/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nz.ac.aut.ense701.gameModel.ScoreList;
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
public class ScoreListTest {
    private ScoreList scoreList;
    private  ArrayList<ScoreRecord> list;
    private ScoreRecord newScoreRecord;
    
    public ScoreListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        scoreList=new ScoreList();
        try {
            list=scoreList.ScoreRecordList();
        } catch (IOException ex) {
            Logger.getLogger(ScoreListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        newScoreRecord=new ScoreRecord();
    }
    
    @After
    public void tearDown() {
        scoreList=null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testScoreRecordList() throws IOException{
        assertNotNull(list);
    
    }
    @Test
    public void testAddNewScoreRecord(){
        int presize=list.size();
        scoreList.addNewScoreRecord(newScoreRecord);
        try {
            list=scoreList.ScoreRecordList();
        } catch (IOException ex) {
            Logger.getLogger(ScoreListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        int cursize=list.size();
        assertTrue("Add", ((presize+1)==cursize));
    } 
    @Test
    public void testScoreListFileOut(){
        int presize=list.size();
        try {
            scoreList.scoreListFileOut(list);
        } catch (IOException ex) {
            Logger.getLogger(ScoreListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        int cursize=list.size();
        assertTrue("Equals",presize==cursize);
    
    }
}
