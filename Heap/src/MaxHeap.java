public class MaxHeap {
  public static void heapify(int[] array) {
    for (int i = (array.length / 2) - 1; i >= 0; i--)
      heapify(array, i);
  }

  private static void heapify(int[] array, int index) {
    int largerIndex = index;
    int leftIndex = (index * 2) + 1;
    if (leftIndex < array.length && array[leftIndex] > array[largerIndex])
      largerIndex = leftIndex;

    int rightIndex = (index * 2) + 2;
    if (rightIndex < array.length && array[rightIndex] > array[largerIndex])
      largerIndex = rightIndex;

    if (index == largerIndex)
      return;

    swap(array, index, largerIndex);
    heapify(array, largerIndex);
  }

  private static void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }

  public int getKthLargest(int[] arr, int k) {
    if (k < 1 && k > arr.length)
      throw new IllegalStateException();

    Heap heap = new Heap();
    for (int e : arr)
      heap.insert(e);
    for (int i = 0; i < k - 1; i++)
      heap.remove();

    return heap.max();
  }
}
