public class MyArrayList<E> implements MyList<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            Object[] newArray = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    public void add(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (E) elements[index];
    }

    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        E removed = (E) elements[index];
        int moveCount = size - index - 1;
        if (moveCount > 0) {
            System.arraycopy(elements, index + 1, elements, index, moveCount);
        }
        elements[--size] = null;
        return removed;
    }

    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) elements[i] = null;
        size = 0;
    }

    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) return i;
        }
        return -1;
    }

    public java.util.Iterator<E> iterator() {
        return new java.util.Iterator<E>() {
            private int cursor = 0;
            public boolean hasNext() { return cursor < size; }
            public E next() { return (E) elements[cursor++]; }
        };
    }
}