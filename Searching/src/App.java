public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 1, 2, 3, 4, 7, 9 };
        // var searcher = new LinearSearch();
        // var searcher = new BinarySearch();
        // var searcher = new TernarySearch();
        // var searcher = new JumpSearch();
        var searcher = new ExponentialSearch();
        System.out.println(searcher.search(arr, 4));
    }
}
