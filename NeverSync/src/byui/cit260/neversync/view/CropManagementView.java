/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import byui.cit260.neversync.exceptions.BuyLandControlException;
import byui.cit260.neversync.exceptions.PlantControlException;
import byui.cit260.neversync.exceptions.SellLandControlException;
import cit260.neversync.control.BuyLandControl;
import cit260.neversync.control.PlantControl;
import cit260.neversync.control.SellLandControl;
import cit260.neversync.model.Game;
import java.util.Random;
import java.util.Scanner;
import neversync.NeverSync;

/**
 *
 * @author Ben Langston
 */
public class CropManagementView extends View {

    @Override
    public String[] getInputs() {

        String[] input = new String[1];
        System.out.println("\n**********************************\n"
                + "City Of Aaron Crop Management Menu\n"
                + "**********************************\n");
        System.out.println(
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
                System.out.println("\nInvalid Menu Item\n");

        }

        return false;
    }

    private void buyLand() {
        
        Game game = NeverSync.getCurrentGame();

        System.out.println("The Player will be required to enter a value for "
                + "the number of acres to purchase. \nThis number must be a positive number.  "
                + "\nThe player must have enough wheat in storage to make the land purchase. "
                + "\nOne bushel of wheat is required for every 10 acres purchased."
                + "\nThe city must have enough people to till the land. "
                + "\nOne person can take care of 10 acres. \n");
        Random rand = new Random();
        int acresPrice = rand.nextInt((27 - 17) + 1) + 17;
        System.out.println("The price for an acre of land today is:\n"
                + acresPrice);

        double currentPop = game.getCurrentPopulation();
        double acresOwnedinit = game.getAcresOwned();
        double currentWheat = game.getWheatInStorage();


        System.out.println("\nThe Current Population of the City is: \n" + currentPop);
        System.out.println("\nCurrent number of acres owned:\n" + acresOwnedinit);
        System.out.println("\nCurrent wheat in storage:\n" + currentWheat);

        // create an input file for the console
        Double acresToPurchase = null;
        Scanner inFile;
        inFile = new Scanner(System.in);

        System.out.println("\nEnter The Number of Acres to Purchase: ");

        // get the value for the number of acres to purchase
        while (acresToPurchase == null) {
            String value = inFile.nextLine();
            value = value.trim().toUpperCase();

            if (value.equals("Q")) {
                return;
            }

            try {

                acresToPurchase = Double.parseDouble(value);

            } catch (NumberFormatException nfe) {

                System.out.println(nfe + "\n\nYou must enter a numerical value");
            }
        }
        double toPurchase = 0;
//                cNumber = true;

        try {

            toPurchase = BuyLandControl.calcLandPurchase(acresOwnedinit,
                    currentPop, currentWheat, acresToPurchase, acresPrice);
        } catch (BuyLandControlException ex) {
            System.out.println(ex);
            return;
        }

        {
            System.out.println("\n-----------------------------"
                    + "-------------------------"
                    + "--------------");

            System.out.println("The new amount of land is " + toPurchase
                    + " acres after the recent purchase");

            System.out.println("--------------------------------"
                    + "-----------------------"
                    + "-------------\n");

        }
        // pass the values to 2nd function and assign the return to a variable

        double wheat = 0;

        try {

            wheat = BuyLandControl.calcWheatRemaining(acresOwnedinit,
                    currentPop, currentWheat, acresToPurchase, acresPrice);
        } catch (BuyLandControlException bex) {
            System.out.println(bex);
            return;

        }

        {
            System.out.println("\n-----------------------------"
                    + "-------------------------"
                    + "--------------");

            System.out.println("The wheat remaining is " + wheat
                    + " bushels after the recent purchase");

            System.out.println("--------------------------------"
                    + "-----------------------"
                    + "-------------\n");

        }
             game.setAcresOwned(toPurchase);
             game.setWheatInStorage(wheat);
    }

    private void sellLand() {
//        System.out.println("Placeholder for sellLand");
        
        Game game = NeverSync.getCurrentGame();

        System.out.println("The Player will be required to enter a value for "
                + "the number of acres to sell. \nThis number must be a positive number.  "
                + "\nThe player must have enough land to sell.\n");
        Random rand = new Random();
        int acresPrice = rand.nextInt((30 - 15) + 1) + 15;
        System.out.println("The price for an acre of land today is:\n"
                + acresPrice);

        double acresOwnedinit = game.getAcresOwned();
        double currentWheat = game.getWheatInStorage();
//        boolean cNumber;

        System.out.println("\nCurrent number of acres owned:\n" + acresOwnedinit);
        System.out.println("\nCurrent wheat in storage:\n" + currentWheat);

        // create an input file for the console
        System.out.println("\nHow many acres of land would you like to sell today? ");

        Double acresToSell = null;
        Scanner inFile;
        inFile = new Scanner(System.in);

        // get the value for the number of acres to purchase
        while (acresToSell == null) {
            String value = inFile.nextLine();
            value = value.trim().toUpperCase();

            if (value.equals("Q")) {
                return;
            }

            try {

                acresToSell = Double.parseDouble(value);
            } catch (NumberFormatException nfe) {

                System.out.println(nfe + "\n\nYou Must Enter a Numerical Value");
                return;

            }

            double landToSell = 0;

            try {
                landToSell = SellLandControl.calcLandSold(acresOwnedinit,
                        currentWheat, acresToSell, acresPrice);
            } catch (SellLandControlException ex) {
                System.out.println(ex);
                return;
            }

            System.out.println("The new amount of land is " + landToSell
                    + " acres after the land sale");

            System.out.println("--------------------------------"
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
            System.out.println(ex);
            return;
        }

        {
            System.out.println("\n-----------------------------"
                    + "-------------------------"
                    + "--------------");

            System.out.println("The new value of wheat is " + wheat
                    + " bushels after the recent land sale");

            System.out.println("--------------------------------"
                    + "-----------------------"
                    + "-------------\n");

        }
        
        game.setWheatInStorage(wheat);
    }

    private void feedPeople() {
        System.out.println("Placeholder for feedPeople");
    }

    private void plantCrops() {
        Game game = NeverSync.getCurrentGame();
        
        System.out.println("The Player will be asked to enter a value for "
                + "the number of acres to plant. \nThis number must be a positive number.  "
                + "\nThe player must have enough wheat in storage. "
                + "\nOne bushel of wheat is required for every 2 acres planted.");

        double currentPop = game.getCurrentPopulation();
        double acresOwned = game.getAcresOwned();
        double initWheatStorage = game.getWheatInStorage();

        System.out.println("\nThe Current Population of the City is: \n" + currentPop);
        System.out.println("\nCurrent number of acres owned:\n" + acresOwned);
        System.out.println("\nCurrent wheat in storage:\n" + initWheatStorage);

        // prompt to enter the number of acres to be planted
        System.out.println("\nEnter The Number of Acres to Plant: ");

        Double acresToPlant = null;
        Scanner inFile;
        inFile = new Scanner(System.in);

        while (acresToPlant == null) {
            String value = inFile.nextLine();
            value = value.trim().toUpperCase();

            if (value.equals("Q")) {
                return;
            }

            try {

                acresToPlant = Double.parseDouble(value);

            } catch (NumberFormatException nfe) {

                System.out.println(nfe + "\n\nYou must enter a numerical value");
                return;

            }

        }

        double landPlant = 0;

        try {
            landPlant = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        } catch (PlantControlException ex) {
            System.out.println(ex);
            return;

        }

        // previous code moved to the bottom in case of need....
        System.out.println("\n******************************************************\n"
                + "The amount of land planted this season is " + acresToPlant
                + " acres. " + "\n******************************************************\n");

        System.out.println("\n*******************************************\n"
                + "You have " + landPlant + " "
                + "bushels of wheat remaining."
                + "\n*******************************************\n");
        game.setAcresOwned(acresToPlant);
        game.setWheatInStorage(landPlant);
    }

    private void payTithes() {
        System.out.println("Placeholder for payTithes");
    }

}

//        if (landPlant == -1) {
//
//            System.out.println("\n-----------------------------"
//                    + "-------------------------"
//                    + "--------------");
//
//            System.out.println("You must own more than 500 acres and no more than 2000 acres.");
//
//            System.out.println("--------------------------------"
//                    + "-----------------------"
//                    + "-------------\n");
//        } else if (landPlant == -2) {
//
//            System.out.println("\n-----------------------------"
//                    + "-------------------------"
//                    + "--------------");
//
//            System.out.println("You must select land value greater than 100 acres and less than 1000.");
//
//            System.out.println("--------------------------------"
//                    + "-----------------------"
//                    + "-------------\n");
//
//        } else if (landPlant == -3) {
//
//            System.out.println("\n-----------------------------"
//                    + "-------------------------"
//                    + "--------------");
//
//            System.out.println("You do not have enough wheat to plant that many acres.");
//
//            System.out.println("--------------------------------"
//                    + "-----------------------"
//                    + "-------------\n");
//			
//			 } else if (landPlant == -4) {
//
//            System.out.println("\n-----------------------------"
//                    + "-------------------------"
//                    + "--------------");
//
//            System.out.println("Your wheat storage is outside the allowable range.");
//
//            System.out.println("--------------------------------"
//                    + "-----------------------"
//                    + "-------------\n");
//
//        } else {
//            System.out.println("\n-----------------------------"
//                    + "-------------------------"
//                    + "--------------");
//                if (land == -1) {
//
//                    System.out.println("\n-----------------------------"
//                            + "-------------------------"
//                            + "--------------");
//
//                    System.out.println("The Value for a Land Purchase Must be a "
//                            + "Positive Number, Please Try Again.");
//
//                    System.out.println("--------------------------------"
//                            + "-----------------------"
//                            + "-------------\n");
//                } else if (land == -2) {
//
//                    System.out.println("\n-----------------------------"
//                            + "-------------------------"
//                            + "--------------");
//
//                    System.out.println("There is Not Enough Wheat in Storage for"
//                            + " the Land Purchase, Please use a lower value.");
//
//                    System.out.println("--------------------------------"
//                            + "-----------------------"
//                            + "-------------\n");
//
//                } else if (land == -3) {
//
//                    System.out.println("\n-----------------------------"
//                            + "-------------------------"
//                            + "--------------");
//
//                    System.out.println("Not Enough People to till the Land, Please "
//                            + "Select a Lower Number");
//
//                    System.out.println("--------------------------------"
//                            + "-----------------------"
//                            + "-------------\n");
//
//                } else {
//  if (land == -1) {
//
//                    System.out.println("\n-----------------------------"
//                            + "-------------------------"
//                            + "--------------");
//
//                    System.out.println("The Value for a Land Purchase Must be a "
//                            + "Positive Number, Please Try Again.");
//
//                    System.out.println("--------------------------------"
//                            + "-----------------------"
//                            + "-------------\n");
//                } else if (land == -2) {
//
//                    System.out.println("\n-----------------------------"
//                            + "-------------------------"
//                            + "--------------");
//
//                    System.out.println("There is Not Enough Wheat in Storage for"
//                            + " the Land Purchase, Please use a lower value.");
//
//                    System.out.println("--------------------------------"
//                            + "-----------------------"
//                            + "-------------\n");
//
//                } else if (land == -3) {
//
//                    System.out.println("\n-----------------------------"
//                            + "-------------------------"
//                            + "--------------");
//
//                    System.out.println("Not Enough People to till the Land, Please "
//                            + "Select a Lower Number");
//
//                    System.out.println("--------------------------------"
//                            + "-----------------------"
//                            + "-------------\n");
//
//                } else 
//   if (land == -1) {
//
//                    System.out.println("\n-----------------------------"
//                            + "-------------------------"
//                            + "--------------");
//
//                    System.out.println("The Value for a Land Purchase Must be a "
//                            + "Positive Number, Please Try Again.");
//
//                    System.out.println("--------------------------------"
//                            + "-----------------------"
//                            + "-------------\n");
//                } else if (land == -2) {
//
//                    System.out.println("\n-----------------------------"
//                            + "-------------------------"
//                            + "--------------");
//
//                    System.out.println("Land sold cannot be more than"
//                            + "land owned. Please use a lower value.");
//
//                    System.out.println("--------------------------------"
//                            + "-----------------------"
//                            + "-------------\n");
//
//                } else {
//                    System.out.println("\n-----------------------------"
//                            + "-------------------------"
//                            + "--------------");
// if (land == -1) {
//
//                    System.out.println("\n-----------------------------"
//                            + "-------------------------"
//                            + "--------------");
//
//                    System.out.println("The Value for a Land Purchase Must be a "
//                            + "Positive Number, Please Try Again.");
//
//                    System.out.println("--------------------------------"
//                            + "-----------------------"
//                            + "-------------\n");
//                } else if (land == -2) {
//
//                    System.out.println("\n-----------------------------"
//                            + "-------------------------"
//                            + "--------------");
//
//                    System.out.println("Land sold cannot be more than"
//                            + "land owned. Please use a lower value.");
//
//                    System.out.println("--------------------------------"
//                            + "-----------------------"
//                            + "-------------\n");
//
//                } else 
