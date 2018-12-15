/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

import byui.cit260.neversync.exceptions.CropControlException;
import byui.cit260.neversync.exceptions.PlantControlException;
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
        String loc = NeverSync.getCurrentGame().getMap().getCurrentLocation().getDisplaySymbol();
        
        if (!"SQ".equals(loc)) {
                throw new CropControlException("\n\nYou must be at the city square"
                        + " to feed the people!!\n"
                        + "Use the Map the Change locations.");
            }

        if (wheatToFeed < 0) {
            throw new CropControlException("\nThe Value must "
                    + "be a Positive Number, Please Try Again.");
        }

        if (initWheatStorage < wheatToFeed) {
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
         String loc = NeverSync.getCurrentGame().getMap().getCurrentLocation().getDisplaySymbol();
        
        if (!"CH".equals(loc)) {
                throw new CropControlException("\n\nYou must be at the Church to "
                        + "pay tithing...!!\n"
                        + "You may want to visit the Temple first....\n"
                        + "Use the Map the Change locations.");
            }
        
        
        double blessingFactor = 0;
        double eatenFactor = 0;
        double bushelsHarvested;

        Random rand = new Random();
        double blessingOne = rand.nextInt((3 - 1) + 1) + 1;
        double blessingTwo = rand.nextInt((4 - 2) + 1) + 2;
        double blessingThree = rand.nextInt((5 - 2) + 1) + 2;

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
        } else if (percentTithed >= 8 && percentTithed <= 12) {
            blessingFactor = blessingTwo;
        } else if (percentTithed > 12) {
            blessingFactor = blessingThree;
        }

        // calc wheat eaten by rats
        int tithingOne = rand.nextInt((10 - 6) + 1) + 6;        
        int tithingTwo = rand.nextInt((7 - 3) + 1) + 3;
        int tithingThree = rand.nextInt((5 - 3) + 1) + 3;

        if (percentTithed < 8) {
            eatenFactor = tithingOne;
        } else if (percentTithed >= 8 && percentTithed <= 12) {
            eatenFactor = tithingTwo;
        } else if (percentTithed > 12) {
            eatenFactor = tithingThree;
        }

        // grow the population
        int popGrowth = rand.nextInt((20 - 1) + 1) + 1;
        
        double curPop = game.getCurrentPopulation();

        popGrowth = (int) ((curPop * popGrowth) / 100);
        double newPop = (curPop + popGrowth);

        game.setNewPopulation((int) popGrowth);

        game.setCurrentPopulation((int)newPop);

        eatenFactor = (eatenFactor / 100);

        eatenFactor = Math.round(eatenFactor * 100.0) / 100.0;
        // save the amount eaten to the game
//        game.setWheatEatenByRats(eatenFactor);

        // get the acres planted for harvesting
        double acresPlanted = game.getAcresPlanted();
        bushelsHarvested = (int) (acresPlanted * blessingFactor);

        // calc amount of wheat to pay tithings
        double bushelsTithed = bushelsHarvested * (percentTithed * .01);

        // save wheat tithed to the game
        game.setBushelsInTithes((int)bushelsTithed);

        // save the bushels per acres value for annual report
        game.setBushelsPerAcreHarvested((int)blessingFactor);

        // set the amount of bushels harvested
        game.setBushelsHarvested((int)bushelsHarvested);

        // get the current wheat in storage value
        int updatedWheat = (int) game.getWheatInStorage();

        // calc new wheat after harvesting and tithing
        updatedWheat = (int) (updatedWheat + (bushelsHarvested - bushelsTithed));

        // set the wheat value in the game after subtracting rat factor
        double stWt = (updatedWheat - (updatedWheat * eatenFactor));

        stWt = Math.round(stWt * 100.0) / 100.0;

        game.setWheatInStorage((int)stWt);

        // save the amount eaten to the game
        double wBRt = (updatedWheat * eatenFactor);

        wBRt = Math.round(wBRt * 100.0) / 100.0;
        game.setWheatEatenByRats((int)wBRt);

        return bushelsHarvested;

    }

    
    
    
    
    public static double calcMortality(double bushFed, double pop) throws CropControlException {
        Game game = NeverSync.getCurrentGame();
        double passed = 0;

        // need exception here and work on the logic
        if (bushFed < 1) {
            throw new CropControlException(
                    "You didn't feed anyone and have killed all your people!!\n\n\n" +
" ██████╗  █████╗ ███╗   ███╗███████╗                   \n" +
"██╔════╝ ██╔══██╗████╗ ████║██╔════╝                   \n" +
"██║  ███╗███████║██╔████╔██║█████╗                     \n" +
"██║   ██║██╔══██║██║╚██╔╝██║██╔══╝                     \n" +
"╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗                   \n" +
" ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝                   \n" +
"                                                       \n" +
" ██████╗ ██╗   ██╗███████╗██████╗ ██╗██╗██╗██╗██╗██╗██╗\n" +
"██╔═══██╗██║   ██║██╔════╝██╔══██╗██║██║██║██║██║██║██║\n" +
"██║   ██║██║   ██║█████╗  ██████╔╝██║██║██║██║██║██║██║\n" +
"██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝\n" +
"╚██████╔╝ ╚████╔╝ ███████╗██║  ██║██╗██╗██╗██╗██╗██╗██╗\n" +
" ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝\n" +
"                                                       ");
        }
//      
//        boolean mort = false;
//        
//        while (mort == false) {
        
        double peopleFed = (bushFed / 20);
     
//        if (peopleFed < (pop * .5)) {
//            throw new CropControlException("Half your population has died!\n"
//                    + "GAME OVER\nGAME OVER\nGAME OVER\nGAME OVER\nGAME OVER\n");
//            
//        }
            int killed = game.getPopulationKilled();
            
            passed = ((peopleFed - pop) * -1);
            
            if (passed < 0) {
            passed = 0;
            }
            
            
            double newPop = (pop - passed - killed);
            
//        if (newPop < (pop * .5)) { 
            
            game.setStarved((int) passed);
            game.setCurrentPopulation((int) newPop);

            int year = game.getYear();

            year = year + 1;

            game.setYear(year);
            
            if (year == 4 ){
//                 mort = true;
            return year;
            }
            if (peopleFed < (50)) {
            throw new CropControlException("Half your population has died!\n" +
                    
" ██████╗  █████╗ ███╗   ███╗███████╗                   \n" +
"██╔════╝ ██╔══██╗████╗ ████║██╔════╝                   \n" +
"██║  ███╗███████║██╔████╔██║█████╗                     \n" +
"██║   ██║██╔══██║██║╚██╔╝██║██╔══╝                     \n" +
"╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗                   \n" +
" ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝                   \n" +
"                                                       \n" +
" ██████╗ ██╗   ██╗███████╗██████╗ ██╗██╗██╗██╗██╗██╗██╗\n" +
"██╔═══██╗██║   ██║██╔════╝██╔══██╗██║██║██║██║██║██║██║\n" +
"██║   ██║██║   ██║█████╗  ██████╔╝██║██║██║██║██║██║██║\n" +
"██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝\n" +
"╚██████╔╝ ╚████╔╝ ███████╗██║  ██║██╗██╗██╗██╗██╗██╗██╗\n" +
" ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝\n" +
"                                                       \n");
        }
             return 5;
    }
            
}
//
//            if (newPop < (pop * .5)) {
//                
//            game.setStarved((int) passed);
//
//            game.setCurrentPopulation((int) newPop);

//            year = game.getYear();
//
//            year = year + 1;
//
//            game.setYear(year);
//            
//            if (year == 10 ){
//            break;
//            }
            
//           
//
//                throw new CropControlException("Half the population has died.\n"
//                        + "Game Over");
//               
                
//            } break;
            
////            return passed;
//            }
//            
//           
//            
//         
//        
//
////            mort = true;
//
//        }
////        return 1;
////    }
//    
//
//}
