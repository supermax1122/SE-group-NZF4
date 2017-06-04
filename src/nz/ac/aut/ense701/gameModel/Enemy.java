/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rongsen Chen
 */
public class Enemy extends Occupant implements Runnable{
    private long moveFrequency;
    private boolean run = false, pause=false;
    private Player player;
    private Position position;
    Game game;
    
    public Enemy (Position position, String name, String description, Player player,long moveFrequency, Game game){
        super(position, name, description);
        this.moveFrequency = moveFrequency;
        this.player = player;
        this.position = position;
        this.game = game;
    }
    
    @Override
    public void run (){
        run = true;
        while (run){
                if(pause==false)
                {
                    tracePlayer ();
                    game.EnemyMove();
                }
                killPlayer();
                try {
                    Thread.sleep(moveFrequency);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Enemy.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    //try to catch player
    public void tracePlayer (){
        int vertical = position.getRow() - player.getPosition().getRow();
        int horizontal = position.getColumn() - player.getPosition().getColumn();

        if (horizontal < 0){
            game.getIsland().removeOccupant(position, this);
            position = position.getNewPosition(MoveDirection.EAST);
            game.getIsland().addOccupant(position, this);
        }else if (horizontal > 0){
            game.getIsland().removeOccupant(position, this);
            position = position.getNewPosition(MoveDirection.WEST);
            game.getIsland().addOccupant(position, this);
        }else if (vertical < 0){
            game.getIsland().removeOccupant(position, this);
            position = position.getNewPosition(MoveDirection.SOUTH);
            game.getIsland().addOccupant(position, this);
        }else if (vertical > 0){
            game.getIsland().removeOccupant(position, this);
            position = position.getNewPosition(MoveDirection.NORTH);
            game.getIsland().addOccupant(position, this);
        }
    }
    
    //kill player when in sam position
    public void killPlayer (){
        int vertical = position.getRow() - player.getPosition().getRow();
        int horizontal = position.getColumn() - player.getPosition().getColumn();
        if (vertical == 0 && horizontal ==0){
            game.getPlayer().kill();
            game.enemyKilled("The enemy has find you!");
        }
    }
        
    public boolean isAlive (){
        return run;
    }
    
    public void EnemyRetreat (){
        run = false;
    }

    @Override
    public String getStringRepresentation() {
        return "X";
    }
    
    public void pauseEnemy(){
        this.pause=true;
    }
    
    public void resumeEnemy(){
        this.pause=false;
    }
}
