/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import cit260.neversync.control.BuyLandControl;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jeffledbetter
 */
public class PlantCropsView {

    public void displayPlantCropsView() {

        boolean endOfView = false;
        do {
            String[] input = PlantCropsView.getInput();
            input[0] = input[0].toUpperCase();
            if (input[0] == null || input.length < 1 || input[0].equals("Q")) {

                return;
            } else {
                //endOfView = doAction(input);
            }
        } while (endOfView != true);

    }

    private static String[] getInput() {

        String[] input = new String[1];
        System.out.println("\n**********************************\n"
                + "Plant Crops Menu\n"
                + "**********************************\n");
        System.out.println(
                "\nHow many bushels of wheat do you want to plant?");

        boolean valid = false;

        while (valid == false) {
            Scanner inFile;
            inFile = new Scanner(System.in);
			double bushelsToPlant = inFile.nextDouble();

            input[0] = inFile.nextLine();

            String plantCropsSelection = input[0].trim();

            if (plantCropsSelection.length() < 1) {
                System.out.println("\nYou must specify a value\n");
                continue;
            }
            input[0] = plantCropsSelection;
            valid = true;
        }
        return input;

    }

    private boolean doAction(String[] input) {

        return false;
    }
		private void plantCrops() {
			 // prompt to enter the number of bushels to plant
			System.out.println("\nEnter The Number of Bushels to Plant: ");

			// get the value for the number of bushels to plant
			double bushelsToPlant = inFile.nextDouble();
			
			double acresOwned = 1000;
			double initWheatStorage = 2700;
			
			

			// pass the values to the function and assign the return to a variable
			double plantNum = PlantControl.calcBushelsToPlant(acresOwned,
                acresToPlant, initWheatStorage);
			
		}
}

