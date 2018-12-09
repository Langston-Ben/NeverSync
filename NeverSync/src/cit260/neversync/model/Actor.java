/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.model;
//import java.awt.Point;

/**
 *
 * @author benjaminlangston
 */
public enum Actor {
    
    Lehi("Lehi","He is the prophet and leader of the family.",2,1),
    Sariah("Sarah", "She is Lehi's wife and mother of the family.",3,1),
    Nephi("Nephi", "Faithful son and later the prophet leader of the Nephites.",1,1),
    Jacob("Jacob", "Nephi's faithful brother, prophet, and successor to Nephi.",4,1),
    Sam("Sam", "The 3rd oldest and faithful brother of Nephi.",0,1),
    Laman("Laman", "The oldest rebellious brother and leader of the Lamanites.",1,2),
    Lemuel("Lemul","The 2nd oldest rebellious brother who went with Laman.",1,3),
    Zoram("Zoram","Laban's servant that became a faithful friend to Nephi.",1,4);
    
   

    private Actor(String name, String description,int column,int row) {
        this.name = name;
        this.description = description;
		this.column = column;
		this.row = row;
//		this.coordinates = coordinates;
    }
    
    
    private String name;
    private final String description;
//    private Point coordinates;
    private Player player;
	private int column;
	private int row;

//    public Point getCoordinates() {
//        return coordinates;
//    }
//
//    public void setCoordinates(Point coordinates) {
//        this.coordinates = coordinates;
//    }
	
	
	
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

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
    
    

    
    
    
    
    
}
