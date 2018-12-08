/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import cit260.neversync.control.GameControl;
import cit260.neversync.model.Actor;
import cit260.neversync.model.Game;
import cit260.neversync.model.Location;
import cit260.neversync.model.Map;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import neversync.NeverSync;
//import java.util.Comparator;

/**
 *
 * @author Ben Langston & Jeff Ledbetter
 */
public class ActorView {
    private String message;

    protected final BufferedReader keyboard = NeverSync.getInFile();
    protected final PrintWriter console = NeverSync.getOutFile();

    public ActorView() {
    }

   public void displayActorView () {
        
       

        Game game = new Game();
        ArrayList<Actor> actors = game.getActors();

        
        
        actors.add(Actor.Lehi);
        actors.add(Actor.Jacob);
        actors.add(Actor.Laman);
        actors.add(Actor.Lemuel);
        actors.add(Actor.Zoram);
        actors.add(Actor.Sam);
        actors.add(Actor.Sariah);
        actors.add(Actor.Nephi);
        
                
            for (Actor actor : actors) {
         
            this.console.println(
					actor.getName() + " - " + 
					actor.getDescription() + " Location(" + 
					actor.getColumn() + "," + 
					actor.getRow() +")");
            }
			
 	
		this.console.println("\nOriginal Order:");
                this.console.println(actors);
		this.console.println("\nReversed List:");
		Collections.sort(actors, Collections.reverseOrder());
		this.console.println(actors);
		                
		 
   }

    
    
}
