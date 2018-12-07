/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Ben Langston
 */
public class Game implements Serializable {

    // class instance variables
    private String thePlayer;
    private InventoryItem[] inventory;
    private Map map;
    private String theStorehouse;
    private double currentPopulation;
    private double acresOwned;
    private double wheatInStorage;
    private double acresPlanted;
    private int year;
    private int starved;
    private int newPopulation;
    private double wheatFedToPeople;
    private double bushelsHarvested;
    private double bushelsInTithes;
    private double wheatEatenByRats;
    private double bushelsPerAcreHarvested;
    
    
    private Player player;
    private Actor actor;
    private ArrayList<Actor> Actors = new ArrayList<>();

    public Game() {
    }

    public double getWheatFedToPeople() {
        return wheatFedToPeople;
    }

    public void setWheatFedToPeople(double wheatFedToPeople) {
        this.wheatFedToPeople = wheatFedToPeople;
    }

    public double getAcresPlanted() {
        return acresPlanted;
    }

    public void setAcresPlanted(double acresPlanted) {
        this.acresPlanted = acresPlanted;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStarved() {
        return starved;
    }

    public void setStarved(int starved) {
        this.starved = starved;
    }

    public int getNewPopulation() {
        return newPopulation;
    }

    public void setNewPopulation(int newPopulation) {
        this.newPopulation = newPopulation;
    }

    public double getBushelsHarvested() {
        return bushelsHarvested;
    }

    public void setBushelsHarvested(double bushelsHarvested) {
        this.bushelsHarvested = bushelsHarvested;
    }

    public double getBushelsInTithes() {
        return bushelsInTithes;
    }

    public void setBushelsInTithes(double bushelsInTithes) {
        this.bushelsInTithes = bushelsInTithes;
    }

    public double getWheatEatenByRats() {
        return wheatEatenByRats;
    }

    public void setWheatEatenByRats(double wheatEatenByRats) {
        this.wheatEatenByRats = wheatEatenByRats;
    }

    public double getBushelsPerAcreHarvested() {
        return bushelsPerAcreHarvested;
    }

    public void setBushelsPerAcreHarvested(double bushelsPerAcreHarvested) {
        this.bushelsPerAcreHarvested = bushelsPerAcreHarvested;
    }
    
    

    public String getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(String thePlayer) {
        this.thePlayer = thePlayer;
    }

    public InventoryItem[] getInventory() {
        return inventory;
    }

    public void setInventory(InventoryItem[] inventory) {
        this.inventory = inventory;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String getTheStorehouse() {
        return theStorehouse;
    }

    public void setTheStorehouse(String theStorehouse) {
        this.theStorehouse = theStorehouse;
    }

    public double getCurrentPopulation() {
        return currentPopulation;
    }

    public void setCurrentPopulation(double currentPopulation) {
        this.currentPopulation = currentPopulation;
    }

    public double getAcresOwned() {
        return acresOwned;
    }

    public void setAcresOwned(double acresOwned) {
        this.acresOwned = acresOwned;
    }

    public double getWheatInStorage() {
        return wheatInStorage;
    }

    public void setWheatInStorage(double wheatInStorage) {
        this.wheatInStorage = wheatInStorage;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public ArrayList<Actor> getActors() {
        return Actors;
    }

    public void setActors(ArrayList<Actor> Actors) {
        this.Actors = Actors;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.thePlayer);
        hash = 23 * hash + Arrays.deepHashCode(this.inventory);
        hash = 23 * hash + Objects.hashCode(this.map);
        hash = 23 * hash + Objects.hashCode(this.theStorehouse);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.currentPopulation) ^ (Double.doubleToLongBits(this.currentPopulation) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.acresOwned) ^ (Double.doubleToLongBits(this.acresOwned) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.wheatInStorage) ^ (Double.doubleToLongBits(this.wheatInStorage) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.player);
        hash = 23 * hash + Objects.hashCode(this.actor);
        hash = 23 * hash + Objects.hashCode(this.Actors);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (Double.doubleToLongBits(this.currentPopulation) != Double.doubleToLongBits(other.currentPopulation)) {
            return false;
        }
        if (Double.doubleToLongBits(this.acresOwned) != Double.doubleToLongBits(other.acresOwned)) {
            return false;
        }
        if (Double.doubleToLongBits(this.wheatInStorage) != Double.doubleToLongBits(other.wheatInStorage)) {
            return false;
        }
        if (!Objects.equals(this.thePlayer, other.thePlayer)) {
            return false;
        }
        if (!Objects.equals(this.theStorehouse, other.theStorehouse)) {
            return false;
        }
        if (!Arrays.deepEquals(this.inventory, other.inventory)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (this.actor != other.actor) {
            return false;
        }
        if (!Objects.equals(this.Actors, other.Actors)) {
            return false;
        }
        return true;
    }
    
    
}
