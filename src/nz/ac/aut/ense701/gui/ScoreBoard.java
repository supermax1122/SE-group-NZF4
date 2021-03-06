/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;


import nz.ac.aut.ense701.gameModel.ScoreRecord;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import nz.ac.aut.ense701.gameModel.ScoreList;

/**
 *
 * @author Marvin'PC
 */
public class ScoreBoard extends JPanel {

    private ArrayList<ScoreRecord> scoreList;
    private JTable table;
  
    DefaultTableModel tableModel ;
    
    public ScoreBoard(ArrayList<ScoreRecord> scoreList) {
       
        this.scoreList = scoreList;    
        String[] columnNames = {"Name", "MapNo","Diffculty","Score"};
        this.table = new JTable();
        table.setBackground(Color.CYAN);
        fillTable();
        JScrollPane scrollPane=new JScrollPane(table);
	this.add(scrollPane,BorderLayout.CENTER);
        this.setBackground(Color.lightGray);
    }

    public void fillTable() {
        tableModel = (DefaultTableModel) this.table .getModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("MapNo");
        tableModel.addColumn("Diffculty");
        tableModel.addColumn("Score");
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
       render.setHorizontalAlignment(SwingConstants.CENTER);
       this.table.getColumn("Name").setCellRenderer(render);
       this.table.getColumn("MapNo").setCellRenderer(render);
       this.table.getColumn("Diffculty").setCellRenderer(render);
       this.table.getColumn("Score").setCellRenderer(render);          
        tableModel.setRowCount(0);
        for (ScoreRecord a : scoreList) {
            String[] arr = new String[4];
            arr[0] = a.getName();
            arr[1] = a.getMapNo();
            arr[2] = a.getDiffculty();
            arr[3] = a.getScore();
            tableModel.addRow(arr);
        }
        
    }

}
