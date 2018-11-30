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
import java.util.Scanner;
import neversync.NeverSync;

/**
 *
 * @author ben langston
 */
public class ItemInventoryView {

    public ItemInventoryView() {
    }

    public void displayItemInventoryView() {

//        Game game = new Game();
//        game.setInventory(GameControl.createItems());
        Game game = NeverSync.getCurrentGame();
        game.getInventory();

        InventoryItem[] tools = game.getInventory();
        System.out.println("========================\n"
                + "Current Items Available\n"
                + "========================\n");
        for (InventoryItem ItemType : tools) {

            String one = ItemType.getItemType();

            System.out.println(one);

        }

        Scanner toolToBuy;
        toolToBuy = new Scanner(System.in);

        System.out.println("\n\nEnter the item to purchase from the list above: ");

        String toBuy = toolToBuy.nextLine().toLowerCase();

        if (toBuy.equalsIgnoreCase("Q")) {
            return;
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

                    System.out.println("\nYour Item Choice: " + two);
                    System.out.println("\nThe Purchase Price = : " + price);
                    System.out.println("\nThere are Currently " + inStock + " at "
                            + "the Storehouse");

                    System.out.println("\n\nEnter the quantity for your purchase");

                    Integer quantityToBuy = null;

                    Scanner inFile;

                    inFile = new Scanner(System.in);

                    while (quantityToBuy == null) {
                        String value = inFile.nextLine();
                        value = value.trim().toUpperCase();

                        if (value.equals("Q")) {
                            return;
                        }

                        try {
                            quantityToBuy = Integer.parseInt(value);
                        } catch (NumberFormatException nfe) {

                            System.out.println(nfe + "\n\nYou must enter a numerical value.");
                            return;
                        }

                        double purchase = 0;
                        double remaining = 0;

                        try {
                            purchase = StoreHouseControl.calTotalSale(price, inStock,
                                    quantityToBuy);
                        } catch (StoreHouseException sh) {
                            System.out.println(sh);
                            return;
                        }

                        try {
                            remaining = StoreHouseControl.calQuanRem(inStock, quantityToBuy);
                        } catch (StoreHouseException sh) {
                            System.out.println(sh);
                            return;
                        }

                        System.out.println("\nThe price for your purchase of " + two + " today is "
                                + purchase);

                        System.out.println("\nThere are " + remaining + " " + two + " items in the"
                                + " Storehouse after your purchase.");
                        ItemType.setItemType(one);
                        ItemType.setQuantity((int) quantityToBuy);
                        ItemType.setQuantityInStock((int) remaining);

                        return;
                    }
//                       
                }

            }

//        } else {
//            System.out.println("\nYou must enter an item on the list!!");
//            return;
        }
        System.out.println("\nYou must enter an item on the list!!");
        
    }
}
