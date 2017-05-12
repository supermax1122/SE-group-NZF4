/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

/**
 *
 * @author Hongzhou Sha
 */
public class User {
      private static String UserName;

      //there should have user score, it s should be add later when we finished the game program.
      private int score;
      public int getScore(){
	return this.score;
      }
     public void setScore(int score){
	this.score= score;
     }
     
     	public User() {}
		
	public User(String name) {
	
		this.UserName = name;
	
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String name) {
		this.UserName = name;
	}




     
    
}
