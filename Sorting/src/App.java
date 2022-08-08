import java.util.Arrays;

public class App {
	public static void main(String[] args) throws Exception {
		int[] arr = { 8, 2, 4, 1, 3 };
		// var sorter = new BubbleSort();
		// var sorter = new SelectionSort();
		// var sorter = new InsertionSort();
		// var sorter = new MergeSort();
		var sorter = new QuickSort();
		sorter.sort(arr, 0, 4);
		System.out.println(Arrays.toString(arr));
	}
}
