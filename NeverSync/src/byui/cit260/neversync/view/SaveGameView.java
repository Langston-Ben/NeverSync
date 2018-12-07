/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import byui.cit260.neversync.exceptions.GameControlException;
import cit260.neversync.control.GameControl;
import cit260.neversync.model.Game;
import neversync.NeverSync;

/**
 *
 * @author benjaminlangston
 */
public class SaveGameView extends View {
    
       @Override
    public String[] getInputs() {

        String[] input = new String[1];
        this.console.println("\n************************\n"
                + "City Of Aaron Save Game Menu\n"
                + "************************\n");

        String saveGameSelection = this.getInput(
                "\nPlease Enter The Path To Save" 
                        + " The Current Game");
        input[0] = saveGameSelection;
        
        return input;

    }

    @Override
    public boolean doAction(String[] input) {

        input[0] = input[0].toUpperCase();
        String filePath = input[0];
        
        Game game = NeverSync.getCurrentGame();
        
        try {
        GameControl.saveGame(game, filePath);
        
        } catch (GameControlException e) {
            ErrorView.display(this.getClass().getName(), 
                   "Error: " + e.getMessage());
            return false;
        }
        {
        this.console.println("The file was saved successfully");
        return true;
        
        }
    }
}
        
        
        

        
        
        
      