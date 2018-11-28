/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.model;

import java.awt.Point;

/**
 *
 * @author benjaminlangston
 */
public enum Actor {
    
    Lehi("Lehi","He is the prophet and leader of the family."),
    Sarah("Sarah", "She is Lehi's wife and mother of the family."),
    Nephi("Nephi", "Faithful son oand later the prophet leader of the Nephites."),
    Jacob("Jacob", "Nephi's faithful brother, prophet, and successor to Nephi."),
    Sam("Sam", "The youngest boy and faithful brother of Nephi."),
    Laman("Laman", "The oldest rebellious brother and leader of the Lamanites."),
    Lemuel("Lemul","The 2nd oldest rebellious brother who went with Laman."),
    Zoram("Zoram","Laban's servant that became a faithful follower of Nephi.");
    
   

    private Actor(String name, String description) {
        this.name = name;
        this.description = description;
        
    }
    
    
    private String name;
    private final String description;
    private Point coordinates;
    private Player player;

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    
    

    
    
    
    
    
}
