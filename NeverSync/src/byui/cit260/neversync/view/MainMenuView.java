/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import byui.cit260.neversync.exceptions.GameControlException;
import cit260.neversync.control.GameControl;
import cit260.neversync.model.Game;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.Scanner;
import neversync.NeverSync;

/**
 *
 * @author Ben Langston and Jeff Ledbetter
 */
public class MainMenuView extends View {

    public MainMenuView() {
    }


    @Override
    public String[] getInputs() {

        String[] input = new String[1];
        this.console.println("Main Menu\n"
                + "\nThe options on the main menu are: \n"
                + "S - Start a New Game\n"
                + "L - Load a Saved Game\n"
                + "H - Help\n"
                + "Q - Quit");

            String gameMenuSelection = this.getInput("\nPlease enter your selection: ");
            input[0] = gameMenuSelection;
        
        return input;

    }

    @Override
    public boolean doAction(String[] input) {

        input[0] = input[0].toUpperCase();
        String menuItem = input[0];

        switch (menuItem) {
            case "S":
                startNewGame();
                break;
            case "L":
                startSavedGame();
                break;
            case "H":
                getHelp();
                break;
            case "Q":
                return true;

            default:
                this.console.println("\nInvalid Menu Item\n");

        }

        return false;
    }

    private void startNewGame() {
        
        int ret = 0;
        try {
            ret = GameControl.createNewGame(NeverSync.getPlayer());
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(), "\n\nGame Could Not Be Startedben"
                    + "");
        }
        if (ret == 1) {
            GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
        
        
        
        }
        else {
        this.console.println("Start New Game Failed");
        }
    }

    private void startSavedGame() {
        StartExistingGameView startExistingGameView = new StartExistingGameView();
        startExistingGameView.display();
    }

    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

}
