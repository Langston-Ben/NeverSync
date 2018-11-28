/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

//import java.util.Scanner;

import byui.cit260.neversync.exceptions.MapControlException;
import cit260.neversync.control.MapControl;
import cit260.neversync.model.Game;
import cit260.neversync.model.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import neversync.NeverSync;


/**
 *
 * @author Ben Langston and Jeff Ledbetter
 */
public class GameMenuView extends View {

    public GameMenuView() {
    }

    @Override
    public String[] getInputs() {

        String[] input = new String[1];
        System.out.println("\n************************\n"
                + "City Of Aaron Game Menu\n"
                + "************************\n");
        System.out.println(
                "\nWhat Would You Like To Do?\n"
                + "\nV - View the Map\n"
                + "I - View and Purchase Current Items\n"     
                + "A - Display Actors\n"
                + "M - Move to a New Location\n"
                + "C - Manage the Crops\n"
                + "L - Live the Year\n"
                + "R - Reports Menu\n"
                + "S - Save Game\n"
                + "Q - Return to the main menu\n");

        String helpMenuSelection = this.getInput("\nPlease enter your selection: ");
        input[0] = helpMenuSelection;
        
        return input;

    }

    @Override
    public boolean doAction(String[] input) {

        input[0] = input[0].toUpperCase();
        String helpItem = input[0];

        switch (helpItem) {
            case "V":
                viewMap();
                break;
            case "I":
                ItemInventory();
                break;               
            case "A":
                viewActors();
                break;
            case "M":
        {
            try {
                moveNewLocation();
            } catch (MapControlException ex) {
                System.out.println(ex.getMessage());
            }
        }
                break;
            case "C":
                manageCrops();
                break;
            case "L":
                liveYear();
                break;
            case "R":
                reportMenu();
                break;
            case "S":
                saveGame();
                break;
            case "Q":
                return true;

            default:
                System.out.println("\nInvalid Menu Item\n");

        }

        return false;
    }

    private void viewMap() {
        MapView mapView = new MapView();
        mapView.displayMap();
    }

    private void moveNewLocation() throws MapControlException {
        
        MapView mapView = new MapView();
        mapView.displayMap();
        
        String row = getInput("Enter Row(Q to quit): ");
       
          
        if (row.toUpperCase().trim().equals("Q")) {
            System.out.println("About to quit");
            return;
        }
        String column = getInput("Enter Column(Q to quit): ");
        if (column.toUpperCase().trim().equals("Q")) {
            System.out.println("About to quit");
            return;
        }
        
        int iRow = -1;
        int iColumn = -1;
        
        try {
            
            iRow = Integer.parseInt(row);
            iColumn = Integer.parseInt(column);
            } catch (NumberFormatException e) {
            System.out.println("Invalid Entry, must be a number");
            return;
            }
        
        Game game = NeverSync.getCurrentGame();
        
        Map map = game.getMap();
        
        MapControl.movePlayer(map, iRow, iColumn);
        MoveNewLocationView moveNewLocationView = new MoveNewLocationView();
        moveNewLocationView.display();
    }

    private void manageCrops() {
        CropManagementView cropManagementView = new CropManagementView();
        cropManagementView.display();
    }

    private void liveYear() {
        System.out.println("placeholder for liveYear");
    }

    private void reportMenu() {
		ReportsMenuView reportsMenuView = new ReportsMenuView();
        reportsMenuView.display();
    }

    private void saveGame() {
        System.out.println("placeholder for saveGame");
    }

    private void viewActors() {
        
//        System.out.println("placeholder for viewActors");
            ActorView actorView = new ActorView();
            actorView.displayActorView();
        
    }

    private void ItemInventory() {
        
                ItemInventoryView itemInventoryView = new ItemInventoryView();
                itemInventoryView.displayItemInventoryView();
                
       
    }

}
