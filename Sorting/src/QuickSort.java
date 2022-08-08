public class QuickSort {
  public void sort(int[] arr, int start, int end) {
    if (start >= end)
      return;
    int boundary = partition(arr, start, end);
    sort(arr, start, boundary - 1);
    sort(arr, boundary + 1, end);
  }

  private int partition(int[] arr, int start, int end) {
    int pivot = end;
    int boundary = start - 1;
    for (int i = start; i <= end; i++) {
      if (arr[i] <= pivot) {
        boundary++;
        int temp = arr[i];
        arr[i] = arr[boundary];
        arr[boundary] = temp;
      }
    }
    return boundary;
  }
}
