/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.model;

import java.io.Serializable;

/**
 *
 * @author benjaminlangston
 */
public class Point implements Serializable {
    
    private int row; 
    private int column;

    public Point() {
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
        hash = 29 * hash + this.row;
        hash = 29 * hash + this.column;
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
        final Point other = (Point) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Point{" + "row=" + row + ", column=" + column + '}';
    }

    
    
}
