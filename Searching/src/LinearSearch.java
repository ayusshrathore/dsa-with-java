public class LinearSearch {
  public boolean search(int[] arr, int key) {
    if (arr.length == 0)
      return false;
    for (int e : arr)
      if (e == key)
        return true;
    return false;
  }
}
