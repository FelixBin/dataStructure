/**
 * 1.从封装int类型数组开始
 */
package Array;


public class Array {
    //使用private 的目的是防止用户从外界修改，造成数据不一致
    private int[] data;
    private int size;//数组中元素个数

    //构造函数，传入数组的容量capacity构造Array函数
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    //无参构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    //获取数组中元素个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //获取数据是否为空
    public boolean iEmpty() {
        return size == 0;
    }

    //向所有元素后添加元素
    public void addLast(int e) {
        add(size, e);//size表示此时的最后一个元素
    }

    //在所有元素之前添加一个新元素
    public void addFirst(int e) {
        add(0, e);//0表示第一个位置
    }

    //在第index个位置插入一个新元素
    public void add(int index, int e) {
        //(1)先判断当前数组容量是否已满，未满则转入(2),否则抛出异常
        if (size == data.length) {
            throw new IllegalArgumentException("数组已满");
        }

        //(2)判断当前需要插入值的位置是否合理，合理则转入(3),否则抛出位置不合法异常
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("您选择的位置不合法");
        }

        //将index位置之后的元素往后依次移动一位
        for (int i = size - 1; i >= index; i--) {
            //(3)将index之后的元素依次往后移动一位，然后将新元素插入到index位置
            data[i + 1] = data[i];
        }
        data[index] = e;
        //(4)维护size值
        size++;
    }

    //获取index索引位置的元素
    int get(int index) {
        //(1)判断当前需要插入值的位置是否合理，合理则转入(2),否则抛出位置不合法异常
        if (index < 0 || index > size)
            throw new IllegalArgumentException("您选择的位置不合法");

        //(2)返回索引index对应的值
        return data[index];
    }

    //获取最后一个元素
    int getLast() {
        return get(size - 1);
    }

    //获取第一个元素
    int getFirst() {
        return get(0);
    }

    //修改index索引位置的元素为e
    void set(int index, int e) {
        //(1)判断当前需要插入值的位置是否合理，合理则转入(2),否则抛出位置不合法异常
        if (index < 0 || index > size)
            throw new IllegalArgumentException("您选择的位置不合法");

        //(2)修改索引index对应的值
        data[index] = e;
    }

    //查找数组中是否包含元素e
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }
        return false;
    }

    //查找数组中元素e所在的索引（只是一个），如果不存在元素e，则返回-1；
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回删除的元素
    public int remove(int index) {
        //1.判断索引的选择是否合法
        if (index < 0 || index > size)
            throw new IllegalArgumentException("您选择的位置不合法");

        //2.先存储需要删除的索引对应的值
        int ret = data[index];

        //将索引为index之后（index）的元素依次向前移动
        for (int i = index + 1; i < size; i++) {
            //3.执行删除--实质为索引为index之后（index）的元素依次向前移动，将元素覆盖
            data[i - 1] = data[i];
        }
        //4.维护size变量
        size--;

        //5.返回被删除的元素
        return ret;
    }

    //从数组中删除第一个元素，返回删除的元素
    public int removeFirst() {
        return remove(0);
    }

    //从数组中删除最后一个元素，返回删除的元素
    public int removeLast() {
        return remove(size - 1);
    }

    //从数组中删除元素（只是删除一个）
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d, capacity=%d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");

            }
        }
        res.append(']');
        return res.toString();
    }

}
