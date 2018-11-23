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
public class ResourceLocation extends Location implements Serializable{

private int amountAvailable;
private int amountUsed;

   public ResourceLocation() {
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public int getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(int amountUsed) {
        this.amountUsed = amountUsed;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.amountAvailable;
        hash = 83 * hash + this.amountUsed;
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
        final ResourceLocation other = (ResourceLocation) obj;
        if (this.amountAvailable != other.amountAvailable) {
            return false;
        }
        if (this.amountUsed != other.amountUsed) {
            return false;
        }
        return true;
    }

  
   
}
