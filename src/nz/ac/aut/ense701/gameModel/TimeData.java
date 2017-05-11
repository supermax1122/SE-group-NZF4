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
    public final static int GAME_TIME = 120;
    private String systemTime;
    private String countDownTime;
    private String countUpTime;
    private long usedTime;
    private boolean stop;
    private long passTime;

    public TimeData() {
        countFinished = false;
        usedTime=0;
        stop=false;
        countDown();
        SysTime();
        countUp();
        passTime=0;
                
    }

    public void countDown() {
        end = System.currentTimeMillis() + GAME_TIME * 1000;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                long sub = end - System.currentTimeMillis();
                countDownTime = updateTimer(sub);
              //  System.out.println("Count Down : " + countDownTime);
                if (sub < 0) {
                    countFinished = true;

                }

            }

        }, 0, 1000);
    }

    public void countUp() {
        end = System.currentTimeMillis();
        usedTime = 0;   
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
         long sub;   
            public void run() {
                if(!stop){
                sub = System.currentTimeMillis() - end+passTime;
                
                usedTime=sub/1000;
                countUpTime = updateTimer(sub);
                }
                else{
                passTime=sub;
                }
            }
        }, 0, 1000);
    }

    public void stopCount(){
        
        this.stop=true;    
    }
    
    public void startCount(){
        this.stop=false;
        reCountUp();
  
    }
    
    public void SysTime() {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                long sub = System.currentTimeMillis();
                systemTime = updateTimer(sub);
          //      System.out.println("System Time : " + systemTime);

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
