/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScoreBoardGUI;

/**
 *
 * @author MengMeng
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScoreBoard {
	public ScoreBoard(){
	     JFrame f=new JFrame();
	     Object[][] playerInfo={
	                 {"Sample Player One",new Integer(66)},
	                {"Sample Player Two",new Integer(82)}
	    };
	    String[] Names={"Player Name","Score"};
	    DefaultTableModel de = new DefaultTableModel(playerInfo,Names);
	    
	    JTable table=new JTable(de);
	    table.setPreferredScrollableViewportSize(new Dimension(550,300));
	    JScrollPane scrollPane=new JScrollPane(table);
	    f.getContentPane().add(scrollPane,BorderLayout.CENTER);
	    f.setTitle("Simple Table");
	    f.pack();
	    f.show();

	    f.addWindowListener(new WindowAdapter() {
	                        public void windowClosing(WindowEvent e) {
	                          System.exit(0);
	                        }
	                      });
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScoreBoard b=new ScoreBoard();
	}

}
