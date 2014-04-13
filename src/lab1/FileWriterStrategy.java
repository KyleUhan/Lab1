/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab1;

import java.util.List;

/**
 *
 * @author Kyle Uhan
 */
public interface FileWriterStrategy {

    
    public abstract void writeToFile(FormatStrategy format);
    
    public abstract void writeToFileStrict(FormatStrategy format);
    
}
