/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nz.ac.aut.ense701.gameModel.GameModel;
import nz.ac.aut.ense701.gameModel.TimeData;

/**
 *
 * @author Marvin'PC
 */
public class TimePanel extends JPanel {

    private JLabel sysTimeLable;
    private JLabel countTimeLable;
    private TimeData timeData;
    private final GameModel model;
    private Timer timeAction;

    public TimePanel(GameModel model,TimeData timeData) {
        this.model = model;
        this.timeData = timeData;
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        initializLable();
      //  this.setOpaque(false);
    }

    private void initializLable() {
        sysTimeLable = new JLabel("", JLabel.LEFT);
        countTimeLable = new JLabel("", JLabel.LEFT);
        Font font = new Font("Default", Font.PLAIN, 10);
        sysTimeLable.setFont(font);
        countTimeLable.setFont(font);
   //     sysTimeLable.setSize(100,100);

        
        JPanel timePanel = new JPanel();
        timePanel.setOpaque(false);
        //timePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Time"));
        timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.Y_AXIS));
  
        timePanel.add(sysTimeLable);
        timePanel.add(countTimeLable);
        this.add(timePanel, BorderLayout.CENTER);

        sysTimeLable.setBorder(javax.swing.BorderFactory.createTitledBorder("System Time"));
        countTimeLable.setBorder(javax.swing.BorderFactory.createTitledBorder("Count    Time"));
        if (model == GameModel.Challenge) {
           // timeData.SysTime();
          //  timeData.countDown();
            timeData.reCountDown();
            new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sysTimeLable.setText("System        Time: " + timeData.getSystemTime());
                    countTimeLable.setText("CountDown Time: " + timeData.getCountDownTime());
                }
            }).start();

        } else if (model ==GameModel.Normal) {
           // timeData.SysTime();
          //  timeData.countUp();
            timeData.reCountUp();
           timeAction= new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sysTimeLable.setText("System        Time: " + timeData.getSystemTime());
                    countTimeLable.setText("Play            Time: " + timeData.getCountUpTime());
                }
            });
           timeAction.start();
        }

    }

    public TimeData getTimeData() {
        return timeData;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TimeData timeData=new TimeData();
        JPanel countDownPanel = new TimePanel(GameModel.Normal,timeData);
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(countDownPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
