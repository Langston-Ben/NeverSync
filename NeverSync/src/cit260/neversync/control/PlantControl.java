/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

import byui.cit260.neversync.exceptions.PlantControlException;

/**
 *
 * @author benjaminlangston
 */
public class PlantControl {

    public static double calcBushelsToPlant(double acresOwned,
            double acresToPlant, double initWheatStorage)
            throws PlantControlException {
//       
            if (acresToPlant< 0) {
                throw new PlantControlException("\n\nThe input cannot be negative.");
                        
            }
            if (acresOwned > 2000) {
                throw new PlantControlException("\n\nThe acres owned cannot "
                        + "exceed 2000.");
            }

            if (acresToPlant < 100) {
                throw new PlantControlException("\n\nThe acres to plant must be greater "
                        + "than 100.");
            }
            
            if (acresToPlant > 1000 || acresToPlant > acresOwned) {
                throw new PlantControlException("\n\nThe acres to plant must be less than "
                        + "1000.");
            }
            if (acresToPlant > acresOwned) {
                throw new PlantControlException("\n\nThe acres to plant cannot "
                        + "exceed the current acres owned");
            }
            

            if (initWheatStorage * .90 < (.5 * acresToPlant) || initWheatStorage * .90 > 10000) {
                throw new PlantControlException("\nYou do not have enough wheat to plant that many acres.\"");
            }

            if (initWheatStorage < 110 || initWheatStorage > 10000) {
                throw new PlantControlException("\nYour wheat storage is outside the allowable range.");
            }

//double bushelsToPlant = acresToPlant * .5;
            double currentWheatStorage = initWheatStorage * .90;
            double wheatRemaining = currentWheatStorage - (acresToPlant * .5);

            return wheatRemaining;

//        
    }
}



