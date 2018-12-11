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
 * @author jeffledbetter
 */
public class StoreHouse implements Serializable {

    private String tool;
    private String animal;
    private String food;
    private String medicine;
    private String weapon;
   

    public StoreHouse() {
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.tool);
        hash = 79 * hash + Objects.hashCode(this.animal);
        hash = 79 * hash + Objects.hashCode(this.food);
        hash = 79 * hash + Objects.hashCode(this.medicine);
        hash = 79 * hash + Objects.hashCode(this.weapon);
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
        final StoreHouse other = (StoreHouse) obj;
        if (!Objects.equals(this.tool, other.tool)) {
            return false;
        }
        if (!Objects.equals(this.animal, other.animal)) {
            return false;
        }
        if (!Objects.equals(this.food, other.food)) {
            return false;
        }
        if (!Objects.equals(this.medicine, other.medicine)) {
            return false;
        }
        if (!Objects.equals(this.weapon, other.weapon)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StoreHouse{" + "tool=" + tool + ", animal=" + animal + ", food=" + food + ", medicine=" + medicine + ", weapon=" + weapon + '}';
    }

}
