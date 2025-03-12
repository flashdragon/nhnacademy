package queue;

import linkedlist.Node;
import linkedlist.XLinkedList;
import linkedlist.XList;

import java.util.Iterator;
import java.util.Queue;

public class XListQueue<T> implements XQueue<T> {

    private XList<T> list;

    public XListQueue() {
        this.list = new XLinkedList<>();
    }

    @Override
    public boolean enqueue(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        list.add(element);
        return true;
    }

    @Override
    public T dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException();
        }
        return list.remove(0);
    }

    @Override
    public T peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException();
        }
        return list.get(0);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public XQueue<T> copy() {
        XQueue<T> copy = new XListQueue<>();
        for (int i = 0; i < list.size(); i++) {
            copy.enqueue(list.get(i));
        }
        return copy;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private int current;

        public QueueIterator() {
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return current != list.size();
        }

        @Override
        public T next() {
            T element = list.get(current);
            current = current + 1;
            return element;
        }
    }
}
