import java.util.*;
import java.util.stream.*;

public class CharFrequency {
    public static void main(String[] args) {
        String word = "banana";

        Map<Character, Long> characterFrequency = word.chars()
                .mapToObj(c -> (char) c) // converting int → char (e.g. 98 → 'b')
                .collect(Collectors.groupingBy(
                        c -> c,                      // grouping by the character itself
                        Collectors.counting()        // counting how many times each shows up
                ));

        // 📢 Step 2: Let’s nicely print out the result
        System.out.println("Frequency of each character in " + word + ":");
        characterFrequency.forEach((character, count) ->
                System.out.println(character + " → " + count)

        );
    }
}
