/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

/**
 *
 * @author jeffledbetter
 */
public class HarvestCropsControl {

    public static double calcCropYield(double acresOwned, double acresToPlant, double percentTithed) {

        int blessingFactor;
        double bushelsHarvested;

        if (acresOwned < 100 || acresOwned > 2000) {
            return -1;
        }

        if (acresToPlant < 100 || acresToPlant > 1000 || acresToPlant > (acresOwned * .5)) {
            return -1;
        }

        if (percentTithed < 0 || percentTithed > 100) {
            return -1;
        }

        if (percentTithed >= 10) {
            blessingFactor = 5;
        } else if (percentTithed >= 6) {
            blessingFactor = 4;
        } else if (percentTithed >= 0) {
            blessingFactor = 3;
        } else {
            return -1;
        }

        bushelsHarvested = acresToPlant * blessingFactor;
        return bushelsHarvested;

    }

}
