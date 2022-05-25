import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        var list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        var array = list.toArray();
        System.out.println(Arrays.toString(array));
    }
}
