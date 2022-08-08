public class ExponentialSearch {
  public int search(int[] arr, int key) {
    int bound = 1;
    while (bound < arr.length && arr[bound] < key)
      bound *= 2;
    int left = bound / 2;
    int right = Math.min(bound, arr.length - 1);
    return binSearch(arr, key, left, right);
  }

  public int binSearch(int[] arr, int key, int left, int right) {
    while (left <= right) {
      int mid = (left + right) / 2;
      if (arr[mid] == key)
        return mid;
      if (key > arr[mid])
        left = mid + 1;
      else
        right = mid - 1;
    }
    return -1;
  }
}
