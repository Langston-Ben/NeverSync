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
public class BuyLandControl {
 
// function to determine land ownership after a purchase
    
public static double calcLandPurchase(double acresOwnedinit, double currentPop, 
double currentWheat, double acresToPurchase, double acresPrice) {

//double acresPrice = 20;    
    
if (acresToPurchase < 0) {
return -1;
}

if (currentWheat < (acresToPurchase * acresPrice)) {
return -1;
}

if (currentPop < (acresOwnedinit + acresToPurchase) / 10) {
return -1;
}

double acresOwnedNew = acresOwnedinit + acresToPurchase;

return acresOwnedNew;
}

// function to determine the wheat remaining after a land purchase

public static double calcWheatRemaining(double acresOwnedinit, double currentPop, 
double currentWheat, double acresToPurchase, double acresPrice) {

//double acresPrice = 20;

if (acresToPurchase < 0) {
return -1;
}

if (currentWheat < (acresToPurchase * acresPrice)) {
return -1;
}

if (currentPop < (acresOwnedinit + acresToPurchase) / 10 ) {
return -1;
}



//double acresOwnedNew = acresOwnedinit + acresToPurchase;

double wheatNew = currentWheat - ( acresPrice * acresToPurchase);

return wheatNew;

    }

//    public BuyLandControl(double acresOwnedint, double currentPop, 
//           double currentWheat, double acresToPurchase, double acresPrice) {
//        
//    }
    
}
