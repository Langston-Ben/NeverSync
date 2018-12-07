/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import byui.cit260.neversync.exceptions.MapControlException;
import cit260.neversync.control.MapControl;
import cit260.neversync.model.Actor;
import cit260.neversync.model.Game;
import cit260.neversync.model.Location;
import cit260.neversync.model.Map;
import neversync.NeverSync;

/**
 *
 * @author benjaminlangston
 */
public class MoveNewLocationView extends View {

    @Override
    public String[] getInputs() {

        String[] input = new String[2];
        this.console.println("\n************************\n"
                + "City Of Aaron Scene Menu\n"
                + "************************\n");
        this.console.println(
                "************************\n"
                + "Enter your desired location\n"
                + "************************\n"
        );

        MapView mapView = new MapView();
        mapView.displayMap();
//        String moveNewLocationViewSelection = this.getInput("\nPlease enter your selection: ");
//        input[0] = moveNewLocationViewSelection;

        return input;

    }

    @Override
    public boolean doAction(String[] input) {
        input[0] = input[0].toUpperCase();
        String mapOption = input[0];
        Game game = NeverSync.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        for (int row = 0; row < locations.length; row++) {
            for (int column = 0; column < locations[row].length; column++) {
                if (locations[row][column] != null) {
                    if (mapOption.equals(locations[row][column].getDisplaySymbol())) {
                        try {
                            MapControl.movePlayer(map, row, column);
                        } catch (MapControlException ex) {
                            ErrorView.display(this.getClass().getName(), ex.getMessage());
                        }

                        MapView mapView = new MapView();
                        mapView.displayMap();
                        MainMenuView mainMenuView = new MainMenuView();
                        mainMenuView.display();
                        return true;
                    }
                }
            }
        }
        this.console.println("\n*** Invalid selection *** Please Try Again");
        return false;
    }

}
