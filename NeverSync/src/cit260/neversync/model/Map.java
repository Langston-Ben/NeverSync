/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author jeffledbetter
 */
public class Map implements Serializable{
	
	private ArrayList locations;
	private Point currentLocation;
	private int rows;
	private int columns;
	
	
	public Map() {
	}

	public ArrayList getLocations() {
		return locations;
	}

	public void setLocations(ArrayList locations) {
		this.locations = locations;
	}

	public Point getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Point currentLocation) {
		this.currentLocation = currentLocation;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 67 * hash + Objects.hashCode(this.locations);
		hash = 67 * hash + Objects.hashCode(this.currentLocation);
		hash = 67 * hash + this.rows;
		hash = 67 * hash + this.columns;
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
		final Map other = (Map) obj;
		if (this.rows != other.rows) {
			return false;
		}
		if (this.columns != other.columns) {
			return false;
		}
		if (!Objects.equals(this.locations, other.locations)) {
			return false;
		}
		if (!Objects.equals(this.currentLocation, other.currentLocation)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Map{" + "locations=" + locations + ", currentLocation=" + currentLocation + ", rows=" + rows + ", columns=" + columns + '}';
	}
	
}
