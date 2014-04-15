package lab2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 *
 * @author Kyle Uhan
 */
public class WriteToTextFile implements FileWriterStrategy {

    private final static String DEFAULT_TEXT_NAME = "Default.txt";
    private boolean append;
    private PrintWriter file;

    public WriteToTextFile() throws IOException {
        setAppend(true);
        setFile(new PrintWriter(new BufferedWriter(new FileWriter(DEFAULT_TEXT_NAME, isAppend()))));
    }

    public WriteToTextFile(final boolean append) throws IOException {
        setAppend(append);
        setFile(new PrintWriter(new BufferedWriter(new FileWriter(DEFAULT_TEXT_NAME, isAppend()))));
    }

    public WriteToTextFile(final String file) throws IOException {
        setAppend(true);
        setFile(new PrintWriter(new BufferedWriter(new FileWriter(file, isAppend()))));
    }

    public WriteToTextFile(final String file, final boolean append) throws IOException {
        setAppend(append);
        setFile(new PrintWriter(new BufferedWriter(new FileWriter(file, isAppend()))));
    }

    public final PrintWriter getFile() {
        return file;
    }

    public final void setFile(final PrintWriter file) {
        this.file = file;
    }

    public final boolean isAppend() {
        return append;
    }

    public final void setAppend(final boolean append) {
        this.append = append;
    }

    @Override
    public void writeToFile(FormatStrategy format) {
        for (int i = 0; i < format.getAsObjectList().size(); i++) {
            String[] tempArray = format.getAsObjectList().get(i).toString().split("\\,");
            for (int e = 0; e < tempArray.length; e++) {
                tempArray[e] = tempArray[e].replace('[', ' ');
                tempArray[e] = tempArray[e].replace(']', ' ');
                tempArray[e] = tempArray[e].trim();
                getFile().println(tempArray[e]);
            }
        }
        getFile().close();
    }

    @Override
    public void writeToFileStrict(final FormatStrategy format) {
        for (int i = 0; i < format.getStrictObjectList().size(); i++) {
            String[] tempArray = format.getStrictObjectList().get(i).toString().split("\\,");
            for (int e = 0; e < tempArray.length; e++) {
                tempArray[e] = tempArray[e].replace('[', ' ');
                tempArray[e] = tempArray[e].replace(']', ' ');
                tempArray[e] = tempArray[e].trim();
                getFile().println(tempArray[e]);
            }
        }
        getFile().close();
    }

}
