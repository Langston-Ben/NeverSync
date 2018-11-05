/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Langstons
 */
public class Game implements Serializable {

    // class instance variables
    private String thePlayer;
    private String theMap;
    private String theStorehouse;
    private int currentPopulation;
    private int acresOwned;
    private int wheatInStorage;
    private Player player;

    public Game() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(String thePlayer) {
        this.thePlayer = thePlayer;
    }

    public String getTheMap() {
        return theMap;
    }

    public void setTheMap(String theMap) {
        this.theMap = theMap;
    }

    public String getTheStorehouse() {
        return theStorehouse;
    }

    public void setTheStorehouse(String theStorehouse) {
        this.theStorehouse = theStorehouse;
    }

    public int getCurrentPopulation() {
        return currentPopulation;
    }

    public void setCurrentPopulation(int currentPopulation) {
        this.currentPopulation = currentPopulation;
    }

    public int getAcresOwned() {
        return acresOwned;
    }

    public void setAcresOwned(int acresOwned) {
        this.acresOwned = acresOwned;
    }

    public int getWheatInStorage() {
        return wheatInStorage;
    }

    public void setWheatInStorage(int wheatInStorage) {
        this.wheatInStorage = wheatInStorage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.thePlayer);
        hash = 13 * hash + Objects.hashCode(this.theMap);
        hash = 13 * hash + Objects.hashCode(this.theStorehouse);
        hash = 13 * hash + this.currentPopulation;
        hash = 13 * hash + this.acresOwned;
        hash = 13 * hash + this.wheatInStorage;
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
        if (this.currentPopulation != other.currentPopulation) {
            return false;
        }
        if (this.acresOwned != other.acresOwned) {
            return false;
        }
        if (this.wheatInStorage != other.wheatInStorage) {
            return false;
        }
        if (!Objects.equals(this.thePlayer, other.thePlayer)) {
            return false;
        }
        if (!Objects.equals(this.theMap, other.theMap)) {
            return false;
        }
        if (!Objects.equals(this.theStorehouse, other.theStorehouse)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "thePlayer=" + thePlayer + ", theMap=" + theMap + ", theStorehouse=" + theStorehouse + ", currentPopulation=" + currentPopulation + ", acresOwned=" + acresOwned + ", wheatInStorage=" + wheatInStorage + '}';
    }

}
