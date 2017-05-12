/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTest;

import static junit.framework.TestCase.assertEquals;
import nz.ac.aut.ense701.gameModel.Durability;
import nz.ac.aut.ense701.gameModel.Enemy;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.Position;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rongsen Chen
 */
public class EnemyTest extends junit.framework.TestCase{
    private Enemy enemy;
    private Game game;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        game = new Game ();
        Position position = new Position (game.getIsland(), 0, 0);
        enemy = new Enemy (position, "Enemy", "Enemy try to catch player", game.getPlayer(), 10, game);
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @After
    public void tearDown() {
        game = null;
        enemy = null;         
    }

    /**
     * Test if the enemy will move to player's location
     */
    @Test
    public void testTracePlayer (){
        boolean move = false;
        Position position = enemy.getPosition();
        enemy.tracePlayer();
        if (position.getRow() != enemy.getPosition().getRow() || position.getColumn() != enemy.getPosition().getColumn())
            move = true;
        assertTrue(move);
    }
    
    /**
     * test if the thread is running
     */
    public void testIsAlive (){
        assertTrue(!enemy.isAlive());
    }
    
    /**
     * test if it call stop to the thread
     */
    @Test
    public void testEnemyRetreat (){
        enemy.EnemyRetreat();
        assertTrue(!enemy.isAlive());
    }
}
