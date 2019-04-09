package BST;

public class Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        //二叉树结构
        //////////////////
        //      5       //
        //    /   \     //
        //   3     6    //
        //  / \     \  //
        // 2   4     8 //
        //////////////////

        System.out.println("前序遍历");
        bst.preOrder();
        System.out.println();

        System.out.println("中序遍历---可以得到一个排好序的");
        bst.inOrder();
        System.out.println();

        System.out.println("后序遍历---->可以用来释放内存");
        bst.postOrder();
        System.out.println();


        System.out.println("层次遍历");
        bst.levelOrder();
        System.out.println();
    }
}
