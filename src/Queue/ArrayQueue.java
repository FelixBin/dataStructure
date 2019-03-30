package Queue;

public class ArrayQueue<E> implements Queue<E> {
    private DynamicArray<E> array;


    //构造函数，传入队列的容量capacity构造函数
    public ArrayQueue(int capacity) {
        array = new DynamicArray<E>(capacity);
    }

    //无参构造函数，默认队列的容量capacity=10
    public ArrayQueue() {
        array = new DynamicArray<E>();
    }

    //获取队列中元素数据是否为空
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    //获取队列中元素个数
    @Override
    public int getSize() {
        return array.getSize();
    }

    //获取队列的容量
    public int getCapacity() {
        return array.getCapacity();
    }

    //入队操作
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    //出队操作
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    //获取队首元素
    @Override
    public E getFront() {
        return array.getFirst();
    }

    //重写object类的toString方法
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue:");
        res.append("front [");//体现左侧为队首
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(",");
            }
        }
        res.append("] rear");//体现右侧为队尾
        return res.toString();
    }
}
