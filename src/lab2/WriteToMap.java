/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author Kyle Uhan
 */
public class WriteToMap implements FileWriterStrategy{

    private Map<String, Object> file;
    

    @Override
    public Map<String, Object> getMap(FormatStrategy format) {
        Map<String, Object> m = new HashMap<>();
        for (int i = 0; i < format.getAsObjectList().size(); i++) {
            String[] tempArray = format.getAsObjectList().get(i).toString().split("\\,");
            for (int e = 0; e < tempArray.length; e++) {
                tempArray[e] = tempArray[e].replace('[', ' ');
                tempArray[e] = tempArray[e].replace(']', ' ');
                tempArray[e] = tempArray[e].trim();
            }
            m.put(tempArray[0]+tempArray[1], format.getAsObjectList().get(i));
            //for testing purposes
            System.out.println("key: " + tempArray[0]+tempArray[1] + " Object: " + format.getAsObjectList().get(i));
        }
        return m;
    }

    @Override
    public void writeToFileStrict(final FormatStrategy format) {
//        for (int i = 0; i < format.getStrictObjectList().size(); i++) {
//            String[] tempArray = format.getStrictObjectList().get(i).toString().split("\\,");
//            for (int e = 0; e < tempArray.length; e++) {
//                tempArray[e] = tempArray[e].replace('[', ' ');
//                tempArray[e] = tempArray[e].replace(']', ' ');
//                tempArray[e] = tempArray[e].trim();
//                getFile().println(tempArray[e]);
//            }
//        }
//        getFile().close();
    }

    @Override
    public void writeToFile(FormatStrategy format) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
