/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import byui.cit260.neversync.exceptions.GameControlException;
import cit260.neversync.control.GameControl;
import cit260.neversync.model.Game;
import java.io.BufferedReader;
import java.io.PrintWriter;
import neversync.NeverSync;

/**
 *
 * @author Ben Langston and Jeff Ledbetter
 */
public class StartExistingGameView extends View {
  
    private String message;
    protected final BufferedReader keyboard = NeverSync.getInFile();
    protected final PrintWriter console = NeverSync.getOutFile();
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  
       @Override
    public String[] getInputs() {

        String[] input = new String[1];
        this.console.println("\n************************\n"
                + "City Of Aaron Start Saved Game Menu\n"
                + "************************\n");

        String saveGameSelection = this.getInput(
                "\nPlease Enter The Path To Start" 
                        + " A Saved Game");
        input[0] = saveGameSelection;
        
        return input;

    }

    @Override
    public boolean doAction(String[] input) {

        input[0] = input[0].toUpperCase();
        String filePath = input[0];
        
//        Game game = NeverSync.getCurrentGame();
        
        try {
        GameControl.getGame(filePath);
        
        } catch (GameControlException e) {
            ErrorView.display(this.getClass().getName(), 
                   "Error: " + e.getMessage());
            return false;
        }
        {
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
        return true;
        
        }
    }
}
        
        
        

        
        
        
      

//
//    public void displayStartExistingGameView() {
//        this.console.println("\ndisplay StartExistingGameView has been called ********\n");
//    }

//}
