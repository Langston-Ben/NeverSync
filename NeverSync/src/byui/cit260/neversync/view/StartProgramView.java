/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import cit260.neversync.control.GameControl;
import cit260.neversync.model.Player;
import java.util.Scanner;


/**
 *
 * @author Ben Langston and Jeff Ledbetter
 */
public class StartProgramView {

    public StartProgramView() {
        
    }
       
    public void display() {
    boolean endOfView = false;
 do { 
    String[] input = StartProgramView.getInput();
        
        
//        input[0] = input[0].toUpperCase();
        if (input[0] == null || input.length < 1 || input[0].equalsIgnoreCase("Q"))
//                input[0].toUpperCase(equals("Q")))
//                || input[0].equals("q")) {
                {
        return;
        }
        else {
        endOfView = doAction(input); 
        }
} while (endOfView != true);
 
    }
    
    private static String [] getInput() {
        
        String[] input = new String[1];
        System.out.println("" +
"===================================================================================" +
"                                                                                 \n" +
"                                                                                 \n" +
"           ██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗        \n" +
"           ██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝        \n" +
"           ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗          \n" +
"           ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝          \n" +
"           ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗        \n" +
"            ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝        \n" +
"                               ████████╗ ██████╗                                 \n" +
"                               ╚══██╔══╝██╔═══██╗                                \n" +
"                                  ██║   ██║   ██║                                \n" +
"                                  ██║   ██║   ██║                                \n" +
"                                  ██║   ╚██████╔╝                                \n" +
"                                  ╚═╝    ╚═════╝                                 \n" +
"   ███╗   ██╗███████╗██╗   ██╗███████╗██████╗ ███████╗██╗   ██╗███╗   ██╗ ██████╗\n" +
"   ████╗  ██║██╔════╝██║   ██║██╔════╝██╔══██╗██╔════╝╚██╗ ██╔╝████╗  ██║██╔════╝\n" +
"   ██╔██╗ ██║█████╗  ██║   ██║█████╗  ██████╔╝███████╗ ╚████╔╝ ██╔██╗ ██║██║     \n" +
"   ██║╚██╗██║██╔══╝  ╚██╗ ██╔╝██╔══╝  ██╔══██╗╚════██║  ╚██╔╝  ██║╚██╗██║██║     \n" +
"   ██║ ╚████║███████╗ ╚████╔╝ ███████╗██║  ██║███████║   ██║   ██║ ╚████║╚██████╗\n" +
"   ╚═╝  ╚═══╝╚══════╝  ╚═══╝  ╚══════╝╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═══╝ ╚═════╝\n" +
"");
        System.out.println("===================================================="
                + "==============================="
                + "\n          Welcome to the City of Aaron! "
                + "\nThe player of the game will assume the role of the leader"
                + "\nover the city of Aaron. Wheat is the staff of life,"
                + "\nand is used as the main currency in the city."
                + "\nAs ruler over the city, the player’s task is to manage the "
                + "\nvillage’s wheat crops so that the people of the village"
                + "\ncan be adequately fed, while dealing with rats, "
                + "\nand random crop yields. The city is blessed when the people pay "
                + "\ntheir tithes and offerings. After serving for 10 years, "
                + "\nthe player will be judged by the people. If too many people "
                + "\ndie during the player’s term of office, the player is removed "
                + "\nfrom office and the game ends"
                + "\n===================================================="
                + "===============================");
        System.out.println("\nCompiled By Jeff Ledbetter & Ben Langston\n");
        System.out.println("*****Welcome to the Game!*****\n");
                
        boolean valid = false;
        
        while (valid == false) {
        Scanner inFile;
        inFile = new Scanner(System.in);   
        System.out.println("\nPlease Enter Your Name\n");
        
        input[0] = inFile.nextLine();
        
        String gamePlayerName = input[0].trim();
        
        
        if (gamePlayerName.length() < 1) {
            System.out.println("You must enter a non-blank value");
            continue;
        }
            input[0] = gamePlayerName;
            valid = true;          
        }          
            return input;
           
    }
    
    
    private static boolean doAction(String[] input) {
        
           String playersName = input[0];
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

//    private static class GameControl {
////
//        private static Player savePlayer(String playersName) {
//            
//            if (playersName == null || playersName.length() < 1) {
//            return null;
//            }
//        
//            else {
//            Player player = new Player();
//            player.setName(playersName);
//            NeverSync.setPlayer(player);
//            
//            return player;
//            }
////          
//        }
//
//        public GameControl() {
//        }
//        public static void createNewGame(Player player) {
//            System.out.println("createNewGame was called");
//        }
//    }

//    private static class MainMenuView {
//
//        public MainMenuView() {
//        }
//        
//        private void displayMainMenuView() {   
//        boolean endOfView = false;
//    do { 
//        String[] input = MainMenuView.getInput();
//        //input[0] = input[0].toUpperCase();
//        if (input[0] == null || input.length < 1 || input[0].equals("Q")) {
//            
//        return;
//        }
//        else {
//        endOfView = doAction(input); 
//        }
//} while (endOfView != true);
// 
//    }
//       private static String [] getInput() {
//        
//        String[] input = new String[1];
//        System.out.println("Main Menu\n" +
//            "The options on the main menu are: \n" +
//            "S - Start a New Game\n" +
//            "L - Load a Saved Game\n" +
//            "H - Help\n" +
//            "Q - Quit");
//        
//                
//        boolean valid = false;
//        
//        while (valid == false) {
//        Scanner inFile;
//        inFile = new Scanner(System.in);   
//        System.out.println("\nPlease Enter Your Selection");
//        
//        input[0] = inFile.nextLine();
//        
//        String gameMenuSelection = input[0].trim();
//        
//        
//        if (gameMenuSelection.length() < 1) {
//            System.out.println("You must specify a value");
//            continue;
//        }
//            input[0] = gameMenuSelection;
//            valid = true;          
//        }          
//            return input;
//           
//    }    
//        
//        private boolean doAction(String[] input) {
//            
//            input[0] = input[0].toUpperCase();
//            String menuItem = input[0];
//            
//            
//            switch (menuItem) {
//                case "S" : startNewGame();
//                    break;
//                case "L" : restartGame();
//                    break;
//                case "H" : getHelp();
//                    break;
//                case "Q" : return true;
//                
//                default: System.out.println("Invalid Menu Item");
//              
//            }
//            
//         return false;           
//        }
//
//        private void startNewGame() {
//            
//            GameControl.createNewGame(NeverSync.getPlayer());
//            GameMenuView gameMenuView = new GameMenuView();
//            gameMenuView.displayGameMenuView();
//        }
//
//        private void restartGame() {
//        StartExistingGameView startExistingGameView = new StartExistingGameView();
//        startExistingGameView.displayStartExistingGameView();
//        }
//
//        private void getHelp() {
//        HelpMenuView helpMenuView = new HelpMenuView();
//        helpMenuView.displayHelpMenuView();
//        }   
            
//    }
}
    
