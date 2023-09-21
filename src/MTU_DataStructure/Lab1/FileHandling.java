package MTU_DataStructure.Lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileHandling {
    public static Map<String, TreeSet<Integer>> hamletAnalysis() {
        String fileName = "C:\\Users\\t00229172\\IdeaProjects\\Princeton_Data_Structure\\src\\MTU_DataStructure\\Lab1\\hamlet.txt";
        Map<String, TreeSet<Integer>> wordsMapList = new TreeMap<>();
        try {
            Scanner in = new Scanner(new File(fileName));
//            Set<String> words = new TreeSet<>();
//            Map<String, Integer> wordsMap = new TreeMap<>();

            int lineNumber = 1;
            while (in.hasNextLine()) {
                Scanner lineParser = new Scanner(in.nextLine());
                // Use any characters other than a-z, A-Z, 0-9 as delimiters
                lineParser.useDelimiter("[^A-Za-z0-9]+");
                while (lineParser.hasNext()) {
                    String word = lineParser.next();
                    //set add stuff
//                    words.add(word);

                    //map without occurrence line numbers add stuff
//                    wordsMap.put(word, lineNumber);

                    if (!wordsMapList.containsKey(word)) {
                        TreeSet<Integer> lineNumberSet = new TreeSet<>();
                        lineNumberSet.add(lineNumber);
                        wordsMapList.put(word, lineNumberSet);
                    } else {
                        wordsMapList.get(word).add(lineNumber);
                    }
                }
                lineNumber++;
            }

//            Iterator<Map.Entry<String, Integer>> i = wordsMap.entrySet().iterator();
//            System.out.println("Map with no occurrences");
//            while(i.hasNext()) {
//                System.out.print("Word: " + i.next().getKey() + " | Last line number: " + i.next().getValue() + "\n");
//            }
//            System.out.println("Size of the tree map: " + wordsMap.size());

            System.out.println(wordsMapList);
            System.out.println("Size of the tree map: " + wordsMapList.size());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return wordsMapList;
    }
}
