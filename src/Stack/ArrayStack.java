package Stack;

import Array.GenericArray;

public class ArrayStack<E> implements Stack<E> {
    GenericArray<E> array;

    //构造函数，传入栈的容量capacity构造函数
    public ArrayStack(int capacity) {
        array = new GenericArray<E>(capacity);
    }

    //无参构造函数，默认栈的容量capacity=10
    public ArrayStack() {
        array = new GenericArray<E>();
    }

    //获取栈中元素个数
    @Override
    public int getSize() {
        return array.getSize();
    }

    //获取栈中元素数据是否为空
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    //获取栈的容量
    public int getCapacity() {
        return array.getCapacity();
    }

    //进栈操作
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    //出栈操作
    @Override
    public E pop() {
        return array.removeLast();
    }

    //查看栈顶元素
    @Override
    public E peek() {
        return array.getLast();
    }

    //重写object类的toString方法
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(",");
            }
        }
        res.append("] top");//体现右侧为栈顶
        return res.toString();
    }

}
