/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

import byui.cit260.neversync.exceptions.ReportsControlException;
import byui.cit260.neversync.view.ActorsReportView;
import byui.cit260.neversync.view.ErrorView;
import neversync.NeverSync;
import cit260.neversync.model.Actor;
import cit260.neversync.model.Game;
import cit260.neversync.model.InventoryItem;
import cit260.neversync.model.ItemType;
import cit260.neversync.model.Location;
import cit260.neversync.model.Map;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import neversync.NeverSync;

/**
 *
 * @author benjaminlangston
 */
public class ReportsControl {

    public static void printInventoryReport(String outputLocation) throws ReportsControlException {

        Game game = NeverSync.getCurrentGame();
        game.getInventory();
        InventoryItem[] tools = game.getInventory();

        if (outputLocation == null) {
            throw new ReportsControlException("You must enter a value");

        }

        try (PrintWriter out = new PrintWriter(outputLocation)) {

            out.println("\n\n            Inventory Report");
            out.printf("%n%-20s%10s%10s", "Description", "Quantity", "Price");
            out.printf("%n%-20s%10s%10s", "-----------", "--------", "-----");
            for (InventoryItem item : tools) {
                out.printf("%n%-20s%7d%13.2f", item.getItemType().toUpperCase(),
                         item.getQuantityInStock(),
                         item.getPricePerUnit());

            }
            out.flush();
        } catch (IOException ex) {
            ErrorView.display("Error:", ex.getMessage());
        }

    }

    public static void printActorsReport(String outputLocation) throws ReportsControlException {

        Game game = NeverSync.getCurrentGame();
        game.getActors();
        ArrayList<Actor> locs = game.getActors();

        if (outputLocation == null) {
            throw new ReportsControlException("You must enter a value");

        }

        try (PrintWriter out = new PrintWriter(outputLocation)) {

            out.println("\n\n  Actor Location Report");
            out.printf("%n%-10s%7s%5s", "Name", "Col", "Row");
            out.printf("%n%-10s%6s%5s", "-----------", "---", "---");
            for (Actor actor : locs) {
                out.printf("%n%-10s%6d%5d", actor.getName(),
                         actor.getColumn(),
                         actor.getRow());

            }
            out.close();
        } catch (IOException ex) {
            ErrorView.display("Error:", ex.getMessage());
        }
    }

//    public static void printLocationReport(String outputLocation)
//            throws ReportsControlException {
//
//        if (outputLocation == null) {
//            throw new ReportsControlException("You must enter a value");
//
//        }
//
//        try (PrintWriter outFile = new PrintWriter(outputLocation)) {
//
//            outFile.println("\n\n            Inventory Report");
//            outFile.printf("%n%-20s%10s%10s", "Description", "Quantity", "Price");
//            outFile.printf("%n%-20s%10s%10s", "-----------", "--------", "-----");
//            for (InventoryItem item : tools) {
//                outFile.printf("%n%-20s%7d%13.2f", item.getItemType().toUpperCase(),
//                        item.getQuantityInStock(),
//                        item.getPricePerUnit());
//
//            }
//            outFile.flush();
//        } catch (IOException ex) {
//            ErrorView.display("Error:", ex.getMessage());
//
//        }
//
//    }

    public static void printLocationReport(String outputLocation) throws ReportsControlException {
//        Location[][] locations = NeverSync.getCurrentGame().getMap().getLocations();
        
        String listing = NeverSync.getCurrentGame().getMap().getDescription();
        
        System.out.println(listing);
        
        
    }

}
