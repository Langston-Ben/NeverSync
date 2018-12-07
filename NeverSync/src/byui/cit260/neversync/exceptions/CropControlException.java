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
public class CropControlException extends Exception {

    public CropControlException() {
    }

    public CropControlException(String message) {
        super(message);
    }

    public CropControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public CropControlException(Throwable cause) {
        super(cause);
    }

    public CropControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
