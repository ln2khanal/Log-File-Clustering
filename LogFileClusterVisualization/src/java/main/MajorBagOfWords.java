/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
*This should be the first commit
*/
package main;

import java.io.IOException;
import streamingLogHandle.LogHandller;

/**
 * The class with main method. This class controls all the activities of the program.
 * @author lnkhanal
 */
public class MajorBagOfWords {

    /**
     * @param args the command line arguments
     */
    public boolean mainMethod() throws IOException {
        boolean returnFlag = false;
        LogHandller logHandeller = new LogHandller();
        if(logHandeller.process()){
            returnFlag = true;
        }
        return returnFlag;
    }
   
}
