public interface MyList<E> extends Iterable<E> {
    void add(E element);
    void add(int index, E element);
    E get(int index);
    E remove(int index);
    boolean remove(E element);
    int size();
    boolean isEmpty();
    void clear();
    boolean contains(E element);
    int indexOf(E element);
}