/**
 *
 *  @author Pahilajani Vinit
 *
 */

package zad2;


import java.io.*;
import java.util.*;

public class Anagram{

    List<List<String>> anagramGroupList = null;

    public List<List<String>> getSortedByAnQty(String filePath) throws FileNotFoundException {

        try {
            
            FileInputStream inputStream = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
            String word;

            // Read File Line By Line
            while ((word = bufferedReader.readLine()) != null) {
                // Sort characters of word
                String sortedWord = sorting(word);

                if (!anagramMap.containsKey(sortedWord))
                    anagramMap.put(sortedWord, new ArrayList<String>());

                anagramMap.get(sortedWord).add(word);
            }

            anagramGroupList = new ArrayList<List<String>>(anagramMap.values());

            bufferedReader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return anagramGroupList;

    }

    // Sort alphabetically characters of given word
    private static String sorting(String word) {
        char[] sortedChars = word.toCharArray();
        Arrays.sort(sortedChars);
        return new String(sortedChars);
    }
}