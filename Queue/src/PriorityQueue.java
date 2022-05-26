import java.util.Arrays;

// Priority Queue is a data structure that stores elements of the same type in a sorted order.
public class PriorityQueue {
    private int[] items;
    private int count;

    public void add(int item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        var i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    public int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }
        return i + 1;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
