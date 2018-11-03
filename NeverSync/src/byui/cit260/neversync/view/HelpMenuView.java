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
public class HelpMenuView {
    
    public void displayHelpMenuView() {
  
        boolean endOfView = false;
    do { 
        String[] input = HelpMenuView.getInput();
        //input[0] = input[0].toUpperCase();
        if (input[0] == null || input.length < 1 || input[0].equals("Q")) {
            
        return;
        }
        else {
        endOfView = doAction(input); 
        }
} while (endOfView != true);
 
    }
       private static String [] getInput() {
        
        String[] input = new String[1];
        System.out.println("\n************************\n"  
        + "City Of Aaron Help Menu\n"
        + "************************\n");
        System.out.println(
            "\nThe options on the main menu are: \n" +
            "G - The theme of the game\n" +
            "M - How to move through the game\n" +
            "P - How is the game won?\n" +
            "H - Crop managing resources\n" +
            "W - How much wheat is in the storehouse\n" +
            "Q - Q the help menu\n");
        
                
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
                case "G" : themeHelp();
                    break;
                case "M" : moveHelp();
                    break;
                case "P" : playHelp();
                    break;
                case "H" : cropHarvestHelp();
                    break;
                case "W" : storeHouseHelp();
                    break;
                case "Q" : return true;
                
                default: System.out.println("\nInvalid Menu Item\n");
              
            }
            
         return false;           
        }
 

    private void themeHelp() {
       System.out.println("\nThe Theme of the Game");
       System.out.println("\n"
               + "The theme or goal of the game is to lead the city of NeverSync"
               + "\nin prosperous living. You are presented with multiple choices "
               + "\nround by round (10 rounds) that will either bless or curse your "
               + "\npeople. The goal is to maintain balance and grow the population "
               + "\nwhile meeting the needs of your community."
               + "\n");
    }

    private void moveHelp() {
        System.out.println("\nHow to Move Through the Game\n");
        System.out.println("\nThe game has many scenes or locations. "
                + "\nYou move by picking your desired destination. "
                + "\nYou can choose from scenes such as the Temple, Storehouse, "
                + "\nor Wheat Storage. After selecting your desired location you "
                + "\nwill be moved to that scene.\n");
    }

    private void playHelp() {
        System.out.println("\nHow to Win the Game \n");
        System.out.println("\nThe game is lost by allowing over 50% of your "
                + "\noriginal population to die from starvation at any point in the game. "
                + "\nThe game is won by growing your population, avoiding starvation, "
                + "\novercoming obstacles such as rats and invaders. "
                + "\nYou overall score is compared with past games. "
                + "\nGetting a new high score unlocks a 3 round bonus level that "
                + "\nprovides an opportunity to achieve Zion status "
                + "\nand have your city taken up unto the Lord.");
    }

    private void cropHarvestHelp() {
        System.out.println("\nCrop Managing Resources\n");
                System.out.println("\nYou are given 2700 bushels of wheat to begin the game. "
                + "\nEach year you are allowed to decide how much is set aside to pay "
                + "\ntithing, feed your people, plant as crops, and to save. "
                + "\nEach person consumes 3 bushels per year. "
                + "\nYou may receive up to 10 newcomers per year. "
                + "\nYou may lose wheat in storage due to rats. "
                + "\nYou may also lose a portion of your crops to invaders. "
                + "\nYou are less likely to suffer these losses when you "
                + "\npay tithing and adequately provide for your people.\n");
    }
    

    private void storeHouseHelp() {
        System.out.println("\nStorehouse help displayed here\n");
    }
            
}

