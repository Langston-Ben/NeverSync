/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import cit260.neversync.model.InventoryItem;
import cit260.neversync.model.ItemType;
import cit260.neversync.model.Location;
import cit260.neversync.model.Question;
import cit260.neversync.model.Scene;

/**
 *
 * @author benjaminlangston
 */

public class SceneView extends View {

    private Question question;
    private InventoryItem item;
    private Location location;
    

    @Override
    public String[] getInputs() {

        String[] input = new String[1];
        this.console.println("\n************************\n"
                + "City Of Aaron Scene Menu\n"
                + "************************\n");
        this.console.println(
                "\nThe options on the main menu are: \n"
                + "V - View Current Scene\n"
                + "Q - Back to previous Menu\n");

          String sceneSelection = this.getInput("\nPlease enter your selection: ");
            input[0] = sceneSelection;
        return input;

    }

    @Override
    public boolean doAction(String[] input) {

        input[0] = input[0].toUpperCase();
        String helpItem = input[0];

        switch (helpItem) {
            case "V":
                currentScene();
                break;
            case "Q":
                return true;

            default:
                this.console.println("\nInvalid Menu Item\n");

        }

        return false;
    }

    private void currentScene() {
       




Question questionOne = new Question();
        questionOne.setQuestionText("Where would you like to go?\n");
        questionOne.setAnswer1("1 - To the Farm\n");
        questionOne.setAnswer2("2 - To the Store\n");
        questionOne.setAnswer3("3 - To the Lake\n");
        questionOne.setAnswer4("4 - To a New Location\n");
        
        Scene sceneOne = new Scene();
        sceneOne.setName("\n\nWelcome to the City of Aaron Town Square\n");
        sceneOne.setDescription(
                  "The Town Square is the initial location of the game.\n"
                + "Have a look around and decide where you would like to go "
                + "next.\n");
        sceneOne.setQuestion(questionOne);
        sceneOne.setLocation(location);
        
//        this.console.println(sceneOne.getName() + sceneOne.getDescription());
//        this.console.println("Your current tool is a " + ItemType.Weapon.getName() + 
//                "\n" + ItemType.Weapon.getDescription() + 
//                "\nIt is " + ItemType.Weapon.getAge() + " years old\n");
//        this.console.println(questionOne.getQuestionText() + questionOne.getAnswer1()
//        + questionOne.getAnswer2() + questionOne.getAnswer3() + questionOne.getAnswer4());
//}
}
}