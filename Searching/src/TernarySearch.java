public class TernarySearch {
  public int search(int[] arr, int key) {
    int index = search(arr, key, 0, arr.length - 1);
    return index;
  }

  private int search(int[] arr, int key, int left, int right) {
    if (left > right)
      return -1;
    int partitionSize = (right - left) / 2;
    int mid1 = left + partitionSize;
    int mid2 = right - partitionSize;

    if (arr[mid1] == key)
      return mid1;
    if (arr[mid2] == key)
      return mid2;
    if (key < arr[mid1])
      return search(arr, key, left, mid1 - 1);
    if (key > arr[mid2])
      return search(arr, key, mid2 + 1, right);
    else
      return search(arr, key, mid1 + 1, mid2 - 1);
  }
}
