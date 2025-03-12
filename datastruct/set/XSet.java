package set;
import java.util.Iterator;

/**
 * XSet 인터페이스는 집합 연산을 지원합니다. 이 인터페이스를 구현하는 클래스는 집합의 기본적인 기능을 제공합니다.
 *
 * @param <T> 저장할 요소의 타입
 */
public interface XSet<T> extends Iterable<T> {

    /**
     * 요소를 추가합니다.
     *
     * @param element 추가할 요소
     * @return 요소가 성공적으로 추가되었으면 true, 이미 존재하는 요소면 false를 반환합니다.
     */
    boolean add(T element);

    /**
     * 요소를 제거합니다.
     *
     * @param element 제거할 요소
     * @return 요소가 성공적으로 제거되었으면 true, 존재하지 않는 요소면 false를 반환합니다.
     */
    boolean remove(T element);

    /**
     * 요소가 포함되어 있는지 확인합니다.
     *
     * @param element 확인할 요소
     * @return 요소가 포함되어 있으면 true, 포함되어 있지 않으면 false를 반환합니다.
     */
    boolean contains(T element);

    /**
     * 집합의 크기를 반환합니다.
     *
     * @return 집합의 크기
     */
    int size();

    /**
     * 집합을 비워줍니다.
     */
    void clear();

    /**
     * 집합이 비어 있는지 확인합니다.
     *
     * @return 집합이 비어 있으면 true, 비어 있지 않으면 false를 반환합니다.
     */
    boolean isEmpty();

    /**
     * 집합의 반복자를 반환합니다.
     *
     * @return 집합의 반복자
     */
    Iterator<T> iterator();

    /**
     * 다른 집합과 합집합을 반환합니다.
     *
     * @param other 다른 집합
     * @return 합집합
     */
    XSet<T> union(XSet<T> other);

    /**
     * 다른 집합과 교집합을 반환합니다.
     *
     * @param other 다른 집합
     * @return 교집합
     */
    XSet<T> intersection(XSet<T> other);

    /**
     * 다른 집합과 차집합을 반환합니다.
     *
     * @param other 다른 집합
     * @return 차집합
     */
    XSet<T> difference(XSet<T> other);

    /**
     * 다른 집합과 대칭 차집합을 반환합니다.
     *
     * @param other 다른 집합
     * @return 대칭 차집합
     */
    XSet<T> symmetricDifference(XSet<T> other);

    /**
     * 다른 집합의 부분집합인지 확인합니다.
     *
     * @param other 다른 집합
     * @return 부분집합이면 true, 부분집합이 아니면 false를 반환합니다.
     */
    boolean isSubsetOf(XSet<T> other);

    /**
     * 다른 집합의 상위집합인지 확인합니다.
     *
     * @param other 다른 집합
     * @return 상위집합이면 true, 상위집합이 아니면 false를 반환합니다.
     */
    boolean isSupersetOf(XSet<T> other);

    /**
     * 집합의 복사본을 반환합니다.
     *
     * @return 집합의 복사본
     */
    XSet<T> copy();
}
