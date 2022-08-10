import java.util.Arrays;

public class App {
  public static void main(String[] args) {
    Heap heap = new Heap();
    heap.insert(10);
    heap.insert(5);
    heap.insert(17);
    heap.insert(4);
    heap.insert(22);
    heap.remove();
    // System.out.println("Heap");

    // Heap Sort
    int[] numbers = { 5, 4, 1, 10, 2, 3 };
    Heap nums = new Heap();
    for (int num : numbers)
      nums.insert(num);
    for (int i = numbers.length - 1; i >= 0; i--)
      numbers[i] = nums.remove();
    System.out.println(Arrays.toString(numbers));

    // Heapify
    MaxHeap.heapify(numbers);
    System.out.println(Arrays.toString(numbers));

  }
}
