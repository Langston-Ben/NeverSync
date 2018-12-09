/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import byui.cit260.neversync.exceptions.GameControlException;
import byui.cit260.neversync.exceptions.ReportsControlException;
import cit260.neversync.control.GameControl;
import cit260.neversync.control.ReportsControl;
import cit260.neversync.model.Game;
import cit260.neversync.model.InventoryItem;
import cit260.neversync.control.ReportsControl;
import java.io.BufferedReader;
import java.io.PrintWriter;
import neversync.NeverSync;

/**
 *
 * @author jeffledbetter
 */
public class ActorsReportView extends View {
	  
    private String message;
    protected final BufferedReader keyboard = NeverSync.getInFile();
    protected final PrintWriter console = NeverSync.getOutFile();
    

  
       @Override
    public String[] getInputs() {

        String[] input = new String[1];
        this.console.println("\n\n************************\n"
                + "Actor Report List\n"
                + "************************\n\n");

        String saveGameSelection = this.getInput(
                "\nPlease Enter Filename To Save Your Actor Report");
        input[0] = saveGameSelection;
        
        return input;

    }

    @Override
    public boolean doAction(String[] input) {

        input[0] = input[0].toUpperCase();
        String actorsReport = input[0];
        
        if (actorsReport == null) {
        ErrorView.display(this.getClass().getName(), "You Must Enter a Value");
        }
        try {
        ReportsControl.printActorsReport(actorsReport);
        
        } catch (ReportsControlException e) {
            ErrorView.display(this.getClass().getName(), 
                   "Error: " + e.getMessage());
            return false;
        }
        
        {
        this.console.println("Your report has been saved.");    
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
        return true;
        
        }
        
    }
}
        
    
