package SetPart;
import java.util.ArrayList;

public class TestComplexity {

    //创建一个测试方法 SetPart<String> set:他们可以是实现了该接口的LinkedListSet和BSTSet对象
    private static double testSet(Set<String> set, String filename) {
        //计算开始时间
        long startTime = System.nanoTime();
        System.out.println("Pride and Prejudice");
        //新建一个ArrayList存放单词
        ArrayList<String> words1 = new ArrayList<>();
        //通过这个方法将书中所以单词存入word1中
        FileOperation.readFile(filename, words1);
        System.out.println("Total words : " + words1.size());

        //增强for循环，定一个字符串word去遍历words
        //底层的话会把ArrayList words1中的值一个一个的赋值给word
        for (String word : words1)
            set.add(word);//不添加重复元素
        System.out.println("Total  different words : " + set.getSize());

        //计算结束时间
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;//纳秒为单位
    }

    public static void main(String[] args) {
        //基于二分搜索的集合
        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, "pride-and-prejudice.txt");
        System.out.println("BSTSet:" + time1 + "s");
        System.out.println("————————————————————");
        //基于链表实现的集合
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, "pride-and-prejudice.txt");
        System.out.println("linkedListSet:" + time2 + "s");

    }

}
