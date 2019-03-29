package Array;
public class test {
    public static void main(String[] args) {

        DynamicArray<Integer> arr=new  DynamicArray<Integer>(10);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println("添加数组元素：");
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println("在数组指定索引位置插入元素e：");
        System.out.println(arr);

        System.out.println("删除数组最后一个元素：");
        arr.removeLast();
        System.out.println(arr);

    }
}
