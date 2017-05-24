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
    public final static int GAME_TIME = 121;
    private String systemTime;
    private String countDownTime;
    private String countUpTime;
    private long usedTime;
    private boolean stop;
    private long passTime;
    private GameModel model;

    public TimeData(GameModel model) {
        this.model = model;
        countFinished = false;
        usedTime = 0;
        stop = true;
        SysTime();
        if (model == GameModel.Challenge) {
            countDown();
        } else if (model == GameModel.Normal) {
            countUp();
        }
        passTime = 0;

    }

    public void countDown() {
        end = System.currentTimeMillis() + (GAME_TIME)* 1000;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {

                if (!stop) {
                    long sub = end - System.currentTimeMillis();
                    countDownTime = updateTimer(sub);
                    System.out.println("Count Down : " + countDownTime);
                    if (sub < 0) {
                        countFinished = true;
                    }
                }else{
                
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
                if (!stop) {
                    sub = System.currentTimeMillis() - end + passTime;
                    
                    usedTime = sub / 1000;                 
                    countUpTime = updateTimer(sub);              
                    System.out.println("Count up : " + countUpTime);
                    
                } else {
                    passTime = sub;
                     System.out.println("passTime : " + passTime);
                }
            }
        }, 0, 1000);
    }

    
    public void SysTime() {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                long sub = System.currentTimeMillis();
                systemTime = updateTimer(sub);
              //   System.out.println("System Time : " + systemTime);

            }

        }, 0, 1000);

    }

    
    public void pause(){
        this.stop = true;
    }

    public void resume(){
       if (model == GameModel.Challenge) {
            stop=false;
            end = System.currentTimeMillis() + GAME_TIME * 1000;
        } else if (model == GameModel.Normal) {
           stop=false;
           end = System.currentTimeMillis();
        }
          
    }
 
    public void startNewTime() {
        this.stop = false;
        if (model == GameModel.Challenge) {
             end = System.currentTimeMillis() + GAME_TIME * 1000;
             countFinished=false;
        } else if (model == GameModel.Normal) {
            end = System.currentTimeMillis();
            passTime=0;
        }

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

    public long getUserTime() {
        return usedTime;
    }

    public GameModel getModel() {
        return model;
    }

    public void setModel(GameModel model) {
        this.model = model;
    }

    public static void main(String args[]) {
        TimeData time = new TimeData(GameModel.Challenge);
        time.startNewTime();
        //      time.SysTime();
        //       time.countUp();
    }

}
