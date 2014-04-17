package lab2;

/**
 *
 * @author Kyle Uhan
 */
public interface FileWriterStrategy {

    public abstract void writeToFile(FormatStrategy format);

    public abstract void writeToFileStrict(FormatStrategy format);

}
