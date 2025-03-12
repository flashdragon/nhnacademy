package stack;

public class XStackEX {
    public static void main(String[] args) {
        XStack<Integer> stack = new XArrayStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());  // 출력: 30
        System.out.println(stack.peek()); // 출력: 20
        System.out.println(stack.size()); // 출력: 2
        System.out.println(stack.isEmpty()); // 출력: false

        stack.clear();
        System.out.println(stack.isEmpty()); // 출력: true

    }
}
