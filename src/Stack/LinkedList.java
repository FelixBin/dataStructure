package Stack;

public class LinkedList<E> {
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

    //定义头节点
    private Node dummyHead;

    //节点个数
    private int size;


    //无参数构造函数
    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在链表的index(0--based)的位置添加新的元素e    (实际不常用，练习用)
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("位置不合法");
        }

        Node prev = dummyHead;//初始时prev指向dummyHead
        for (int i = 0; i < index; i++) {//获取到需要添加元素位置的前一个元素  从dummyHead开始遍历
            prev = prev.next;
        }

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        prev.next = new Node(e, prev.next);

        size++;

    }

    //在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    //在链表末尾添加新的元素
    public void addLast(E e) {
        add(size, e);
    }

    //获取链表的第index（0-based）个位置的元素   (实际不常用，练习用)
    public E get(int index) {
        //合法性判断
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,Illegal index");
        }

        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    //获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }


    //修改链表的第index（0-based）个位置的元素   (实际不常用，练习用)
    public void set(int index, E e) {
        //合法性判断
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("update failed,Illegal index");
        }

        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }


    //查找链表中是否有元素e
    public boolean contains(E e) {
        Node<E> cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    //从链表删除第index（0-based）个位置的元素 ，返回删除的元素  (实际不常用，练习用)
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed,Illegal index");
        }

        //获取虚拟头节点
        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            //获取到删除元素之前节点
            prev = prev.next;
        }

        Node<E> retNode = prev.next;//被删除的元素
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    //从链表中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    //从链表中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    //重写object类，便于测试
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        for (Node<E> cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");

        return res.toString();
    }
}
