/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

import byui.cit260.neversync.exceptions.StoreHouseException;

/**
 *
 * @author benjaminlangston
 */
public class StoreHouseControl {

    public static double calTotalSale(double price, double inStock, double quanToBuy)
    throws StoreHouseException {

        if (quanToBuy > inStock) {
            throw new StoreHouseException("\n\nThe Storehouse does not have enough inventory"
                                        + " for your purchase.\n"
                                        + "Please enter a lower number.");
           
        }
        
        if (quanToBuy < 0) {
            throw new StoreHouseException("\n\nYour entry cannot be negative\n"
                                        + "Please enter a positive number.");
           
        }

        double total = price * quanToBuy;
        total = Math.round(total * 100.0) / 100.0;
        return total;

    }

    public static double calQuanRem(double inStock, double quanToBuy) 
    throws StoreHouseException {

        if (quanToBuy > inStock) {
           throw new StoreHouseException("\n\nThe Storehouse does not have enough inventory"
                                        + " for your purchase.\n"
                                        + "Please enter a lower number.");
        }
        
         if (quanToBuy < 0) {
            throw new StoreHouseException("\n\nYour entry cannot be negative\n"
                                        + "Please enter a positive number.");
         }
        
        double remaining = inStock - quanToBuy;
        remaining = Math.round(remaining * 100.0) / 100.0;
        return remaining;
    }

}
