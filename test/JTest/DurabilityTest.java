/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTest;

import nz.ac.aut.ense701.gameModel.Durability;
import nz.ac.aut.ense701.gameModel.Tool;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rongsen Chen
 */
public class DurabilityTest extends junit.framework.TestCase{
    Durability durability;
    Tool tool;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        durability = new Durability ();
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @After
    public void tearDown() {
        durability = null;        
    }

    @Test
    public void testGetDurability (){
        assertEquals(0, durability.getDurability());
    }
    
    @Test
    public void testSetDurability (){
        durability.setDurability(3);
        assertEquals(3, durability.getFulldurability());
    }
    
    @Test
    public void testGetDroprate (){
        assertEquals(0, durability.getDroperate());        
    }
    
    @Test
    public void testSetDroprate (){
        durability.setDroperate(1);
        assertEquals(1, durability.getDroperate());                
    }
    
    /**
     * Test durability drop after use
     */
    @Test
    public void testUse (){
        durability.setDurability(3);
        durability.setDroperate(1);
        durability.use();
        assertEquals(2, durability.getDurability());
    }
    
    /**
     * Test full durability remain after use
     */
    @Test
    public void testGetFullDurability (){
        durability.setDurability(3);
        durability.setDroperate(1);
        durability.use();
        assertEquals(3, durability.getFulldurability());
    }
    
    /**
     * Test after used, durability can still be restore to full  
     */
    @Test
    public void testDurabilityReastore (){
        durability.setDurability(3);
        durability.setDroperate(1);
        durability.use();
        durability.durabilityReastore();
        assertEquals(durability.getFulldurability(), durability.getDurability());        
    }
}
