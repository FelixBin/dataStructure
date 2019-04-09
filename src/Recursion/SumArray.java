package Recursion;

public class SumArray {
    //调用
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    //递归实现数组相加
    private static int sum(int[] arr, int left) {
        if (left == arr.length)
            return 0;

        return arr[left] + sum(arr, left + 1);

    }

    //测试
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int value = sum(nums);
        System.out.println(value);
    }
}
