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

        // Продублировал всё в тестах
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));
        System.out.println(fuzzySearch("cwhl", "cartwheel"));
        System.out.println(fuzzySearch("cwhee", "cartwheel"));
        System.out.println(fuzzySearch("cartwheel", "cartwheel"));
        System.out.println(fuzzySearch("cwheeel", "cartwheel"));
        System.out.println(fuzzySearch("lw", "cartwheel"));
    }

    public static boolean fuzzySearch(String source, String comparing) {
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
}
