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
public class Durability {
    private int fulldurability;
    private int durability;
    private int droperate;    
    
    public Durability (){
    }
    
    public Durability (int durability, int rate){
        setDurability(durability);
        setDroperate(rate);
    }
    
    public int getDurability() {
        return durability;
    }
    
    public void durabilityReastore(){
        durability = fulldurability;
    }

    public int getFulldurability() {
        return fulldurability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
        this.fulldurability = durability;
    }

    public int getDroperate() {
        return droperate;
    }

    public void setDroperate(int dropreate) {
        this.droperate = dropreate;
    }    
    
    public void use (){
        durability = durability - droperate;
    }
}
