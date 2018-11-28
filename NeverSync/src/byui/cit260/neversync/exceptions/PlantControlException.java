/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.exceptions;

/**
 *
 * @author benjaminlangston
 */
public class PlantControlException extends Exception {

    public PlantControlException() {
    }

    public PlantControlException(String message) {
        super(message);
    }

    public PlantControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlantControlException(Throwable cause) {
        super(cause);
    }

    public PlantControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
