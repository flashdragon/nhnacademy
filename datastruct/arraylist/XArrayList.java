package arraylist;

import linkedlist.XList;

import java.util.Comparator;
import java.util.List;

/**
 * XArrayList은 linkedlist.XList 인터페이스를 구현한 클래스입니다.
 * 이 클래스는 Java Collection Framework의 ArrayList를 이용하여 XList의 기능을 구현합니다.
 * @param <T> 리스트에 저장되는 요소의 타입
 */
public class XArrayList<T> implements XList<T> {
    private T[] array;
    private int capacity;
    private int size;

    /**
     * XArrayList의 생성자입니다.
     * 내부적으로는 ArrayList를 생성하여 사용합니다.
     */
    public XArrayList() {
        this.capacity = 10;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }
    /**
     * 리스트의 끝에 요소를 추가합니다.
     * @param element 추가할 요소
     */
    @Override
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (size == capacity) {
            this.capacity = (int) (capacity * 1.5);
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < capacity; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size++] = element;
    }

    /**
     * 특정 위치에 요소를 삽입합니다.
     * @param index 삽입할 위치
     * @param element 삽입할 요소
     */
    @Override
    public void add(int index, T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        if (size == capacity) {
            this.capacity = (int) (capacity * 1.5);
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < capacity; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        for (int i = index; i < size; i++) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    /**
     * 특정 위치의 요소를 제거하고 반환합니다.
     * @param index 제거할 요소의 위치
     * @return 제거된 요소
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        T element = array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        array[size] = null;
        size--;
        return element;
    }

    /**
     * 특정 요소를 제거합니다.
     * @param element 제거할 요소
     * @return 제거에 성공하면 true, 그렇지 않으면 false
     */
    @Override
    public boolean remove(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                found = true;
            }
            if (found) {
                array[i] = array[i + 1];
            }
        }
        if (found) {
            array[size] = null;
            size--;
        }
        return found;
    }

    /**
     * 특정 요소가 리스트에 존재하는지 확인합니다.
     * @param element 확인할 요소
     * @return 요소가 존재하면 true, 그렇지 않으면 false
     */
    @Override
    public boolean contains(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 특정 요소의 인덱스를 반환합니다.
     * @param element 인덱스를 찾을 요소
     * @return 요소의 인덱스
     */
    @Override
    public int indexOf(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 특정 인덱스의 요소를 반환합니다.
     * @param index 반환할 요소의 인덱스
     * @return 요소
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return array[index];
    }

    /**
     * 특정 인덱스의 요소를 변경합니다.
     * @param index 변경할 요소의 인덱스
     * @param element 변경할 요소
     */
    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        if (element == null) {
            throw new IllegalArgumentException();
        }
        array[index] = element;
    }

    /**
     * 리스트를 정렬합니다.
     * @param comparator 정렬 기준
     */
    @Override
    public void sort(Comparator<T> comparator) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (comparator.compare(array[i], array[j]) > 0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 리스트의 일부분을 반환합니다.
     * @param fromIndex 시작 인덱스
     * @param toIndex 끝 인덱스
     * @return 부분 리스트
     */
    @Override
    public XList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size) {
            throw new IndexOutOfBoundsException("Invalid sublist range");
        }
        else if (fromIndex > toIndex) {
            throw new IllegalArgumentException("Invalid sublist range");
        }
        XArrayList<T> subList = new XArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(array[i]);
        }
        return subList;
    }

    /**
     * 다른 리스트의 모든 요소를 추가합니다.
     * @param otherList 추가할 리스트
     */
    @Override
    public void addAll(List<T> otherList) {
        boolean updated = false;
        while (size + otherList.size() > capacity) {
            capacity = (int) (capacity * 1.5);
            updated = true;
        }
        if (updated) {
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        for (int i = 0; i < otherList.size(); i++) {
            array[size + i] = otherList.get(i);
        }
        size = size + otherList.size();
    }

    /**
     * 리스트의 모든 요소를 순회합니다.
     */
    @Override
    public void forEach() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 리스트의 크기를 반환합니다.
     * @return 리스트의 크기
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 리스트가 비어있는지 확인합니다.
     * @return 리스트가 비어있으면 true, 그렇지 않으면 false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 리스트의 모든 요소를 제거합니다.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * 리스트의 복사본을 반환합니다.
     * @return 리스트의 복사본
     */
    @Override
    public XList<T> copy() {
        XArrayList<T> copy = new XArrayList<>();
        for (int i = 0; i < size; i++) {
            copy.add(array[i]);
        }
        return copy;
    }
}
