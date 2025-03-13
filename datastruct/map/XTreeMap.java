package map;

import java.util.HashSet;
import java.util.Set;

public class XTreeMap<K extends Comparable<K> , V> implements XMap<K, V> {

    public Node<Entry<K, V>> root;
    private int size;
    private V deletedValue = null;

    public XTreeMap() {
        root = null;
        size = 0;
    }

    @Override
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        Entry<K, V> entry = new Entry<>(key, value);
        root = putGo(root, entry);
        return null;
    }

    private Node<Entry<K, V>> putGo(Node<Entry<K, V>> node, Entry<K, V> entry) {
        if (node == null) {
            size++;
            return new Node<>(entry);
        }
        if (node.data.key.compareTo(entry.key) > 0) {
            node.left = putGo(node.left, entry);
            return node;
        }
        else if (node.data.key.compareTo(entry.key) < 0) {
            node.right = putGo(node.right, entry);
            return node;
        }
        else {
            node.data.value = entry.value;
            return node;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        return getGo(root, key);
    }
    private V getGo(Node<Entry<K, V>> node ,K key) {
        if (node == null) {
            return null;
        }
        if (node.data.key.compareTo(key) > 0) {
            return getGo(node.left, key);
        }
        else if (node.data.key.compareTo(key) < 0) {
            return getGo(node.right, key);
        }
        else {
            return node.data.value;
        }
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        return containsKeyGo(root, key);
    }

    private boolean containsKeyGo(Node<Entry<K,V>> node, K key) {
        if (node == null) {
            return false;
        }
        if (node.data.key.compareTo(key) > 0) {
            return containsKeyGo(node.left, key);
        }
        else if (node.data.key.compareTo(key) < 0) {
            return containsKeyGo(node.right, key);
        }
        else {
            return true;
        }
    }


    @Override
    public boolean containsValue(V value) {
        if (value == null) {
            throw new NullPointerException();
        }
        return containsValueGo(root, value);
    }

    private boolean containsValueGo(Node<Entry<K,V>> node, V value) {
        if (node == null) {
            return false;
        }
        if (node.data.value.equals(value)) {
            return true;
        }
        return containsValueGo(node.right, value) || containsValueGo(node.left, value) ;
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        deletedValue = null;
        root = removeGo(root, key);
        return deletedValue;
    }

    private Node<Entry<K, V>> removeGo(Node<Entry<K,V>> node, K key) {
        if (node == null) {
            return null;
        }
        if (node.data.key.compareTo(key) > 0) {
            node.left = removeGo(node.left, key);
            return node;
        }
        else if (node.data.key.compareTo(key) < 0) {
            node.right = removeGo(node.right, key);
            return node;
        }
        else {
            size--;
            deletedValue = node.data.value;
            if (node.left == null && node.right == null) {
                return null;
            }
            else if (node.left == null) {
                return node.right;
            }
            else if (node.right == null) {
                return node.left;
            }
            else {
                return highToHigh(node.left, node.right);
            }
        }
    }

    private Node<Entry<K,V>> highToHigh(Node<Entry<K,V>> node, Node<Entry<K,V>> high) {
        if (node.right == null) {
            node.right = high;
            return node;
        }
        return highToHigh(node.right, high);
    }

    @Override
    public void clear() {
        root = null;
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
        HashSet<K> set = new HashSet<>();
        keySetGo(root, set);
        return set;
    }

    private void keySetGo(Node<Entry<K,V>> node, HashSet<K> set) {
        if (node == null) {
            return;
        }
        set.add(node.data.key);
        keySetGo(node.left, set);
        keySetGo(node.right, set);
    }

    @Override
    public Set<V> values() {
        HashSet<V> set = new HashSet<>();
        valueSetGo(root, set);
        return set;
    }

    private void valueSetGo(Node<Entry<K,V>> node, HashSet<V> set) {
        if (node == null) {
            return;
        }
        set.add(node.data.value);
        valueSetGo(node.left, set);
        valueSetGo(node.right, set);
    }

    private static class Entry<K, V> {
        K key;
        V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        public Node(T data) {
            this.data = data;
        }
    }
}
