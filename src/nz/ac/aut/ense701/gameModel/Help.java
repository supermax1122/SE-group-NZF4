/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Near
 */
public class Help {
    private JFrame frame;
    private JPanel main;
    
    
    public Help(){
        //Initialize a JFrame
        frame = new JFrame("Help");
        
        //Initialize a Panel and add component
        main = new JPanel();
        main.add(Description());
        
        //Add main panel to frame
        frame.add(main);
        
        //JFrame Setup
        frame.pack();
        frame.setVisible(true);
    }
    
    //Create a Panel includes description of this game
    private JPanel Description(){
        JPanel p = new JPanel();
        
        JEditorPane editorPane = new JEditorPane("text/html", "");
        editorPane.setText("<b>Victory Conditions</b><br>"
                + "Before your stamina is exhausted or you are dead:<br>"
                + "<ul><li>Find all Kiwis on this island</li>or<br><li>Catch 80% Predators on this island by using Trap</li></ul>"
                + "<b>Operating Instructions</b><br>"
                + "Moving Direction:<br>"
                + "Move up: W<br>"
                + "Move down: S<br>"
                + "Move left: A<br>"
                + "Move right: D<br>"
                + "<b>Pick up item</b>:<br>"
                + "Move to the position of item, then select item from 'Object' menu and click 'Collect' button<br>"
                + "<b>Use items</b>:<br>"
                + "Select the item that you gonna use on the 'Inventory' menu, then click 'Use' button<br>"
                + "<b>Catch predator</b>:<br>"
                + "Move to the position of Predator, then select 'Trap' in 'Inventory' menu and click 'Use' button<br>"
                + "<b>Count Kiwi</b>:<br>"
                + "Go to the position of Kiwi, then select 'Kiwi' from 'Object' menu and click 'Count' button<br>"
                + "<b>Drop items</b>:<br>"
                + "Select item from 'inventory' menu and click 'Drop' button<br>"
                + "<b>Terrain</b><br>"
                + "Different terrain costs different stamina:<br>"
                + "Water(Blue): 4 stamina<br>"
                + "Sand(Yellow): 1 stamina<br>"
                + "Forest(Green): 2 stamina<br>"
                + "Wetland(Purple/Deep Blue): 2.5 stamina<br>"
                + "Scrub(Deep Grey/Black): 3 stamina<br>"
                + "<b>Item Details</b><br>"
                + "Sandwich: Recover 50% stamina<br>"
                + "Muesli Bar: Recover 50% stamina<br>"
                + "Apple: Recover 50% stamina<br>"
                + "Orange Juice: Recover 50% stamina<br>"
                + "Trap: Catch predators<br>"
                + "Screwdriver: Fix traps<br>"
                + "<b>Capital Letters</b><br>"
                + "E: Equitment that player can pick up<br>"
                + "T: Tools that player can pick up<br>"
                + "F: Fauna that lives on this island<br>"
                + "K: Kiwis on this island<br>"
                + "P: Predators on this island<br>"
                + "H: Hazards on this island<br>");
        p.add(editorPane);
        return p;
    }
    
    public JFrame getFrame(){
        return this.frame;
    }
    
    public JPanel getPanel(){
        return this.main;
    }
}
