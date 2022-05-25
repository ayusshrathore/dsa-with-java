import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var previous = getPreviousNode(last);
            last = previous;
            last.next = null;
        }

        size--;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        var array = new int[size];
        var current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        if (isEmpty())
            return;

        var current = first.next;
        var previous = first;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthNodeFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var current = first;
        var runner = first;
        for (int i = 0; i < k; i++) {
            if (runner == null)
                throw new IllegalArgumentException();
            runner = runner.next;
        }

        while (runner != null) {
            current = current.next;
            runner = runner.next;
        }

        return current.value;
    }

    public void printMiddle() {
        var a = first;
        var b = first;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
        }

        if (b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + " " + a.next.value);
    }

    private Node getPreviousNode(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty() {
        return first == null;
    }
}