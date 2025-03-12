package queue;

public class XPrioryQueueEX {
    public static void main(String[] args) {
        XQueue<Integer> pq = new XPriorityQueue<>(Integer::compareTo);  // 오름차순 우선순위 큐

        pq.enqueue(30);
        pq.enqueue(10);
        pq.enqueue(20);

        System.out.println(pq.dequeue());  // 출력: 10 (우선순위가 가장 높은 값)
        pq.enqueue(5);
        System.out.println(pq.peek());  // 출력: 5
        System.out.println(pq.size());  // 출력: 3


        XQueue<String> pq1 = new XPriorityQueue<>((a, b) -> b.length() - a.length());  // 긴 문자열 우선순위

        pq1.enqueue("apple");
        pq1.enqueue("banana");
        pq1.enqueue("kiwi");

        System.out.println(pq1.dequeue());  // 출력: "banana" (가장 긴 문자열)

    }
}
