package LinkedList;

public class TestMain {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        System.out.println("============在链表头部添加============");
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        System.out.println("============修改链表============");
        linkedList.set(2, 666);
        System.out.println(linkedList);

        System.out.println("============删除链表中666节点============");
        linkedList.remove(2);
        System.out.println(linkedList);
    }
}
