import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        private Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] table;

    public void put(int key, String value) {
        var index = hash(key);
        if (table[index] == null)
            table[index] = new LinkedList<>();

        for (var entry : table[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        table[index].addLast(new Entry(key, value));
    }

    public String get(int key) {
        var index = hash(key);
        if (table[index] == null)
            return null;

        for (var entry : table[index]) {
            if (entry.key == key)
                return entry.value;
        }
        return null;
    }

    public void remove(int key) {
        var index = hash(key);
        if (table[index] == null)
            throw new IllegalArgumentException("Key not found");

        for (var entry : table[index]) {
            if (entry.key == key) {
                table[index].remove(entry);
                return;
            }
        }
        throw new IllegalArgumentException("Key not found");
    }

    private int hash(int key) {
        return key % table.length;
    }
}

// Hash function is a function that maps a key to a value. A hash function
// returns a index for the key, where the key is stored in the memory.
// Simplest example of a hash function is, for e.g we want to store 100
// employees, and we want to store them in a hash table.
// And if the employee id is 123456 or "123456-A" then we can calculate the hash
// value of the employee id as employee id % 100 and store it in the hash table.
// Similarly for "123456-A", we can calculate the hash value as numeric value of
// "123456-A" % 100 and store it in the hash table.