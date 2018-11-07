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
                "\nHow many acres of land do you want to plant?");

        boolean valid = false;

        while (valid == false) {
            Scanner inFile;
            inFile = new Scanner(System.in);
            System.out.println("\nPlease Enter Your Selection\n");

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

//    private boolean doAction(String[] input) {
//
//        input[0] = input[0].toUpperCase();
//        String cropSelection = input[0];
//
//        switch (cropSelection) {
//            case "B":
//                buyLand();
//                break;
//            case "S":
//                sellLand();
//                break;
//            case "F":
//                feedPeople();
//                break;
//            case "P":
//                plantCrops();
//                break;
//            case "T":
//                payTithes();
//                break;
//            case "Q":
//                return true;
//
//            default:
//                System.out.println("\nInvalid Menu Item\n");
//
//        }
//
//        return false;
//    }

    
}

