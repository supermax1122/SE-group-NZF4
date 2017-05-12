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
public enum GameModel {
    
    Challenge(1),Normal(0);
 
    private int value;
    
    private GameModel (int value){
        this.value = value;
    }
    
    public int getValue (){
        return value;
    }
}
