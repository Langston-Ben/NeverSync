/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

import byui.cit260.neversync.exceptions.GameControlException;
import byui.cit260.neversync.exceptions.MapControlException;
import byui.cit260.neversync.view.ErrorView;
import cit260.neversync.model.Actor;
import cit260.neversync.model.Game;
import cit260.neversync.model.InventoryItem;
import cit260.neversync.model.ItemType;
import cit260.neversync.model.Map;
import cit260.neversync.model.Player;
import cit260.neversync.model.Question;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import neversync.NeverSync;

/**
 *
 * @author Ben Langston and Jeff Ledbetter
 */
public class GameControl implements Serializable {

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

    public static int createNewGame(Player player) throws GameControlException{
        // Check for invalid inputs
        if (player == null) {
            return -1;
        }

        Game game = new Game();
        game.setPlayer(player);
        NeverSync.setCurrentGame(game);
        game.setPlayer(player);
        game.setInventory(GameControl.createItems());
        ArrayList<Actor> Actors = createActors();
        game.setActors(Actors);

        // set initial values 
        game.setYear(1);
        game.setStarved(1);
        game.setNewPopulation(5);
        game.setBushelsHarvested(3000);
        game.setBushelsInTithes(300);
        game.setWheatEatenByRats(0);
//        game.setBushelsPerAcreHarvested();

        game.setAcresOwned(1000);
        game.setCurrentPopulation(100);
        game.setWheatInStorage(2700);

//      game.setInventoryType.items;
        Map map = new Map();
        try {
            game.setMap(MapControl.createMap(game, 5, 5));
        } catch (MapControlException ex) {
            ErrorView.display("Error:", ex.getMessage());
        }

        if (map == null) {
            throw new GameControlException("Map creation has failed");
        } else {

            return 1;
        }

    }

    public static InventoryItem[] createItems() {

        InventoryItem[] items = new InventoryItem[16];

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
        
        item = new InventoryItem();
        item.setItemType("antiplague");
        item.setQuantityInStock(1);
        item.setRequiredAmount(1);
        item.setPricePerUnit(100);
        items[ItemType.antiplague.ordinal()] = item;

        return items;

    }

    public static Question createQuestion() {
        return null;
    }

    public static ArrayList<Actor> createActors() {

        ArrayList<Actor> actors = new ArrayList<>();
        actors.add(Actor.Lehi);
        actors.add(Actor.Jacob);
        actors.add(Actor.Laman);
        actors.add(Actor.Lemuel);
        actors.add(Actor.Zoram);
        actors.add(Actor.Sam);
        actors.add(Actor.Sariah);
        actors.add(Actor.Nephi);

        return actors;
    }

    public static void saveGame(Game game, String filePath)
            throws GameControlException {
        if (filePath == null || game == null) {
            throw new GameControlException(
                    "Error saving game");
        }

        if (!filePath.contains(".")) {
            filePath += ".dat";
        }
        try (ObjectOutputStream out
                = new ObjectOutputStream(new FileOutputStream(filePath))) {

            out.writeObject(game);

        } catch (Exception ex) {

            throw new GameControlException("Game Could Not Be Saved. "
                    + "Error: " + ex.getMessage());
        }

    }

    public static Game getGame(String filePath) throws GameControlException {

        if (filePath == null) {
            throw new GameControlException(
                    "Error Loading Game");
        }

        if (!filePath.contains(".")) {
            filePath += ".dat";
        }

        Game game = null;

        try (FileInputStream in = new FileInputStream(filePath)) {
            ObjectInputStream saved = new ObjectInputStream(in);

            game = (Game) saved.readObject();

        } catch (Exception e) {
            throw new GameControlException(
                    e.getMessage());
        }

        {

            NeverSync.setCurrentGame(game);

        }

        return game;
    }

}
