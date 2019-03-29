package Stack;

public interface Stack<E> {

    //栈中元素个数
    int getSize();

    //栈中元素个数是否为空
    boolean isEmpty();

    //进栈
    void push(E e);

    //出栈
    E pop();

    //查看栈顶元素
    E peek();
}
