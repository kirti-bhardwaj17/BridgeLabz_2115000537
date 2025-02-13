import java.util.Stack;

public class SortStackRecursively {
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int top = stack.pop();
        sortStack(stack);
        insertInSortedOrder(stack, top);
    }

    private static void insertInSortedOrder(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int top = stack.pop();
        insertInSortedOrder(stack, value);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
