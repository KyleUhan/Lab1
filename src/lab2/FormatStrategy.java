/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.List;

/**
 *
 * @author Kyle
 */
public interface FormatStrategy {

    public abstract List<String> getFormattedList();
    
    public abstract List<Object> getAsObjectList();
    
    public abstract List<Object> getStrictObjectList();
    
    public abstract String getCharacterUsed();

}
