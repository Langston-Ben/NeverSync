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
public class BuyLandControlException extends Exception {

    public BuyLandControlException() {
    }

    public BuyLandControlException(String message) {
        super(message);
    }

    public BuyLandControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuyLandControlException(Throwable cause) {
        super(cause);
    }

    public BuyLandControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
}
