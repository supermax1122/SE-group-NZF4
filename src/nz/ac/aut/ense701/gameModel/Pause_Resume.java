/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

import nz.ac.aut.ense701.gui.KiwiCountUI;

/**
 *
 * @author Near
 */
public class Pause_Resume {
    final private boolean ispause;

    public boolean isIspause() {
        return ispause;
    }
    
    public Pause_Resume(){
        ispause=false;
    }
    
    public boolean pause_function(Game game,KiwiCountUI ui){
        if(game.getEnemy()==null)
        {
            game.getTimeData().stopCount();
        }
        else
        {
            game.getEnemy().pauseEnemy();
        }
        ui.removeKeyListener(ui.getKeyListeners()[0]);

        return true;
    }
}
