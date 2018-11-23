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
//assignActorsToLocations(createLocations(noOfRows, noOfColumns));
//
//
////
//assignItemsToLocations(createLocations(noOfRows, noOfColumns),(GameControl.createItems()));

return map;

 }
// create a two-dimensional array of locations and assign array to the map
public static Location[][] createLocations(int row, int column) {
   
    
    if (row < 1 || column < 1) {
        System.out.println("**** createMap failed *******");
        return null; 
    }
//        Location location = new Location();

        System.out.println("createLocations has been called.");
        
        Location location = new Location();
        Location[][] locations = new Location[row][column];
            
                    location.setRow(0);
                    location.setColumn(0);
                    location.setVisited(true);
                    location.setBlocked(false);
                    location.setDisplaySymbol("~~~~");
                    location.setDescription("This is a river");
//                    
                    location.setRow(0);
                    location.setColumn(1);
                    location.setDescription("This is a wheat field");
                    location.setVisited(true);
                    location.setBlocked(false);
                    location.setDisplaySymbol("WH");
                    
                    location.setRow(0);
                    location.setColumn(2);
                    location.setDescription("This is the storehouse");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("ST");
                    
                    location.setRow(0);
                    location.setColumn(3);
                    location.setDescription("This is city square");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("SQ");
                    
                    location.setRow(0);
                    location.setColumn(4);
                    location.setDescription("This is the medical office");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("MO");
                    
                    location.setRow(1);
                    location.setColumn(0);
                    location.setDescription("This is the river bank");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("RB");
                    
                    location.setRow(1);
                    location.setColumn(1);
                    location.setDescription("This is the hospital");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("HO");
                    
                    location.setRow(1);
                    location.setColumn(2);
                    location.setDescription("This is the church");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("CH");
                    
                    location.setRow(1);
                    location.setColumn(3);
                    location.setDescription("This is the playhouse");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("PL");
                    
                    location.setRow(1);
                    location.setColumn(4);
                    location.setDescription("This is the animal shed");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("AS");
                    
                    location.setRow(2);
                    location.setColumn(0);
                    location.setDescription("This is the farm");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("FR");
                    
                    location.setRow(2);
                    location.setColumn(1);
                    location.setDescription("Location 12");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("FS");
                    
                    location.setRow(2);
                    location.setColumn(2);
                    location.setDescription("Location 13");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("AZ");
                    
                    location.setRow(2);
                    location.setColumn(3);
                    location.setDescription("Location 14");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("AC");
                    
                    location.setRow(2);
                    location.setColumn(4);
                    location.setDescription("Location 15");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("AV");
                    
                    location.setRow(3);
                    location.setColumn(0);
                    location.setDescription("Location 16");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("AB");
                    
                    location.setRow(3);
                    location.setColumn(1);
                    location.setDescription("Location 17");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("AN");
                    
                    location.setRow(3);
                    location.setColumn(2);
                    location.setDescription("Location 18");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("AM");
                    
                    location.setRow(3);
                    location.setColumn(3);
                    location.setDescription("Location 19");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("ER");
                    
                    location.setRow(3);
                    location.setColumn(4);
                    location.setDescription("Location 20");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("TY");
                    
                    location.setRow(4);
                    location.setColumn(0);
                    location.setDescription("Location 21");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("YU");
                    
                    location.setRow(4);
                    location.setColumn(1);
                    location.setDescription("Location 22");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("HH");
                    
                    location.setRow(4);
                    location.setColumn(2);
                    location.setDescription("Location 23");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("DE");
                    
                    location.setRow(4);
                    location.setColumn(3);
                    location.setDescription("Location 24");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("GT");
                    
                    location.setRow(4);
                    location.setColumn(4);
                    location.setDescription("Location 25");
                    location.setVisited(false);
                    location.setBlocked(false);
                    location.setDisplaySymbol("SD");
                    
                    
                   
                    System.out.println("locations called" + Arrays.toString(locations));
                    
                    return locations;
}
   
  

//
private static int assignActorsToLocations(Location[][] locations){
    
    if (locations == null) {
        
        return -1;
    }
   
    Location location = locations[1][1];
    location.setActor(Actor.Nephi);
    Point actorCoordinates = Actor.Nephi.getCoordinates();
    actorCoordinates.x = 1;
    actorCoordinates.y = 1;
    
    location = locations[2][1];
    location.setActor(Actor.Lehi);
    actorCoordinates = Actor.Lehi.getCoordinates();
    actorCoordinates.x = 2;
    actorCoordinates.y = 1;
    
    location = locations[3][1];
    location.setActor(Actor.Sarah);
    actorCoordinates = Actor.Sarah.getCoordinates();
    actorCoordinates.x = 3;
    actorCoordinates.y = 1;
    
    location = locations[4][1];
    location.setActor(Actor.Jacob);
    actorCoordinates = Actor.Jacob.getCoordinates();
    actorCoordinates.x = 4;
    actorCoordinates.y = 1;
    
    location = locations[0][1];
    location.setActor(Actor.Sam);
    actorCoordinates = Actor.Sam.getCoordinates();
    actorCoordinates.x = 0;
    actorCoordinates.y = 1;
    
    location = locations[1][2];
    location.setActor(Actor.Laman);
    actorCoordinates = Actor.Laman.getCoordinates();
    actorCoordinates.x = 1;
    actorCoordinates.y = 2;
    
    location = locations[1][3];
    location.setActor(Actor.Lemuel);
    actorCoordinates = Actor.Lemuel.getCoordinates();
    actorCoordinates.x = 1;
    actorCoordinates.y = 3;
    
    location = locations[1][4];
    location.setActor(Actor.Zoram);
    actorCoordinates = Actor.Zoram.getCoordinates();
    actorCoordinates.x = 2;
    actorCoordinates.y = 1;
    
    
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



}



//}








//locations = createLocations(noOfRows, noOfColumns)

//call setter to save a locations array in the map object
// assign actors and items to locations


//success = assignActorsToLocations(locations)
//if (success < 0) then
// return null
//endif
//success = assignIemsToLocations(locations)
//if (success < 0) then
// return null
//endif
//
//private static int assignItemsToLocations(
// Location[][] locations,
// InventoryItem[] itemsInGame)
//// Assign all other types objects to locations (e.g., questions, spells)
//…
//return map
//}
//    
//}
