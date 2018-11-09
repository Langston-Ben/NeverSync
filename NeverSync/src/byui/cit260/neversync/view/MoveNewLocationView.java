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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author benjaminlangston
 */
class MoveNewLocationView {

    private Question question;
    private InventoryItem item;
    private Location location;

    void displayMoveNewLocationView() {
        boolean endOfView = false;
        do {
            String[] input = MoveNewLocationView.getInput();
            //input[0] = input[0].toUpperCase();
            if (input[0] == null || input.length < 1 || input[0].equals("Q")) {

                return;
            } else {
                endOfView = doAction(input);
            }
        } while (endOfView != true);

    }

    private static String[] getInput() {

        String[] input = new String[1];
        System.out.println("\n************************\n"
                + "City Of Aaron Scene Menu\n"
                + "************************\n");
        System.out.println(
                "\nThe options on the main menu are: \n"
                + "N - Select New Scene\n"
                + "Q - Back to previous Menu\n");

        boolean valid = false;

        while (valid == false) {
            Scanner inFile;
            inFile = new Scanner(System.in);
            System.out.println("\nPlease Enter Your Selection\n");

            input[0] = inFile.nextLine();

            String moveNewLocationViewSelection = input[0].trim();

            if (moveNewLocationViewSelection.length() < 1) {
                System.out.println("\nYou must specify a value\n");
                continue;
            }
            input[0] = moveNewLocationViewSelection;
            valid = true;
        }
        return input;

    }

    private boolean doAction(String[] input) {

        input[0] = input[0].toUpperCase();
        String helpItem = input[0];

        switch (helpItem) {
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
        
        System.out.println(sceneOne.getName() + sceneOne.getDescription());
        System.out.println("Your current tool is a " + ItemType.Weapon.getName() + 
                "\n" + ItemType.Weapon.getDescription() + 
                "\nIt is " + ItemType.Weapon.getAge() + " years old\n");
        System.out.println(questionOne.getQuestionText() + questionOne.getAnswer1()
        + questionOne.getAnswer2() + questionOne.getAnswer3() + questionOne.getAnswer4());

    }

}
