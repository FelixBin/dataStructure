package Queue;

public class LinkedListQueue<E> implements Queue<E> {

    //将Node节点设计成私有的类中类
    private class Node<E> {
        public E e;
        public Node next;

        //两个参数的构造函数
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        //一个参数的构造函数
        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        //无参构造函数
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node<E> head, tail;

    private int size;


    //显示初始化
    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    //获取队列中节点个数
    @Override
    public int getSize() {
        return size;
    }

    //队列中是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //进队操作
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    //出队操作
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("链表为空");
        }

        Node<E> retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {//当链表只有一个元素时
            tail = null;
        }

        size--;
        return retNode.e;
    }

    //获取队首元素
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("链表为空");
        }
        return head.e;
    }


    //为了便于测试，重写object类toString()方法
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node<E> cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }


    //测试用例
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {//每添加3个元素出队列一个
                queue.dequeue();
                System.out.println(queue);
            }

        }

    }
}
