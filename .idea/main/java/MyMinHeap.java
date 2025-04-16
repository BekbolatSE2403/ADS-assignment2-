public class MyMinHeap {
    private MyArrayList<Integer> heap = new MyArrayList<>();

    public void insert(int val) {
        heap.add(val);
        int i = heap.size() - 1;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(parent) <= heap.get(i)) break;
            int temp = heap.get(i);
            heap.add(i, heap.get(parent));
            heap.remove(i + 1);
            heap.add(parent, temp);
            heap.remove(parent + 1);
            i = parent;
        }
    }

    public int extractMin() {
        if (heap.isEmpty()) throw new RuntimeException("Heap is empty");
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.add(0, last);
            heap.remove(1);
            heapify(0);
        }
        return min;
    }

    private void heapify(int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int smallest = i;
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) smallest = left;
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) smallest = right;
        if (smallest != i) {
            int temp = heap.get(i);
            heap.add(i, heap.get(smallest));
            heap.remove(i + 1);
            heap.add(smallest, temp);
            heap.remove(smallest + 1);
            heapify(smallest);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }
}