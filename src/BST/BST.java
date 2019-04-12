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
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    // 寻找二分搜索树的最小元素
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        Node ninNode = minimum(root);
        return ninNode.e;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        //返回相应的节点的左子树的最小值
        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maxmum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        Node maxNode = maxmum(root);

        return maxNode.e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maxmum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maxmum(node.right);
    }


    public E removeMin() {
        E ret = minimum();//获取最小元素
        root = removeMin(root);

        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {

        // 递归的终止条件，当前节点没有左子树了，那么就是最小节点了
        // 如果是最小节点，我们要做的是删除当前节点，但是当前节点很可能是有右子树的
        // 我们先把该节点的右子树节点保存，然后就删除掉该右子树节点，最后把右子树节点返回即可
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null; //左节点为空了，让右子树也为空，相当于脱离了树
            size--;
            return rightNode;//返回右子树是为了后面的绑定操作
        }

        // 没有递归到底的情况，那么就递归调用其左子树，这个调用的过程会返回被删除节点的右子树，
        //将返回的右子树重新绑定到上一层的node的左节点上就相当于彻底删除了那个元素
        node.left = removeMin(node.left);

        return node;// 删除后，根节点依然是node，返回即可
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax() {
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);//等号"="左边的相当于上一次的right,右边相当于下一次返回的结果
        return node;

    }

    //从二叉搜索树中删除元素为e的节点
    public void remove(E e) {
        root = remove(root, e);
    }

    //删除以node为根的二叉搜索树中值为e的节点，递归算法
    //返回删除节点后更新的二叉搜索树的根
    private Node remove(Node node, E e) {
        if (node == null)
            return null;

        if (e.compareTo(node.e) < 0) {//e<node.e (被删除元素e小于当前节点值e)
            node.left = remove(node.left, e);
            return node;
        }
        if (e.compareTo(node.e) > 0) {//e>node.e  (被删除元素e大于当前节点值e)
            node.right = remove(node.right, e);
            return node;
        } else {//e==node.e

            //待删除节点左子树为空情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            //待删除节点右子树为空情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //左右子树均不为空
            //方法：找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;

            return successor;
        }
    }

}
