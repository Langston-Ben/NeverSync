/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import cit260.neversync.control.GameControl;
import cit260.neversync.model.Actor;
import cit260.neversync.model.Game;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;

/**
 *
 * @author benjaminlangston
 */
public class ActorView {

    public ActorView() {
    }

   public void displayActorView() {
     
         Game game = new Game();
        ArrayList<Actor> actors = game.getActors();
       
        
     
        
        
        
        actors.add(Actor.Lehi);
        actors.add(Actor.Jacob);
        actors.add(Actor.Laman);
        actors.add(Actor.Lemuel);
        actors.add(Actor.Zoram);
        actors.add(Actor.Sam);
        actors.add(Actor.Sarah);
        actors.add(Actor.Nephi);
        
                
            for (Actor actor : actors) {
         
            System.out.println(actor.getName() + " - " + actor.getDescription());
           
            }
                
      
            
         Collections.sort(actors);
         System.out.println("\n" + actors);
        
   }

    
    
}