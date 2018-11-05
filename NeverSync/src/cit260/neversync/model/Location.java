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
 * @author benjaminlangston
 */
public class Location implements Serializable {

    private int row;
    private int column;
    private boolean visited;
    private Scene scene;

    public Location() {
    }

    /**
     * Get the value of scene
     *
     * @return the value of scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Set the value of scene
     *
     * @param scene new value of scene
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * Get the value of visited
     *
     * @return the value of visited
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Set the value of visited
     *
     * @param visited new value of visited
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Get the value of column
     *
     * @return the value of column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Set the value of column
     *
     * @param column new value of column
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Get the value of row
     *
     * @return the value of row
     */
    public int getRow() {
        return row;
    }

    /**
     * Set the value of row
     *
     * @param row new value of row
     */
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.row;
        hash = 67 * hash + this.column;
        hash = 67 * hash + (this.visited ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.scene);
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
        final Location other = (Location) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", visited=" + visited + ", scene=" + scene + '}';
    }

}
