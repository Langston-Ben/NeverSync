/////*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package byui.cit260.neversync.view;

import cit260.neversync.model.Actor;
import cit260.neversync.model.Game;
import cit260.neversync.model.InventoryItem;
import cit260.neversync.model.ItemType;
import cit260.neversync.model.Location;
import cit260.neversync.model.Map;
import java.io.BufferedReader;
import java.io.PrintWriter;
import neversync.NeverSync;

/**
 *
 * @author benjaminlangston
 */
public class MapView {
    
    private String message;

    protected final BufferedReader keyboard = NeverSync.getInFile();
    protected final PrintWriter console = NeverSync.getOutFile();


    public MapView() {

    }

    public void displayMap() {

        this.console.println("\n=============================");
        this.console.println("=============================");
        this.console.println("This is the City of Aaron Map");
        this.console.println("=============================");
        this.console.println("=============================\n");
        String leftIndicator;
        String rightIndicator;
        Game game = NeverSync.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        // Build the heading of the map
        
        this.console.print("  |");
        for (int column = 0; column < locations[0].length; column++) {
            // print col numbers to side of map
            this.console.print("  " + column + " |");
        }
        // Now build the map.  For each row, show the column information
        this.console.println();
        for (int row = 0; row < locations.length; row++) {
            this.console.print(row + " "); // print row numbers to side of map
            for (int column = 0; column < locations[row].length; column++) {
                // set default indicators as blanks
                leftIndicator = " ";
                rightIndicator = " ";
                if (locations[row][column] == map.getCurrentLocation()) {
                    // Set star indicators to show this is the current location.
                    leftIndicator = "*";
                    rightIndicator = "*";
                } else if (locations[row][column].isVisited()) {
                    // Set < > indicators to show this location has been visited.
                    leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
                    rightIndicator = "<"; // same as above
                }
                this.console.print("|"); // start map with a |
                if (locations[row][column] == null) {
                    // No scene assigned here so use ?? for the symbol
                    this.console.print(leftIndicator + "??" + rightIndicator);
                } else {
                    this.console.print(leftIndicator
                            + locations[row][column].getDisplaySymbol()
                            + rightIndicator);
                }
            }
            this.console.println("|");
            
        }
        this.console.println("\nYour current location is: \n" + map.getCurrentLocation().getDescription());
        
        
        
        InventoryItem currentItems = map.getCurrentLocation().getItem();
        
        if (currentItems != null) {
        
       
            String one = currentItems.getItemType();
            
            

            this.console.println("You have found " + one + " at this location."
                    + "\nWould you like to add it to your backpack?");

        }
        
        
        
        Actor currentActor = map.getCurrentLocation().getActor();
        if (currentActor == null) {
        return;
        }
        this.console.println(currentActor + " is here to help you, do you have a question to ask?");
    }

}
