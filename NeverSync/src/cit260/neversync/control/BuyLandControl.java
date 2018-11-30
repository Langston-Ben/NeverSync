/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

import byui.cit260.neversync.exceptions.BuyLandControlException;

/**
 *
 * @author benjaminlangston
 */
public class BuyLandControl {

// function to determine land ownership after a purchase
    public static double calcLandPurchase(double acresOwnedinit, double currentPop,
            double currentWheat, double acresToPurchase, double acresPrice) 
        throws BuyLandControlException {

//acresPrice = 20;    
        if (acresToPurchase < 0) {
            throw new BuyLandControlException("\nThe Value for a Land Purchase must "
                    + "be a Positive Number, Please Try Again.");
        }

        if (currentWheat < (acresToPurchase * acresPrice)) {
            throw new BuyLandControlException("\n\nThere is Not Enough Wheat in "
                    + "Storage for the Land Purchase, Please use a lower "
                    + "value.");
        }

        if (currentPop < (acresOwnedinit + acresToPurchase) / 10) {
            throw new BuyLandControlException("Not Enough People to till the Land, "
                    + "Please Select a Lower Number");
        }

        double acresOwnedNew = acresOwnedinit + acresToPurchase;

        return acresOwnedNew;
    }

// function to determine the wheat remaining after a land purchase
    public static double calcWheatRemaining(double acresOwnedinit, double currentPop,
            double currentWheat, double acresToPurchase, double acresPrice) 
            throws BuyLandControlException {
//acresPrice = 20;
        if (acresToPurchase < 0) {
            throw new BuyLandControlException("The Value for a Land Purchase Must be a "
                            + "Positive Number, Please Try Again.");
        }

        if (currentWheat < (acresToPurchase * acresPrice)) {
            throw new BuyLandControlException("There is Not Enough Wheat in Storage for"
                            + " the Land Purchase, Please use a lower value.");
        }

        if (currentPop < (acresOwnedinit + acresToPurchase) / 10) {
            throw new BuyLandControlException("Not Enough People to till the Land, Please "
                            + "Select a Lower Number");
        }

//double acresOwnedNew = acresOwnedinit + acresToPurchase;
        double wheatNew = currentWheat - (acresPrice * acresToPurchase);
//        int x = 10/0;
        return wheatNew;

    }

//    public BuyLandControl(double acresOwnedint, double currentPop, 
//           double currentWheat, double acresToPurchase, double acresPrice) {
//        
//    }
}
