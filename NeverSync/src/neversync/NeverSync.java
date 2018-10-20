/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neversync;

import cit260.neversync.model.Condition;
import cit260.neversync.model.Game;
import cit260.neversync.model.InventoryItem;
import cit260.neversync.model.ItemType;
import cit260.neversync.model.Location;
import cit260.neversync.model.Map;
import cit260.neversync.model.Player;
import cit260.neversync.model.Question;
import cit260.neversync.model.Scene;
import cit260.neversync.model.StoreHouse;



/**
 *
 * @author Ben Langston, Jeff Ledbetter, Scott Moscarello
 */

public class NeverSync {
    
    public static void testTeamClasses() {
        
            // test code for the player class
        
            Player playerOne = new Player();
		
		playerOne.setName("Fred Flinstone");
		playerOne.setTime(7.00);
                
                String playerOneName = playerOne.getName();
                double playerOneTime = playerOne.getTime();
                
                System.out.println(playerOne);
                
                // test code for Game class
                
                Game gameOne = new Game();
                gameOne.setThePlayer("Jimmy Page");
                gameOne.setTheMap("Main Map");
                gameOne.setTheStorehouse("The Main Storehouse");
                gameOne.setCurrentPopulation(200000);
                gameOne.setAcresOwned(500);
                gameOne.setWheatInStorage(20000);
                
                System.out.println("\n" + gameOne.toString());
                
                // test code for Condition (enum)
                
                String conditionName = Condition.Fair.getName();
                String conditionDesc = Condition.Fair.getDescription();

                
                System.out.println("\nThe condition of the item is " 
                + conditionName + ". " + "Meaning " + conditionDesc);
                
    }
    
    public static void testBenClasses() {

         // test code for question class
            
                Question questionOne = new Question();
                
                questionOne.setQuestionText("Where would you like to go?");
                questionOne.setAnswer1("City One");
                questionOne.setAnswer2("City Two");
                questionOne.setAnswer3("City Three");
                questionOne.setAnswer4("City Four");
                questionOne.setCorrectAnswer(5);
                
                System.out.println("\n" + questionOne.toString());
                          
               
                
         // test code for the scence class
         
               // test code for the scence class
         
               ItemType itemType = ItemType.Tool;
               
               Scene sceneOne = new Scene();
               questionOne.getQuestionText();
             
               sceneOne.setName("City of Aaron");
               sceneOne.setDescription("Biblical City");
               sceneOne.setQuestion(questionOne);
               ItemType.Tool.getName();
              
               
               
               System.out.println("\n" + sceneOne.toString() + ItemType.Tool.getName());
               
         // test code for the location class
               
               Location locationOne = new Location();
               Scene sceneTwo = new Scene();
               
               sceneTwo.setName("Aaron");
               
               
               locationOne.setRow(25);
               locationOne.setColumn(55);
               locationOne.setVisited(true);
               locationOne.setScene(sceneTwo);
               
               System.out.println("\n" + locationOne.toString());
                          
            }
    public static void testJeffclasses() {
        
        // Create instance of ItemType Class
		 System.out.println("(Test) ItemType Tool value: "  + ItemType.Tool.getName());
		        
         // Create instance of Map Class   
		 Map mapOne = new Map();
		 
		 //mapOne.setLocations( "Town Square" );
		 //mapOne.setCurrentLocation(1,3);
		 mapOne.setRows(5);
		 mapOne.setColumns(5);
		 
		 //ArrayList mapOneLocations = mapOne.getLocations();
		 java.awt.Point mapOneCurrentLocation = mapOne.getCurrentLocation();
         int mapOneRows = mapOne.getRows();
		 int mapOneColumns = mapOne.getColumns();
		 
		 System.out.println("Map Details: " + 
				 //"\n Locations: " + mapOneLocations +
				 //"\n Current Location: " + mapOneCurrentLocation +
				 "\n Rows: " + mapOneRows +
				 "\n Columns: " + mapOneColumns
				 );
		 System.out.println(mapOne.toString());
		 
		 // Create instance of StoreHouse Class
		 StoreHouse storeOne = new StoreHouse();
		 
		 storeOne.setAnimal("Pig");
		 System.out.println("(Test) StoreHouse - Animal Value: " + storeOne.getAnimal());
		 

		 // Create instance of InventoryItem Class
		 InventoryItem inventoryItemOne = new InventoryItem();
		 inventoryItemOne.setName("Juicy Pig");
		 inventoryItemOne.setQuantity(2);
		 inventoryItemOne.setPricePerUnit(30.0);
		 inventoryItemOne.setAge(3);

		 System.out.println("(Test) InventoryItem value: "  + inventoryItemOne.toString());
	
		 System.out.println(inventoryItemOne.getCondition());
	}
        
        
        
        
    
    
	public static void main(String[] args) {
	
            System.out.println("\nThese are the team test classes:\n");
            testTeamClasses();
            System.out.println("\nThis is the end of the team test classes.");
            System.out.println("\nThese are Ben's test classes:");
            testBenClasses ();
            System.out.println("\nThis is the end of Ben's test classes.");
            
        

            testJeffclasses();
        
            // testScottClasses
                      
             

    }    
               
}
        
        
	
            
        

        
        
	
        
