/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

/**
 *
 * @author benjaminlangston
 */
public class StoreHouseControl {

    public static double calTotalSale(double price, double inStock, double quanToBuy) {

        if (quanToBuy > inStock) {
            return -1;
        }

        double total = price * quanToBuy;
        total = Math.round(total * 100.0) / 100.0;
        return total;

    }

    public static double calQuanRem(double inStock, double quanToBuy) {

        if (quanToBuy > inStock) {
            return -1;
        }
        double remaining = inStock - quanToBuy;
        remaining = Math.round(remaining * 100.0) / 100.0;
        return remaining;
    }

}
