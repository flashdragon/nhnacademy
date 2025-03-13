package map;

import java.util.*;

public class XHashMap<K, V> implements XMap<K, V>{

    private LinkedList<Entry<K, V>>[] map;
    private int size;
    private int limit;
    private int capacity;

    public XHashMap() {
        capacity = 16;
        map = new LinkedList[capacity];
        size = 0;
        limit = 0;
    }

    private class Entry<K, V>{
        K key;
        V value;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private int hashCode(K key) {
        return key.hashCode() % capacity < 0 ? key.hashCode() % capacity + capacity : key.hashCode() % capacity;
    }

    @Override
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        int index = hashCode(key);
        if (map[index] == null) {
            map[index] = new LinkedList<>();
            limit++;
            if (limit == capacity * 3 / 4) {
                resize();
            }
        }
        for (int i = 0; i < map[index].size(); i++) {
            Entry<K, V> entry = map[index].get(i);
            if (entry.key.equals(key)) {
                entry.value = value;
                return value;
            }
        }
        map[index].add(new Entry(key, value));
        size++;
        return value;
    }

    private void resize() {
        ArrayList<Entry<K, V>> list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (map[i] != null) {
                for (int j = 0; j < map[i].size(); j++) {
                    Entry<K, V> entry = map[i].get(j);
                    list.add(entry);
                }
            }
        }
        capacity = capacity * 2;
        map = new LinkedList[capacity];
        limit = 0;
        size = 0;
        for (int i = 0; i < list.size(); i++) {
            Entry<K, V> entry = list.get(i);
            put(entry.key, entry.value);
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        int index = hashCode(key);
        if (map[index] == null) {
            return null;
        }
        else {
            for (int i = 0; i < map[index].size(); i++) {
                Entry<K, V> entry = map[index].get(i);
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
            return null;
        }
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        int index = hashCode(key);
        if (map[index] == null) {
            return false;
        }
        else {
            for (int i = 0; i < map[index].size(); i++) {
                Entry<K, V> entry = map[index].get(i);
                if (entry.key.equals(key)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public boolean containsValue(V value) {
        if (value == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < capacity; i++) {
            if (map[i] != null) {
                for (int j = 0; j < map[i].size(); j++) {
                    if (map[i].get(j).value.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        int index = hashCode(key);
        if (map[index] == null) {
            return null;
        }
        else {
            for (int i = 0; i < map[index].size(); i++) {
                Entry<K, V> entry = map[index].get(i);
                if (entry.key.equals(key)) {
                    map[index].remove(i);
                    return entry.value;
                }
            }
            return null;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            map[i] = null;
        }
        size = 0;
        limit = 0;
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
        Set<K> set = new HashSet<K>();
        for (int i = 0; i < capacity; i++) {
            if (map[i] != null) {
                for (int j = 0; j < map[i].size(); j++) {
                    set.add(map[i].get(j).key);
                }
            }
        }
        return set;
    }

    @Override
    public Set<V> values() {
        Set<V> set = new HashSet<V>();
        for (int i = 0; i < capacity; i++) {
            if (map[i] != null) {
                for (int j = 0; j < map[i].size(); j++) {
                    set.add(map[i].get(j).value);
                }
            }
        }
        return set;
    }
}
