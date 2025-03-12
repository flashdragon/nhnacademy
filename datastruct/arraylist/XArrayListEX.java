package arraylist;

import linkedlist.XList;

public class XArrayListEX {
    public static void main(String[] args) {
        XList<Integer> myList = new XArrayList<>();

        // 요소 추가
        myList.add(10);
        myList.add(20);
        myList.add(1, 15);  // 인덱스 1에 15 삽입

        // 리스트 출력
        myList.forEach(); // 출력: 10 15 20

        // 요소 검색
        System.out.println("Index of 20: " + myList.indexOf(20)); // 2
        System.out.println("Contains 25? " + myList.contains(25)); // false

        // 요소 삭제
        myList.remove(2); // 20 삭제
        myList.forEach(); // 출력: 10 15

        // 리스트 정렬 (기본 오름차순)
        myList.add(5);
        myList.sort(Integer::compareTo);
        myList.forEach(); // 출력: 5 10 15

        // 리스트 복사 및 부분 리스트
        XList<Integer> copiedList = myList.copy();
        System.out.println("Copied List: ");
        copiedList.forEach(); // 출력: 5 10 15

        XList<Integer> subList = myList.subList(0, 2);
        System.out.println("SubList: ");
        subList.forEach(); // 출력: 5 10

        // 리스트 비우기
        myList.clear();
        System.out.println("Size after clear: " + myList.size()); // 0
    }

}
