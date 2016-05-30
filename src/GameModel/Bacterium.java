/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import GameModel.specializations.Ration;
import GameModel.specializations.Specialization;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author tranhieu
 */
public class Bacterium extends DishObject {
    
    private Specialization spec;
    
    private static Random rn = new Random();
    
    private int nextLevel;
    
    private final int FIRST_UPGRADE_LEVEL = 100;
    
    private final int LEVEL_JUMP = 50;
    
    private ArrayList<DishObject> resources = new ArrayList<>();
    
    public Bacterium(Dish d, int size, Specialization s) {
        super(d, size);
        spec = s;
        nextLevel = FIRST_UPGRADE_LEVEL;
    }
    
    @Override
    public boolean collideWith(DishObject o) {
        if (spec.canEat(o, (DishObject)this)) {
            dish.removeObject(o);
            eat(o);
            return true;
        }
        return false;
    }
    
    private void eat(DishObject food){
        resources.add(food);
        resize(digest());
    }
    
    private void resize(int change){
        if(change==0)
            return;
        setSize(getSize()+change);
    }
    
    private int digest(){
        Ration completedRation = spec.completedRation(resources);
        if(completedRation == null)
            return 0;
        int eatenSize = 0;
        Map<String,Integer> objects = completedRation.getRation();
        for(String type : objects.keySet()){
            for(int i=0;objects.get(type)>0 && i<resources.size();++i){
                if(resources.get(i).getType().equals(type)){
                    eatenSize += resources.get(i).getSize();
                    resources.remove(i--);
                    objects.put(type,objects.get(type)-1);
                }
            }
        }
        return completedRation.getSizeGrowth(eatenSize);
    }

    @Override
    public String getType() {
        return spec.getType();
    }
    
    
}
