/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neversync;

//import byui.cit260.neversync.exceptions.MapControlException;
import byui.cit260.neversync.view.StartProgramView;
////import cit260.neversync.model.Condition;
import cit260.neversync.model.Game;
//import cit260.neversync.model.InventoryItem;
//import cit260.neversync.model.ItemType;
//import cit260.neversync.model.Location;
//import cit260.neversync.model.Map;
import cit260.neversync.model.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static com.sun.corba.se.impl.util.Utility.printStackTrace;
//import cit260.neversync.model.Question;
//import cit260.neversync.model.Scene;
//import cit260.neversync.model.StoreHouse;

/**
 *
 * @author Ben Langston, Jeff Ledbetter
 */
public class NeverSync {

    private static Game currentGame = null;
    private static Player player = null;

    private static PrintWriter outFile = null;
    private static PrintWriter logFile = null;
    private static BufferedReader inFile = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        NeverSync.currentGame = currentGame;

    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        NeverSync.player = player;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        NeverSync.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        NeverSync.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        NeverSync.logFile = logFile;
    }
    
    

    public static void main(String[] args) {
        boolean showCallStack = false;
        try {

            // open character stream files for end user input and output
            NeverSync.inFile
                    = new BufferedReader(new InputStreamReader(System.in));
            NeverSync.outFile = new PrintWriter(System.out, true);
            NeverSync.logFile = new PrintWriter(
            "/users/benjaminlangston/Desktop/NetBeansReports/logFile.txt");

            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();
            return;

        } catch (Exception e) {
            showCallStack = true;
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;

        } catch (Throwable te) {
            showCallStack = true;
            System.out.println(te.getMessage());
            te.printStackTrace();
            return;
        } finally {
            try {

                if (NeverSync.inFile != null) {
                    NeverSync.inFile.close();
                }

                if (NeverSync.outFile != null) {
                    NeverSync.outFile.close();
                }
                
                if (NeverSync.logFile != null) {
                    NeverSync.logFile.close();
                }

            } catch (IOException ex) {
                System.out.println(ex + "File failed to close");
                return;
            }

        }

    }

}


