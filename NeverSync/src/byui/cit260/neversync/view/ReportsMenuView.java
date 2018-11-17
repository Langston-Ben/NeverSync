/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

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
        System.out.println("\n************************\n"
                + "City Of Aaron Help Menu\n"
                + "************************\n");
        System.out.println(
                "\nThe options on the Report Menu are: \n"
                + "A - View the ANIMALS in the storehouse\n"
                + "T - View the TOOLS in the storehouse\n"
                + "P - View the PROVISIONS in the storehouse\n"
                + "W - View the AUTHORS of the game\n"
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
            case "T":
                toolsReport();
                break;
            case "P":
                provisionsReport();
                break;
            case "W":
                authorsReport();
                break;
            case "Q":
                return true;

            default:
                System.out.println("\nInvalid Menu Item\n");

        }

        return false;
    }

    private void animalsReport() {
        System.out.println("\nAnimals Report:");
        System.out.println("\n");
    }

    private void toolsReport() {
        System.out.println("\nTools Report:");
        System.out.println("\n");
    }

    private void provisionsReport() {
        System.out.println("\nProvisions Report:");
		System.out.println("\n");
    }

    private void authorsReport() {
        System.out.println("\nGame Authors");
        System.out.println("\nBen Langston and Jeff Ledbetter");
    }
}