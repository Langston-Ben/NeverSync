/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

import cit260.neversync.model.Game;
import cit260.neversync.model.InventoryItem;
import cit260.neversync.model.ItemType;
import cit260.neversync.model.Map;
import cit260.neversync.model.Player;
import cit260.neversync.model.Question;
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
        if (player == null) {
            return -1;
        }

        Game game = new Game();
        game.setPlayer(player);
        NeverSync.setCurrentGame(game);
        game.setPlayer(player);
        game.setInventory(GameControl.createItems());
        Map map = new Map();
        game.setMap(MapControl.createMap(game, 5, 5));

        if (map == null) {

            System.out.println("createMap failed");
            return -2;
        } else {
            return 1;
        }

    }

    public static InventoryItem[] createItems() {

        InventoryItem[] items = new InventoryItem[15];

        InventoryItem item = new InventoryItem();
        item.setItemType("oil");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(1.50);
        items[ItemType.oil.ordinal()] = item;

        item = new InventoryItem();
        item.setItemType("lumber");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(5.00);
        items[ItemType.lumber.ordinal()] = item;

        item = new InventoryItem();
        item.setItemType("ore");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(10.00);
        items[ItemType.ore.ordinal()] = item;

        item = new InventoryItem();
        item.setItemType("grain");
        item.setQuantityInStock(100);
        item.setRequiredAmount(5);
        item.setPricePerUnit(2.00);
        items[ItemType.grain.ordinal()] = item;

        item = new InventoryItem();
        item.setItemType("legume");
        item.setQuantityInStock(20);
        item.setRequiredAmount(1);
        item.setPricePerUnit(2.50);
        items[ItemType.legume.ordinal()] = item;

        item = new InventoryItem();
        item.setItemType("water");
        item.setQuantityInStock(100);
        item.setRequiredAmount(1);
        item.setPricePerUnit(1.00);
        items[ItemType.water.ordinal()] = item;

        item = new InventoryItem();
        item.setItemType("honey");
        item.setQuantityInStock(200);
        item.setRequiredAmount(2);
        item.setPricePerUnit(2.00);
        items[ItemType.honey.ordinal()] = item;

        item = new InventoryItem();
        item.setItemType("salt");
        item.setQuantityInStock(200);
        item.setRequiredAmount(4);
        item.setPricePerUnit(1.25);
        items[ItemType.salt.ordinal()] = item;

        item = new InventoryItem();
        item.setItemType("axe");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(3.00);
        items[ItemType.axe.ordinal()] = item;

        item = new InventoryItem();
        item.setItemType("hammer");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(3.00);
        items[ItemType.hammer.ordinal()] = item;

        item = new InventoryItem();
        item.setItemType("drill");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(4.50);
        items[ItemType.drill.ordinal()] = item;

        item = new InventoryItem();
        item.setItemType("shovel");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(2.50);
        items[ItemType.shovel.ordinal()] = item;

        item = new InventoryItem();
        item.setItemType("sickle");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(5.00);
        items[ItemType.sickle.ordinal()] = item;

        item = new InventoryItem();
        item.setItemType("saw");
        item.setQuantityInStock(10);
        item.setRequiredAmount(1);
        item.setPricePerUnit(2.50);
        items[ItemType.saw.ordinal()] = item;

        item = new InventoryItem();
        item.setItemType("nails");
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
