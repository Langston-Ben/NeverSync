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
        System.out.println("Placehold for City of Aaron Game Description");
        System.out.println("Compiled By Jeff Ledbetter & Ben Langston");
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
//            ENDIF
//            player = new Player object
//            save the name in the player object
//            save the player in the main class of the project
//            RETURN player
//            END
            
            
            
            
            
            
            
            
            
            
            
            
//            System.out.println("*****savePlayer() called ***");
//            return new Player();
            
        }

        public GameControl() {
        }
    }

    private static class MainMenuView {

        
        public MainMenuView() {
        }

        private void displayMainMenuView() {
           System.out.println("*****displayMainMenuView() called ****");
        }
    }
    
}


    
     

 
    
 
