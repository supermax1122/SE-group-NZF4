/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Marvin'PC
 */
public class ScoreRecord implements Comparable<ScoreRecord>


{

    private String Name;
    private String MapNo;
    private String Diffculty;
    private String score;

    public ScoreRecord() {
        this.Name = "Unknown";
        this.MapNo = "Unknown";
        this.Diffculty = "Unknown";
        this.score = "Unknown";

    }
    
    public ScoreRecord(String name,String MapNo,String Diffculty,String score){
         this.Name = name;
        this.MapNo = MapNo;
        this.Diffculty = Diffculty;
        this.score = score;
    
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getMapNo() {
        return MapNo;
    }

    public void setMapNo(String MapNo) {
        this.MapNo = MapNo;
    }

    public String getDiffculty() {
        return Diffculty;
    }

    public void setDiffculty(String Diffculty) {
        this.Diffculty = Diffculty;
    }

    @Override
    public int compareTo(ScoreRecord aScoreRecord) {
        if ("Challenge".equals(this.Diffculty)) {
            if ("Challenge".equals(aScoreRecord.Diffculty)) {
                if (Integer.parseInt(this.score) > Integer.parseInt(aScoreRecord.score)) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return -1;
            }
        } else if ("HARD".equals(this.Diffculty)) {
            if ("Challenge".equals(aScoreRecord.Diffculty)) {
                return 1;
            } else if ("HARD".equals(aScoreRecord.Diffculty)) {
                if (Integer.parseInt(this.score) > Integer.parseInt(aScoreRecord.score)) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return -1;
            }
        } else if ("NORMAL".equals(this.Diffculty)) {
            if ("Challenge".equals(aScoreRecord.Diffculty)) {
                return 1;
            } else if ("HARD".equals(aScoreRecord.Diffculty)) {
                return 1;

            } else if ("NORMAL".equals(aScoreRecord.Diffculty)) {
                if (Integer.parseInt(this.score) > Integer.parseInt(aScoreRecord.score)) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return -1;
            }
        } else if ("EASY".equals(this.Diffculty)) {
            if ("EASY".equals(aScoreRecord.Diffculty)) {
                if (Integer.parseInt(this.score) > Integer.parseInt(aScoreRecord.score)) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String str = "**\n";
        str += "Name. : " + getName() + "\n";
        str += "MapNo :" + getMapNo() + "\n";
        str += "Diffculty :" + getDiffculty() + "\n";
        str += "score  : " + getScore() + "\n";
        str += "**\n";
        str += "\n";
        return str;
    }

}
