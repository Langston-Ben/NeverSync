/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

//import cit260.neversync.model.Player;
import cit260.neversync.model.Actor;
import cit260.neversync.model.Game;
import cit260.neversync.model.InventoryItem;
//import cit260.neversync.model.ItemType;
import cit260.neversync.model.ItemType;
import cit260.neversync.model.Location;
import cit260.neversync.model.Map;
import cit260.neversync.model.Player;
import cit260.neversync.model.Question;
import java.util.Arrays;
//import cit260.neversync.model.Scene;
//import java.util.ArrayList;
import neversync.NeverSync;

/**
 *
 * @author Ben Langston and Jeff Ledbetter
 */
public class GameControl {

    public static Player savePlayer(String playersName) {

        if (playersName == null || playersName.length() < 3) {
            return null;
        } else {
            Player player = new Player();
            player.setName(playersName);
            NeverSync.setPlayer(player);

            return player;
        }

    }

    public GameControl() {
    }

    public static int createNewGame(Player player) {
        // Check for invalid inputs
        if(player == null) {
        return -1;
        }
     
        Game game = new Game();
        game.setPlayer(player);
        NeverSync.setCurrentGame(game);
        game.setPlayer(player);
        game.setInventory(GameControl.createItems());
//      game.setActors(createActors()); 
//      game.setInventoryType.items;
        Map map = new Map();
        game.setMap(MapControl.createMap(game,5,5));
        
//        game.setMap(createMap(game,2,2));
      
        
        if (map == null) {

         System.out.println("createMap failed");
         return -2;
}       else 
{
          return 1;
     }
      
    }
    
    
    public static InventoryItem[] createItems() {
        
        
        InventoryItem[] items = new InventoryItem[15];       

        InventoryItem item = new InventoryItem();
        item.setItemType("Oil");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.oil.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Lumber");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.lumber.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Ore");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.ore.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Grain");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.grain.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Legume");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.legume.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Water");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.water.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Honey");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.honey.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Salt");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.salt.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Axe");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.axe.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Hammer");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.hammer.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Drill");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.drill.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Shovel");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.shovel.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Sickle");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.sickle.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Saw\n");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.saw.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Nails");
        item.setQuantity(0);
        item.setRequiredAmount(150);
        items[ItemType.nails.ordinal()] = item;
        
        return items;
    
    }
    
    public static Question createQuestion() {
    return null;
    }
    
 

   
   }
    
//    
//    public static void creatNewScene(Scene scene)  {
//       Nev
//    }
//}
