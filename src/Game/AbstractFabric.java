/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GameModel.*;
import IModel.*;
import IView.*;
import java.util.HashMap;

/**
 *
 * @author tranhieu
 */
public abstract class AbstractFabric {
    
    protected HashMap<DishObject,DishObjectView> createdDishObjects = new HashMap<>();
    
    public abstract Bacterium createBactery(Dish d, int size);
    
    public abstract DishObject createBolid(Dish d, int size);
    
    public abstract DishObject createPrimitive(Dish d, String type);
    
    public DishObjectView getDishObjectView(DishObject model){
        return createdDishObjects.get(model);
    }
    
    public void removeObject(DishObject obj){
        createdDishObjects.remove(obj);
    }
    
    public abstract CollisionManager createCollisionManager();
    
    public abstract PlayerController createPlayerController(Bacterium b);
    
    public abstract GameView createGameView(GameModel model, int w, int h);
    
    public abstract DishView createDishView(Dish dish, int w, int h, String background);
    
    public abstract GameManager createGameManager();
}
