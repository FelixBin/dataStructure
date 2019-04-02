package Stack;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<E>();
    }

    //栈中元素个数
    @Override
    public int getSize() {
        return list.getSize();
    }

    //栈中是否为空
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    //在栈中添加元素
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    //从栈中删除第一个元素
    @Override
    public E pop() {
        return list.removeFirst();
    }

    //查看栈中第一个元素
    @Override
    public E peek() {
        return list.getFirst();
    }


    //主要是便于输出给对象信息
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }


    //测试
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        System.out.println("出栈一个元素：");
        stack.pop();
        System.out.println(stack);
    }
}
