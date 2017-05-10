/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author Marvin'PC
 */
public class TimeData {

    private boolean countFinished;
    private long end;
    public final static int GAME_TIME = 60;
    private String systemTime;
    private String countDownTime;
    private String countUpTime;
    private long usedTime;
    private boolean stop;

    public TimeData() {
        countFinished = false;
        usedTime=0;
        stop=false;
        countDown();
        SysTime();
        countUp();
                
    }

    public void countDown() {
        end = System.currentTimeMillis() + GAME_TIME * 1000;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                long sub = end - System.currentTimeMillis();
                countDownTime = updateTimer(sub);
                System.out.println("Count Down : " + countDownTime);
                if (sub < 0) {
                    countFinished = true;

                }

            }

        }, 0, 1000);
    }

    public void countUp() {
        end = System.currentTimeMillis();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                if(!stop){
                long sub = System.currentTimeMillis() - end;
                usedTime=sub;
                countUpTime = updateTimer(sub);
                System.out.println("Count Up : " + countUpTime);
                }
            }

        }, 0, 1000);
    }

    public void stopCount(){
        this.stop=true;
    
    }
    
    public void startCount(){
        this.stop=false;
    
    }
    
    public void SysTime() {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                long sub = System.currentTimeMillis();
                systemTime = updateTimer(sub);
                System.out.println("System Time : " + systemTime);

            }

        }, 0, 1000);

    }
    
    public void reCountDown(){
        end = System.currentTimeMillis() + GAME_TIME * 1000;
    }
    
    public void reCountUp(){
        end = System.currentTimeMillis();
    
    }

    public String updateTimer(long sub) {
        int h = (int) (sub / 1000 / 60 / 60);
        int m = (int) (sub / 1000 / 60 % 60);
        int s = (int) (sub / 1000 % 60);
        String str = h + ":" + m + ":" + s;

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();

        try {
            date = sdf.parse(str);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sdf.format(date);
        //   System.out.println();
        //       label.setText(sdf.format(date));
    }

    public boolean isCountFinished() {
        return countFinished;
    }

    public String getSystemTime() {
        return systemTime;
    }

    public String getCountDownTime() {
        return countDownTime;
    }

    public String getCountUpTime() {
        return countUpTime;
    }

    
    public long getUserTime(){
    
        return usedTime;
    }
    public static void main(String args[]) {
        TimeData time = new TimeData();
        time.countDown();
        time.SysTime();
        time.countUp();

    }

}
