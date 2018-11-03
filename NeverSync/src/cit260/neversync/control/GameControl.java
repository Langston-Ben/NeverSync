/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.control;

//import cit260.neversync.model.Player;

import cit260.neversync.model.Player;
import neversync.NeverSync;

/**
 *
 * @author Ben Langston and Jeff Ledbetter
 */
public class GameControl {
    
    

        public static Player savePlayer(String playersName) {
            
            if (playersName == null || playersName.length() < 3) {
            return null;
            }
        
            else {
            Player player = new Player();
            player.setName(playersName);
            NeverSync.setPlayer(player);
            
            return player;
            }
          
        }

        public GameControl() {
        }
        public static void createNewGame(Player player) {
            System.out.println("\ncreateNewGame was called\n");
        }
    }
    

