/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neversync;

import byui.cit260.neversync.view.StartProgramView;
////import cit260.neversync.model.Condition;
import cit260.neversync.model.Game;
//import cit260.neversync.model.InventoryItem;
//import cit260.neversync.model.ItemType;
//import cit260.neversync.model.Location;
//import cit260.neversync.model.Map;
import cit260.neversync.model.Player;
//import cit260.neversync.model.Question;
//import cit260.neversync.model.Scene;
//import cit260.neversync.model.StoreHouse;



/**
 *
 * @author Ben Langston, Jeff Ledbetter
 */

public class NeverSync {
    
        private static Game currentGame = null;
        private static Player player =null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        NeverSync.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        NeverSync.player = player;
    }
        
        
    
	public static void main(String[] args) {
            
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.displayStartProgramView();
//            startProgramView.displayMainMenuView();
            
            
            
            
            
            
            
            
            
            
	
//            System.out.println("\nThese are the team test classes:\n");
//            testTeamClasses();
//            System.out.println("\nThis is the end of the team test classes.");
//            System.out.println("\nThese are Ben's test classes:");
//            testBenClasses ();
//            System.out.println("\nThis is the end of Ben's test classes.");
//            
//        
//
//            testJeffclasses();
        
            // testScottClasses
                      
             

    }    
               
}
        
        
	
            
        

        
        
	
        
