package lab1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Kyle
 */
public class CSVFormat implements FormatStrategy {

    private final static String CHARCTER_TO_ADD = ",";
    private final static String DOUBLE_SLASH = "\\";
    private final static int ZERO_VALUE = 0;
    private FileReaderStrategy file;

    public CSVFormat(final FileReaderStrategy file) {
        setFile(file);
    }

    public final FileReaderStrategy getFile() {
        return file;
    }

    public final void setFile(final FileReaderStrategy file) {
        this.file = file;
    }

    @Override
    public List<String> getFormattedList() {
        List<String> formattedList = new ArrayList<>();
        int count = ZERO_VALUE;
        int recordBreakNum;
        String quickFormatter = "";
        for (String s : getFile().getFileContent()) {
            count++;
            s = s.trim();
            quickFormatter += s + CHARCTER_TO_ADD;
            recordBreakNum = count % getFile().getRecordSize();
            if (recordBreakNum == ZERO_VALUE) {
                formattedList.add(quickFormatter);
                quickFormatter = "";
            }
        }

        return formattedList;
    }

    @Override
    public String getCharacterUsed() {
        return CHARCTER_TO_ADD;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.file);
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
        final CSVFormat other = (CSVFormat) obj;
        if (!Objects.equals(this.file, other.file)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CommaSeparatorFormat{" + "file=" + file + '}';
    }

    @Override
    public final List<Object> getAsObjectList() {
        List<Object> eachUnitArray = new ArrayList<>();
        for (String s : getFormattedList()) {
            String[] UnitInRecordArray = s.split(DOUBLE_SLASH + CHARCTER_TO_ADD);
            List<Object> objArray = new ArrayList<>();
            for (int i = 0; i < getFile().getRecordSize(); i++) {
                objArray.add(UnitInRecordArray[i]);
            }
            eachUnitArray.add(objArray);
        }
        return eachUnitArray;
    }

    @Override
    public final List<Object> getStrictObjectList() {
        Set<Object> tempSet = new HashSet<>(getAsObjectList());
        List<Object> tempList = new ArrayList<>(tempSet);
        return tempList;
    }

}
