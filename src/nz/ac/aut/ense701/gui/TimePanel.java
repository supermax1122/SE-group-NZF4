/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.Timer;



/**
 *
 * @author Marvin'PC
 */
public class TimePanel extends JPanel{
        public static Timer userTimeAction;
        public static long usedTime = 0;
        
    public TimePanel(){
        
        this.setBorder(new TitledBorder("Time"));
        this.setLayout(new GridLayout(2, 1));
        setTimer();
       

        
    }
    
   private void setTimer(){
        final JLabel lbSysTime = new JLabel();
        final JLabel lbUserTime = new JLabel();
        this.add(lbSysTime, BorderLayout.NORTH);
        this.add(lbUserTime, BorderLayout.SOUTH);
        
        
        
        Timer sysTimeAction = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long timeMillis = System.currentTimeMillis();
                SimpleDateFormat df = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");
                lbSysTime.setText("System Time:   " + df.format(timeMillis));
            }
        });
         sysTimeAction.start();
        userTimeAction = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lbUserTime.setText("Play       Time:   " + (++usedTime)+ " sec.");
            }
        });
        start ();
    }
    
    public void start(){
        userTimeAction.start();
    
    }   
    public void stop(){
        userTimeAction.stop();
    }
    
    public void setZero(){
        usedTime=0;
    
    }
    
    public long getUserTime(){
    
        return usedTime;
    }
    

       public static void main(String[] args){
       
           JFrame jf=new JFrame();
           JPanel jp=new JPanel();
           TimePanel timer= new TimePanel();
            //jf.set
           jf.add(jp);
           jp.add(timer, BorderLayout.EAST);
           jf.setVisible(true);
           jf.setSize(515, 600);
           jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           timer.start();
           
       }
    
}
    
    

    

