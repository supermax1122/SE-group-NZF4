/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogInUI;

/**
 *
 * @author MengMeng
 */
public class User {
      private String UserName;
      private int sex;
      //there should have user score, it s should be add later when we finished the game program.
      private int score;
      public int getScore(){
	return this.score;
      }
     public void setScore(int score){
	this.score= score;
     }
     
     	public User() {}
		
	public User(String name, int sex) {
	
		this.UserName = name;
		this.sex = sex;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String name) {
		this.UserName = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

      
    
}
