/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.ArrayList;

/**
 *
 * @author Langstons
 */
public class Player implements Serializable{
    
    // class instance variables
        private String name;
	private Double time;
	private ArrayList<Game> games = new ArrayList<Game>();

    // Constructor
    public Player() {
    }
     
	// Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
	}  
		
	public Double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}
	
    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
		
    

	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 47 * hash + Objects.hashCode(this.name);
		hash = 47 * hash + (int) (Double.doubleToLongBits(this.time) ^ (Double.doubleToLongBits(this.time) >>> 32));
		hash = 47 * hash + Objects.hashCode(this.games);
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
		final Player other = (Player) obj;
		if (Double.doubleToLongBits(this.time) != Double.doubleToLongBits(other.time)) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.games, other.games)) {
			return false;
		}
		return true;
	}
	
		@Override
	public String toString() {
		return "Player{" + "name=" + name + ", time=" + time + ", games=" + games + '}';
	}
    
		
	
		
	
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 23 * hash + Objects.hashCode(this.name);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Player other = (Player) obj;
//        if (!Objects.equals(this.name, other.name)) {
//            return false;
//        }
//        return true;
//    }

//    @Override
//    public String toString() {
//        return "Player{" + "name=" + name + '}';
//    }

	
        
}
