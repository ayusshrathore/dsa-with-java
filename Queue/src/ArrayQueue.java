import java.util.Arrays;

public class ArrayQueue {
    private int[] data;
    private int size;
    private int front;
    private int rear;

    public ArrayQueue(int capacity) {
        data = new int[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    // Implementing enqueue and dequeue using circular array
    public void enqueue(int item) {
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }

        data[rear] = item;
        // Circular arrays are implemented using modulo arithmetic (i.e. %) to handle
        // the wrap-around case when rear is at the end of the array and front is at the
        // beginning of the array (i.e. rear == data.length - 1 && there is space
        // remaining in the array).
        rear = (rear + 1) % data.length;
        size++;
    }

    public int dequeue() {
        int item = data[front];
        data[front] = 0;
        front = (front + 1) % data.length;
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public int peek() {
        return data[front];
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
