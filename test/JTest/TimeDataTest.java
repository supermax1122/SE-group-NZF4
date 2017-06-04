/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTest;

import java.util.logging.Level;
import java.util.logging.Logger;
import nz.ac.aut.ense701.gameModel.GameModel;
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
public class TimeDataTest {

    private TimeData timeData;
    private GameModel model;

    public TimeDataTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        model = GameModel.Normal;
        timeData = new TimeData(model);

    }

    @After
    public void tearDown() {
        timeData.shutdown();
        timeData = null;
        model = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testGetSystemTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TimeDataTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str = timeData.getSystemTime();
        assertNotNull(str);

    }

    @Test
    public void testGetCountUpTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TimeDataTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str = timeData.getSystemTime();
        assertNotNull(str);

    }

    @Test
    public void testGetUserTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TimeDataTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        long time = timeData.getUserTime();
        assertTrue(time >= 0);

    }

    @Test
    public void testGetCountDownTime() {

        assertNull(timeData.getCountDownTime());
    }

    @Test
    public void testGetModel() {
        assertEquals(GameModel.Normal, timeData.getModel());

    }

}
