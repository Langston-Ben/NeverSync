/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import java.io.PrintWriter;
import neversync.NeverSync;

/**
 *
 * @author benjaminlangston
 */
public class ErrorView {
    
    private static PrintWriter console = NeverSync.getOutFile();
    private static PrintWriter log = NeverSync.getLogFile();
    
    
    public static void display(String className, String errorMessage) {
    
        console.println(
            "\n--- ERROR ---------------------------------------------------"
          + "\n" + errorMessage
          + "\n-------------------------------------------------------------");
    
        log.printf("%n%n%s", className + " - " + errorMessage);
    
    }
    
    
    
    

    public static PrintWriter getConsole() {
        return console;
    }

    public static void setConsole(PrintWriter console) {
        ErrorView.console = console;
    }

    public static PrintWriter getLog() {
        return log;
    }

    public static void setLog(PrintWriter log) {
        ErrorView.log = log;
    }
    
    
    
}
