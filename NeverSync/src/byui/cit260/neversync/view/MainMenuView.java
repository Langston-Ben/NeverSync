/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import cit260.neversync.control.GameControl;
import java.util.Scanner;
import neversync.NeverSync;

/**
 *
 * @author Ben Langston and Jeff Ledbetter
 */
public class MainMenuView {

        public MainMenuView() {
        }
        
        public void displayMainMenuView() {   
        boolean endOfView = false;
    do { 
        String[] input = MainMenuView.getInput();
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
        System.out.println("Main Menu\n" +
            "\nThe options on the main menu are: \n" +
            "S - Start a New Game\n" +
            "L - Load a Saved Game\n" +
            "H - Help\n" +
            "Q - Quit");
        
                
        boolean valid = false;
        
        while (valid == false) {
        Scanner inFile;
        inFile = new Scanner(System.in);   
        System.out.println("\nPlease Enter Your Selection\n");
        
        input[0] = inFile.nextLine();
        
        String gameMenuSelection = input[0].trim();
        
        
        if (gameMenuSelection.length() < 1) {
            System.out.println("\nYou must specify a value\n");
            continue;
        }
            input[0] = gameMenuSelection;
            valid = true;          
        }          
            return input;
           
    }    
        
        private boolean doAction(String[] input) {
            
            input[0] = input[0].toUpperCase();
            String menuItem = input[0];
            
            
            switch (menuItem) {
                case "S" : startNewGame();
                    break;
                case "L" : restartGame();
                    break;
                case "H" : getHelp();
                    break;
                case "Q" : return true;
                
                default: System.out.println("\nInvalid Menu Item\n");
              
            }
            
         return false;           
        }

        private void startNewGame() {
            
            GameControl.createNewGame(NeverSync.getPlayer());
            GameMenuView gameMenuView = new GameMenuView();
            gameMenuView.displayGameMenuView();
        }

        private void restartGame() {
            StartExistingGameView startExistingGameView = new StartExistingGameView();
            startExistingGameView.displayStartExistingGameView();
        }

        private void getHelp() {
            HelpMenuView helpMenuView = new HelpMenuView();
            helpMenuView.displayHelpMenuView();
        }
    
}
