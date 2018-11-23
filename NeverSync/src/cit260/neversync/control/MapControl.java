/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

//import static cit260.neversync.control.GameControl.createItems;
import cit260.neversync.model.Actor;
import cit260.neversync.model.Game;
import cit260.neversync.model.InventoryItem;
import cit260.neversync.model.ItemType;
import cit260.neversync.model.Location;
import cit260.neversync.model.Map;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.ArrayList;

/**
 *
 * @author benjaminlangston
 */
public class MapControl {
   
 public static Map createMap( Game game,
 int noOfRows,
 int noOfColumns) {
     
    // check for invalid inputs 
 if (game == null || noOfRows < 0 || noOfColumns < 0) {
     
     return null;
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
   System.out.println("createLocations Failed");
    return null; }

map.setLocations(createLocations(noOfRows, noOfColumns));

//     
assignActorsToLocations(createLocations(noOfRows, noOfColumns));
//
//
////
assignItemsToLocations(createLocations(noOfRows, noOfColumns),(GameControl.createItems()));

return map;

 }
// create a two-dimensional array of locations and assign array to the map
public static Location[][] createLocations(int row, int column) {
   
    
    if (row < 1 || column < 1) {
        System.out.println("**** createMap failed *******");
        return null; 
    }
//        Location location = new Location();

//        System.out.println("createLocations has been called.");
        
        Location location = new Location();
        Location[][] locations = new Location[row][column];
            
                    location.setRow(0);
                    location.setColumn(0);
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("RV");
                    location.setDescription("This is a river");
                    locations[0][0] = location;
//                  
                    location = new Location();   
                    location.setRow(0);
                    location.setColumn(1);
                    location.setDescription("This is a wheat field");
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
                    location.setDescription("This is city square");
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
                    location.setDescription("This is the church");
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
                    location.setDescription("Location 12");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("FS");
                    locations[2][1] = location;
                    
                    location = new Location();
                    location.setRow(2);
                    location.setColumn(2);
                    location.setDescription("Location 13");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("AZ");
                    locations[2][2] = location;
                    
                    location = new Location();
                    location.setRow(2);
                    location.setColumn(3);
                    location.setDescription("Location 14");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("AC");
                    locations[2][3] = location;
                    
                    location = new Location();
                    location.setRow(2);
                    location.setColumn(4);
                    location.setDescription("Location 15");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("AV");
                    locations[2][4] = location;
                    
                    location = new Location();
                    location.setRow(3);
                    location.setColumn(0);
                    location.setDescription("Location 16");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("AB");
                    locations[3][0] = location;
                    
                    location = new Location();
                    location.setRow(3);
                    location.setColumn(1);
                    location.setDescription("Location 17");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("AN");
                    locations[3][1] = location;
                    
                    location = new Location();
                    location.setRow(3);
                    location.setColumn(2);
                    location.setDescription("Location 18");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("AM");
                    locations[3][2] = location;
                    
                    location = new Location();
                    location.setRow(3);
                    location.setColumn(3);
                    location.setDescription("Location 19");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("ER");
                    locations[3][3] = location;
                    
                    location = new Location();
                    location.setRow(3);
                    location.setColumn(4);
                    location.setDescription("Location 20");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("TY");
                    locations[3][4] = location;
                    
                    location = new Location();
                    location.setRow(4);
                    location.setColumn(0);
                    location.setDescription("Location 21");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("YU");
                    locations[4][0] = location;
                    
                    location = new Location();
                    location.setRow(4);
                    location.setColumn(1);
                    location.setDescription("Location 22");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("HH");
                    locations[4][1] = location;
                    
                    location = new Location();
                    location.setRow(4);
                    location.setColumn(2);
                    location.setDescription("Location 23");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("DE");
                    locations[4][2] = location;
                    
                    location = new Location();
                    location.setRow(4);
                    location.setColumn(3);
                    location.setDescription("Location 24");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("GT");
                    locations[4][3] = location;
                    
                    location = new Location();
                    location.setRow(4);
                    location.setColumn(4);
                    location.setDescription("Location 25");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("SD");
                    locations[4][4] = location;
                    
                    return locations;
}
   
  

//
private static int assignActorsToLocations(Location[][] locations){
    
    if (locations == null) {
        
        return -1;
    }
   
    Location location = locations[1][1];
    location.setActor(Actor.Nephi);
//    Point actorCoordinates = Actor.Nephi.getCoordinates();
//    actorCoordinates.x = location.getRow();
//    actorCoordinates.y = location.getColumn();
    locations[1][1]= location;
    
    location = locations[2][1];
    location.setActor(Actor.Lehi);
//    actorCoordinates = Actor.Lehi.getCoordinates();
//    actorCoordinates.x = location.getRow();
//    actorCoordinates.y = location.getColumn();
    locations[2][1] = location;
    
    location = locations[3][1];
    location.setActor(Actor.Sarah);
//    actorCoordinates = Actor.Sarah.getCoordinates();
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
    
    
    return 1;
}

    private static int assignItemsToLocations(Location[][] locations,
                                     InventoryItem[] itemsInGame) {

        if (locations == null || itemsInGame == null) {
        return -1; }
        
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

public static void movePlayerToStartingLocation(Map map) {
     // If starting location is not supposed to be 0,0 then use the correct values here.
     movePlayer(map, 0, 0); // or instead of 0,0 you can select a different starting location
}
public static void movePlayer(Map map, int row, int column) {
   map.setCurrentLocation(map.getLocations()[row][column]);
   map.getCurrentLocation().setVisited(true);
   map.setCurrentRow(row);
   map.setCurrentColumn(column);
}
    
}

