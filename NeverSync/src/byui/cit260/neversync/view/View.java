/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

//import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import neversync.NeverSync;

/**
 *
 * @author benjaminlangston
 */
public abstract class View implements ViewInterface {

    private String message;

    protected final BufferedReader keyboard = NeverSync.getInFile();
    protected final PrintWriter console = NeverSync.getOutFile();

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

//        String[] inputs = new String[1];
        boolean valid = false;
        String selection = null;

        while (valid == false) {
            try {
                this.console.println(promptMessage);

                selection = this.keyboard.readLine();
                selection = selection.trim();


                if (selection.length() < 1) {
                    ErrorView.display(this.getClass().getName(), "\nYou must specify a value\n");
                    continue;
                }

                break;
            } catch (IOException e) {
                ErrorView.display(this.getClass().getName(), "Error Reading input: " 
                        + e.getMessage());
            }
        }

            return selection;
    }

}
