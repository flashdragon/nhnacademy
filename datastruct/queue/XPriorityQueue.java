package queue;

import linkedlist.XLinkedList;
import linkedlist.XList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class XPriorityQueue<T> implements XQueue<T> {

    PriorityQueue<T> priorityQueue;
    private XList<T> queue;
    private Comparator<T> comparator;

    public XPriorityQueue() {
        comparator = null;
    }

    public XPriorityQueue(Comparator<T> comparator) {
        queue = new XLinkedList<>();
        this.comparator = comparator;
    }

    @Override
    public boolean enqueue(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < queue.size(); i++) {
            if (comparator == null) {
                Comparable<? super T> key = (Comparable<? super T>) element;
                if (key.compareTo((T) queue.get(i)) > 0) {
                    queue.add(i, element);
                    return true;
                }
            }
            if (comparator.compare(queue.get(i), element) > 0) {
                queue.add(i, element);
                return true;
            }
        }
        queue.add(element);
        return true;
    }

    @Override
    public T dequeue() {
        if (queue.isEmpty()) {
            throw new NullPointerException();
        }
        return queue.remove(0);
    }

    @Override
    public T peek() {
        if (queue.isEmpty()) {
            throw new NullPointerException();
        }
        return queue.get(0);
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public XQueue<T> copy() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
