/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTest;

import nz.ac.aut.ense701.gameModel.ScoreRecord;
import nz.ac.aut.ense701.gameModel.FileOut;
import java.util.List;
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
public class FileOutTest {
    private List<ScoreRecord> list;
    private FileOut fileOut;
    
    public FileOutTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ScoreRecord aScoreRecord=new ScoreRecord();
        aScoreRecord.setName("Weiwei Ma");
        aScoreRecord.setMapNo("Weiwei Ma");
        aScoreRecord.setDiffculty("Weiwei Ma");
        aScoreRecord.setScore("Weiwei Ma");    
        fileOut=new FileOut();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of scoreListFileOut method, of class FileOut.
     */
    @Test
    public void testScoreListFileOut() throws Exception {
        
        
        
        
    }


    
}
