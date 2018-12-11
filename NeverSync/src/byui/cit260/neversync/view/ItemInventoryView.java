/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import byui.cit260.neversync.exceptions.StoreHouseException;
//import cit260.neversync.control.GameControl;
import cit260.neversync.control.StoreHouseControl;
import cit260.neversync.model.Game;
import cit260.neversync.model.InventoryItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import neversync.NeverSync;

/**
 *
 * @author ben langston
 */
public class ItemInventoryView {
    
    private String message;

    protected final BufferedReader keyboard = NeverSync.getInFile();
    protected final PrintWriter console = NeverSync.getOutFile();

    public ItemInventoryView() {
    }

    public void displayItemInventoryView() {

//        Game game = new Game();
//        game.setInventory(GameControl.createItems());
        Game game = NeverSync.getCurrentGame();
        game.getInventory();

        InventoryItem[] tools = game.getInventory();
        this.console.println("========================\n"
                + "Current Items Available\n"
                + "========================\n");
        for (InventoryItem ItemType : tools) {

            String one = ItemType.getItemType();

            this.console.println(one);

        }
        
        String toBuy = null;
        this.console.println("\n\nEnter the item to purchase from the list above: ");
        

        try {
            toBuy = this.keyboard.readLine();
        
               toBuy = toBuy.trim().toLowerCase();

        if (toBuy.equalsIgnoreCase("Q")) {
            return;
        }
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "Error Reading Input: ");
        }

        // check for a string input
        String regex = "^[a-zA-Z]+$";

        if (toBuy.matches(regex)) {

            for (InventoryItem ItemType : tools) {

                String one = ItemType.getItemType();

                if (one == null ? toBuy == null : one.equals(toBuy)) {
                    String two = one;
                    double price = ItemType.getPricePerUnit();
                    double inStock = ItemType.getQuantityInStock();

                    this.console.println("\nYour Item Choice: " + two);
                    this.console.println("\nThe Purchase Price = : " + price);
                    this.console.println("\nThere are Currently " + inStock + " at "
                            + "the Storehouse");

                    this.console.println("\n\nEnter the quantity for your purchase");

                    Integer quantityToBuy = null;

                    while (quantityToBuy == null) {
                        String value;
                        try {
                            value = this.keyboard.readLine();
                        
                        value = value.trim().toUpperCase();

                        if (value.equals("Q")) {
                            return;
                        }

                        try {
                            quantityToBuy = Integer.parseInt(value);
                        } catch (NumberFormatException nfe) {
                            
                            ErrorView.display(getClass().getName(), 
                                    "\n\nYou must enter a numerical value.");
                            return;
                        }
                        } catch (IOException ex) {
                            ErrorView.display(getClass().getName(), "Error Reading Input: ");
                        }

                        double purchase = 0;
                        double remaining = 0;

                        try {
                            purchase = StoreHouseControl.calTotalSale(price, inStock,
                                    quantityToBuy);
                        } catch (StoreHouseException sh) {
                            ErrorView.display(this.getClass().getName(), sh.getMessage());
                            return;
                        }

                        try {
                            remaining = StoreHouseControl.calQuanRem(inStock, quantityToBuy);
                        } catch (StoreHouseException sh) {
                            ErrorView.display(this.getClass().getName(), sh.getMessage());
                            return;
                        }

                        this.console.println("\nThe price for your purchase of " + two + " today is "
                                + purchase);

                        this.console.println("\nThere are " + remaining + " " + two + " items in the"
                                + " Storehouse after your purchase.");
                        ItemType.setItemType(one);
                        ItemType.setQuantity((int) quantityToBuy);
                        ItemType.setQuantityInStock((int) remaining);
                        
                        // save the item to the players backpack
                        
                        ArrayList<String> backPack = game.getPlayer().getBackPack();
                        
                        backPack.add(two);
//
//        
//        
//        actors.add(Actor.Lehi);
                        
                       

                        return;
                    }
                    
                }

            }

        }
        ErrorView.display(this.getClass().getName(), "\nYou must enter an item on the list!!");
        
    }
}
