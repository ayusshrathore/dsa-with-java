public class BinarySearch {
  public int search(int[] arr, int key) {
    int index = search(arr, key, 0, arr.length - 1);
    return index;
  }

  private int search(int[] arr, int key, int left, int right) {
    if (right < left)
      return -1;
    int mid = (left + right) / 2;
    if (key == arr[mid])
      return mid;
    if (key > arr[mid])
      return search(arr, key, mid + 1, right);
    return search(arr, key, left, mid - 1);
  }

  public int binSearch(int[] arr, int key) {
    int left = 0;
    int right = arr.length - 1;

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
