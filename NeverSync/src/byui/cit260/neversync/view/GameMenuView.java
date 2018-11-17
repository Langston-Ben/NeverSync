/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

//import java.util.Scanner;

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
                + "M - Move to a New Location\n"
                + "C - Manage the Crops\n"
                + "L - Live the Year\n"
                + "R - Reports Menu\n"
                + "S - Save Game\n"
                + "Q - Return to the main menu\n");

        String helpMenuSelection = this.getInput("\nPlease enter your name: ");
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
                System.out.println("\nInvalid Menu Item\n");

        }

        return false;
    }

    private void viewMap() {
        System.out.println("placeholder for viewMap");
    }

    private void moveNewLocation() {
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

}
