/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import cit260.neversync.control.GameControl;
import cit260.neversync.model.Game;
import cit260.neversync.model.InventoryItem;
import cit260.neversync.model.ItemType;
import cit260.neversync.model.Location;
import cit260.neversync.model.Map;
import java.util.ArrayList;
import java.util.Scanner;
import neversync.NeverSync;

/**
 *
 * @author benjaminlangston
 */
public class ItemInventoryView {

    public ItemInventoryView() {
    }
    
   

    public void displayItemInventoryView() {
        
            System.out.println("===================\n"
                    + "Current Items Available\n"
                    + "==================\n");
            ItemType[] items = ItemType.values();
            for (ItemType item : items) {
            System.out.println(item.ordinal() + ": " + item);
            }
            
            Scanner inFile;
        inFile = new Scanner(System.in);

            System.out.println("\n\nEnter the item number for purchase");
            
            int toBuy = inFile.nextInt();
            
            ItemInventoryView.purchaseItems(toBuy);
            
    }



public static void purchaseItems(int i) {


            System.out.println("showToolsList Method Called");
            Game game = new Game();
            game.setInventory(GameControl.createItems());
            InventoryItem[] tools = game.getInventory();
            InventoryItem newItem = new InventoryItem();
            
            
            newItem = tools[ItemType.lumber.ordinal()];
            
            double need = newItem.getRequiredAmount();
            double price = newItem.getPricePerUnit();
            String item = newItem.getItemType();
            double quanity = 0;
            double stock = newItem.getQuantityInStock();
            
            
            
          
            
//            for (InventoryItem inventory : tools) {
                System.out.println("The price for " + item + " is " + price);
                System.out.println("There are currently " + stock + " in stock");
            }
    }
//    }
//     
        
//    }
    
    
    

    
    
    
    
    
    
    
    

