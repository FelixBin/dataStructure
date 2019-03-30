package Queue;

public class TestMain {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if(i%3==2){//每添加3个元素出队列一个
                queue.dequeue();
                System.out.println(queue);
            }

        }

    }
}
