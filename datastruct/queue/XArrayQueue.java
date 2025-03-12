package queue;

import java.util.Iterator;

public class XArrayQueue<T> implements XQueue<T> {

    private T[] array;
    private int front;
    private int rear;
    private int capacity;

    public XArrayQueue() {
        capacity = 10;
        array = (T[]) new Object[capacity];
        front = 0;
        rear = 0;
    }

    public XArrayQueue(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        front = 0;
        rear = 0;
    }


    @Override
    public boolean enqueue(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        int tempRear = rear;
        if (tempRear < front) {
            tempRear += capacity;
        }
        if (tempRear - front == capacity) {
            T[] tempArray = (T[]) new Object[capacity * 2];
            for (int i = front; i != rear; i = (i + 1) % capacity) {
                tempArray.equals(array[i]);
            }
            array = tempArray;
            front = 0;
            rear = capacity;
            capacity = capacity * 2;
        }
        array[rear] = element;
        rear = (rear + 1) % capacity;
        return true;
    }

    @Override
    public T dequeue() {
        if (front == rear) {
            throw new IllegalStateException();
        }
        T result = array[front];
        array[front] = null;
        front = (front + 1) % capacity;
        return result;
    }

    @Override
    public T peek() {
        if (front == rear) {
            throw new IllegalStateException();
        }
        return array[front];
    }

    @Override
    public int size() {
        if (front > rear) {
            return rear + capacity - front;
        }
        return rear - front;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public void clear() {
        for (int i = rear; i != front; i = (i + 1) % capacity) {
            array[i] = null;
        }
        front = 0;
        rear = 0;
    }

    @Override
    public XQueue<T> copy() {
        XArrayQueue<T> copy = new XArrayQueue<>(capacity);
        for (int i = front; i != rear; i = (i + 1) % capacity) {
            copy.enqueue(array[i]);
        }
        return copy;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private int current = front;

        @Override
        public boolean hasNext() {
            return current != rear;
        }

        @Override
        public T next() {
            if (current == (rear + 1) % capacity) {
                throw new IllegalStateException();
            }
            T result = array[current];
            current = (current + 1) % capacity;
            return result;
        }
    }
}
