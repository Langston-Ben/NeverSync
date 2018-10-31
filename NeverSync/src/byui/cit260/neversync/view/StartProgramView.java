/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import cit260.neversync.model.Player;
import java.util.Scanner;
import neversync.NeverSync;

/**
 *
 * @author benjaminlangston
 */
public class StartProgramView {

    public StartProgramView() {
        
    }
   
    
    public static void displayStartProgramView() {
    boolean endOfView = false;
 do { 
    String[] inputs = StartProgramView.getInputs();
        
        
        inputs[0] = inputs[0].toUpperCase();
        if (inputs[0] == null || inputs.length < 1 || inputs[0].equals("Q")) {
            
        return;
        }
        else {
        endOfView = doAction(inputs); 
        }
} while (endOfView = false);
 
    }
    
    private static String [] getInputs() {
        
        String[] inputs = new String[1];
        System.out.println("===================================================="
                + "==========="
                + "\nWelcome to the City of Aaron! \nThe player of the "
                + "\ngame will assume the role of the leader over the city of "
                + "\nAaron. Wheat is the staff of life, and is used as the main "
                + "\ncurrency in the city. As ruler over the city, the player’s "
                + "\ntask is to manage the village’s wheat crops so that the people "
                + "\nof the village can be adequately fed, while dealing with rats, "
                + "\nand random crop yields. The city is blessed when the people pay "
                + "\ntheir tithes and offerings. After serving for 10 years, "
                + "\nthe player will be judged by the people. If too many people "
                + "\ndie during the player’s term of office, the player is removed "
                + "\nfrom office and the game ends"
                + "\n================================================================");
        System.out.println("\nCompiled By Jeff Ledbetter & Ben Langston\n");
        System.out.println("*****Welcome to the Game!*****");
                
        boolean valid = false;
        
        while (valid == false) {
        Scanner inFile;
        inFile = new Scanner(System.in);   
        System.out.println("\nPlease Enter Your Name");
        
        inputs[0] = inFile.nextLine();
        
        String gamePlayerName = inputs[0].trim();
        
        
        if (gamePlayerName.length() < 1) {
            System.out.println("You must enter a non-blank value");
            continue;
        }
            inputs[0] = gamePlayerName;
            valid = true;          
        }          
            return inputs;
           
    }
    
    // This will be changed on the next step
    
    private static boolean doAction(String[] inputs) {
        
           String playersName = inputs[0];
           Player player = GameControl.savePlayer(playersName);
           
           if (player == null) {
           System.out.println("Could not create the player." + "\n"
                   + "Enter a different name.");
           return false;
           }
           
           else {
           System.out.println("======================================= "
           + "\nWelcome to the game " + playersName
           + "\nWe hope you have a lot of fun!"
           + "\n=======================================");
           
           MainMenuView mainMenuView = new MainMenuView();
           mainMenuView.displayMainMenuView();
           return true;
           
                   
            }

    }

    private static class GameControl {

        private static Player savePlayer(String playersName) {
            
            if (playersName == null || playersName.length() < 1) {
            return null;
            }
        
            else {
            Player player = new Player();
            player.setName(playersName);
            NeverSync.setPlayer(player);
            
            return player;
            }
//          
        }

        public GameControl() {
        }
    }

    private static class MainMenuView {

        

        
        public MainMenuView() {
        }
        private void displayMainMenuView() {   
        boolean endOfView = false;
    do { 
        String[] inputs = MainMenuView.getInputs();
        //inputs[0] = inputs[0].toUpperCase();
        if (inputs[0] == null || inputs.length < 1 || inputs[0].equals("Q")) {
            
        return;
        }
        else {
        endOfView = doAction(inputs); 
        }
} while (endOfView = false);
 
    }
       private static String [] getInputs() {
        
        String[] inputs = new String[1];
        System.out.println("Main Menu\n" +
            "The options on the main menu are: \n" +
            "S - Start a New Game\n" +
            "L - Load a Saved Game\n" +
            "H - Help\n" +
            "Q - Quit");
        
                
        boolean valid = false;
        
        while (valid == false) {
        Scanner inFile;
        inFile = new Scanner(System.in);   
        System.out.println("\nPlease Enter Your Selection");
        
        inputs[0] = inFile.nextLine();
        
        String gameMenuSelection = inputs[0].trim();
        
        
        if (gameMenuSelection.length() < 1) {
            System.out.println("You must specify a value");
            continue;
        }
            inputs[0] = gameMenuSelection;
            valid = true;          
        }          
            return inputs;
           
    }    
        
        private boolean doAction(String[] inputs) {
            
            inputs[0] = inputs[0].toUpperCase();
            String menuItem = inputs[0];
            
            
            switch (menuItem) {
                case "S" : startNewGame();
                    break;
                case "L" : restartGame();
                    break;
                case "H" : getHelp();
                    break;
                case "Q" : return true;
                
                default: System.out.println("Invalid Menu Item");
//               
            }
            
         return false;       
         
        }


        private void startNewGame() {
            System.out.println("***** startNewGame() - called! ");
        }

        private void restartGame() {
            System.out.println("***** restartGame() - called! ");
        }

        private void getHelp() {
            System.out.println("***** getHelp() - called! ");
        }
            
            
        }
    }
    
