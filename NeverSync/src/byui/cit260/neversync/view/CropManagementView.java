/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import cit260.neversync.control.BuyLandControl;
import java.util.Scanner;

/**
 *
 * @author benjaminlangston
 */
public class CropManagementView {
    public void displayCropManagementView() {
  
        boolean endOfView = false;
    do { 
        String[] input = CropManagementView.getInput();
        //input[0] = input[0].toUpperCase();
        if (input[0] == null || input.length < 1 || input[0].equals("Q")) {
            
        return;
        }
        else {
        endOfView = doAction(input); 
        }
} while (endOfView != true);
 
    }
       private static String [] getInput() {
        
        String[] input = new String[1];
        System.out.println("\n**********************************\n"  
        + "City Of Aaron Crop Management Menu\n"
        + "**********************************\n");
        System.out.println(
            "\nThe options on the main menu are: \n" +
            "B - Buy Land\n" +
            "S - Sell Land\n" +
            "F - Feed the People\n" +
            "P - Plant the Crops\n" +
            "T - Pay Tithes and Offerings\n" +
            "Q - Q the help menu\n");
        
                
        boolean valid = false;
        
        while (valid == false) {
        Scanner inFile;
        inFile = new Scanner(System.in);   
        System.out.println("\nPlease Enter Your Selection\n");
        
        input[0] = inFile.nextLine();
        
        String helpMenuSelection = input[0].trim();
        
        
        if (helpMenuSelection.length() < 1) {
            System.out.println("\nYou must specify a value\n");
            continue;
        }
            input[0] = helpMenuSelection;
            valid = true;          
        }          
            return input;
           
    }    
        
        private boolean doAction(String[] input) {
            
            input[0] = input[0].toUpperCase();
            String helpItem = input[0];
            
            
            switch (helpItem) {
		case "B" : buyLand();
                    break;
                case "S" : sellLand();
                    break;
                case "F" : feedPeople();
                    break;
                case "P" : plantCrops();
                    break;
		case "T" : payTithes();
                    break;
                case "Q" : return true;
                
                default: System.out.println("\nInvalid Menu Item\n");
              
            }
            
         return false;           
        }

    private void buyLand() {
        
        
        System.out.println("\nEnter the number of acres owned:\n");
 		
                double currentPop = 20000;
                double acresPrice = 20;
 		// create an input file for the console
 		Scanner inFile;
 		inFile = new Scanner(System.in);
 		
 		// this line will read the value of the next line typed in the console
 		double acresOwnedint = inFile.nextDouble();
 		
 		// prompt to enter the dollar amount of the loan
 		System.out.println("\nEnter The Current Wheat in Storage ");
 		
 		// get the value for the loan amount
 		double currentWheat = inFile.nextDouble();
 		
 		// prompt to enter the number of years for the loan
 		System.out.println("\nEnter The Number of Acres to Purchase: ");
 		
 		// get the value for the number of years of the loan
 		double acresToPurchase = inFile.nextDouble();
 		BuyLandControl buyLandControl = new BuyLandControl();
                double land = BuyLandControl.calcLandPurchase(acresOwnedint, 
                currentPop, currentWheat, acresToPurchase, acresPrice);
                
                double wheat = BuyLandControl.calcWheatRemaining(acresOwnedint, 
                currentPop, currentWheat, acresToPurchase, acresPrice);
                
//                calcLandPurchase(double acresOwnedinit, double currentPop, 
//double currentWeat, double acresToPurchase, double acresPrice);
// 		// prompt to enter the periods per year
// 		System.out.println("\nPeriods per years: ");
// 		
// 		// get the value of the periods per year entered
// 		double periodsPerYear = inFile.nextDouble();
 		
// 		// prompt to enter the yearly interest rate
// 		System.out.println("\nEnter the Interest Rate for this loan as a decimal:");
// 		
// 		// get the value of the interest rate
// 		double interestRate = inFile.nextDouble();
// 		
// 		
// 		// perform the first calculation
// 		double eqOne = 1 + (interestRate / periodsPerYear);
// 		
// 		// perform the second calculation
// 		double eqTwo = numberOfYears * -periodsPerYear;
// 		
// 		// perform the third calculation
// 		double eqThree = 1 - Math.pow(eqOne,eqTwo);
// 		
// 		// perform the fourth calculation
// 		double payment = loanAmount * (interestRate / periodsPerYear) / eqThree;
// 		
// 		// round the payment amount to two decimals
// 		double monthlyPayment = Math.round(payment * 100.0) /100.0;
// 		
// 		// display the results of the calculated input
// 		
 		System.out.println("\n------------------------------------------------------" +
 		"--------------");
 		
 			System.out.println("The new amount of land is " +land 
                        + " after the recent purchase"); 
                
 							  
 		System.out.println("-------------------------------------------------------" +
 		"-------------\n");	
                
                System.out.println("\n------------------------------------------------------" +
 		"--------------");
 		
 			System.out.println("The wheat remain is " + wheat 
                        + " bushels after the recent purchase"); 
                
 							  
 		System.out.println("-------------------------------------------------------" +
 		"-------------\n");

 		}
        
        
        
        
        
        
        
        
       
    

    private void sellLand() {
        System.out.println("Placeholder for sellLand");
    }

    private void feedPeople() {
      System.out.println("Placeholder for feedPeople");
    }

    private void plantCrops() {
        System.out.println("Placeholder for plantCrops");
    }

    private void payTithes() {
        System.out.println("Placeholder for payTithes");
    }
    
    
}
