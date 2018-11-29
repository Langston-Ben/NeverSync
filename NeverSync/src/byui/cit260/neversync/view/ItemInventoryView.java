/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;


import cit260.neversync.control.GameControl;
import cit260.neversync.control.StoreHouseControl;
import cit260.neversync.model.Game;
import cit260.neversync.model.InventoryItem;
import java.util.Scanner;


/**
 *
 * @author ben langston
 */
public class ItemInventoryView {

    public ItemInventoryView() {
    }

    public void displayItemInventoryView() {

        Game game = new Game();
        game.setInventory(GameControl.createItems());
        
        
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

        // need validation statements.
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
                    Scanner quantityToBuy;
                   
                    quantityToBuy = new Scanner(System.in);
                    
                     
                    boolean cNumber;

                    do {

                        if (quantityToBuy.hasNextDouble()) {

                            cNumber = true;
                            double quanToBuy = quantityToBuy.nextDouble();
                            double purchase = StoreHouseControl.calTotalSale(price, inStock, quanToBuy);
                            double remaining = StoreHouseControl.calQuanRem(inStock, quanToBuy);
                            

                            if (purchase == -1 || remaining == -1) {
                                System.out.println("The Storehouse does not have enough inventory"
                                        + " for your purchase.\n"
                                        + "Please enter a lower number.");
                                break;
                            } else {

                                System.out.println("\nThe price for your purchase of " + two + " today is "
                                        + purchase);

                                System.out.println("\nThere are " + remaining + " " + two + " items in the"
                                        + " Storehouse after your purchase.");
                                ItemType.setItemType(one);
                                ItemType.setQuantity((int) quanToBuy);
                                ItemType.setQuantityInStock((int) remaining);

                                return;
                            }
                        } else {
                            System.out.println("You must enter a numerical value.");
                            cNumber = false;
                            quantityToBuy.next();
                        }

                    } while (!(cNumber));

                }

            }

        } else {
            System.out.println("Invalid Input");
        }
        System.out.println("Invalid Input");

    }
}
