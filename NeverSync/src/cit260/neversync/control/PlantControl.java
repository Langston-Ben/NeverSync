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
public class PlantControl {
    
public static double calcBushelsToPlant(double acresOwned, double acresToPlant, double initWheatStorage) {
    
double currentWheatStorage = initWheatStorage * .90;
    
if (acresOwned < 500 || acresOwned > 2000) {
    return  -1;
}

if (acresToPlant < 100 || acresToPlant > 1000 || acresToPlant > acresOwned) {
    return  -1;
}

if (currentWheatStorage < (.5 * acresToPlant) || currentWheatStorage > 550) {
    return  -1;
}

if (initWheatStorage < 110 || initWheatStorage > 600) {
    return -1;
}


//double bushelsToPlant = acresToPlant * .5;
double wheatRemaining = currentWheatStorage - (acresToPlant * .5);

return wheatRemaining;


        }    
   
}
