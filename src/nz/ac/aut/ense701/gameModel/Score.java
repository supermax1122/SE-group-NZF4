/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;



/**
 *
 * @author Marvin'PC
 */
public class Score {

    private int score;
    private int preTime;
    private int curTime;

    public Score() {

        score = 0;
        preTime = 0;
        curTime = 0;
    }

    public void plusScore(TimeData timeData) {

        curTime = (int) timeData.getUserTime();
        int periodTime = curTime - preTime;

        if(periodTime==0){
            score=score;
        }
        if (periodTime < 5) {
            score = score + periodTime * 5;
        } else if (periodTime < 10) {
            score = score + periodTime * 3;
        } else if (periodTime < 30) {
            score = score + periodTime * 2;
        } else {
            score = score + 1;
        }

        preTime = curTime;

    }

    public void endCount(TimeData timeData) {

        int playTime = (int) timeData.getUserTime();
        
        if (playTime < 100) {
            score = score + 50;
        } else if (playTime < 1000) {
            score = score + 20;
        } else {
            score = score + 5;
        }

    }
    
    public void addExtra(int extraPoint){
        
        score=score+extraPoint;
    
    }

    public int getscore() {
        return score;
    }
    

}
