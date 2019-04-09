package LeetCodeSubject;
/*
* 使用虚拟头节点
* */

class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        //链表中所有节点均有头节点

        ListNode dummyHead = new ListNode(-1);//虚拟头节点
        dummyHead.next = head;

        //中间处理
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else
                prev = prev.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};

        ListNode head = new ListNode(nums);

        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 6);
        System.out.println(res);

    }
}
