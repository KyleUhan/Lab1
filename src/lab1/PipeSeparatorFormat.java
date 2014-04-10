/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Kyle
 */
public class PipeSeparatorFormat implements FormatStrategy{

    //Update with Strategy
    private FileManager file;

    public PipeSeparatorFormat(final FileManager file) {
        setFile(file);
    }
    
    public final FileManager getFile() {
        return file;
    }

    public final void setFile(final FileManager file) {
        this.file = file;
    }
    
    @Override
    public List<String> getFormattedList() {
        List<String> formattedList = new ArrayList<>();
        int count = 0;
        int recordBreakNum;
        String quickFormatter = "";
        for (String s : getFile().getFileContent()) {
            count++;
            quickFormatter += s + "|";
            recordBreakNum = count % FileManager.getRECORD_SIZE();
            if (recordBreakNum == 0) {
                formattedList.add(quickFormatter);
                quickFormatter = "";
            }
        }
        
        return formattedList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.file);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PipeSeparatorFormat other = (PipeSeparatorFormat) obj;
        if (!Objects.equals(this.file, other.file)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PipeSeparatorFormat{" + "file=" + file + '}';
    }
    
    
    
}
