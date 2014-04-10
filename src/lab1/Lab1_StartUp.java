package lab1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kyle
 */
public class Lab1_StartUp {

    public static void main(String[] args) throws IOException {

        FileManager fm = new FileManager();
        FormatStrategy pipeFormat = new PipeSeparatorFormat(fm);

//        for (String s : pipeFormat.getFormattedList()) {
//            System.out.println(s);
//        }

        List<Contact> mailingList = new ArrayList<>();

        for (String s : pipeFormat.getFormattedList()) {
            String[] array = s.split("\\|");
            //  u.add(array);
            Contact c = new Contact(array[0], array[1], array[2], array[3], array[4], array[5]);
            mailingList.add(c);
        }

        for (Contact c : mailingList) {
            System.out.println(c.toString());
        }

    }

}
