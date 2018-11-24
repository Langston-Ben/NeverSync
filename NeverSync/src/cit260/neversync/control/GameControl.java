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
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(1.50);
        items[ItemType.oil.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Lumber");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(5.00);
        items[ItemType.lumber.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Ore");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(10.00);
        items[ItemType.ore.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Grain");
        item.setQuantityInStock(100);
        item.setRequiredAmount(5);
        items[ItemType.grain.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Legume");
        item.setQuantityInStock(20);
        item.setRequiredAmount(1);
        item.setPricePerUnit(2.50);
        items[ItemType.legume.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Water");
        item.setQuantityInStock(100);
        item.setRequiredAmount(1);
        item.setPricePerUnit(1.00);
        items[ItemType.water.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Honey");
        item.setQuantityInStock(200);
        item.setRequiredAmount(2);
        item.setPricePerUnit(2.00);
        items[ItemType.honey.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Salt");
        item.setQuantityInStock(200);
        item.setRequiredAmount(4);
        item.setPricePerUnit(1.25);
        items[ItemType.salt.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Axe");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(3.00);
        items[ItemType.axe.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Hammer");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(3.00);
        items[ItemType.hammer.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Drill");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(4.50);
        items[ItemType.drill.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Shovel");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(2.50);
        items[ItemType.shovel.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Sickle");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        items[ItemType.sickle.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Saw");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(2.50);
        items[ItemType.saw.ordinal()] = item;
        
        item = new InventoryItem();
        item.setItemType("Nails");
        item.setQuantityInStock(50);
        item.setRequiredAmount(5);
        item.setPricePerUnit(1.50);
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
