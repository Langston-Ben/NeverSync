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
import java.io.BufferedReader;
import java.io.PrintWriter;
import neversync.NeverSync;

/**
 *
 * @author benjaminlangston
 */

    
    public class ToolsReportView extends View {
  
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
        this.console.println("\n\n************************\n"
                + "Tools Report List\n"
                + "************************\n\n");

        String saveGameSelection = this.getInput(
                "\nPlease Enter Filename To Save Your Tool Report");
        input[0] = saveGameSelection;
        
        return input;

    }

    @Override
    public boolean doAction(String[] input) {

        input[0] = input[0].toUpperCase();
        String toolReport = input[0];
        
        if (toolReport == null) {
        ErrorView.display(this.getClass().getName(), "You Must Enter a Value");
        }
        try {
        ReportsControl.printInventoryReport(toolReport);
        
        } catch (ReportsControlException e) {
            ErrorView.display(this.getClass().getName(), 
                   "Error: " + e.getMessage());
            return false;
        }
        
        {
        this.console.println("Your report has been created");    
//        GameMenuView gameMenuView = new GameMenuView();
//        gameMenuView.display();
        return true;
        
        }
    }
}
        
    
