/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Marvin'PC
 */
public class ScoreRecord implements Comparable<ScoreRecord>
//        Comparator<ScoreRecord> 

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
        } else if ("ESAY".equals(this.Diffculty)) {
            if ("ESAY".equals(aScoreRecord.Diffculty)) {
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

    
    
    public static void main(String args[]){
        ScoreRecord a=new ScoreRecord("1", "01", "HARD", "1000");
        ScoreRecord b=new ScoreRecord("2", "01", "Challenge", "1000");
        ScoreRecord c=new ScoreRecord("3", "01", "ESAY", "1000");
        ScoreRecord d=new ScoreRecord("4", "01", "ESAY", "900");
        ScoreRecord e=new ScoreRecord("5", "01", "HARD", "1000");
    //    ArrayList<ScoreRecord> list=new ArrayList<ScoreRecord>();
        List<ScoreRecord> list=new LinkedList<ScoreRecord>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
      // Array.sort(list);
       Collections.sort(list);
       
         for(ScoreRecord x:list){
             System.out.println(x);       
         }
      
       System.out.println( a.compareTo(b));
       System.out.println( e.compareTo(d));
         System.out.println( a.compareTo(b));
    }


}
