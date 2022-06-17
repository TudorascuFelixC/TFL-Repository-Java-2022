/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_TFL_Underground;

/**
 *
 * @author Tudorascu Felix
 */
public class ValidatorTicket {
    private boolean istheticketValid;
    private String XML;

    public ValidatorTicket() {
    }

    public ValidatorTicket(boolean istheticketValid, String XML) {
        this.istheticketValid = istheticketValid;
        this.XML = XML;
    }



    public boolean isIstheticketValid() {
        return istheticketValid;
    }

    public void setIstheticketValid(boolean istheticketValid) {
        this.istheticketValid = istheticketValid;
    }

    public String getXML() {
        return XML;
    }

    public void setXML(String XML) {
        this.XML = XML;
    }
    
}
