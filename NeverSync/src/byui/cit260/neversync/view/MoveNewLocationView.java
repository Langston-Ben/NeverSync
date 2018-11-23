/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import cit260.neversync.model.InventoryItem;
import cit260.neversync.model.Location;
import cit260.neversync.model.Question;

/**
 *
 * @author benjaminlangston
 */


class MoveNewLocationView extends View {

    private Question question;
    private InventoryItem item;
    private Location location;

    @Override
    public String[] getInputs() {

        String[] input = new String[1];
        System.out.println("\n************************\n"
                + "City Of Aaron Scene Menu\n"
                + "************************\n");
        System.out.println(
                "\nThe options on the main menu are: \n"
                + "M - View the Map\n"         
                + "N - Select New Scene\n"
                + "Q - Back to previous Menu\n");

          String moveNewLocationViewSelection = this.getInput("\nPlease enter your selection: ");
            input[0] = moveNewLocationViewSelection;
        return input;

    }

    @Override
    public boolean doAction(String[] input) {

        input[0] = input[0].toUpperCase();
        String helpItem = input[0];

        switch (helpItem) {
            case "M":
                mapScene();
                break;
            case "N":
                newScene();
                break;
            case "Q":
                return true;

            default:
                System.out.println("\nInvalid Menu Item\n");

        }

        return false;
    }

    private void newScene() {
        
        SceneView sceneView = new SceneView();
        sceneView.display();

    }

    private void mapScene() {
        MapView mapView = new MapView();
        mapView.displayMap();
    }

}
