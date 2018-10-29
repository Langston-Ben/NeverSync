/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

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
    
    private static String[] getInputs() {
        System.out.println("**** getInputs() called***");
        
        String[] inputs = new String[1];
        inputs[0] = "testInput";
        return inputs;
 }
    
    private static boolean doAction(String[] inputs) {
     System.out.println("**** doAction() called ***");
     System.out.println("\tinputs = " + inputs[0]);
     return true;
    }
    
    
 
    }

 
 
    
     

 
    
 
