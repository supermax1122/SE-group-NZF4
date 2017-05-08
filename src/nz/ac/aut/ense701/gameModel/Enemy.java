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
    private boolean run = false;
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
            try {
                Thread.sleep(moveFrequency);
            } catch (InterruptedException ex) {
                Logger.getLogger(Enemy.class.getName()).log(Level.SEVERE, null, ex);
            }
            tracePlayer ();
            game.EnemyMove();
        }
    }
    
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
        }else{
            game.getPlayer().kill();
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
}
