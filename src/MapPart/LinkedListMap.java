package MapPart;

public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node {
        public K key;    //定义键
        public V value;    //定义值
        public Node next;

        public Node(K key, V value, Node next) { //用户传入 key 和 value
            this.key = key;        //将用户传入的 key 赋值给 this.key
            this.value = value;    //将用户传入的 value 赋值给 this.value
            this.next = next;

        }

        public Node(K key, V value) {    //用户只传入 key
            this(key, value, null);        //value 默认为空
        }

        public Node() {        //用户 key 和 value 都没有传入
            this(null, null, null);//key 和 value 默认为空
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;    //虚拟头节点
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }

            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {        //查看是否包含键为 K 的值
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {    //查找键为 K 的对应的值 V
        Node node = getNode(key);
        return node == null ? null : node.value;    //如果 K 为空则返回的 V 也为空，否则返回 node.value
    }

    @Override
    public void add(K key, V value) {    //添加元素
        Node node = getNode(key);    //查询当前映射中是否已存在 key 对应的数据
        if (node == null) {    //如果 node 为空，
            dummyHead.next = new Node(key, value, dummyHead.next); //直接在链表头添加元素即可
            size++;
        } else
            node.value = value; //将用户传入的 value 覆盖掉之前的 value
    }

    @Override
    public void set(K key, V newValue) {        //用户指定键，希望这个键在映射中附上新的 Value
        Node node = getNode(key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");    // key 不存在无法赋值

        node.value = newValue;

    }


    @Override
    public V remove(K key) {    //删除 key 所对应的 value 值

        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key))
                break;
            prev = prev.next;
        }

        if (prev.next != null) {    //删除节点
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }

        return null;
    }


}