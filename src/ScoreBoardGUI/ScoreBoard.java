/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScoreBoardGUI;

/**
 *
 * @author hongzhou sha
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScoreBoard {
		
	public ScoreBoard(){
	     JFrame f=new JFrame();
	 
	    String[] Names={"Player Name","Score","Game Level"};
	    DefaultTableModel de = new DefaultTableModel(createArray("A:/errlog.txt"),Names);
	    
	    JTable table=new JTable(de);
	    table.setPreferredScrollableViewportSize(new Dimension(550,300));
	    JScrollPane scrollPane=new JScrollPane(table);
	    f.getContentPane().add(scrollPane,BorderLayout.CENTER);
	    f.setTitle("ScoreBoard Table");
	    f.pack();
	    f.show();

	    f.addWindowListener(new WindowAdapter() {
	                        public void windowClosing(WindowEvent e) {
	                          System.exit(0);
	                        }
	                      });
	   }
     /**
     * read the TXT file.
     * @param filePath
     * @return
     */
    public static  List  readTxtFile(String filePath) {
        List<String> list = new ArrayList<String>();
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    if (!lineTxt.startsWith("#"))
                        list.add(lineTxt);
                }
                read.close();
            } else {
                System.out.println("The TXT file can not be found!");
            }
        } catch (Exception e) {
            System.out.println("readTxtFile Exception!!");
            e.printStackTrace();
        }
        return list;
  
    }
      
    /**
     * Creat two-dimensional array.
     * @param list
     * @return
     */

    public static String[][] createArray(String filePath){
        List<String> list = readTxtFile(filePath);
        String array[][] = new String[list.size()][];
        for(int i=0;i<list.size();i++){
            array[i] = new String[3];
            String linetxt=list.get(i);
            String[] myArray = linetxt.replaceAll("\\s+", "@").split("@");
            for(int j=0;j<myArray.length;j++){
                if(j<3){
                    array[i][j]=myArray[j];
                }
            }
        }
        return array;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                //deispaly test
		ScoreBoard b=new ScoreBoard();
	
	}

}
