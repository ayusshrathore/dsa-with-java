public class JumpSearch {
  public int search(int[] arr, int key) {
    int blockSize = (int) Math.sqrt(arr.length);
    int start = 0;
    int next = blockSize;

    while (start < arr.length && arr[next - 1] < key) {
      start = next;
      next += blockSize;
      if (next > arr.length)
        next = arr.length;
    }
    for (int i = start; i < next; i++)
      if (arr[i] == key)
        return i;
    return -1;
  }
}
