/**
 * Task3
 * Реализовать функцию нечеткого поиска
 * <p>
 * fuzzySearch("car", "ca6$$#_rtwheel"); // true
 * fuzzySearch("cwhl", "cartwheel"); // true
 * fuzzySearch("cwhee", "cartwheel"); // true
 * fuzzySearch("cartwheel", "cartwheel"); // true
 * fuzzySearch("cwheeel", "cartwheel"); // false
 * fuzzySearch("lw", "cartwheel"); // false
 */

package task3;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Продублировал всё в тестах.
        System.out.println(fuzzySearchStream("car", "ca6$$#_rtwheel"));
        System.out.println(fuzzySearchStream("cwhl", "cartwheel"));
        System.out.println(fuzzySearchStream("cwhee", "cartwheel"));
        System.out.println(fuzzySearchStream("cartwheel", "cartwheel"));
        System.out.println(fuzzySearchStream("cwheeel", "cartwheel"));
        System.out.println(fuzzySearchStream("lw", "cartwheel"));

        System.out.println(fuzzySearchLoop("car", "ca6$$#_rtwheel"));
        System.out.println(fuzzySearchLoop("cwhl", "cartwheel"));
        System.out.println(fuzzySearchLoop("cwhee", "cartwheel"));
        System.out.println(fuzzySearchLoop("cartwheel", "cartwheel"));
        System.out.println(fuzzySearchLoop("cwheeel", "cartwheel"));
        System.out.println(fuzzySearchLoop("lw", "cartwheel"));
    }

    // Stream and collection
    public static boolean fuzzySearchStream(String source, String comparing) {
        List<Character> sourceList = source.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        List<Character> compList = comparing.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        compList.retainAll(sourceList);

        String retainedStr = compList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return retainedStr.equals(source);
    }

    // Simple loop
    public static boolean fuzzySearchLoop(String source, String comparing) {
        int i = 0;
        for (int j = 0; j < comparing.length(); ++j) {
            if (i != source.length() && source.charAt(i) == comparing.charAt(j)) {
                ++i;
            }
        }
        return i == source.length();
    }
}
