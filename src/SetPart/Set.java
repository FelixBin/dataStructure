package SetPart;

/**
 * 集合的接口
 */
public interface Set<E> {
    void add(E e);//添加  <——<不能添加重复元素

    void remove(E e);//移除

    int getSize();//获取大小

    boolean isEmpty();//是否为空

    boolean contains(E e);//是否包含元素

}