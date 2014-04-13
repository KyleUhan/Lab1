package lab1;

import java.io.File;
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

        FileReaderStrategy frs = new ReadFromTextFile(6);
        FormatStrategy format = new PipeSeparatorFormat(frs);

//      Shows formatted list
        for (String s : format.getFormattedList()) {
            System.out.println(s);
        }

        System.out.println("");
//      Returns as Objects
        for (Object o : format.getAsObjectList()) {
            System.out.println(o.toString());
        }

        System.out.println("");
//      Strict removes duplicates
        for (Object o : format.getStrictObjectList()) {
            System.out.println(o.toString());
        }

        System.out.println("");

//        FileWriterStrategy fws1 = new WriteToTextFile();
//        fws1.writeToFile(format);
//
//        FileWriterStrategy fws2 = new WriteToTextFile("default2.txt");
//        fws2.writeToFile(format);
        FileWriterStrategy fws3 = new WriteToTextFile(true);
        fws3.writeToFile(format);

        FileWriterStrategy fws4 = new WriteToTextFile("C:" + File.separatorChar + "Users"
                + File.separatorChar + "Kyle" + File.separatorChar + "Desktop"
                + File.separatorChar + "default3.txt");
        fws4.writeToFileStrict(format);

//        List<Contact> mailingList = new ArrayList<>();
//
//        for (String s : format.getFormattedList()) {
//            String[] UnitInRecordArray = s.split("\\|");
//            Contact c = new Contact(UnitInRecordArray[0], UnitInRecordArray[1], UnitInRecordArray[2], UnitInRecordArray[3], UnitInRecordArray[4], UnitInRecordArray[5]);
//            mailingList.add(c);
//        }
//        
//        for(Contact c : mailingList){
//            System.out.println(c.toString());
//        }
//        System.out.println("\n");
//         List<String> st = new ArrayList<>();
//        count = 0;
//        for (Object f : format.getAsObjectList()) {
//
//           st.add(format.getAsObjectList().get(count).toString());
//            System.out.println(format.getAsObjectList().get(count) + "  - ");
//             count++;
//
//        }
//        System.out.println("");
//        for(String str : st){
//            System.out.println(str);
//        }
    }

}
