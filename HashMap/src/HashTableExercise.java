import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableExercise {

    public int mostFrequent(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (var number : numbers) {
            // getOrDefault returns the value associated with the key, or the
            // default value if the key is not present in the map.
            var count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }

        int max = -1;
        int result = numbers[0];
        for (var item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                result = item.getKey();
            }
        }

        return result;
    }

    public int countPairsWithDiff(int[] numbers, int k) {
        Set<Integer> set = new HashSet<>();

        for (var number : numbers)
            set.add(number);

        int count = 0;
        for (var number : numbers) {
            if (set.contains(number + k))
                count++;
            if (set.contains(number - k))
                count++;
            set.remove(number);
        }
        return count;
    }
}