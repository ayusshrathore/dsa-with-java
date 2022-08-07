import java.util.HashMap;
import java.util.HashSet;

public class CharFinder {
    private String str;

    public CharFinder(String input) {
        this.str = input;
    }

    public char getFirstNonRepeatedChar() {
        var map = new HashMap<Character, Integer>();
        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (char ch : str.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return ' ';
    }

    public char getFirstRepeatedChar() {
        var set = new HashSet<Character>();
        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return ch;
            } else {
                set.add(ch);
            }
        }

        return ' ';
    }

}
