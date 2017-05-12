/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTest;

import nz.ac.aut.ense701.gameModel.EnemyRandomize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rongsen Chen
 */
public class EnemyRandomizeTest extends junit.framework.TestCase{
    private EnemyRandomize randomize;
    
    @Before
    public void setUp() {
        randomize = new EnemyRandomize ();
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @After
    public void tearDown() {
        randomize = null;
    }
    
    /**
     * Test getRandomTime should return a integer value bigger than 0
     */
    @Test
    public void testGetRandomTime (){
        boolean result = false;
        if (randomize.getRandonTime() > 0)
            result = true;
        
        assertTrue(result);
    }

    /**
     * The random row should not in the same row as player
     */
    @Test
    public void testRandomRow (){
        boolean result = !(5 == randomize.randomRow(5));
        
        assertTrue(result);        
    }
    
    /**
     * The random column should not in the same row as player
     */
    @Test
    public void testRandomCol (){
        boolean result = !(5 == randomize.randomCol(5));
        
        assertTrue(result);        
    }

}
