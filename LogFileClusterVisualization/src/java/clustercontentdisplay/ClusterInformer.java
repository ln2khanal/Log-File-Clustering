/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clustercontentdisplay;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author lnkhanal
 */
public class ClusterInformer {

    public String showClusterInfo(String fileName) throws FileNotFoundException, IOException {
        String returnString = "", filePath = String.format("D:/Major/clusters/" + fileName);
        File myfile = new File(filePath);
        Scanner scanner = new Scanner(myfile);
        while(scanner.hasNext()){
            returnString = String.format(returnString+scanner.nextLine()+"<br/>");
        }
        scanner.close();


        return returnString;
    }
}
