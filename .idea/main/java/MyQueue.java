public class MyQueue<E> {
    private MyLinkedList<E> list = new MyLinkedList<>();

    public void enqueue(E item) {
        list.add(item);
    }

    public E dequeue() {
        if (list.isEmpty()) throw new RuntimeException("Queue is empty");
        return list.remove(0);
    }

    public E peek() {
        if (list.isEmpty()) throw new RuntimeException("Queue is empty");
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}