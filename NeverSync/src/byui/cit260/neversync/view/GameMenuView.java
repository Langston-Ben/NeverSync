/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import java.util.Scanner;

/**
 *
 * @author Ben Langston and Jeff Ledbetter
 */
public class GameMenuView {

    public GameMenuView() {
    }

    void displayGameMenuView() {

        boolean endOfView = false;
        do {
            String[] input = GameMenuView.getInput();
            //input[0] = input[0].toUpperCase();
            if (input[0] == null || input.length < 1 || input[0].equals("Q")) {

                return;
            } else {
                endOfView = doAction(input);
            }
        } while (endOfView != true);

    }

    private static String[] getInput() {

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

        boolean valid = false;

        while (valid == false) {
            Scanner inFile;
            inFile = new Scanner(System.in);
            System.out.println("\nPlease Enter Your Selection\n");

            input[0] = inFile.nextLine();

            String helpMenuSelection = input[0].trim();

            if (helpMenuSelection.length() < 1) {
                System.out.println("\nYou must specify a value\n");
                continue;
            }
            input[0] = helpMenuSelection;
            valid = true;
        }
        return input;

    }

    private boolean doAction(String[] input) {

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
        System.out.println("placeholder for moveNewLocation");
    }

    private void manageCrops() {
        CropManagementView cropManagementView = new CropManagementView();
        cropManagementView.displayCropManagementView();
    }

    private void liveYear() {
        System.out.println("placeholder for liveYear");
    }

    private void reportMenu() {
		ReportsMenuView reportsMenuView = new ReportsMenuView();
        reportsMenuView.displayReportsMenuView();
    }

    private void saveGame() {
        System.out.println("placeholder for saveGame");
    }

}
