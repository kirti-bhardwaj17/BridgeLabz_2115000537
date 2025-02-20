class CircularBuffer {
    private int[] buffer;
    private int front, rear, size, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        rear = (rear + 1) % capacity;
        buffer[rear] = value;
        if (size < capacity) size++;
        else front = (front + 1) % capacity;
    }

    public int dequeue() {
        if (size == 0) return -1;
        int removed = buffer[front];
        front = (front + 1) % capacity;
        size--;
        return removed;
    }

    public void display() {
        for (int i = 0; i < size; i++) System.out.print(buffer[(front + i) % capacity] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
        cb.display();
        cb.enqueue(4);
        cb.display();
        cb.dequeue();
        cb.display();
    }
}

