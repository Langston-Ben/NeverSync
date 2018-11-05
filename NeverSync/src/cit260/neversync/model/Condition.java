/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.model;

import java.awt.Point;

/**
 *
 * @author Langstons
 */
public enum Condition {

    Good("Good", "The item is in good condition.", new Point(1, 1)),
    Fair("Fair", "The item is in fair condition.", new Point(0, 1)),
    Poor("Poor", "The item is in poor condition.", new Point(1, 2));

    private String name;
    private String description;
    private Point coordinates;

    Condition(String name, String description, Point coordinates) {
        this.name = name;
        this.description = description;
        this.coordinates = coordinates;

    }

    public static Condition getGood() {
        return Good;
    }

    public static Condition getFair() {
        return Fair;
    }

    public static Condition getPoor() {
        return Poor;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Condition{" + "name=" + name + ", description=" + description + ", coordinates=" + coordinates + '}';
    }

}
