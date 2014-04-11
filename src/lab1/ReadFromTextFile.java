package lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kyle
 */
public class ReadFromTextFile implements FileReaderStrategy {

    private final static int DEFAULT_RECORD_SIZE = 1;
    private int recordSize;
    private List<String> fileContent;
    private File file;

    public ReadFromTextFile() throws IOException {
        setFile("src" + File.separatorChar + "ContactListData.txt");
        setRecordSize(DEFAULT_RECORD_SIZE);
        setFileContent(new ArrayList<String>());
        transferFileContents();
    }

    public ReadFromTextFile(final int recordSize) throws IOException, IllegalArgumentException {
        setFile("src" + File.separatorChar + "ContactListData.txt");
        setRecordSize(recordSize);
        setFileContent(new ArrayList<String>());
        transferFileContents();
    }

    /**
     * Transfers data from file to array list
     *
     * @throws IOException
     */
    @Override
    public final void transferFileContents() throws IOException {
        if (getFile() == null || !getFile().exists()) {
            throw new IOException("Unable to locate file...");
        }
        BufferedReader input = new BufferedReader(new FileReader(getFile()));;
        String line = input.readLine();
        while (line != null) {
            getFileContent().add(line);
            line = input.readLine();
        }
        input.close();
    }

    public final int fileSize() {
        return getFileContent().size() / getRecordSize();
    }

    public final File getFile() {
        return file;
    }

    @Override
    public final void setFile(final String filePath) throws FileNotFoundException {
        File tempFile = new File(filePath);
        if (!tempFile.exists()) {
            throw new FileNotFoundException("Unable to locate file.");
        }
        this.file = tempFile;
    }

    @Override
    public final List<String> getFileContent() {
        return fileContent;
    }

    public final void setFileContent(final List<String> fileContent) throws NullPointerException {
        if (fileContent == null) {
            throw new NullPointerException("Must not be Null");
        }
        this.fileContent = fileContent;
    }

    @Override
    public final int getRecordSize() {
        return recordSize;
    }

    @Override
    public final void setRecordSize(final int recordSize) throws IllegalArgumentException {
        if (recordSize < 1) {
            throw new IllegalArgumentException("Record size must be at least 1");
        }
        this.recordSize = recordSize;
    }

}
