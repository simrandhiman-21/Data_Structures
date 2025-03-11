import java.util.*;

class sortStack {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }
        
        sortStack(stack);
        
        System.out.println("Sorted stack:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertSorted(stack, temp);
        }
    }

    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertSorted(stack, element);
            stack.push(temp);
        }
    }
}
