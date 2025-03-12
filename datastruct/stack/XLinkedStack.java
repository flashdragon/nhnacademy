package stack;

import linkedlist.XLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class XLinkedStack<T> implements XStack<T> {

    private XLinkedList<T> list;

    public XLinkedStack() {
        list = new XLinkedList<>();
    }

    @Override
    public void push(T element) {
        list.add(element);
    }

    @Override
    public T pop() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        }
        return list.remove(list.size() - 1);
    }

    @Override
    public T peek() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        }
        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int current;

        public StackIterator() {
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < list.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("stack is empty");
            }
            T element = list.get(current);
            current++;
            return element;
        }
    }
}
