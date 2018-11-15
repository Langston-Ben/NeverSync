/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

//import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author benjaminlangston
 */
public abstract class View implements ViewInterface {

    public View() {
    }
    
    @Override
    public void display() {
        boolean endOfView = false;
        do {
            String[] input = getInputs();

            if (input[0] == null || input.length < 1 || input[0].equalsIgnoreCase("Q")) {
                return;
            } else {
                endOfView = doAction(input);
            }
        } while (endOfView != true);

    }
    
    @Override
    public String getInput(String promptMessage) {
    
    String[] inputs = new String[1];
        boolean valid = false;

        while (valid == false) {
            Scanner inFile;
            inFile = new Scanner(System.in);
            System.out.println(promptMessage);

            inputs[0] = inFile.nextLine();

            String selection = inputs[0].trim();

            if (selection.length() < 1) {
                System.out.println("\nYou must specify a value\n");
                continue;
            }
            inputs[0] = selection;
            valid = true;
        }
        return inputs[0];
    
    
    }
    
    
    

    }

    
    
    

