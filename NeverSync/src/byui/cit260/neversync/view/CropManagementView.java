/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import byui.cit260.neversync.exceptions.BuyLandControlException;
import byui.cit260.neversync.exceptions.CropControlException;
import byui.cit260.neversync.exceptions.PlantControlException;
import byui.cit260.neversync.exceptions.SellLandControlException;
import cit260.neversync.control.BuyLandControl;
import cit260.neversync.control.CropControl;
import cit260.neversync.control.PlantControl;
import cit260.neversync.control.SellLandControl;
import cit260.neversync.model.Game;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import neversync.NeverSync;

/**
 *
 * @author Ben Langston
 */
public class CropManagementView extends View {

    @Override
    public String[] getInputs() {

        String[] input = new String[1];


        this.console.println("\n**********************************\n"
                + "City Of Aaron Crop Management Menu\n"
                + "**********************************\n");
        this.console.println(
                "\nThe options on the main menu are: \n"
                + "B - Buy Land\n"
                + "S - Sell Land\n"
                + "F - Feed the People\n"
                + "P - Plant the Crops\n"
                + "T - Pay Tithes and Offerings\n"
                + "Q - Return to the game menu\n");

        String cropManagementSelection = this.getInput("\nPlease enter your selection: ");
        input[0] = cropManagementSelection;

        return input;
    }

    @Override
    public boolean doAction(String[] input) {

        input[0] = input[0].toUpperCase();
        String cropSelection = input[0];

        switch (cropSelection) {
            case "B":
                buyLand();
                break;
            case "S":
                sellLand();
                break;
            case "F":
                feedPeople();
                break;
            case "P":
                plantCrops();
                break;
            case "T":
                payTithes();
                break;
            case "Q":
                return true;

            default:
                this.console.println("\nInvalid Menu Item\n");

        }

        return false;
    }

    private void buyLand() {

        Game game = NeverSync.getCurrentGame();

        this.console.println("The Player will be required to enter a value for "
                + "the number of acres to purchase. \nThis number must be a positive number.  "
                + "\nThe player must have enough wheat in storage to make the land purchase. "
                + "\nOne bushel of wheat is required for every 10 acres purchased."
                + "\nThe city must have enough people to till the land. "
                + "\nOne person can take care of 10 acres. \n");
        Random rand = new Random();
        int acresPrice = rand.nextInt((27 - 17) + 1) + 17;
        this.console.println("The price for an acre of land today is:\n"
                + acresPrice);

        double currentPop = game.getCurrentPopulation();
        double acresOwnedinit = game.getAcresOwned();
        double currentWheat = game.getWheatInStorage();

        this.console.println("\nThe Current Population of the City is: \n" + currentPop);
        this.console.println("\nCurrent number of acres owned:\n" + acresOwnedinit);
        this.console.println("\nCurrent wheat in storage:\n" + currentWheat);

        // create an input file for the console
        Double acresToPurchase = null;

        String selection = null;

        this.console.println("\nEnter The Number of Acres to Purchase: ");

        // get the value for the number of acres to purchase
        while (acresToPurchase == null) {

            try {
                selection = this.keyboard.readLine();

                selection = selection.trim().toUpperCase();

//            String value = inFile.nextLine();
//            value = value.trim().toUpperCase();
                if (selection.equals("Q")) {
                    return;
                }

                try {

                    acresToPurchase = Double.parseDouble(selection);

                } catch (NumberFormatException nfe) {

                    ErrorView.display(this.getClass().getName(),
                            "\n\nYou must enter a numerical value");
                }
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),
                        "Error Reading Input: " + ex.getMessage());
            }
        }
        double toPurchase = 0;

        try {

            toPurchase = BuyLandControl.calcLandPurchase(acresOwnedinit,
                    currentPop, currentWheat, acresToPurchase, acresPrice);
        } catch (BuyLandControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return;
        }

        {
            this.console.println("\n-----------------------------"
                    + "-------------------------"
                    + "--------------");

            this.console.println("The new amount of land is " + toPurchase
                    + " acres after the recent purchase");

            this.console.println("--------------------------------"
                    + "-----------------------"
                    + "-------------\n");

        }
        // pass the values to 2nd function and assign the return to a variable

        double wheat = 0;

        try {

            wheat = BuyLandControl.calcWheatRemaining(acresOwnedinit,
                    currentPop, currentWheat, acresToPurchase, acresPrice);
        } catch (BuyLandControlException bex) {
            ErrorView.display(this.getClass().getName(), bex.getMessage());
            return;

        }

        {
            this.console.println("\n-----------------------------"
                    + "-------------------------"
                    + "--------------");

            this.console.println("The wheat remaining is " + wheat
                    + " bushels after the recent purchase");

            this.console.println("--------------------------------"
                    + "-----------------------"
                    + "-------------\n");

        }
//        game.setAcresOwned(toPurchase);
//        game.setWheatInStorage(wheat);
    }

    private void sellLand() {

        Game game = NeverSync.getCurrentGame();

        this.console.println("The Player will be required to enter a value for "
                + "the number of acres to sell. \nThis number must be a positive number.  "
                + "\nThe player must have enough land to sell.\n");
        Random rand = new Random();
        int acresPrice = rand.nextInt((30 - 15) + 1) + 15;
        this.console.println("The price for an acre of land today is:\n"
                + acresPrice);

        double acresOwnedinit = game.getAcresOwned();
        double currentWheat = game.getWheatInStorage();
//        boolean cNumber;

        this.console.println("\nCurrent number of acres owned:\n" + acresOwnedinit);
        this.console.println("\nCurrent wheat in storage:\n" + currentWheat);

        // create an input file for the console
        this.console.println("\nHow many acres of land would you like to sell today? ");

        Double acresToSell = null;

        // get the value for the number of acres to purchase
        while (acresToSell == null) {
            String value;
            try {
                value = this.keyboard.readLine();

                value = value.trim().toUpperCase();

                if (value.equals("Q")) {
                    return;
                }

                try {

                    acresToSell = Double.parseDouble(value);
                } catch (NumberFormatException nfe) {

                    ErrorView.display(this.getClass().getName(), 
                            "\n\nYou Must Enter a Numerical Value");
                    return;

                }
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex);
            }

            double landToSell = 0;

            try {
                landToSell = SellLandControl.calcLandSold(acresOwnedinit,
                        currentWheat, acresToSell, acresPrice);
            } catch (SellLandControlException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
                return;
            }

            this.console.println("The new amount of land is " + landToSell
                    + " acres after the land sale");

            this.console.println("--------------------------------"
                    + "-----------------------"
                    + "-------------\n");
            game.setAcresOwned(landToSell);

        }
        // pass the values to 2nd function and assign the return to a variable
        double wheat = 0;
        try {
            wheat = SellLandControl.calcWheatRemaining(acresOwnedinit,
                    currentWheat, acresToSell, acresPrice);
        } catch (SellLandControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return;
        }

        {
            this.console.println("\n-----------------------------"
                    + "-------------------------"
                    + "--------------");

            this.console.println("The new value of wheat is " + wheat
                    + " bushels after the recent land sale");

            this.console.println("--------------------------------"
                    + "-----------------------"
                    + "-------------\n");

        }

    }

    private void feedPeople() {

        Game game = NeverSync.getCurrentGame();

        double initWheatStorage = game.getWheatInStorage();
        this.console.println("\nCurrent wheat in storage:\n" + initWheatStorage);

        this.console.println("\nHow many bushels of grain do you want to give to the people? ");

        Double bushelsToFeed = null;

        while (bushelsToFeed == null) {
            String value;
            try {
                value = this.keyboard.readLine();

                value = value.trim().toUpperCase();

                if (value.equals("Q")) {
                    return;
                }

                try {

                    bushelsToFeed = Double.parseDouble(value);

                } catch (NumberFormatException nfe) {

                    ErrorView.display(this.getClass().getName(),
                            "\n\nYou must enter a numerical value" + nfe);
                    return;

                }
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex);
            }

        }
        double bushelsFed = 0;

        try {
            bushelsFed = CropControl.calcBushelsToFeedThePeople(bushelsToFeed, initWheatStorage);
        } catch (CropControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return;
        }

        this.console.println("\n******************************************************\n"
                + "The amount of remaining after feeding the people is " + bushelsFed
                + " bushels. " + "\n******************************************************\n");

    }

    private void plantCrops() {
        Game game = NeverSync.getCurrentGame();

        this.console.println("Please enter a value for "
                + "the number of acres to plant. \nThis number must be a positive number.  "
                + "\nYou must have enough wheat in storage. "
                + "\nOne bushel of wheat is required for every 2 acres planted.");

        double currentPop = game.getCurrentPopulation();
        double acresOwned = game.getAcresOwned();
        double initWheatStorage = game.getWheatInStorage();

        this.console.println("\nThe Current Population of the City is: \n" + currentPop);
        this.console.println("\nCurrent number of acres to plant:\n" + acresOwned);
        this.console.println("\nCurrent wheat in storage:\n" + initWheatStorage);

        // prompt to enter the number of acres to be planted
        this.console.println("\nEnter The Number of Acres to Plant: ");

        Double acresToPlant = null;

        while (acresToPlant == null) {
            String value;
            try {
                value = this.keyboard.readLine();

                value = value.trim().toUpperCase();

                if (value.equals("Q")) {
                    return;
                }

                try {

                    acresToPlant = Double.parseDouble(value);

                } catch (NumberFormatException nfe) {

                    ErrorView.display(this.getClass().getName(),
                            "\n\nYou must enter a numerical value" + nfe);
                    return;

                }
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex);
            }

        }

        double landPlant = 0;

        try {
            landPlant = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        } catch (PlantControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return;

        }

        double landPlanted = 0;

        try {
            landPlanted = PlantControl.calcAcresRemaining(acresOwned, acresToPlant, initWheatStorage);
        } catch (PlantControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return;

        }

        this.console.println("\n******************************************************\n"
                + "The amount of land planted this season is " + acresToPlant
                + " acres. " + "\n******************************************************\n");

        this.console.println("\n*******************************************\n"
                + "You have " + landPlant + " "
                + "bushels of wheat remaining."
                + "\n*******************************************\n");

        this.console.println("\n******************************************************\n"
                + "The amount of land not planted this season is " + landPlanted
                + " acres. " + "\n******************************************************\n");
    }

    private void payTithes() {
      
        this.console.println("Please enter a value to "
                + "pay tithes and offerings as a percent.\nThis number must be a positive number.  "
                + "\nThe percent cannot be greater than 100. ");

        // prompt to enter the number for tithes and offerings
        this.console.println("\nEnter The Percentage of Tithes and Offerings: ");

        Double tithingPercent = null;

        while (tithingPercent == null) {
            String value;
            try {
                value = this.keyboard.readLine();

                value = value.trim().toUpperCase();

                if (value.equals("Q")) {
                    return;
                }

                try {

                    tithingPercent = Double.parseDouble(value);

                } catch (NumberFormatException nfe) {

                    ErrorView.display(this.getClass().getName(),
                            "\n\nYou must enter a numerical value" + nfe);
                    return;

                }
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex);
            }

        }

        double harvest = 0;

        try {
            harvest = CropControl.calcCropYield(tithingPercent);
        } catch (CropControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return;

        }

        this.console.println("\n******************************************************\n"
                + "The the crop yield this season is " + harvest
                + " bushels. " + "\n******************************************************\n");
    }

}
