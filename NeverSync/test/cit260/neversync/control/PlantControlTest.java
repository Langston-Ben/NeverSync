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
public class PlantControlTest {
    
    public PlantControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcBushelsToPlant method, of class PlantControl.
     */
    @Test
    public void testCalcBushelsToPlant() {
        System.out.println("  calcBushelsToPlant");
        System.out.println("\tTest Case #1");
        double acresOwned = 500;
        double acresToPlant = 400;
        double initWheatStorage = 300;
        double expResult = 70.0;
        double result = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
   
    
//    static {
        System.out.println("\tTest Case #2");
        acresOwned = 500;
        acresToPlant = 0;
        initWheatStorage = 300;
        expResult = -2;
        result = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    
    
//    static {
        System.out.println("\tTest Case #3");
        acresOwned = 500;
        acresToPlant = 1004;
        initWheatStorage = 5;
        expResult = -2;
        result = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//    static {
        System.out.println("\tTest Case #4");
        acresOwned = 500;
        acresToPlant = 300;
        initWheatStorage = 0;
        expResult = -3;
        result = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
   

        System.out.println("\tTest Case #5");
        acresOwned = 1000;
        acresToPlant = 100;
        initWheatStorage = 110;
        expResult = 49;
        result = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//    static {
        System.out.println("\tTest Case #6");
        acresOwned = 2000;
        acresToPlant = 1000;
        initWheatStorage = 560;
        expResult = 4;
        result = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//    static {
        System.out.println("\tTest Case #7");
        acresOwned = 2000;
        acresToPlant = 1000;
        initWheatStorage = 600;
        expResult = 40;
        result = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");

    }
    
}
