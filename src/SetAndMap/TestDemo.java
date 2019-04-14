package SetAndMap;
import java.util.ArrayList;


public class TestDemo {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");
        //新建一个ArrayList存放单词
        ArrayList<String> words1=new ArrayList<>();
        //通过这个方法将书中所以单词存入word1中
        FileOperation.readFile("pride-and-prejudice.txt",words1);
        System.out.println("Total words : "+words1.size());

        BSTSet<String> set1=new BSTSet<>();
        //增强for循环，定一个字符串word去遍历words
        //底层的话会把ArrayList words1中的值一个一个的赋值给word
        for(String word:words1)
            set1.add(word);//不添加重复元素
        System.out.println("Total  different words : "+set1.getSize());


        System.out.println("-------------------");
        System.out.println("Pride and Prejudice");
        //新建一个ArrayList存放单词
        ArrayList<String> words2=new ArrayList<>();
        //通过这个方法将书中所以单词存入word1中
        FileOperation.readFile("a-tale-of-two-cities.txt",words2);
        System.out.println("Total words : "+words2.size());

        BSTSet<String> set2=new BSTSet<>();
        //增强for循环，定一个字符串word去遍历words
        //底层的话会把ArrayList words1中的值一个一个的赋值给word
        for(String word:words2)
            set2.add(word);//不添加重复元素
        System.out.println("Total  different words : "+set2.getSize());

    }

}



