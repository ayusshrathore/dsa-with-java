public class Main {
    public static void main(String[] args) throws Exception {
        var numbers = new Array(3);
        numbers.insert(1);
        numbers.insert(2);
        numbers.insert(3);
        numbers.insert(4);
        numbers.removeAt(2);
        numbers.print();
        System.out.println(numbers.indexOf(4));
    }

    // ArrayList and Vectors can be used for dynamic arrays.
}
