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
public class StoreHouseException extends Exception {

    public StoreHouseException() {
    }

    public StoreHouseException(String message) {
        super(message);
    }

    public StoreHouseException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreHouseException(Throwable cause) {
        super(cause);
    }

    public StoreHouseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
}
