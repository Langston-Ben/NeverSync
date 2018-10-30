/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;
import java.util.Scanner;

/**
 *
 * @author benjaminlangston
 */
public class StartProgramView {

    public StartProgramView() {
        
    }
   
    
    public static void displayStartProgramView() {
    boolean endOfView = false;
 do { 
    String[] inputs = StartProgramView.getInputs();
        
        
    
        if (inputs[0] == null || inputs.length < 1 || inputs[0].equals("Q")) {
        inputs[0] = inputs[0].toUpperCase();    
        return;
        }
        else {
        endOfView = doAction(inputs); 
        }
} while (endOfView = false);
 
    }
    
    private static String [] getInputs() {
        
        String[] inputs = new String[1];
        System.out.println("Placehold for City of Aaron Game Description");
        System.out.println("Compiled By Jeff Ledbetter & Ben Langston");
        System.out.println("*****Welcome to the Game!*****");
                
        boolean valid = false;
        
        while (valid == false) {
        Scanner inFile;
        inFile = new Scanner(System.in);   
        System.out.println("\nPlease Enter Your Name");
        
        inputs[0] = inFile.nextLine();
        
        String gamePlayerName = inputs[0].trim();
        
        
        if (gamePlayerName.length() < 1) {
            System.out.println("You must enter a non-blank value");
            continue;
        }
            inputs[0] = gamePlayerName;
               valid = true;
               
            }
            
            return inputs;
            
    }
    
    // This will be changed on the next step
    
    private static boolean doAction(String[] inputs) {
     System.out.println("**** doAction() called ***");
     System.out.println("\tinputs = " + inputs[0]);
     return true;
    }
    
}


    
     

 
    
 
