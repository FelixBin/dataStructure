package Stack;

public class TestMain {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        System.out.println("出栈");
        stack.pop();
        System.out.println(stack);
    }
}
