package lab1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kyle
 */
public class Lab1_StartUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        FileManager fm = new FileManager();


        List<String> formattedList = new ArrayList<>();
       
        
        int count = 0;
        int recordBreakNum;
        String quickFormatter = "";
        for (String s : fm.getFileContent()) {
            count++;
            quickFormatter += s + "|";
            recordBreakNum = count % FileManager.getRECORD_SIZE();
            if (recordBreakNum == 0) {
                formattedList.add(quickFormatter);
                quickFormatter = "";
            }
        }
        
        List<Contact> mailingList = new ArrayList<>();
        
        List<String[]> u = new ArrayList<>();
        String[] array = new String[50];

        for (String s : formattedList) {
            array = s.split("\\|");
            u.add(array);
            String fistName = array[0];
            String LastName = array[1];
            String address = array[2];
            String city = array[3];
            String state = array[4];
            String zip = array[5];

            Contact c = new Contact(fistName, LastName, address, city, state, zip);
            mailingList.add(c);
        }

        System.out.println(mailingList.size());

        for (Contact c : mailingList) {
            System.out.println(c.toString());
        }

    }

}
