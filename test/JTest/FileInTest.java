/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTest;

import nz.ac.aut.ense701.gameModel.FileIn;
import nz.ac.aut.ense701.gameModel.ScoreRecord;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rongsen Chen
 */
public class FileInTest {
    FileIn filein;

       
    @Before
    public void setUp() {
        String url = "scoreFile.txt";
        filein = new FileIn(url);
    }
    
    @After
    public void tearDown() {
        filein = null;
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testScoreRecordList() throws Exception {
        String expResult = "Weiwei Ma";
        List<ScoreRecord> scores = filein.ScoreRecordList();
        String result = scores.get(0).getName();
        System.out.println(result);
        System.out.println(expResult);

        assertEquals(expResult, result);
    }
}
