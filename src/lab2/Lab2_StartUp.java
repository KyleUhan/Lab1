/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Kyle Uhan
 */
public class Lab2_StartUp {

    public static void main(String[] args) throws IOException {

        FileReaderStrategy frs = new ReadFromTextFile(6);
        FormatStrategy format = new PipeSeparatorFormat(frs);
        
        for(String s : format.getFormattedList()){
            System.out.println(s);
        }

//        Map<String, Object> mailingList = new HashMap<String, Object>();
//        mailingList.put("KyleUhan", format.getStrictObjectList().get(0));
//        mailingList.put("JaneSmith", format.getStrictObjectList().get(1));
//        mailingList.put("JohnSmith", format.getAsObjectList().get(2));
//        mailingList.put("TommyTwoTone", format.getAsObjectList().get(3));
//        mailingList.put("JohnSmith", format.getAsObjectList().get(4));
//        
//        System.out.println("Map size: " + mailingList.size());
//        String[] s = mailingList.get("KyleUhan").toString().split("\\|");
//        for(String t : s){
//            System.out.println(t);
//        }
//        
//        System.out.println("");
//        
//        for(String o : mailingList.keySet()){
//            if(o.equals("JaneSmith")){
//                System.out.println(mailingList.get(o));
//            }
//            
//        }
//        Iterator i = mailingList.keySet().iterator();
//        while(i.hasNext()){
//            
//        }
//        System.out.println(mailingList.get("KyleUhan"));
//        System.out.println(mailingList.get("JaneSmith"));
//        System.out.println(mailingList.get("JohnSmith"));
//        System.out.println(mailingList.get("TommyTwoTone"));
//        System.out.println(mailingList.get("JohnSmith"));
        
        System.out.println("");
        
        Map<String, Object> map = new HashMap<>(format.getMap());
        System.out.println("Map size: " + map.size());
        System.out.println("Keys in map: " + map.keySet());
        
        
//
//        String key = "KyleUhan";
//        System.out.println(map.get(key));
//        key = "JaneSmith";
//        System.out.println(map.get(key));

    }
}
