/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.model;

import static cit260.neversync.model.Condition.Fair;
import static cit260.neversync.model.Condition.Good;
import static cit260.neversync.model.Condition.Poor;
//import static cit260.neversync.model.ItemType.Animal;
//import static cit260.neversync.model.ItemType.Food;
//import static cit260.neversync.model.ItemType.Medicine;
//import static cit260.neversync.model.ItemType.Tool;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Jeff Ledbetter & Ben Langston
 */
public class InventoryItem implements Serializable {

    private String name;
    private String itemType;
//  private final ArrayList<ItemType> itemType = new ArrayList<>();
    private int quantity;
    private final ArrayList<Condition> condition = new ArrayList<>();
    private double pricePerUnit;
    private int requiredAmount;
    private String animalType;
    private int quantityInStock;
    private int age;
    

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }
   

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    
   
    

    public InventoryItem() {
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Condition getGood() {
        return Good;
    }

    public Condition getFair() {
        return Fair;
    }

    public Condition getPoor() {
        return Poor;
    }

//    public ItemType getTool() {
//        return Tool;
//    }
//
//    public ItemType getFood() {
//        return Food;
//    }
//
//    public ItemType getAnimal() {
//        return Animal;
//    }
//
//    public ItemType getMedicine() {
//        return Medicine;
//    }

    public void setName(String name) {
        this.name = name;
    }

//    public ArrayList<ItemType> getItemType() {
//        return itemType;
//    }

//	public void setItemType(Enum itemType) {
//		this.itemType = itemType;
//	}
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Condition> getCondition() {
        return condition;
    }

//	public void setCondition(Enum condition) {
//		this.condition = condition;
//	}
    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.itemType);
        hash = 59 * hash + this.quantity;
        hash = 59 * hash + Objects.hashCode(this.condition);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.pricePerUnit) ^ (Double.doubleToLongBits(this.pricePerUnit) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.animalType);
        hash = 59 * hash + this.age;
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
        final InventoryItem other = (InventoryItem) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.pricePerUnit) != Double.doubleToLongBits(other.pricePerUnit)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.animalType, other.animalType)) {
            return false;
        }
        if (this.itemType != other.itemType) {
            return false;
        }
        if (this.condition != other.condition) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InventoryItem{" + "name=" + name + ", itemType=" + itemType + ", quantity=" + quantity + ", condition=" + condition + ", pricePerUnit=" + pricePerUnit + ", animalType=" + animalType + ", age=" + age + '}';
    }

}
