/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

import byui.cit260.neversync.exceptions.SellLandControlException;

/**
 *
 * @author benjaminlangston
 */
public class SellLandControl {
    
    

// function to determine land ownership after a purchase
    public static double calcLandSold(double acresOwnedinit,
            double currentWheat, double acresToSell, double acresPrice) 
            throws SellLandControlException {

//acresPrice = 20;    
        if (acresToSell < 0) {
            throw new SellLandControlException("\n\nThe Value for a Land Purchase Must be a "
                            + "Positive Number, Please Try Again");
        
        
        }

        if (acresToSell > acresOwnedinit) {
            throw new SellLandControlException("\n\nLand sold cannot be more than"
                            + " land owned. Please use a lower value.");
        }

        double acresOwnedNew = acresOwnedinit - acresToSell;

        return acresOwnedNew;
    }
    
    public static double calcWheatRemaining(double acresOwnedinit,
            double currentWheat, double acresToSell, double acresPrice)
            throws SellLandControlException {
//acresPrice = 20;
        if (acresToSell < 0) {
            throw new SellLandControlException("\n\nThe Value for a Land Purchase Must be a "
                            + "Positive Number, Please Try Again.");
        }

        if (acresToSell > acresOwnedinit) {
            throw new SellLandControlException("\n\nLand sold cannot be more than"
                            + " land owned. Please use a lower value.");
        }

       

//double acresOwnedNew = acresOwnedinit + acresToPurchase;
        double wheatNew = currentWheat + (acresPrice * acresToSell);

        return wheatNew;

    }
}
