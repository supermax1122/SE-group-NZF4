/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Marvin'PC
 */
public class CountdownPanel extends JPanel {

    private JLabel label;
    private boolean finished;
    public final static int GAME_TIME=60;

    public CountdownPanel() {
        finished = false;
        countDown();
    }

    public boolean isCountFinished() {

        return finished;
    }

    public void countDown() {

        label = new JLabel("", JLabel.CENTER);
        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.CENTER);
        this.setVisible(true);

       // System.out.println("How long：");
       // Scanner input = new Scanner(System.in);
       // int i = input.nextInt();
        int i =GAME_TIME;
        final long end = System.currentTimeMillis() + i * 1000 * 60;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                long sub = end - System.currentTimeMillis();
                if (sub < 0) {
                    return;
                }
                updateTimer(sub);
            }

        }, 0, 1000);
    }

    public void updateTimer(long sub) {
        int h = (int) (sub / 1000 / 60 / 60);
        int m = (int) (sub / 1000 / 60 % 60);
        int s = (int) (sub / 1000 % 60);
        String str = h + ":" + m + ":" + s;

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        Font font = new Font("Default", Font.PLAIN, 40);
        label.setFont(font);
        try {
            date = sdf.parse(str);
            if(h==0&&m==0&&s==0){
                finished=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        label.setText(sdf.format(date));
 //       System.out.println(sdf.format(date));
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel countDownPanel=new CountdownPanel();
        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(countDownPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
