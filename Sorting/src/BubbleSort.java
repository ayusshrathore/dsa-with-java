public class BubbleSort {
  public void sort(int[] arr) {
    boolean isSorted;
    for (int i = 0; i < arr.length; i++) {
      isSorted = true;
      for (int j = 1; j < arr.length - i; j++) {
        if (arr[i] > arr[j]) {
          int temp = arr[j];
          arr[i] = arr[j];
          arr[j] = temp;
          isSorted = false;
        }
      }
      if (isSorted)
        return;
    }
  }
}
