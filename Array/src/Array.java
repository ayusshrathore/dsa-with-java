public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }
        items[count++] = item;
    }

    public void insertAt(int index) {
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }
        for (int i = count; i > index; i--)
            items[i] = items[i - 1];
        items[index] = 0;
        count++;
    }

    public void remove() {
        if (count > 0)
            count--;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i + 1];
        count--;
    }

    public int indexOf(int value) {
        for (int i = 0; i < count; i++)
            if (items[i] == value)
                return i;
        return -1;
    }

    public int max() {
        int max = items[0];
        for (int i = 1; i < count; i++)
            if (items[i] > max)
                max = items[i];
        return max;
    }

    public int min() {
        int min = items[0];
        for (int i = 1; i < count; i++)
            if (items[i] < min)
                min = items[i];
        return min;
    }

    public int[] intersect(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    result[index++] = array1[i];
                }
            }
        }
        int[] newResult = new int[index];
        for (int i = 0; i < index; i++) {
            newResult[i] = result[i];
        }
        return newResult;
    }

    public int[] reverse(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++)
            result[i] = array[array.length - i - 1];
        return result;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

}
