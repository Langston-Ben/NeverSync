/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author benjaminlangston
 */
public class QuestionLocation extends Location implements Serializable {
    
    private int requiredCorrect;
    private int noCorrect;
    private int bonus;

    public QuestionLocation() {
    }

    public int getRequiredCorrect() {
        return requiredCorrect;
    }

    public void setRequiredCorrect(int requiredCorrect) {
        this.requiredCorrect = requiredCorrect;
    }

    public int getNoCorrect() {
        return noCorrect;
    }

    public void setNoCorrect(int noCorrect) {
        this.noCorrect = noCorrect;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.requiredCorrect;
        hash = 59 * hash + this.noCorrect;
        hash = 59 * hash + this.bonus;
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
        final QuestionLocation other = (QuestionLocation) obj;
        if (this.requiredCorrect != other.requiredCorrect) {
            return false;
        }
        if (this.noCorrect != other.noCorrect) {
            return false;
        }
        if (this.bonus != other.bonus) {
            return false;
        }
        return true;
    }

   
    
    
}
