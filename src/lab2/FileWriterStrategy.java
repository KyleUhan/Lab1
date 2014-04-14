/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab2;

import java.util.Map;

/**
 *
 * @author Kyle Uhan
 */
public interface FileWriterStrategy {

    public abstract void writeToFile(FormatStrategy format);
    
    public abstract Map<String, Object> getMap(FormatStrategy format);
  
    public abstract void writeToFileStrict(FormatStrategy format);
    
}
