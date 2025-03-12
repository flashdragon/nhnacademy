package linkedlist;

public class XLinkedListEX {
    public static void main(String[] args) {
        XList<Integer> list = new XLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(1, 15);
        System.out.println(list.get(1)); // 출력: 15

        list.remove(Integer.valueOf(20));
        System.out.println(list.contains(20)); // 출력: false

        list.sort(Integer::compareTo);
        System.out.println(list.get(0)); // 출력: 10

        XList<Integer> copiedList = list.copy();
        System.out.println(copiedList.size()); // 출력: 2

    }
}
