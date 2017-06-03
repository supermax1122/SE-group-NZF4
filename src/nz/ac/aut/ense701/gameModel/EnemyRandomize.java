/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

import java.util.Random;

/**
 *
 * @author Rongsen Chen
 */
public class EnemyRandomize {
    private Random random;
    
    public EnemyRandomize (){
        random = new Random ();
    }
    
    public int getRandonTime (){
        return random.nextInt(15) + 20;
    }
    
    public int randomRow (int playerRow){
        int randomrow;
        do{
            randomrow = random.nextInt(10);
        }while (playerRow - randomrow < 4 && playerRow - randomrow > -4);
        return randomrow;
    }
    
    public int randomCol (int playerCol){
        int randomcol;
        do{
            randomcol = random.nextInt(10);
        }while (playerCol - randomcol < 4 && playerCol - randomcol > -4);
        return randomcol;
    }
}
