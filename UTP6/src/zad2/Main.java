/**
 *
 *  @author Pahilajani Vinit 
 *
 */

package zad1;


import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        URL wordListUrl = new URL("http://wiki.puzzlers.org/pub/wordlists/unixdict.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(wordListUrl.openStream()));

        Map<String, List<String>> anagrams = reader.lines()
                .collect(Collectors.groupingBy(sorted -> sortString(sorted)));

        int maxAnagrams = anagrams.entrySet().stream()
                .max(Comparator.comparingInt(biggest -> biggest.getValue().size()))
                .get()
                .getValue()
                .size();

        anagrams.entrySet().stream()
                .filter(current -> current.getValue().size() == maxAnagrams)
                .forEach(words -> {
                    for (String word : words.getValue()) {
                        System.out.println(word + " " + joinWords(words.getValue(), word));
                    }
                });
    }
    
    
    public static String sortString(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    
    public static String joinWords(List<String> words, String word) {
        return words.stream()
                .filter(wlist -> !wlist.equals(word))
                .collect(Collectors.joining(" "));
    }
}
