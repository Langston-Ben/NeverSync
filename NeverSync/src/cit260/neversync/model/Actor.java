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
    
    Lehi("He is the prophet and leader of the family."),
    Sarah("She is Lehi's wife and mother of the family."),
    Nephi("Faithful son oand later the prophet leader of the Nephites."),
    Jacob("Nephi's faithful brother, prophet, and successor to Nephi."),
    Sam("The 3rd oldest and faithful brother of Nephi."),
    Laman("The oldest rebellious brother and leader of the Lamanites."),
    Lemuel("The 2nd oldest rebellious brother who went with Laman."),
    Zoram("Laban's servant that became a faithful follower of Nephi.");

    public static Actor getLehi() {
        return Lehi;
    }

    public static Actor getSarah() {
        return Sarah;
    }

    public static Actor getNephi() {
        return Nephi;
    }

    public static Actor getJacob() {
        return Jacob;
    }

    public static Actor getSam() {
        return Sam;
    }

    public static Actor getLaman() {
        return Laman;
    }

    public static Actor getLemuel() {
        return Lemuel;
    }

    public static Actor getZoram() {
        return Zoram;
    }

    private Actor(String description, Player player) {
        this.description = description;
        this.player = player;
    }
    private String name;
    private Point coordinates;
    private final String description;
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

   
    

    public void setPlayer(Player player) {
        this.player = player;
    }
   
    Actor(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    
    
    
    }
}
