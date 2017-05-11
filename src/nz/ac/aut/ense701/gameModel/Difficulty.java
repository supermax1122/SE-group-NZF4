/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

/**
 *
 * @author Rongsen Chen
 */
public enum Difficulty {
    ESAY(1500), NORMAL(1200), HARD(800);
    
    private int value;
    
    private Difficulty (int value){
        this.value = value;
    }
    
    public int getValue (){
        return value;
    }
}
