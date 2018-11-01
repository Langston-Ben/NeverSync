/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import java.util.Scanner;

/**
 *
 * @author benjaminlangston
 */
public class HelpMenuView {
    
    public void displayHelpMenuView() {
    
    
        
//        private void displayHelpMenuView() {   
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
        System.out.println("************************\n"  
        + "City Of Aaron Help Menu\n"
        + "************************\n");
        System.out.println(
            "The options on the main menu are: \n" +
            "G - The theme of the game\n" +
            "M - How to move through the game\n" +
            "P - How is the game won?\n" +
            "H - Crop managing resources\n" +
            "W - How much wheat is in the storehouse\n" +
            "Q - Q the help menu");
        
                
        boolean valid = false;
        
        while (valid == false) {
        Scanner inFile;
        inFile = new Scanner(System.in);   
        System.out.println("\nPlease Enter Your Selection");
        
        input[0] = inFile.nextLine();
        
        String helpMenuSelection = input[0].trim();
        
        
        if (helpMenuSelection.length() < 1) {
            System.out.println("You must specify a value");
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
                
                default: System.out.println("Invalid Menu Item");
              
            }
            
         return false;           
        }
 

    private void themeHelp() {
       System.out.println("The purpose of the game help displayed here\n");
    }

    private void moveHelp() {
        System.out.println("How to move around the game help displayed here\n");
    }

    private void playHelp() {
        System.out.println("How to win the game help displayed here\n");
    }

    private void cropHarvestHelp() {
        System.out.println("Havest and crop resources help displayed here\n");
    }

    private void storeHouseHelp() {
        System.out.println("Storehouse help displayed here\n");
    }
            
    }

