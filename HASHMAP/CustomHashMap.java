package HASHMAP;

import java.util.LinkedList;

public class CustomHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private static final int INITIAL_CAPACITY = 16;

    public CustomHashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
    }

    private int getIndex(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % table.length);
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        if (table[index] == null)
            return null;
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        if (table[index] == null)
            return;
        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                toRemove = entry;
                break;
            }
        }
        if (toRemove != null) {
            table[index].remove(toRemove);
            size--;
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        System.out.println(map.get("One"));
        map.remove("One");
        System.out.println(map.get("One"));
    }
}
