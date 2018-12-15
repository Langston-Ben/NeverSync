/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

//import java.util.Scanner;
import byui.cit260.neversync.exceptions.CropControlException;
import byui.cit260.neversync.exceptions.GameControlException;
import byui.cit260.neversync.exceptions.MapControlException;
import cit260.neversync.control.CropControl;
import cit260.neversync.control.MapControl;
import cit260.neversync.model.Actor;
import cit260.neversync.model.Game;
import cit260.neversync.model.Location;
import cit260.neversync.model.Map;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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

//        boolean c = true;
//        while (c == true) {
        Game game = NeverSync.getCurrentGame();
        
        if (game.isHideReport()) {
        
        
        } else {
        
        
        
        this.console.println("\n\n              Annual Report");
        this.console.printf("%n%-30s%10s", "Item", "Quantity");
        this.console.printf("%n%-30s%10s", "----", "  --------\n\r");

        this.console.printf("%n%-30s%10s", "Current Year:", game.getYear(), "\n");
        this.console.printf("%n%-30s%10s", "People Starved:", game.getStarved(), "\n");
        this.console.printf("%n%-30s%10s", "New Population:", game.getNewPopulation(), "\n");
        this.console.printf("%n%-30s%10s", "Population Killed:",
                game.getPopulationKilled(), "\n");
        this.console.printf("%n%-30s%10s", "Current Population:",
                game.getCurrentPopulation(), "\n");
        this.console.printf("%n%-30s%10s", "Current Acres Owned:", game.getAcresOwned(), "\n");
        this.console.printf("%n%-30s%10s", "Current Bushels Per Acre:",
                game.getBushelsPerAcreHarvested(), "\n");
        this.console.printf("%n%-30s%10s", "Current Bushels Harvested:",
                game.getBushelsHarvested(), "\n");
        this.console.printf("%n%-30s%10s", "Current Bushels Tithed:",
                game.getBushelsInTithes(), "\n");
        this.console.printf("%n%-30s%10s", "Current Wheat Eaten By Rats:",
                game.getWheatEatenByRats(), "\n");
        this.console.printf("%n%-30s%10s", "Current Wheat:",
                game.getWheatInStorage(), "\n");
        game.setHideReport(true); }

//            c = false;}
        String[] input = new String[1];
        this.console.println("\n\n************************\n"
                + "City Of Aaron Game Menu\n"
                + "************************\n");
        this.console.println(
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
                moveNewLocation();
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
                this.console.println("\nInvalid Menu Item\n");

        }

        return false;
    }

    private void viewMap() {
        MapView mapView = new MapView();
        mapView.displayMap();
    }

    private void moveNewLocation() {

        MapView mapView = new MapView();
        mapView.displayMap();

        String row = getInput("Enter Row(Q to quit): ");

        if (row.toUpperCase().trim().equals("Q")) {
            this.console.println("About to quit");
            return;
        }
        String column = getInput("Enter Column(Q to quit): ");
        if (column.toUpperCase().trim().equals("Q")) {
            this.console.println("About to quit");
            return;
        }

        int iRow = -1;
        int iColumn = -1;

        try {

            iRow = Integer.parseInt(row);
            iColumn = Integer.parseInt(column);
        } catch (NumberFormatException e) {
            ErrorView.display(this.getClass().getName(), "Invalid Entry, must be a number");
            return;
        }

        Game game = NeverSync.getCurrentGame();

        Map map = game.getMap();

        try {
            try {
                MapControl.movePlayer(map, iRow, iColumn);
            } catch (MapControlException ex) {
                ErrorView.display(this.getClass().getName(), "\n\n" + ex.getMessage());
                return;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            ErrorView.display(this.getClass().getName(), "\n\nInvalid Entry");
            return;
        }
        MoveNewLocationView moveNewLocationView = new MoveNewLocationView();
        moveNewLocationView.display();
        return;
    }

    private void manageCrops() {
        CropManagementView cropManagementView = new CropManagementView();
        cropManagementView.display();
    }

    private void liveYear() {
        
        
        // this needs some work.....
        Game game = NeverSync.getCurrentGame();
        game.setHideReport(false);
        double wheatFed = game.getWheatFedToPeople();
        double curPop = game.getCurrentPopulation();
        double mort = 0;

        try {
            mort = CropControl.calcMortality(wheatFed, curPop);
        } catch (CropControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            System.exit(0);
//                return;

        }
//        
        if (mort == 4) {
            double points = game.getCurrentPopulation();
            double bonus = game.getWheatInStorage();

            points = points * 10;
            bonus = bonus + points;

            this.console.println(
                    "██╗   ██╗ ██████╗ ██╗   ██╗\n"
                    + "╚██╗ ██╔╝██╔═══██╗██║   ██║                                                 \n"
                    + " ╚████╔╝ ██║   ██║██║   ██║                                                 \n"
                    + "  ╚██╔╝  ██║   ██║██║   ██║                                                 \n"
                    + "   ██║   ╚██████╔╝╚██████╔╝                                                 \n"
                    + "   ╚═╝    ╚═════╝  ╚═════╝                                                  \n"
                    + "                                                                            \n"
                    + " █████╗ ██████╗ ███████╗                                                    \n"
                    + "██╔══██╗██╔══██╗██╔════╝                                                    \n"
                    + "███████║██████╔╝█████╗                                                      \n"
                    + "██╔══██║██╔══██╗██╔══╝                                                      \n"
                    + "██║  ██║██║  ██║███████╗                                                    \n"
                    + "╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝                                                    \n"
                    + "                                                                            \n"
                    + " █████╗                                                                     \n"
                    + "██╔══██╗                                                                    \n"
                    + "███████║                                                                    \n"
                    + "██╔══██║                                                                    \n"
                    + "██║  ██║                                                                    \n"
                    + "╚═╝  ╚═╝                                                                    \n"
                    + "                                                                            \n"
                    + "██╗    ██╗██╗███╗   ██╗███╗   ██╗███████╗██████╗ ██╗██╗██╗██╗██╗██╗██╗██╗██╗\n"
                    + "██║    ██║██║████╗  ██║████╗  ██║██╔════╝██╔══██╗██║██║██║██║██║██║██║██║██║\n"
                    + "██║ █╗ ██║██║██╔██╗ ██║██╔██╗ ██║█████╗  ██████╔╝██║██║██║██║██║██║██║██║██║\n"
                    + "██║███╗██║██║██║╚██╗██║██║╚██╗██║██╔══╝  ██╔══██╗╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝\n"
                    + "╚███╔███╔╝██║██║ ╚████║██║ ╚████║███████╗██║  ██║██╗██╗██╗██╗██╗██╗██╗██╗██╗\n"
                    + " ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝\n"
                    + "                                                                            \n\n");
            this.console.println("You have finished the game. Your score is: \n" + bonus);
            
            
//            PrintWriter out = null;
//            String score = "highscore.txt";
//            try {
//                out = new PrintWriter(score); 
//                out.println("\n\n            Score Report");
//                out.printf("%n%-20s", "High Score");
//                out.printf("%n%-20s", "-----------");
//
//                out.printf("%n%-13.2f", bonus);
//                
//           
//                // need to fix or delete this....
//            } catch (FileNotFoundException ex) {
//                ErrorView.display(this.getClass().getName(), "\n\nInvalid Entry");
//                return;
//            }
            

        this.console.println("\n\n         This is the final Annual Report");
        this.console.printf("%n%-30s%10s", "Item", "Quantity");
        this.console.printf("%n%-30s%10s", "----", "  --------\n\r");

        this.console.printf("%n%-30s%10s", "Current Year:", game.getYear(), "\n");
        this.console.printf("%n%-30s%10s", "People Starved:", game.getStarved(), "\n");
        this.console.printf("%n%-30s%10s", "New Population:", game.getNewPopulation(), "\n");
        this.console.printf("%n%-30s%10s", "Population Killed:",
                game.getPopulationKilled(), "\n");
        this.console.printf("%n%-30s%10s", "Current Population:",
                game.getCurrentPopulation(), "\n");
        this.console.printf("%n%-30s%10s", "Current Acres Owned:", game.getAcresOwned(), "\n");
        this.console.printf("%n%-30s%10s", "Current Bushels Per Acre:",
                game.getBushelsPerAcreHarvested(), "\n");
        this.console.printf("%n%-30s%10s", "Current Bushels Harvested:",
                game.getBushelsHarvested(), "\n");
        this.console.printf("%n%-30s%10s", "Current Bushels Tithed:",
                game.getBushelsInTithes(), "\n");
        this.console.printf("%n%-30s%10s", "Current Wheat Eaten By Rats:",
                game.getWheatEatenByRats(), "\n");
        this.console.printf("%n%-30s%10s", "Current Wheat:",
                game.getWheatInStorage(), "\n");
            
            
            
            

            this.console.println("\n\nEnter Q to quit or M to return to the main menu");
            boolean valid = false;
            String selection = null;

            while (valid == false) {

                try {
                    selection = this.keyboard.readLine();
                } catch (IOException ex) {
                    ErrorView.display(this.getClass().getName(), "\n\nInvalid Entry\n"
                            + "Enter Q to quit or M to return to the main menu");
                }

                selection = selection.trim();
                selection = selection.toUpperCase();

                if (selection.equals("Q")) {
                    System.exit(0);
                    break;
                }
                if (selection.equals("M")) {

                    MainMenuView mainMenuView = new MainMenuView();
                    mainMenuView.display();
                    break;
                } else {
                    ErrorView.display(this.getClass().getName(), "\n\nInvalid Entry");

                }

            }

//                } catch (IOException ex) {
//                    ErrorView.display(this.getClass().getName(), "\n\nInvalid Entry");
//                
        } else if (mort == 5) {
            GameMenuView gameMenuView = new GameMenuView();
            gameMenuView.display();

        }

    }

    private void reportMenu() {
        ReportsMenuView reportsMenuView = new ReportsMenuView();
        reportsMenuView.display();
    }

    private void saveGame() {
        SaveGameView saveGameView = new SaveGameView();
        saveGameView.display();
    }

    private void viewActors() {

        ActorView actorView = new ActorView();
        actorView.displayActorView();

    }

    private void ItemInventory() {

        ItemInventoryView itemInventoryView = new ItemInventoryView();
        itemInventoryView.displayItemInventoryView();

    }

}
