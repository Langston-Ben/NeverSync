/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

import byui.cit260.neversync.exceptions.MapControlException;
import cit260.neversync.model.Actor;
import cit260.neversync.model.Game;
import cit260.neversync.model.InventoryItem;
import cit260.neversync.model.ItemType;
import cit260.neversync.model.Location;
import cit260.neversync.model.Map;
import cit260.neversync.model.Player;
import neversync.NeverSync;

/**
 *
 * @author benjaminlangston
 */
public class MapControl {

    public static Map createMap(Game game,
            int noOfRows,
            int noOfColumns) throws MapControlException {

        // check for invalid inputs 
        if (game == null || noOfRows < 0 || noOfColumns < 0) {
           throw new MapControlException("You must enter a value");
            
        }
// create the map object and assign values to it

        Map map = new Map();
        map.setDescription("***** City Of Aaron *****");
        map.setRows(noOfRows);
        map.setColumns(noOfColumns);
        game.setMap(map);

        noOfRows = 5;
        noOfColumns = 5;

        createLocations(noOfRows, noOfColumns);
        if (game == null || noOfRows < 1 || noOfColumns < 1) {
            throw new MapControlException("You Must Enter a Value");
        }

        map.setLocations(createLocations(noOfRows, noOfColumns));
        
        
        
        
        MapControl.assignActorsToLocations(map.getLocations());
        MapControl.assignItemsToLocations(map.getLocations(), 
                game.getInventory());
        
        
        MapControl.movePlayerToStartingLocation(map);

        return map;

    }
// create a two-dimensional array of locations and assign array to the map

    public static Location[][] createLocations(int row, int column) throws
            MapControlException {

        if (row < 1 || column < 1) {
            throw new MapControlException("Your Entry is not valid");
        }

        Location location = new Location();
        Location[][] locations = new Location[row][column];

        location.setRow(0);
        location.setColumn(0);
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("RV");
        location.setDescription("This is a river Aaron.\nThis is your starting"
                + " point in the game.\nPlease select your next location carefully!\n"
                + "You should move to the wheat field to plant the crops this season.");
        locations[0][0] = location;
//                  
        location = new Location();
        location.setRow(0);
        location.setColumn(1);
        location.setDescription("This is a wheat field.\nPlant the crops for this season, "
                + "then move to the city square to feed the people.");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("WH");
        locations[0][1] = location;

        location = new Location();
        location.setRow(0);
        location.setColumn(2);
        location.setDescription("This is the storehouse");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("ST");
        locations[0][2] = location;

        location = new Location();
        location.setRow(0);
        location.setColumn(3);
        location.setDescription("This is city square.\nPlease feed the people,"
                + "they are hungry and require 20 bushels each to live the year\n"
                + "Next, proceed to the church to pay tithes and offerings.\n");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("SQ");
        locations[0][3] = location;

        location = new Location();
        location.setRow(0);
        location.setColumn(4);
        location.setDescription("This is the medical office");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("MO");
        locations[0][4] = location;

        location = new Location();
        location.setRow(1);
        location.setColumn(0);
        location.setDescription("This is the river bank");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("RB");
        locations[1][0] = location;

        location = new Location();
        location.setRow(1);
        location.setColumn(1);
        location.setDescription("This is the hospital");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("HO");
        locations[1][1] = location;

        location = new Location();
        location.setRow(1);
        location.setColumn(2);
        location.setDescription("This is the church.\nPlease pay your tithes and "
                + "then proceed to one other location\nbefore moving to the storehouse");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("CH");
        locations[1][2] = location;

        location = new Location();
        location.setRow(1);
        location.setColumn(3);
        location.setDescription("This is the playhouse");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("PL");
        locations[1][3] = location;

        location = new Location();
        location.setRow(1);
        location.setColumn(4);
        location.setDescription("This is the animal shed");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("AS");
        locations[1][4] = location;

        location = new Location();
        location.setRow(2);
        location.setColumn(0);
        location.setDescription("This is the farm");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("FR");
        locations[2][0] = location;

        location = new Location();
        location.setRow(2);
        location.setColumn(1);
        location.setDescription("This is the Animal Doctor");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("AD");
        locations[2][1] = location;

        location = new Location();
        location.setRow(2);
        location.setColumn(2);
        location.setDescription("This is the Library");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("LB");
        locations[2][2] = location;

        location = new Location();
        location.setRow(2);
        location.setColumn(3);
        location.setDescription("This is the Law Enforcement");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("LE");
        locations[2][3] = location;

        location = new Location();
        location.setRow(2);
        location.setColumn(4);
        location.setDescription("This is the Judge");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("JD");
        locations[2][4] = location;

        location = new Location();
        location.setRow(3);
        location.setColumn(0);
        location.setDescription("This is the Bakey");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("BK");
        locations[3][0] = location;

        location = new Location();
        location.setRow(3);
        location.setColumn(1);
        location.setDescription("This is the Butcher");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("BX");
        locations[3][1] = location;

        location = new Location();
        location.setRow(3);
        location.setColumn(2);
        location.setDescription(" This is the Seamstress");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("SM");
        locations[3][2] = location;

        location = new Location();
        location.setRow(3);
        location.setColumn(3);
        location.setDescription("This is the Boot Maker");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("BM");
        locations[3][3] = location;

        location = new Location();
        location.setRow(3);
        location.setColumn(4);
        location.setDescription("This is the Temple of the City of Aaron\n"
                + "Temple attendance can bring miracles into the lives of the "
                + "population of the City of Aaron.\n\n");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("TP");
        locations[3][4] = location;

        location = new Location();
        location.setRow(4);
        location.setColumn(0);
        location.setDescription("This is the Iron Smith");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("IS");
        locations[4][0] = location;

        location = new Location();
        location.setRow(4);
        location.setColumn(1);
        location.setDescription("This is the Carpenter");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("CP");
        locations[4][1] = location;

        location = new Location();
        location.setRow(4);
        location.setColumn(2);
        location.setDescription("This is the Cemetery");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("CY");
        locations[4][2] = location;

        location = new Location();
        location.setRow(4);
        location.setColumn(3);
        location.setDescription("This is the Grain Mill");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("GM");
        locations[4][3] = location;

        location = new Location();
        location.setRow(4);
        location.setColumn(4);
        location.setDescription("This is the Orchard");
        location.setVisited(false);
        location.setBlocked(false);
        location.setDisplaySymbol("OR");
        locations[4][4] = location;

        return locations;
    }

//
    private static int assignActorsToLocations(Location[][] locations) {

        if (locations == null) {

            return -1;
        }

        Location location = locations[1][1];
        location.setActor(Actor.Nephi);
//    Point actorCoordinates = Actor.Nephi.getCoordinates();
//    actorCoordinates.x = location.getRow();
//    actorCoordinates.y = location.getColumn();
        locations[1][1] = location;

        location = locations[2][1];
        location.setActor(Actor.Lehi);
//    actorCoordinates = Actor.Lehi.getCoordinates();
//    actorCoordinates.x = location.getRow();
//    actorCoordinates.y = location.getColumn();
        locations[2][1] = location;

        location = locations[3][1];
        location.setActor(Actor.Sariah);
//    actorCoordinates = Actor.Sariah.getCoordinates();
//     actorCoordinates.x = location.getRow();
//    actorCoordinates.y = location.getColumn();
        locations[3][1] = location;

        location = locations[4][1];
        location.setActor(Actor.Jacob);
//    actorCoordinates = Actor.Jacob.getCoordinates();
//    actorCoordinates.x = location.getRow();
//    actorCoordinates.y = location.getColumn();
        locations[4][1] = location;

        location = locations[0][1];
        location.setActor(Actor.Sam);
//    actorCoordinates = Actor.Sam.getCoordinates();
//    actorCoordinates.x = location.getRow();
//    actorCoordinates.y = location.getColumn();
        locations[0][1] = location;

        location = locations[1][2];
        location.setActor(Actor.Laman);
//    actorCoordinates = Actor.Laman.getCoordinates();
//    actorCoordinates.x = location.getRow();
//    actorCoordinates.y = location.getColumn();
        locations[1][2] = location;

        location = locations[1][3];
        location.setActor(Actor.Lemuel);
//    actorCoordinates = Actor.Lemuel.getCoordinates();
//    actorCoordinates.x = location.getRow();
//    actorCoordinates.y = location.getColumn();
        locations[1][3] = location;

        location = locations[1][4];
        location.setActor(Actor.Zoram);
//    actorCoordinates = Actor.Zoram.getCoordinates();
//    actorCoordinates.x = location.getRow();
//    actorCoordinates.y = location.getColumn();
        locations[1][4] = location;
        
        location = locations[2][2];
        location.setActor(Actor.Laman);
        locations[2][2] = location;
        
        location = locations[2][3];
        location.setActor(Actor.Laman);
        locations[2][3] = location;

        location = locations[2][4];
        location.setActor(Actor.Laman);
        locations[2][4] = location;
        
        location = locations[3][3];
        location.setActor(Actor.Lemuel);
        locations[3][3] = location;
        
        location = locations[4][4];
        location.setActor(Actor.Korihor);
        locations[4][4] = location;
        
        location = locations[4][2];
        location.setActor(Actor.Lemuel);
        locations[4][2] = location;
        
        location = locations[4][2];
        location.setActor(Actor.Laman);
        locations[4][2] = location;
        
        location = locations[4][0];
        location.setActor(Actor.Amalickiah);
        locations[4][0] = location;
     
        
        
        
        return 1;
    }

    private static int assignItemsToLocations(Location[][] locations,
            InventoryItem[] itemsInGame) {

        if (locations == null || itemsInGame == null) {
            return -1;
        }

        Location location = locations[1][1];
        location.setItem(itemsInGame[ItemType.water.ordinal()]);

        location = locations[1][2];
        location.setItem(itemsInGame[ItemType.lumber.ordinal()]);

        location = locations[1][3];
        location.setItem(itemsInGame[ItemType.ore.ordinal()]);

        location = locations[1][4];
        location.setItem(itemsInGame[ItemType.grain.ordinal()]);

        location = locations[1][0];
        location.setItem(itemsInGame[ItemType.legume.ordinal()]);

        location = locations[2][1];
        location.setItem(itemsInGame[ItemType.oil.ordinal()]);

        location = locations[2][2];
        location.setItem(itemsInGame[ItemType.honey.ordinal()]);

        location = locations[2][3];
        location.setItem(itemsInGame[ItemType.salt.ordinal()]);

        location = locations[2][4];
        location.setItem(itemsInGame[ItemType.axe.ordinal()]);

        location = locations[2][0];
        location.setItem(itemsInGame[ItemType.hammer.ordinal()]);

        location = locations[3][1];
        location.setItem(itemsInGame[ItemType.drill.ordinal()]);

        location = locations[3][2];
        location.setItem(itemsInGame[ItemType.shovel.ordinal()]);

        location = locations[3][3];
        location.setItem(itemsInGame[ItemType.sickle.ordinal()]);

        location = locations[3][4];
        location.setItem(itemsInGame[ItemType.saw.ordinal()]);

        location = locations[3][0];
        location.setItem(itemsInGame[ItemType.nails.ordinal()]);

        return 0;
    }

    public static void movePlayerToStartingLocation(Map map) 
    throws MapControlException {
        // If starting location is not supposed to be 0,0 then use the correct values here.
        movePlayer(map, 0, 0); // or instead of 0,0 you can select a different starting location
    }

    public static void movePlayer(Map map, int row, int column) 
        throws MapControlException {
        
        if (map == null || row < 0 || column < 0)
            throw new MapControlException("MovePlayer Failed");
        
        map.setCurrentLocation(map.getLocations()[row][column]);
        map.getCurrentLocation().setVisited(true);
        map.setCurrentRow(row);
        map.setCurrentColumn(column);
        
    }
    
    
//public static Location moveActor(Player player, int newRow, int newColumn)  
//        throws MapControlException {
//       
//    
//        if (player == null) {
//        throw new MapControlException("\nPlayer cannot be null");
//        }
//        Game game = new Game();
//        game = NeverSync.getCurrentGame();
//        
//        Map map = game.getMap();
//        
//        Location[][] locations = map.getLocations();
//        
//        if (newRow < 1 || newRow > map.getRows() || newColumn < 1 
//                || newColumn > map.getColumns()) {
//        throw new MapControlException();
//        }
//            
//        int currentRow = map.getCurrentRow();
//        int currentColumn = map.getCurrentColumn();
//        
//        map.getCurrentLocation().setVisited(true);
//        
//        Location[][] newLocation = map.setCurrentRow(newRow);
//        
//        map.setCurrentRow(newRow);
//        map.setCurrentColumn(newColumn);
//        
//        
// return newLocation;
//}
}
