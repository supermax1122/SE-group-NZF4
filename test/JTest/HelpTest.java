/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTest;

import javax.swing.JPanel;
import static junit.framework.TestCase.assertEquals;
import nz.ac.aut.ense701.gameModel.Help;
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
public class HelpTest {
    private Help test = new Help();
    
    public HelpTest() {
        
    }
    
    /**
     * Check if JFrame is displayed
     */
    @Test
    public void frameisvisabled(){
        assertEquals(true, test.getFrame().isVisible());
    }
    
    /**
     * Check if JPanel is displayed
     */
    @Test
    public void panelisvisabled(){
        assertEquals(true,test.getPanel().isVisible());
    }
    
    /**
     * Check if panel is added into frame
     */
    @Test
    public void panelisadded(){
        assertEquals(true,test.getPanel().isDisplayable());
    }
    
}
