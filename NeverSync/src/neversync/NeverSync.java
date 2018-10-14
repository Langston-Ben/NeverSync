/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neversync;

import java.awt.Point;
import cit260.neversync.model.Condition;
import cit260.neversync.model.Game;
import cit260.neversync.model.Player;
import cit260.neversync.model.ItemType;
import cit260.neversync.model.InventoryItem;
import cit260.neversync.model.Map;
import cit260.neversync.model.StoreHouse;


/**
 *
 * @author jeffledbetter
 */

public class NeverSync {
	
	public static void main(String[] args) {
	
		Player playerOne = new Player();
		
		playerOne.setName("Fred Flinstone");
		playerOne.setTime(7.00);
                
                String playerOneName = playerOne.getName();
                double playerOneTime = playerOne.getTime();
                
                System.out.println("Name = " + playerOneName +
                        ", time = " + playerOneTime);
		
		System.out.println(playerOne.toString());
                

                String conditionName = Condition.Fair.getName();
                String conditionDesc = Condition.Fair.getDescription();

                
                System.out.println("The condition of the item is " + conditionName + ". " + "Meaning " + conditionDesc);
                
                
                Game gameOne = new Game();
                gameOne.setThePlayer("Jimmy Page");
                gameOne.setTheMap("Main Map");
                gameOne.setTheStorehouse("The Main Storehouse");
                gameOne.setCurrentPopulation(200000);
                gameOne.setAcresOwned(500);
                gameOne.setWheatInStorage(20000);
								
				
                
                String gameOneName = gameOne.getThePlayer();
                String gameOneTheMap = gameOne.getTheMap();
                String gameOneTheStorehouse = gameOne.getTheStorehouse();
                int gameOneCurrentPopulation = gameOne.getCurrentPopulation();
                int gameOneAcresOwned = gameOne.getAcresOwned();
                int gameOneWheatInStorage = gameOne.getWheatInStorage();
                
                
                System.out.println("The Player's Name is: " + gameOneName + 
                "\nThe current map is: " + gameOneTheMap + "\nThe current storehouse is: "
                + gameOneTheStorehouse + "\nThe current population is " 
                + gameOneCurrentPopulation + "\nThe current acres owned is " 
                + gameOneAcresOwned + "\nThe current wheat is storage is: " 
                + gameOneWheatInStorage + " bushels.");
                
         // Create instance of ItemType Class
		 System.out.println("(Test) ItemType Tool value: "  + ItemType.Tool.getName());
		        
         // Create instance of Map Class   
		 Map mapOne = new Map();
		 
		 //mapOne.setLocations( "Town Square" );
		 //mapOne.setCurrentLocation(1,3);
		 mapOne.setRows(5);
		 mapOne.setColumns(5);
		 
		 //ArrayList mapOneLocations = mapOne.getLocations();
		 Point mapOneCurrentLocation = mapOne.getCurrentLocation();
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
	     
		
}
