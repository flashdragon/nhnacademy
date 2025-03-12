package linkedlist;

import java.util.Comparator;
import java.util.List;

public class XLinkedList<T> implements XList<T> {

    public Node<T> head = new Node<>();

    @Override
    public void add(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        Node<T> cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        Node<T> temp = new Node<>();
        temp.data = element;
        cur.next = temp;
    }

    @Override
    public void add(int index, T element) {
        Node<T> cur = head;
        int id = 0;
        while (cur.next != null) {
            if (id == index) {
                Node<T> temp = new Node<>();
                temp.data = element;
                temp.next = cur.next;
                cur.next = temp;
                break;
            }
            cur = cur.next;
            id++;
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        T result = null;
        Node<T> cur = head;
        int id = 0;
        while (cur.next != null) {
            if (id == index) {
                result = cur.next.data;
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
            id++;
        }
        return result;
    }

    @Override
    public boolean remove(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        Node<T> cur = head;
        while (cur.next != null) {
            if (cur.next.data.equals(element)) {
                cur.next = cur.next.next;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        Node<T> cur = head;
        while (cur.next != null) {
            if (cur.next.data.equals(element)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        Node<T> cur = head;
        int id = 0;
        while (cur.next != null) {
            if (cur.next.data.equals(element)) {
                return id;
            }
            cur = cur.next;
            id++;
        }
        return -1;
    }

    @Override
    public T get(int index) {
        Node<T> cur = head;
        int id = 0;
        while (cur.next != null) {
            if (id == index) {
                return cur.next.data;
            }
            cur = cur.next;
            id++;
        }
        if (index >= id) {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    @Override
    public void set(int index, T element) {
        Node<T> cur = head;
        int id = 0;
        while (cur.next != null) {
            if (id == index) {
                cur.next.data = element;
            }
            cur = cur.next;
            id++;
        }
    }

    @Override
    public void sort(Comparator<T> comparator) {
        int size = size();
        if(size == 0 || size == 1) {return;}
        for (int i = 0 ; i < size(); i++) {
            Node<T> cur = head;
            while (cur.next.next != null) {
                if (comparator.compare(cur.next.data, cur.next.next.data) > 0) {
                    Node<T> temp = cur.next;
                    cur.next = cur.next.next;
                    temp.next = cur.next.next;
                    cur.next.next = temp;
                }
                cur = cur.next;
            }
        }
    }

    @Override
    public XList<T> subList(int fromIndex, int toIndex) {
        XList<T> newList = new XLinkedList<>();
        Node<T> cur = head;
        int id = 0;
        while (cur.next != null) {
            if (fromIndex <= id && id < toIndex) {
                newList.add(cur.next.data);
            }
            else if (id == toIndex) {
                break;
            }
            cur = cur.next;
            id++;
        }
        return newList;
    }

    @Override
    public void addAll(List<T> otherList) {
        otherList.forEach(this::add);
    }

    @Override
    public void forEach() {
        Node<T> cur = head;
        while (cur.next != null) {
            System.out.println(cur.next.data);
            cur = cur.next;
        }
    }

    @Override
    public int size() {
        Node<T> cur = head;
        int size = 0;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        Node<T> cur = head;
        return cur.next == null;
    }

    @Override
    public void clear() {
        Node<T> cur = head;
        cur.next = null;
    }

    @Override
    public XList<T> copy() {
        XList<T> newList = new XLinkedList<>();
        newList = this.subList(0, size());
        return newList;
    }
}
