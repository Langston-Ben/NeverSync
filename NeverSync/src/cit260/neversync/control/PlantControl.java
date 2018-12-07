/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

import byui.cit260.neversync.exceptions.PlantControlException;
import cit260.neversync.model.Game;
import neversync.NeverSync;

/**
 *
 * @author benjaminlangston
 */
public class PlantControl {

    public static double calcBushelsToPlant(double acresOwned,
            double acresToPlant, double initWheatStorage)
            throws PlantControlException {
            Game game = NeverSync.getCurrentGame();
            if (acresToPlant< 0) {
                throw new PlantControlException("\n\nThe input cannot be negative.\n");
                        
            }
            if (acresOwned > 2000) {
                throw new PlantControlException("\n\nThe acres owned cannot "
                        + "exceed 2000.\n");
            }

            if (acresToPlant < 100) {
                throw new PlantControlException("\n\nThe acres to plant must be greater "
                        + "than 100.\n");
            }
            
            if (acresToPlant > 1000 || acresToPlant > acresOwned) {
                throw new PlantControlException("\n\nThe acres to plant must be less than "
                        + "1000.\n");
            }
            if (acresToPlant > acresOwned) {
                throw new PlantControlException("\n\nThe acres to plant cannot "
                        + "exceed the current acres owned\n");
            }
            

//            if (initWheatStorage * .90 < (.5 * acresToPlant) || initWheatStorage * .90 > 10000) {
//                throw new PlantControlException("\nYou do not have enough wheat to "
//                        + "plant that many acres.\n");
//            }

            if (initWheatStorage < 110 || initWheatStorage > 10000) {
                throw new PlantControlException("\nYour wheat storage is outside the allowable range.\n");
            }

//double bushelsToPlant = acresToPlant * .5;
            
            
//            double currentWheatStorage = initWheatStorage * .90;
            double wheatRemaining = initWheatStorage - (acresToPlant * .5);
             game.setWheatInStorage(wheatRemaining);
            return wheatRemaining;

//        
    }
    
    public static double calcAcresRemaining(double acresOwned,
            double acresToPlant, double initWheatStorage)
            throws PlantControlException {
            Game game = NeverSync.getCurrentGame();
            if (acresToPlant< 0) {
                throw new PlantControlException("\n\nThe input cannot be negative.\n");
                        
            }
            if (acresOwned > 2000) {
                throw new PlantControlException("\n\nThe acres owned cannot "
                        + "exceed 2000.\n");
            }

            if (acresToPlant < 100) {
                throw new PlantControlException("\n\nThe acres to plant must be greater "
                        + "than 100.\n");
            }
            
            if (acresToPlant > 1000 || acresToPlant > acresOwned) {
                throw new PlantControlException("\n\nThe acres to plant must be less than "
                        + "1000.\n");
            }
            if (acresToPlant > acresOwned) {
                throw new PlantControlException("\n\nThe acres to plant cannot "
                        + "exceed the current acres owned\n");
            }
            
//
//            if (initWheatStorage * .90 < (.5 * acresToPlant) || initWheatStorage * .90 > 10000) {
//                throw new PlantControlException("\nYou do not have enough wheat "
//                        + "to plant that many acres.\n");
//            }

            if (initWheatStorage < 110 || initWheatStorage > 10000) {
                throw new PlantControlException("\nYour wheat storage is outside the allowable range.\n");
            }

//double bushelsToPlant = acresToPlant * .5;
            double acresRemaining = (acresOwned - acresToPlant);
            game.setAcresPlanted(acresToPlant);
            
            return acresRemaining;

//        
    }
    
    
    
    
    
    
}



