/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

import byui.cit260.neversync.exceptions.CropControlException;
import cit260.neversync.model.Game;
import java.util.Random;
import neversync.NeverSync;

/**
 *
 * @author benjaminlangston
 */
public class CropControl {
    
    public static double calcBushelsToFeedThePeople(double wheatToFeed, double initWheatStorage) 
        throws CropControlException {
        Game game = NeverSync.getCurrentGame();

        if (wheatToFeed < 0) {
            throw new CropControlException("\nThe Value must "
                    + "be a Positive Number, Please Try Again.");
        }

        if (initWheatStorage < wheatToFeed ) {
            throw new CropControlException("\n\nThere is Not Enough Wheat in "
                    + "Storage To Feed The People, Please use a lower "
                    + "value.");
        }

        double wheatNew = initWheatStorage - wheatToFeed;
        game.setWheatInStorage(wheatNew);
        game.setWheatFedToPeople(wheatToFeed);
        return wheatNew;
    }
    
    public static double calcCropYield(double percentTithed) 
        throws CropControlException {
        Game game = NeverSync.getCurrentGame();
        int blessingFactor;
        double bushelsHarvested;
        
        Random rand = new Random();
        int blessingOne = rand.nextInt((3 - 1) + 1) + 1;
        int blessingTwo = rand.nextInt((4 - 2) + 1) + 2;
        int blessingThree = rand.nextInt((5 - 2) + 1) + 2;
        
        
        

        if (percentTithed < 0) {
            throw new CropControlException("\nThe Value must "
                    + "be a Positive Number, Please Try Again.");
        }

        if (percentTithed > 100) {
            throw new CropControlException("\nThe Value Entered Cannot Be Greater"
                    + "Than 100\n");
        }

        

        if (percentTithed < 8) {
            blessingFactor = blessingOne;
        } else if (percentTithed >= 8 || percentTithed <= 12 ) {
            blessingFactor = blessingTwo;
        } else if (percentTithed > 12) {
            blessingFactor = blessingThree;
        } else {
            return -1;
        }
// fix the logic here
        double acresPlanted = game.getAcresPlanted();
        bushelsHarvested = acresPlanted * blessingFactor;
        
        
        double bushelsTithed = bushelsHarvested * .1;
        game.setBushelsInTithes(bushelsTithed);
        game.setBushelsPerAcreHarvested(blessingFactor);
        game.setBushelsHarvested(bushelsHarvested);
        double updatedWheat = game.getWheatInStorage();
        
        updatedWheat = updatedWheat + (bushelsHarvested - bushelsTithed);
        game.setWheatInStorage(updatedWheat);
        return bushelsHarvested;

    }

    
    
    
    
    
    
    
    
}
