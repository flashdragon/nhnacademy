package arraylist;

import linkedlist.XList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * arraylist.XArrayList 클래스의 JUnit 테스트 클래스입니다.
 *
 * 이 클래스는 arraylist.XArrayList 클래스의 모든 메서드를 테스트합니다.
 * 각 테스트 메서드는 arraylist.XArrayList 클래스의 메서드가 올바르게 동작하는지 확인합니다.
 *
 * @author 작성자 이름
 */
class XArrayListTest {
    private XArrayList<String> arrayList;

    /**
     * 각 테스트 메서드 실행 전에 호출됩니다.
     * arraylist.XArrayList 인스턴스를 초기화합니다.
     */
    @BeforeEach
    void setUp() {
        arrayList = new XArrayList<>();
    }

    /**
     * XArrayList에 요소를 추가하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에 요소를 추가하고, 추가된 요소가 올바르게 저장되는지 확인합니다.
     */
    @Test
    void add_element() {
        arrayList.add("element1");
        arrayList.add("element2");
        assertEquals(2, arrayList.size());
        assertEquals("element1", arrayList.get(0));
        assertEquals("element2", arrayList.get(1));
    }

    /**
     * XArrayList에 null 요소를 추가하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에 null 요소를 추가하려고 하면 IllegalArgumentException이 발생하는지 확인합니다.
     */
    @Test
    void add_element_null_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> arrayList.add(null));
    }

    /**
     * XArrayList에 특정 인덱스에 요소를 추가하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에 특정 인덱스에 요소를 추가하고, 추가된 요소가 올바르게 저장되는지 확인합니다.
     */
    @Test
    void add_index_element() {
        arrayList.add("element1");
        arrayList.add("element3");
        arrayList.add(1, "element2");
        assertEquals(3, arrayList.size());
        assertEquals("element1", arrayList.get(0));
        assertEquals("element2", arrayList.get(1));
        assertEquals("element3", arrayList.get(2));
    }

    /**
     * XArrayList에 특정 인덱스에 요소를 추가하는 메서드에서 인덱스 범위를 벗어나는 경우를 테스트합니다.
     *
     * 이 테스트는 XArrayList에 특정 인덱스에 요소를 추가하려고 할 때 인덱스가 범위를 벗어나면
     * IndexOutOfBoundsException이 발생하는지 확인합니다.
     */
    @Test
    void add_index_element_outOfBounds_throwsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(1, "element"));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(-1, "element"));
    }

    /**
     * XArrayList에 특정 인덱스에 null 요소를 추가하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에 특정 인덱스에 null 요소를 추가하려고 하면 IllegalArgumentException이 발생하는지
     * 확인합니다.
     */
    @Test
    void add_index_element_null_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> arrayList.add(0, null));
    }

    /**
     * XArrayList에서 특정 인덱스의 요소를 제거하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에서 특정 인덱스의 요소를 제거하고, 제거된 요소가 올바르게 반환되는지 확인합니다.
     */
    @Test
    void remove_index() {
        arrayList.add("element1");
        arrayList.add("element2");
        arrayList.add("element3");
        String removedElement = arrayList.remove(1);
        assertEquals("element2", removedElement);
        assertEquals(2, arrayList.size());
        assertEquals("element1", arrayList.get(0));
        assertEquals("element3", arrayList.get(1));
    }

    /**
     * XArrayList에서 특정 인덱스의 요소를 제거하는 메서드에서 인덱스 범위를 벗어나는 경우를 테스트합니다.
     *
     * 이 테스트는 XArrayList에서 특정 인덱스의 요소를 제거하려고 할 때 인덱스가 범위를 벗어나면
     * IndexOutOfBoundsException이 발생하는지 확인합니다.
     */
    @Test
    void remove_index_outOfBounds_throwsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(0)); // Empty list
        arrayList.add("element1");
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(1));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(-1));
    }

    /**
     * XArrayList에서 특정 요소를 제거하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에서 특정 요소를 제거하고, 제거된 요소가 올바르게 반환되는지 확인합니다.
     */
    @Test
    void remove_element() {
        arrayList.add("element1");
        arrayList.add("element2");
        arrayList.add("element3");
        boolean removed = arrayList.remove("element2");
        assertTrue(removed);
        assertEquals(2, arrayList.size());
        assertEquals("element1", arrayList.get(0));
        assertEquals("element3", arrayList.get(1));
    }

    /**
     * XArrayList에서 존재하지 않는 요소를 제거하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에서 존재하지 않는 요소를 제거하려고 하면 제거되지 않고, false가 반환되는지 확인합니다.
     */
    @Test
    void remove_element_notExists() {
        arrayList.add("element1");
        arrayList.add("element2");
        boolean removed = arrayList.remove("element4");
        assertFalse(removed);
        assertEquals(2, arrayList.size());
    }

    /**
     * XArrayList에서 null 요소를 제거하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에서 null 요소를 제거하려고 하면 IllegalArgumentException이 발생하는지 확인합니다.
     */
    @Test
    void remove_element_null_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> arrayList.remove(null));
    }

    /**
     * XArrayList에 특정 요소가 포함되어 있는지 확인하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에 특정 요소가 포함되어 있는지 확인합니다.
     */
    @Test
    void contains() {
        arrayList.add("element1");
        arrayList.add("element2");
        assertTrue(arrayList.contains("element1"));
        assertTrue(arrayList.contains("element2"));
        assertFalse(arrayList.contains("element3"));
    }

    /**
     * XArrayList에 null 요소가 포함되어 있는지 확인하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에 null 요소가 포함되어 있는지 확인하려고 하면 IllegalArgumentException이 발생하는지
     * 확인합니다.
     */
    @Test
    void contains_null_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> arrayList.contains(null));
    }

    /**
     * XArrayList에서 특정 요소의 인덱스를 찾는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에서 특정 요소의 인덱스를 찾습니다.
     */
    @Test
    void indexOf() {
        arrayList.add("element1");
        arrayList.add("element2");
        arrayList.add("element1");
        assertEquals(0, arrayList.indexOf("element1"));
        assertEquals(1, arrayList.indexOf("element2"));
        assertEquals(-1, arrayList.indexOf("element3"));
    }

    /**
     * XArrayList에서 null 요소의 인덱스를 찾는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에서 null 요소의 인덱스를 찾하려고 하면 IllegalArgumentException이 발생하는지
     * 확인합니다.
     */
    @Test
    void indexOf_null_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> arrayList.indexOf(null));
    }

    /**
     * XArrayList에서 특정 인덱스의 요소를 가져오는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에서 특정 인덱스의 요소를 가져옵니다.
     */
    @Test
    void get() {
        arrayList.add("element1");
        arrayList.add("element2");
        assertEquals("element1", arrayList.get(0));
        assertEquals("element2", arrayList.get(1));
    }

    /**
     * XArrayList에서 특정 인덱스의 요소를 가져오는 메서드에서 인덱스 범위를 벗어나는 경우를 테스트합니다.
     *
     * 이 테스트는 XArrayList에서 특정 인덱스의 요소를 가져하려고 할 때 인덱스가 범위를 벗어나면
     * IndexOutOfBoundsException이 발생하는지 확인합니다.
     */
    @Test
    void get_outOfBounds_throwsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(0)); // Empty list
        arrayList.add("element1");
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(-1));
    }

    /**
     * XArrayList에서 특정 인덱스의 요소를 수정하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에서 특정 인덱스의 요소를 수정합니다.
     */
    @Test
    void set() {
        arrayList.add("element1");
        arrayList.add("element2");
        arrayList.set(1, "element3");
        assertEquals("element3", arrayList.get(1));
    }

    /**
     * XArrayList에서 특정 인덱스의 요소를 수정하는 메서드에서 인덱스 범위를 벗어나는 경우를 테스트합니다.
     *
     * 이 테스트는 XArrayList에서 특정 인덱스의 요소를 수정하려고 할 때 인덱스가 범위를 벗어나면
     * IndexOutOfBoundsException이 발생하는지 확인합니다.
     */
    @Test
    void set_outOfBounds_throwsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(0, "element")); // Empty list
        arrayList.add("element1");
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(1, "element"));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(-1, "element"));
    }

    /**
     * XArrayList에서 특정 인덱스에 null 요소를 수정하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에서 특정 인덱스에 null 요소를 수정하려고 하면 IllegalArgumentException이 발생하는지
     * 확인합니다.
     */
    @Test
    void set_null_throwsException() {
        arrayList.add("element1");
        assertThrows(IllegalArgumentException.class, () -> arrayList.set(0, null));
    }

    /**
     * XArrayList의 요소를 정렬하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList의 요소를 정렬합니다.
     */
    @Test
    void sort() {
        arrayList.add("banana");
        arrayList.add("apple");
        arrayList.add("cherry");
        arrayList.sort(Comparator.naturalOrder());
        assertEquals("apple", arrayList.get(0));
        assertEquals("banana", arrayList.get(1));
        assertEquals("cherry", arrayList.get(2));
    }

    /**
     * XArrayList의 부분 리스트를 가져오는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList의 부분 리스트를 가져옵니다.
     */
    @Test
    void subList() {
        arrayList.add("element1");
        arrayList.add("element2");
        arrayList.add("element3");
        XList<String> subList = arrayList.subList(0, 2);
        assertEquals(2, subList.size());
        assertEquals("element1", subList.get(0));
        assertEquals("element2", subList.get(1));
    }

    /**
     * XArrayList의 부분 리스트를 가져오는 메서드에서 인덱스 범위를 벗어나는 경우를 테스트합니다.
     *
     * 이 테스트는 XArrayList의 부분 리스트를 가져하려고 할 때 인덱스가 범위를 벗어나면 IndexOutOfBoundsException이
     * 발생하는지 확인합니다.
     */
    @Test
    void subList_outOfBounds_throwsException() {
        arrayList.add("element1");
        arrayList.add("element2");
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.subList(-1, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.subList(0, 4));
        assertThrows(IllegalArgumentException.class, () -> arrayList.subList(2, 1));
    }

    /**
     * XArrayList에 다른 리스트의 모든 요소를 추가하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList에 다른 리스트의 모든 요소를 추가합니다.
     */
    @Test
    void addAll() {
        List<String> otherList = new ArrayList<>();
        otherList.add("element4");
        otherList.add("element5");
        arrayList.add("element1");
        arrayList.add("element2");
        arrayList.addAll(otherList);
        assertEquals(4, arrayList.size());
        assertEquals("element1", arrayList.get(0));
        assertEquals("element2", arrayList.get(1));
        assertEquals("element4", arrayList.get(2));
        assertEquals("element5", arrayList.get(3));
    }

    /**
     * XArrayList의 모든 요소를 순회하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList의 모든 요소를 순회합니다.
     */
    @Test
    void forEach() {
        arrayList.add("element1");
        arrayList.add("element2");
        // forEach method currently prints to System.out, cannot directly assert, but
        // can check for no exceptions
        assertDoesNotThrow(() -> arrayList.forEach());
        // To properly test forEach, you might need to redirect System.out or modify
        // forEach to return a value or use a Consumer.
    }

    /**
     * XArrayList의 크기를 확인하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList의 크기를 확인합니다.
     */
    @Test
    void size() {
        assertEquals(0, arrayList.size());
        arrayList.add("element1");
        assertEquals(1, arrayList.size());
        arrayList.add("element2");
        assertEquals(2, arrayList.size());
    }

    /**
     * XArrayList가 비어 있는지 확인하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList가 비어 있는지 확인합니다.
     */
    @Test
    void isEmpty() {
        assertTrue(arrayList.isEmpty());
        arrayList.add("element1");
        assertFalse(arrayList.isEmpty());
    }

    /**
     * XArrayList의 모든 요소를 제거하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList의 모든 요소를 제거합니다.
     */
    @Test
    void clear() {
        arrayList.add("element1");
        arrayList.add("element2");
        arrayList.clear();
        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

    /**
     * XArrayList의 복사본을 생성하는 메서드를 테스트합니다.
     *
     * 이 테스트는 XArrayList의 복사본을 생성합니다.
     */
    @Test
    void copy() {
        arrayList.add("element1");
        arrayList.add("element2");
        XList<String> copiedList = arrayList.copy();
        assertEquals(arrayList.size(), copiedList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            assertEquals(arrayList.get(i), copiedList.get(i));
        }
        // Ensure it's a shallow copy and not the same instance
        assertNotSame(arrayList, copiedList);
    }
}
