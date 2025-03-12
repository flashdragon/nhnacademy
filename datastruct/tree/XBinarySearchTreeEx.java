package tree;

public class XBinarySearchTreeEx {
    public static void main(String[] args) {
        XBinaryTree<Integer> bst = new XBinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.println(bst.search(4));  // 출력: true
        System.out.println(bst.search(10)); // 출력: false
        System.out.println(bst.size());     // 출력: 7
        System.out.println(bst.height());   // 출력: 2

        System.out.println(bst.inorderTraversal()); // 출력: 2 3 4 5 6 7 8

        XBinaryTree<Integer> bst1 = new XBinarySearchTree<>();
        bst1.insert(10);
        bst1.insert(5);
        bst1.insert(15);
        bst1.insert(3);
        bst1.insert(7);

        bst1.delete(5); // 5 삭제

        System.out.println(bst1.size());   // 출력: 4
        System.out.println(bst1.search(5)); // 출력: false

        System.out.println(bst1.inorderTraversal()); // 출력: 3 7 10 15

    }
}
