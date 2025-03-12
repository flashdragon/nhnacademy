package set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class XHashSet<T> implements XSet<T> {

    private HashMap<T, Boolean> map;
    private ArrayList<T> keys;

    public XHashSet() {
        map = new HashMap<>();
        keys = new ArrayList<>();
    }


    @Override
    public boolean add(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (map.containsKey(element)) {
            return false;
        }
        map.put(element, true);
        keys.add(element);
        return true;
    }

    @Override
    public boolean remove(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (map.containsKey(element)) {
            map.remove(element);
            keys.remove(element);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (map.containsKey(element)) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return new SetIterator();
    }

    private class SetIterator implements Iterator<T> {
        int index = 0;
        @Override
        public boolean hasNext() {
            return index < keys.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                return null;
            }
            return keys.get(index++);
        }
    }

    @Override
    public XSet<T> union(XSet<T> other) {
        XSet<T> newSet = new XHashSet<>();
        for(T element : other) {
            newSet.add(element);
        }
        for(T element : this) {
            newSet.add(element);
        }
        return newSet;
    }

    @Override
    public XSet<T> intersection(XSet<T> other) {
        XSet<T> newSet = new XHashSet<>();
        for(T element : other) {
            if (map.containsKey(element)) {
                newSet.add(element);
            }
        }
        return newSet;
    }

    @Override
    public XSet<T> difference(XSet<T> other) {
        XSet<T> newSet = new XHashSet<>();
        for(T element : this) {
            if (!other.contains(element)) {
                newSet.add(element);
            }
        }
        return newSet;
    }

    @Override
    public XSet<T> symmetricDifference(XSet<T> other) {
        XSet<T> newSet = new XHashSet<>();
        for(T element : this) {
            if (!other.contains(element)) {
                newSet.add(element);
            }
        }
        for (T element : other) {
            if (!map.containsKey(element)) {
                newSet.add(element);
            }
        }
        return newSet;
    }

    @Override
    public boolean isSubsetOf(XSet<T> other) {
        for(T element : this) {
            if (!other.contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isSupersetOf(XSet<T> other) {
        for(T element : other) {
            if (!map.containsKey(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public XSet<T> copy() {
        XSet<T> newSet = new XHashSet<>();
        for (T element: this) {
            newSet.add(element);
        }
        return newSet;
    }
}
