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
 * @author jeffledbetter
 */
public class HarvestCropsControlTest {
	
	public HarvestCropsControlTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of calcCropYield method, of class HarvestCropsControl.
	 */
	@Test
	public void testCalcCropYield() {
		System.out.println("calcCropYield");
		System.out.println("\tTest Case #1");
		double acresOwned = 1000.0;
		double acresToPlant = 500.0;
		double percentTithed = 10.0;
		double expResult = 2500.0;
		double result = HarvestCropsControl.calcCropYield(acresOwned, acresToPlant, percentTithed);
		assertEquals(expResult, result, 0.0001);
		// TODO review the generated test code and remove the default call to fail.
	//	fail("The test case is a prototype.");
		
	
		System.out.println("\tTest Case #2");
		acresOwned = 500.0;
		acresToPlant = 0.0;
		percentTithed = 9.0;
		expResult = -1.0;
		result = HarvestCropsControl.calcCropYield(acresOwned, acresToPlant, percentTithed);
		assertEquals(expResult, result, 0.0001);
	
		
		
		System.out.println("\tTest Case #3");
		acresOwned = 500.0;
		acresToPlant = 1004.0;
		percentTithed = 5.0;
		expResult = -1.0;
		result = HarvestCropsControl.calcCropYield(acresOwned, acresToPlant, percentTithed);
		assertEquals(expResult, result, 0.0001);
		
		
		System.out.println("\tTest Case #4");
		acresOwned = 500.0;
		acresToPlant = 300.0;
		percentTithed = -1.0;
		expResult = -1.0;
		result = HarvestCropsControl.calcCropYield(acresOwned, acresToPlant, percentTithed);
		assertEquals(expResult, result, 0.0001);
		
		
		System.out.println("\tTest Case #5");
		acresOwned = 200.0;
		acresToPlant = 100.0;
		percentTithed = 0.0;
		expResult = 300.0;
		result = HarvestCropsControl.calcCropYield(acresOwned, acresToPlant, percentTithed);
		assertEquals(expResult, result, 0.0001);
		
		
		System.out.println("\tTest Case #6");
		acresOwned = 2000.0;
		acresToPlant = 1000.0;
		percentTithed = 1.0;
		expResult = 3000.0;
		result = HarvestCropsControl.calcCropYield(acresOwned, acresToPlant, percentTithed);
		assertEquals(expResult, result, 0.0001);
		
		
		System.out.println("\tTest Case #7");
		acresOwned = 2000.0;
		acresToPlant = 500.0;
		percentTithed = 100.0;
		expResult = 2500.0;
		result = HarvestCropsControl.calcCropYield(acresOwned, acresToPlant, percentTithed);
		assertEquals(expResult, result, 0.0001);
	
	}
	
}
