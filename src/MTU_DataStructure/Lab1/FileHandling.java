package MTU_DataStructure.Lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileHandling {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\t00229172\\IdeaProjects\\Princeton_Data_Structure\\src\\MTU_DataStructure\\Lab1\\hamlet.txt";

        try {
            Scanner in = new Scanner(new File(fileName));
//            Set<String> words = new TreeSet<>();
            Map<String, Integer> map = new TreeMap<>();
            int lineNumber = 1;
            while (in.hasNextLine()) {
                Scanner lineParser = new Scanner(in.nextLine());
                // Use any characters other than a-z, A-Z, 0-9 as delimiters
                lineParser.useDelimiter("[^A-Za-z0-9]+");
                while (lineParser.hasNext()) {
                    String word = lineParser.next();
//                    words.add(word);
                    map.put(word,lineNumber);
                    lineNumber++;
                }
            }
//            Iterator<String> i = words.iterator();
//            while(i.hasNext()) {
//                System.out.print(i.next() + " ");
//            }
//            System.out.println("Size of the tree set: " + words.size());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
