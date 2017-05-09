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
public class RandomEnemyTime {
    Random random;
    
    public RandomEnemyTime (){
        random = new Random ();
    }
    
    public int getRandonTime (){
        return random.nextInt(15) + 20;
    }
}
