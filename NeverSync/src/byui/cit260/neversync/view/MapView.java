/////*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package byui.cit260.neversync.view;

import cit260.neversync.model.Game;
import cit260.neversync.model.Location;
import cit260.neversync.model.Map;
import cit260.neversync.model.Player;
import neversync.NeverSync;

/**
 *
 * @author benjaminlangston
 */
public class MapView  {

    public MapView() {
        
    }
    
public void displayMap() {
        System.out.println("This is the City of Aaron Map");
        String leftIndicator;
        String rightIndicator;
        Game game = NeverSync.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
    // Build the heading of the map
    System.out.print("  |");
    for( int column = 0; column < locations[0].length; column++){
      // print col numbers to side of map
      System.out.print("  " + column + " |"); 
    }
    // Now build the map.  For each row, show the column information
    System.out.println();
    for( int row = 0; row < locations.length; row++){
     System.out.print(row + " "); // print row numbers to side of map
      for( int column = 0; column < locations[row].length; column++){
        // set default indicators as blanks
        leftIndicator = " ";
        rightIndicator = " ";
        if(locations[row][column] == map.getCurrentLocation()){
          // Set star indicators to show this is the current location.
          leftIndicator = "*"; 
          rightIndicator = "*"; 
        } 
        else if(locations[row][column].isVisited()){
           // Set < > indicators to show this location has been visited.
           leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
           rightIndicator = "<"; // same as above
        }
       System.out.print("|"); // start map with a |
        if(locations[row][column] == null)
        {
             // No scene assigned here so use ?? for the symbol
             System.out.print(leftIndicator + "??" + rightIndicator);
        }
        else
          System.out.print(leftIndicator
             + locations[row][column].getDisplaySymbol()
             + rightIndicator);
      }
     System.out.println("|");
    }
 }
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
//    public void displayMap() {
//            String leftIndicator;
//            String rightIndicator;
//            Game game = NeverSync.getCurrentGame(); // retreive the game
//            Map map = game.getMap(); // retreive the map from game
//            Location[][] locations = map.getLocations(); // retreive the locations from map
//    // Build the heading of the map
////    System.out.print("  |");
//
//    String lineSeparator = "\n      --|----|----|----|----|----|----|----|----|----|";
//
//        // Build the heading of the map     
//        System.out.println("\n=================================================="
//                + "====================================\n         |");  
//    for( int column = 0; column < locations[0].length; column++){
//      // print col numbers to side of map
//      System.out.print("  " + column + " |");
//      
//      if(column == (locations[0].length - 1)){
//                System.out.print("    [ ] - Blocked Location " + lineSeparator);
//            }
//    }
//    // Now build the map.  For each row, show the column information
//    System.out.println();
//    for( int row = 0; row < locations.length; row++){
//     System.out.print(row + " "); // print row numbers to side of map
//      for( int column = 0; column < locations[row].length; column++){
//        // set default indicators as blanks
//        leftIndicator = " ";
//        rightIndicator = " ";
//        if(locations[row][column] == map.getCurrentLocation()){
//          // Set star indicators to show this is the current location.
//          leftIndicator = "*"; 
//          rightIndicator = "*"; 
//        } 
//        if(locations[row][column].isVisited()){
//           // Set < > indicators to show this location has been visited.
//           leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
//           rightIndicator = "<"; // same as above
//        }
//       System.out.print("|"); // start map with a |
//        if(locations[row][column]== null)
//        {
//             // No scene assigned here so use ?? for the symbol
//             System.out.print(leftIndicator + "??" + rightIndicator);
//        }
//        else
//          System.out.print(leftIndicator
//             + locations[row][column].getDisplaySymbol()
//             + rightIndicator);
//      }
//     System.out.println("|");
//    }
// }
//}
////     