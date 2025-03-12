package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class XArrayStack<T> implements XStack<T> {
    private T[] array;
    private int size;
    private int capacity;

    public XArrayStack() {
        capacity = 10;
        array = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void push(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (size == capacity) {
            T[] newArray = (T[]) new Object[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size++] = element;
    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("stack is empty");
        }
        T element = array[--size];
        array[size] = null;
        return element;
    }

    @Override
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("stack is empty");
        }
        T element = array[size - 1];
        return element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
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
            return current < size ;
        }

        @Override
        public T next() {
            T element = array[current];
            current++;
            return element;
        }
    }
}
