package MapPart;

import java.util.ArrayList;

public class testMap {

    private static double testMap(Map<String, Integer> map, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());    //输出总词汇数

            for (String word : words) {
                if (map.contains(word))//当前映射中存在word
                    map.set(word, map.get(word) + 1);//将 word 对应的频率进行+1操作
                else
                    map.add(word, 1);    //给map添加词频，初始化时该次出现1次
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String filename = "pride-and-prejudice.txt";

        BSTMap<String, Integer> bstMap = new BSTMap<>();//声明基于二分搜索树的映射
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time1 + " s");

        System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + time2 + " s");

    }
}