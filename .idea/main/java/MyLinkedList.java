public class MyLinkedList<E> implements MyList<E> {
    private class MyNode {
        E data;
        MyNode next, prev;
        MyNode(E data) { this.data = data; }
    }

    private MyNode head, tail;
    private int size = 0;

    public void add(E element) {
        MyNode newNode = new MyNode(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        MyNode newNode = new MyNode(element);
        if (index == size) {
            add(element);
        } else {
            MyNode current = getNode(index);
            newNode.next = current;
            newNode.prev = current.prev;
            if (current.prev != null) current.prev.next = newNode;
            current.prev = newNode;
            if (index == 0) head = newNode;
            size++;
        }
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
    }

    public E get(int index) {
        return getNode(index).data;
    }

    public E remove(int index) {
        MyNode toRemove = getNode(index);
        if (toRemove.prev != null) toRemove.prev.next = toRemove.next;
        else head = toRemove.next;
        if (toRemove.next != null) toRemove.next.prev = toRemove.prev;
        else tail = toRemove.prev;
        size--;
        return toRemove.data;
    }

    public boolean remove(E element) {
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(element)) {
                remove(index);
                return true;
            }
            current = current.next;
            index++;
        }
        return false;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    public int indexOf(E element) {
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(element)) return i;
            current = current.next;
        }
        return -1;
    }

    public java.util.Iterator<E> iterator() {
        return new java.util.Iterator<E>() {
            private MyNode current = head;
            public boolean hasNext() { return current != null; }
            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}