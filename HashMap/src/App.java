import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "John");
        map.put(2, "Jane");
        map.put(3, "Jack");
        System.out.println(map);

        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = scanner.nextInt();

        int k = scanner.nextInt();
        scanner.close();
        var hashTableExercise = new HashTableExercise();
        System.out.println(hashTableExercise.countPairsWithDiff(numbers, k));
    }
}
