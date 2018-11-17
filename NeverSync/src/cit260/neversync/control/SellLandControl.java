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
public class SellLandControl {
    
    

// function to determine land ownership after a purchase
    public static double calcLandSold(double acresOwnedinit,
            double currentWheat, double acresToSell, double acresPrice) {

//acresPrice = 20;    
        if (acresToSell < 0) {
            return -1;
        }

        if (acresToSell > acresOwnedinit) {
            return -2;
        }

        double acresOwnedNew = acresOwnedinit - acresToSell;

        return acresOwnedNew;
    }
    
    public static double calcWheatRemaining(double acresOwnedinit,
            double currentWheat, double acresToSell, double acresPrice) {
//acresPrice = 20;
        if (acresToSell < 0) {
            return -1;
        }

        if (acresToSell > acresOwnedinit) {
            return -2;
        }

       

//double acresOwnedNew = acresOwnedinit + acresToPurchase;
        double wheatNew = currentWheat + (acresPrice * acresToSell);

        return wheatNew;

    }
}
