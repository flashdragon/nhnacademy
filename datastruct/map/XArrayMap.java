package map;

import java.util.HashSet;
import java.util.Set;

public class XArrayMap<K, V> implements XMap<K, V> {

    private Entry<K, V>[] array;
    private int capacity;
    int size;

    public XArrayMap() {
        capacity = 10;
        array = new Entry[capacity];
        size = 0;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public V put(K key, V value) {
        if (size == capacity) {
            capacity *= 2;
            Entry<K, V>[] newArray = new Entry[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        for (int i = 0; i < size; i++) {
            Entry<K, V> entry = array[i];
            if (entry.key.equals(key)) {
                entry.value = value;
                return entry.value;
            }
        }
        array[size] = new Entry<>(key, value);
        size++;
        return value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            Entry<K, V> entry = array[i];
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            Entry<K, V> entry = array[i];
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < size; i++) {
            Entry<K, V> entry = array[i];
            if (entry.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V remove(K key) {
        boolean found = false;
        V value = null;
        for (int i = 0; i < size; i++) {
            Entry<K, V> entry = array[i];
            if (entry.key.equals(key)) {
                found = true;
                value = entry.value;
            }
            if (found && i < size - 1) {
                array[i] = array[i + 1];
            }
        }
        if (found) {
            array[size] = null;
            size--;
        }
        return value;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(array[i].key);
        }
        return set;
    }

    @Override
    public Set<V> values() {
        Set<V> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(array[i].value);
        }
        return set;
    }
}
