package SetAndMap;

public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;


    public LinkedListSet() {
        list = new LinkedList<E>();
    }


    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }


    @Override
    public void remove(E e) {
        list.removeElement(e);
    }
}
