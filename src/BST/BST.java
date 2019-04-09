package BST;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class BST<E extends Comparable<E>> {

    //定义树节点
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    //二分搜索树存储元素个数
    public int size() {
        return size;
    }

    //二分搜索树存储元素是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树中添加新的元素e
    public void add(E e) {
        root = add(root, e);
    }

    //向以node为根的二分搜索树中插入元素e，(递归算法)
    //返回插入新节点后二分搜索树的根
    public Node add(Node node, E e) {
        //root
        if (node == null) {
            size++;
            return new Node(e);
        }

        //root的left,right分支情况
        if (e.compareTo(node.e) < 0) {//root的left分支
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {//root的right分支
            node.right = add(node.right, e);
        }

        return node;
    }

    //查看二分搜索树是否包含元素e(从根节点开始)
    public boolean contains(E e) {
        return contains(root, e);
    }

    //查看以node为根的二分搜索树中是否包含元素e,递归算法
    private boolean contains(Node node, E e) {

        //递归终止条件
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }


    //二分搜索树的前序遍历(前序遍历：根结点 ---> 左子树 ---> 右子树)
    public void preOrder() {
        preOrder(root);
    }

    //前序遍历以node为根的二分搜索树,递归算法
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //前序遍历（非递归--使用栈实现）
    public void preOrderTraverseRN() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //二分搜索树的中序遍历(中序遍历：左子树---> 根结点 ---> 右子树)
    public void inOrder() {
        inOrder(root);
    }

    //中序遍历以node为根的二分搜索树,递归算法
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的后序遍历(后序遍历：左子树 ---> 右子树 ---> 根结点)
    public void postOrder() {
        postOrder(root);
    }

    //后序遍历以node为根的二分搜索树,递归算法
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //层次遍历--(基于队列实现)
    public void levelOrder() {

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right!=null){
                q.add(cur.right);
            }
        }
    }


}
