/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fixbits;

import global.Global;

/**
 * Fixes the bits in the given string.
 * @author lnkhanal
 */
public class BitFixer {
     String bitFixedString = "",messageString;
    public void  bitFixer(String str){
        this.messageString = str;
    }
    public void fixBits(){
        this.fix();
    }
    public String getVal(){
        return this.bitFixedString;
    }
    private void fix() {
    /**
    *appends necessary zeros to a message bit string.
    */
       String returnString = "";
        
        if (this.messageString.length() > Global.bitlength) {
            System.out.println("\"" + this.messageString + "\" is too long to process. The maximum bit length possible to process is " + Global.bitlength);
            System.exit(1);
        }
        if (this.messageString.length() < Global.bitlength) {

            for (int j = 0; j < (Global.bitlength - this.messageString.length()); j++) {
                returnString += "0";
            }

            returnString += this.messageString;

        } else {
            returnString += this.messageString;
        }
        this.bitFixedString =  returnString;

    }
}
