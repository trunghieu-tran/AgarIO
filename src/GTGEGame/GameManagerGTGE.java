/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEGame;

import Game.AbstractFabric;
import Game.GameManager;
import com.golden.gamedev.GameLoader;
import java.awt.Dimension;

/**
 *
 * @author tranhieu
 */
public class GameManagerGTGE extends GameManager{
    
    private GameGTGE gamegtge;
    
    public GameManagerGTGE(AbstractFabric fabric) {
        super(fabric);
        GameLoader game;
        game = new GameLoader();
        gamegtge = new GameGTGE(this);
        ((GTGEFabric)fabric).setGameGTGEObject(gamegtge);
        game.setup(gamegtge, new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT), false);
        game.start();
    }
    
    public GameGTGE getGameGTGE(){
        return gamegtge;
    }
    
}
