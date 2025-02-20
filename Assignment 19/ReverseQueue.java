import java.util.*;

public class ReverseQueue {
    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) return;
        int front = queue.poll();
        reverse(queue);
        queue.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        reverse(queue);
        System.out.println(queue); // Output: [30, 20, 10]
    }
}
