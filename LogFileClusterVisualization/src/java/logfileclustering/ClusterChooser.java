/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logfileclustering;

import java.io.*;

/**
 *
 * @author lnkhanal
 */
public class ClusterChooser {

    private String filePath = "D:/major/clusters/";

    public String showClusters() throws FileNotFoundException, IOException {
        int fileCount = 0;
        String returnString = "";
        File file = new File(filePath);
        String cluster = "Cluster-";
        if (file.isDirectory()) {
            String[] filesInTheDirectory = file.list();
            for (fileCount = 0; fileCount < filesInTheDirectory.length; fileCount++) {

                FileInputStream inputFile = new FileInputStream(filePath + filesInTheDirectory[fileCount]);
                DataInputStream ds = new DataInputStream(inputFile);
                fileCount++;
                int count = 0;
                while (ds.readLine() != null) {
                    count++;
                }
                returnString = returnString + String.format(cluster+fileCount + ": " + count + ",");
                fileCount--;
                ds.close();
                inputFile.close();
            }
            
        }
        return returnString;
    }
}
