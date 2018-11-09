/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author benjaminlangston
 */
public class BuyLandControlTest {
    
    public BuyLandControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcLandPurchase method, of class BuyLandControl.
     */
    @Test
    public void testCalcLandPurchase() {
        System.out.println("\n" + "    calcLandPurchase");
        System.out.println("\tTest Case #1");
        double acresOwnedinit = 500;
        double currentPop = 60;
        double currentWheat = 4000;
        double acresToPurchase = 100;
        double acresPrice = 20;
        double expResult = 600;
        double result = BuyLandControl.calcLandPurchase(acresOwnedinit, 
        currentPop, currentWheat, acresToPurchase, acresPrice);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest Case #2");
        acresOwnedinit = 500;
        currentPop = -1;
        currentWheat = 4000;
        acresToPurchase = 100;
        acresPrice = 20;
        expResult = -3;
        result = BuyLandControl.calcLandPurchase(acresOwnedinit, currentPop, 
        currentWheat, acresToPurchase, acresPrice);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest Case #3");
        acresOwnedinit = 500;
        currentPop = 60;
        currentWheat = 20;
        acresToPurchase = 100;
        acresPrice = 20;
        expResult = -2;
        result = BuyLandControl.calcLandPurchase(acresOwnedinit, currentPop, 
        currentWheat, acresToPurchase, acresPrice);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest Case #4");
        acresOwnedinit = 500;
        currentPop = 6;
        currentWheat = 4000;
        acresToPurchase = 100;
        acresPrice = 20;
        expResult = -3;
        result = BuyLandControl.calcLandPurchase(acresOwnedinit, currentPop, 
        currentWheat, acresToPurchase, acresPrice);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest Case #5");
        acresOwnedinit = 2000;
        currentPop = 210;
        currentWheat = 2000;
        acresToPurchase = 100;
        acresPrice = 20;
        expResult = 2100;
        result = BuyLandControl.calcLandPurchase(acresOwnedinit, currentPop, 
        currentWheat, acresToPurchase, acresPrice);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest Case #6");
        acresOwnedinit = 2000;
        currentPop = 220;
        currentWheat = 4000;
        acresToPurchase = 200;
        acresPrice = 20;
        expResult = 2200;
        result = BuyLandControl.calcLandPurchase(acresOwnedinit, currentPop, 
        currentWheat, acresToPurchase, acresPrice);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest Case #7");
        acresOwnedinit = 2000;
        currentPop = 250;
        currentWheat = 10000;
        acresToPurchase = 500;
        acresPrice = 20;
        expResult = 2500;
        result = BuyLandControl.calcLandPurchase(acresOwnedinit, currentPop, 
        currentWheat, acresToPurchase, acresPrice);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of calcWheatRemaining method, of class BuyLandControl.
     */
    @Test
    public void testCalcWheatRemaining() {
        System.out.println("  calcWheatRemaining");
        System.out.println("\tTest Case #1");
        double acresOwnedinit = 500;
        double currentPop = 60;
        double currentWheat = 4000;
        double acresToPurchase = 100;
        double acresPrice = 20;
        double expResult = 2000;
        double result = BuyLandControl.calcWheatRemaining(acresOwnedinit, 
        currentPop, currentWheat, acresToPurchase, acresPrice);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest Case #2");
        acresOwnedinit = 500;
        currentPop = 60;
        currentWheat = 4000;
        acresToPurchase = -1;
        acresPrice = 20;
        expResult = -1;
        result = BuyLandControl.calcWheatRemaining(acresOwnedinit, 
        currentPop, currentWheat, acresToPurchase, acresPrice);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest Case #3");
        acresOwnedinit = 500;
        currentPop = 60;
        currentWheat = 20;
        acresToPurchase = 100;
        acresPrice = 20;
        expResult = -2;
        result = BuyLandControl.calcWheatRemaining(acresOwnedinit, 
        currentPop, currentWheat, acresToPurchase, acresPrice);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest Case #4");
        acresOwnedinit = 500;
        currentPop = 6;
        currentWheat = 4000;
        acresToPurchase = 100;
        acresPrice = 20;
        expResult = -3;
        result = BuyLandControl.calcWheatRemaining(acresOwnedinit, 
        currentPop, currentWheat, acresToPurchase, acresPrice);
        assertEquals(expResult, result, 0.0);
        
        
        System.out.println("\tTest Case #5");
        acresOwnedinit = 2000;
        currentPop = 210;
        currentWheat = 2000;
        acresToPurchase = 100;
        acresPrice = 20;
        expResult = 0;
        result = BuyLandControl.calcWheatRemaining(acresOwnedinit, 
        currentPop, currentWheat, acresToPurchase, acresPrice);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest Case #6");
        acresOwnedinit = 2000;
        currentPop = 220;
        currentWheat = 4000;
        acresToPurchase = 200;
        acresPrice = 20;
        expResult = 0;
        result = BuyLandControl.calcWheatRemaining(acresOwnedinit, 
        currentPop, currentWheat, acresToPurchase, acresPrice);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest Case #7");
        acresOwnedinit = 2000;
        currentPop = 250;
        currentWheat = 10000;
        acresToPurchase = 500;
        acresPrice = 20;
        expResult = 0;
        result = BuyLandControl.calcWheatRemaining(acresOwnedinit, 
        currentPop, currentWheat, acresToPurchase, acresPrice);
        assertEquals(expResult, result, 0.0);


        

    }
    
}
