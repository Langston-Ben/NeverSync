/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import byui.cit260.neversync.exceptions.ReportsControlException;
import cit260.neversync.model.Game;
import cit260.neversync.model.InventoryItem;
import cit260.neversync.model.Actor;
import java.io.PrintWriter;
import neversync.NeverSync;
import java.util.ArrayList;


/**
 *
 * @author jeffledbetter
 */
public class ReportsMenuView extends View {
	
	public ReportsMenuView() {
	}

	@Override
    public String[] getInputs() {

        String[] input = new String[1];
        this.console.println("\n************************\n"
                + "City Of Aaron Reports Menu\n"
                + "************************\n");
        this.console.println(
                "\nThe options on the Report Menu are: \n"
                + "A - View the ANIMALS in the storehouse\n"
				+ "M - View Locations of Actors\n"
                + "T - View the TOOLS in the storehouse\n"
                + "P - View the PROVISIONS in the storehouse\n"
                + "W - View the AUTHORS of the game\n"
                + "L - View Locations and Availability\n"
                + "Q - Quit the Reports Menu\n");
       
		String reportsMenuSelection = this.getInput("\nPlease enter your selection: ");
		input[0] = reportsMenuSelection;
		
    return input;

    }

	@Override
    public boolean doAction(String[] input) {

        input[0] = input[0].toUpperCase();
        String reportsItem = input[0];

        switch (reportsItem) {
            case "A":
                animalsReport();
                break;
			case "M":
                actorsReport();
                break;
            case "T":
                toolsReport();
                break;
            case "P":
                provisionsReport();
                break;
            case "W":
                authorsReport();
                break;
            case "L":
                locationsReport();
                break;
            case "Q":
                return true;

            default:
                this.console.println("\nInvalid Menu Item\n");

        }

        return false;
    }

    private void animalsReport() {
        this.console.println("\nAnimals Report:");
        this.console.println("\n");
    }

    private void toolsReport() {
        
        Game game = NeverSync.getCurrentGame();
        game.getInventory();
        InventoryItem[] tools = game.getInventory();
        
            this.console.println("\n\n            Inventory Report"          );
            this.console.printf("%n%-20s%10s%10s", "Description", "Quantity", "Price");
            this.console.printf("%n%-20s%10s%10s", "-----------", "--------", "-----");
            for (InventoryItem item : tools) {
                this.console.printf("%n%-20s%7d%13.2f", item.getItemType().toUpperCase()
                                             , item.getQuantityInStock()
                                             , item.getPricePerUnit());
          
            }
        
        ToolsReportView toolsReportView = new ToolsReportView();
        toolsReportView.display();
    }
	
	private void actorsReport() {
		
		Game game = NeverSync.getCurrentGame();
			game.getActors();
			ArrayList<Actor> locs = game.getActors();

				this.console.println("\n\n         Actor Location Report"          );
				this.console.printf("%n%-10s%7s%5s", "Name", "Col", "Row");
				this.console.printf("%n%-10s%6s%5s", "-----------", "---", "---");
				for (Actor actor : locs) {
					this.console.printf("%n%-10s%6d%5d", actor.getName()
												 , actor.getColumn()
												 , actor.getRow());

            }
	}

    private void provisionsReport() {
        this.console.println("\nProvisions Report:");
		this.console.println("\n");
    }

    private void authorsReport() {
        this.console.println("\nGame Authors");
        this.console.println("\nBen Langston and Jeff Ledbetter");
    }

    private void locationsReport() {
         LocationsReportView locationsReportView = new LocationsReportView();
         locationsReportView.display();
    }
}