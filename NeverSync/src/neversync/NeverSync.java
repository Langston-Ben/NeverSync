/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neversync;

import cit260.neversync.model.Condition;
import cit260.neversync.model.Game;
import cit260.neversync.model.Location;
import cit260.neversync.model.Player;
import cit260.neversync.model.Point;
import cit260.neversync.model.Question;
import cit260.neversync.model.Scene;



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
                questionOne.setAnwser1("City One");
                questionOne.setAnswer2("City Two");
                questionOne.setAnswer3("City Three");
                questionOne.setAnswer4("City Four");
                questionOne.setCorrectAnswer(5);
                
                String questionOneQuestionText = questionOne.getQuestionText();
                String questionOneAnswer1 = questionOne.getAnwser1();
                String questionOneAnswer2 = questionOne.getAnswer2();
                String questionOneAnswer3 = questionOne.getAnswer3();
                String questionOneAnswer4 = questionOne.getAnswer4();
                int questionOneCorrectAnswer = questionOne.getCorrectAnswer();
                
                System.out.println("\nNew Question = " + questionOneQuestionText
                + "\nYour Choices:" + "\nAnswer One = " + questionOneAnswer1 
                + "\nAnswer Two = " + questionOneAnswer2 + "\nAnswer Three = "
                + questionOneAnswer3 + "\nAnswer Four = " + questionOneAnswer4
                + "\nThe Output Value for the correct answer is: "
                + questionOneCorrectAnswer);        
                
               // test code for the point class
               
               Point pointOne = new Point();
               
               pointOne.setColumn(20);
               pointOne.setRow(40);
               
               int pointOneCol = pointOne.getColumn();
               int pointOneRow = pointOne.getRow();
                
               System.out.println("\nColumn = " + pointOneCol + "\nRow = " +pointOneRow);
                
               // test code for the scence class
               
               Scene sceneOne = new Scene();
               
               sceneOne.setName("City of Aaron");
               sceneOne.setDescription("Biblical City");
               
               String aaronSceneOne = sceneOne.getName();
               String aaronDescpriptionOne = sceneOne.getDescription();
               
               System.out.println("\nScene Name: " + aaronSceneOne 
               + "\nScene Description: "
               + aaronDescpriptionOne );
               
               
               // test code for the location class
               
               Location locationOne = new Location();
               
               locationOne.setRow(25);
               locationOne.setColumn(55);
               locationOne.setVisited(true);
               locationOne.setScene("City of Aaron");
               
               int aaronLocationRow = locationOne.getRow();
               int aaronLocationColumn = locationOne.getColumn();
               boolean aaronLocationVisited = locationOne.isVisited();
               String aaronLocationScene = locationOne.getScene();
               
               System.out.println("\nName of the location: " + aaronLocationScene
               + "\nHave been there: " + aaronLocationVisited + "\nRow: " 
               + aaronLocationRow + "\nColumn: " + aaronLocationColumn);
               
    }
    
	public static void main(String[] args) {
	
            System.out.println("\nThese are the team test classes:\n");
            testTeamClasses();
            System.out.println("\nThis is the end of the team test classes.");
            System.out.println("\nThese are Ben's test classes:");
            testBenClasses ();
            System.out.println("\nThese are the end of Ben's test classes.");
            // testJeffClasses
                      
             

            }    
               
	}
        
        
	
            
        
