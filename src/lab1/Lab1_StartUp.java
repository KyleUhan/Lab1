package lab1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Kyle
 */
public class Lab1_StartUp {

    public static void main(String[] args) throws IOException {

        FileReaderStrategy fr = new ReadFromTextFile(6);
        FormatStrategy format = new PipeSeparatorFormat(fr);

//      Shows formatted list
        for (String s : format.getFormattedList()) {
            System.out.println(s);
        }

        System.out.println("");

        //Returns as Objects
        for (Object o : format.getAsObjectList()) {
            System.out.println(o.toString());
        }

        System.out.println("");
        //Strict removes duplicates
        for (Object o : format.getStrictObjectList()) {
            System.out.println(o.toString());

        }

    }

}
