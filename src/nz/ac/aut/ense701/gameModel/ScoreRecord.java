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
public class ScoreRecord {

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
	public String toString() {
		String str = "**\n";
		str+="Name. : " + getName() + "\n";
		str+="MapNo :"+getMapNo()+"\n";
		str+="Diffculty :"+getDiffculty()+"\n";
		str += "score  : " + getScore() + "\n";
		str+="**\n";
		str+="\n";
		return str;
	}
    
}
