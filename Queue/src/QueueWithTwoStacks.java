import java.util.Stack;

public class QueueWithTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueWithTwoStacks(int capacity) {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // O(1)
    public void enqueue(int item) {
        stack1.push(item);
    }

    // O(n)
    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        return stack2.pop();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public boolean isFull() {
        return false;
    }

    public int peek() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        if (stack2.isEmpty())
            throw new IllegalStateException("Queue is empty");

        return stack2.peek();
    }

    @Override
    public String toString() {
        return stack1.toString() + stack2.toString();
    }
}
