/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neversync;

import cit260.neversync.model.Condition;
import cit260.neversync.model.Player;
//import cit260.neversync.model.Game;


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

	}
	
        
        
}
