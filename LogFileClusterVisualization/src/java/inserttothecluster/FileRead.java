/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inserttothecluster;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lnkhanal
 * File reading and inserting in the data structure.
 */
public class FileRead {

    private String fileName, filePath;
    //This result will contain the array of lines of strings not the words separately.
    private String[] result = null;

    FileRead(String dir) {
        filePath = dir;
        //fileName = filename;
    }

    public wordContainer readFile() {
        int fileCount = 0;

        File file = new File(filePath);
        wordContainer WC = new wordContainer(fileCount, "");

        if (file.isDirectory()) {
            String[] filesInTheDirectory = file.list();
            for (fileCount = 0; fileCount < filesInTheDirectory.length; fileCount++) {
                try {
                    FileInputStream inputFile = new FileInputStream(filePath + filesInTheDirectory[fileCount]);
                    DataInputStream ds = new DataInputStream(inputFile);
                    BufferedReader br = new BufferedReader(new InputStreamReader(ds));
                    VerifyWords VW = new VerifyWords();

                    String line = "", newline = "";

                    //Checking the mac address and the ip address.
                    macIPFloatCheck MCIP = new macIPFloatCheck();
                    try {
                        final String REGEX = "[\\s\\<\\>\\@\\-~`#+/*\\(\\t\\,[:]+[ ]|[ ]+[:]){}\\[\\]'=^;!_%]+";
                        while ((line = br.readLine()) != null) {
                            newline = VW.ReplaceDate(line);
                            newline = VW.ReplaceDateAndTime(newline);
                            newline = VW.ReplaceIP(newline);
                            newline = VW.ReplaceMAC(newline);
                            newline = VW.ReplaceTime(newline);

                            newline = newline.replaceAll(REGEX, " ");

                            result = newline.split(" ");
                            for (int i = 0; i < result.length; i++) {

                                //System.out.println("Current string: " + result[i]);
                                if (!(MCIP.isAMacAddress(result[i]) || MCIP.isIPAddress(result[i]) || MCIP.doesItContainIpWithPortAddr(result[i]) || MCIP.isItIntegerOrFloatNumber(result[i]) || (result[i].length() <= 2))) {
                                    WC.searchList(result[i]);
                                }
                            }
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return WC;
    }
}
