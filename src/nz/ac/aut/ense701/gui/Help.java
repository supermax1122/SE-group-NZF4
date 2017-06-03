/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
        frame.setSize(700,800);
        frame.setVisible(true);
    }
    
    //Create a Panel includes description of this game
    private JPanel Description(){
        JPanel p = new JPanel();
        
        JEditorPane editorPane = new JEditorPane("text/html", ""){
            public boolean getScrollableTracksViewportWidth() {
            return true;
    }
        };
        editorPane.setEditable(false);
        editorPane.setPreferredSize(new Dimension(600,700));
        editorPane.setText("<b>Victory Conditions</b><br>"
                + "Before your stamina is exhausted or you are dead:<br>"
                + "<ul><li>Find all Kiwis on this island</li>or<br><li>Catch 80% Predators on this island by using Trap</li></ul>"
                + "<br><b>Operating Instructions</b><br>"
                + "Moving Direction:<br>"
                + "Move up: W or Direction key ↑<br>"
                + "Move down: S or Direction key ↓<br>"
                + "Move left: A or Direction key ←<br>"
                + "Move right: D or Direction key →<br>"
                + "Pause: Click 'Pause' button, the time and enemy will be paused until you operate again<br>"
                + "<br><b>Game mode</b><br>"
                + "Normal mode: There are several levels in this mode to control the speed of enemy. This mode also has a timer counting how much time you spend to winning this game.<br>"
                + "Challenge mode: You are given 2 minutes in this mode. You have to win the game within 2 mins, or else you lose the game<br>"
                + "<br><b>Pick up item</b>:<br>"
                + "Move to the position of item, then select item from 'Object' menu and click 'Collect' button<br>"
                + "<br><b>Use items</b>:<br>"
                + "Select the item that you gonna use on the 'Inventory' menu, then click 'Use' button<br>"
                + "<br><b>Catch predator</b>:<br>"
                + "Move to the position of Predator, then select 'Trap' in 'Inventory' menu and click 'Use' button<br>"
                + "<br><b>Count Kiwi</b>:<br>"
                + "Go to the position of Kiwi, then select 'Kiwi' from 'Object' menu and click 'Count' button<br>"
                + "<br><b>Drop items</b>:<br>"
                + "Select item from 'inventory' menu and click 'Drop' button<br>"
                + "<br><b>Terrain</b><br>"
                + "Different terrain costs different stamina:<br>"
                + "Water(Blue): 4 stamina<br>"
                + "Sand(Yellow): 1 stamina<br>"
                + "Forest(Green): 2 stamina<br>"
                + "Wetland(Purple/Deep Blue): 2.5 stamina<br>"
                + "Scrub(Deep Grey/Black): 3 stamina<br>"
                + "<br><b>Item Details</b><br>"
                + "Sandwich: Recover 50% stamina<br>"
                + "Muesli Bar: Recover 50% stamina<br>"
                + "Apple: Recover 50% stamina<br>"
                + "Orange Juice: Recover 50% stamina<br>"
                + "Trap: Catch predators and has durability<br>"
                + "Screwdriver: Fix traps by improving the durability<br>"
                + "<br><b>Capital Letters</b><br>"
                + "Fruits: Food that player can pick up<br>"
                + "Box: Tools that player can pick up<br>"
                + "Light-spots: Fauna that lives on this island<br>"
                + "Kiwi: Kiwis on this island<br>"
                + "Shadow of animal: Predators on this island<br>"
                + "Exclamation mark: Hazards on this island<br>"
                + "<br><b>Enemy(Tiger)</b><br>"
                + "Purpose: Catch you to prevent you from saving kiwis<br>"
                + "Appear time and location: Random time and location that enemy appears on the map<br>"
                + "Speed: The moving speed of enemy depends on the game level");
        JScrollPane scrollpane = new JScrollPane(editorPane);
        scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        p.add(scrollpane);
        return p;
    }
    
    public JFrame getFrame(){
        return this.frame;
    }
    
    public JPanel getPanel(){
        return this.main;
    }
}
