package lab2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Kyle Uhan
 */
public interface FileReaderStrategy {

    public abstract void setFile(final String filePath) throws FileNotFoundException;

    public abstract List<String> getFileContent();

    public abstract void setRecordSize(final int recordSize) throws IllegalArgumentException;

    public abstract int getRecordSize();

    public abstract void transferFileContents() throws IOException;

}
