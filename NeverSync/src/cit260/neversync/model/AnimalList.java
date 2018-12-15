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
public class AnimalList implements Serializable {
	
	private String name;
	private String animalType;
	private int quantityInStock;
	private int requiredAmount;
	private double pricePerUnit;
	
	public AnimalList() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public int getRequiredAmount() {
		return requiredAmount;
	}

	public void setRequiredAmount(int requiredAmount) {
		this.requiredAmount = requiredAmount;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 43 * hash + Objects.hashCode(this.name);
		hash = 43 * hash + Objects.hashCode(this.animalType);
		hash = 43 * hash + this.quantityInStock;
		hash = 43 * hash + this.requiredAmount;
		hash = 43 * hash + (int) (Double.doubleToLongBits(this.pricePerUnit) ^ (Double.doubleToLongBits(this.pricePerUnit) >>> 32));
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
		final AnimalList other = (AnimalList) obj;
		if (this.quantityInStock != other.quantityInStock) {
			return false;
		}
		if (this.requiredAmount != other.requiredAmount) {
			return false;
		}
		if (Double.doubleToLongBits(this.pricePerUnit) != Double.doubleToLongBits(other.pricePerUnit)) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.animalType, other.animalType)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "AnimalList{" + "name=" + name + ", animalType=" + animalType + ", quantityInStock=" + quantityInStock + ", requiredAmount=" + requiredAmount + ", pricePerUnit=" + pricePerUnit + '}';
	}
	
	
}
