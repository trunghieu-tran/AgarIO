/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GTGEGame.GTGEFabric;

/**
 *
 * @author tranhieu
 */
public class ApplicationLauncher {
    public static void main(String[] args){ 
        AbstractFabric fabric = new GTGEFabric();
        GameManager manager = fabric.createGameManager();
    }
}
