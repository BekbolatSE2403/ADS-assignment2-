public class MyStack<E> {
    private MyArrayList<E> list = new MyArrayList<>();

    public void push(E item) {
        list.add(item);
    }

    public E pop() {
        if (list.isEmpty()) throw new RuntimeException("Stack is empty");
        return list.remove(list.size() - 1);
    }

    public E peek() {
        if (list.isEmpty()) throw new RuntimeException("Stack is empty");
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}